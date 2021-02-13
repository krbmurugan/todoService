package com.rs.todo.controller;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rs.todo.service.Todo;
import com.rs.todo.service.TodoHardCodedService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TodoHomeController {
	private Logger LOG = LoggerFactory.getLogger(TodoHomeController.class);
	
	@Autowired
	TodoHardCodedService todoHardcodedService;
	
	@GetMapping(value = {"/home","/home5","/home6"})
	public String welcome() {
		LOG.info("inside home..");
		
		return "Welcome to TODO home";
	}
	
	@GetMapping(path = {"/home2","/home4"})
	public String welcome2() {
		LOG.info("inside welcome2..");
		
		return "Welcome 2 to TODO home";
	}
	
	@GetMapping("/home3")
	public String welcome3() {
		LOG.info("inside welcome3..");
		
		return "Welcome 3 to TODO home";
	}
	
	@GetMapping("/home7")
	public WelcomeBean welcome4() {
		LOG.info("inside welcome3..");
		
		return new WelcomeBean("Welcome message from Bean");
	}
	
	@GetMapping("/withpathvar/{name1}/check")
	public WelcomeBean getMsgWithPathVar(@PathVariable String name1) {
		LOG.info("path var method..{}",name1);
		String resp = String.format("Hello welcome, %s", name1);
		
		return new WelcomeBean(resp);
		
	}
	
	@GetMapping("/withqueryparam")
	public WelcomeBean getMsgWithQueryParam(@RequestParam(value = "username") String name1) {
		LOG.info("withqueryparam method..{}",name1);
//		throw new RuntimeException("Error happened");
		String resp = String.format("Hello welcome, %s", name1);
		
		return new WelcomeBean(resp);
		
	}
	
	@GetMapping("/")
	public String welcomeMsg() {
		return "Welcome to ToDO app- Deployed through AWS..another build..";
	}
	
	@GetMapping("/users/{username}/todos")
	public List<Todo> getAllTodos(@PathVariable String username){
		LOG.info("Username is {}", username);
		return todoHardcodedService.findAll(username);
	}
	
	@GetMapping("/users/{username}/todo/{id}")
	public Todo getTodoById(@PathVariable String username, @PathVariable long id){
		LOG.info("Username is {} and todo id is ", username, id);
		return todoHardcodedService.findById(id);
	}
	
	@DeleteMapping("/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable long id) {
		Todo deletedTodo = todoHardcodedService.deleteTodo(id);
		if(deletedTodo!=null) return ResponseEntity.noContent().build();
		return ResponseEntity.notFound().build();
		
	}
	
	@PutMapping("/users/{username}/todos/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable long id, @RequestBody Todo todo){
		Todo updatedTodo = todoHardcodedService.save(todo);
		
		return new ResponseEntity<Todo>(todo, HttpStatus.OK);
	}
	
	@PostMapping("/users/{username}/todos")
	public ResponseEntity<Todo> updateTodo(@PathVariable String username, @RequestBody Todo todo){
		Todo createdTodo = todoHardcodedService.save(todo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
		LOG.info(uri.getPath());
		return ResponseEntity.created(uri).build();
	}

}
