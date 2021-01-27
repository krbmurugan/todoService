package com.rs.todo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
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

}
