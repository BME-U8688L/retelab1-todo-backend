package hu.bme.mit.inf.retelab1.todo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.bme.mit.inf.retelab1.todo.model.TodoItem;
import hu.bme.mit.inf.retelab1.todo.repositories.TodoRepository;

@Service
public class TodoService {

	@Autowired 
	private TodoRepository todoRepository;
    
	public List<TodoItem> getTodos() {	
		return this.todoRepository.findAll();
	}
	
	public TodoItem getTodoById(final Long id) {
        return todoRepository.findById(id).orElse(null);
	}

	public void addTodo(final TodoItem todo) {
		todo.setId(null);
		todoRepository.save(todo);
	}

	public void updateTodo(final Long id, final TodoItem todo) {
        todo.setId(id);
		todoRepository.saveAndFlush(todo);
	}
	
	public void deleteTodo(final Long id) {
        todoRepository.deleteById(id);
	}
}