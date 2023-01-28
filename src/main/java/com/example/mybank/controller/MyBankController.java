package com.example.mybank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyBankController {
	
	@GetMapping(path="/")
	public String sayHello() {
		return "Hello from My Bank Application";
	}

}
