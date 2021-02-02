package com.rs.todo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TodoHomeService {
	private Logger LOG = LoggerFactory.getLogger(TodoHomeService.class);
	
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

}
