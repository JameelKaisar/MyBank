package com.example.mybank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MyBankController {
	
	@GetMapping(path="/")
	public String sayHello() {
		return "hello";
	}

}
