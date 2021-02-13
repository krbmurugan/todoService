package com.rs.todo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TodoHardCodedService {
	
	
	private static final Logger log = LoggerFactory.getLogger(TodoHardCodedService.class);

	
	static  List<Todo> todos = new ArrayList();
	static int todoIdCounter=0;
	
	static {
		todos.add(new Todo(++todoIdCounter, "React", "Learn React", new Date(), false));
		todos.add(new Todo(++todoIdCounter, "Spring Boot", "Learn Spring Boot", new Date(), false));
		todos.add(new Todo(++todoIdCounter, "Microservices", "Learn Microservices", new Date(), false));
		todos.add(new Todo(++todoIdCounter, "Kafka", "Learn Kafka", new Date(), false));
		todos.add(new Todo(++todoIdCounter, "AWS", "Learn AWS", new Date(), false));
		todos.add(new Todo(++todoIdCounter, "Spark", "Learn Spark", new Date(), false));
		
	}
	
	public List<Todo> findAll(String username){
		return todos;
	}
	
	public Todo deleteTodo(long id) {
		log.info("Todo id to delete {}",id);
		Todo todo = findById(id);
		todos.remove(todo);
		return todo;
		
	}

	public Todo findById(long id) {
		
		for(Todo todo : todos) {
			if(todo.getId()==id) return todo;
		}
		return null;
	}
	
	public Todo save(Todo todo) {
		if(todo.getId()==-1|| todo.getId()==0) {
			todo.setId(++todoIdCounter);
			todos.add(todo);
		}
		else {
			todos.remove(findById(todo.getId()));
			todos.add(todo);
		}
		return todo;
	}
	
	

}
