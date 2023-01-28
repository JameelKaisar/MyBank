package com.example.mybank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {
	
	@GetMapping(path="/")
	public String root() {
		return "redirect:/login";
	}

}
