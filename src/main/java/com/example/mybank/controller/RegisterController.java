package com.example.mybank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.example.mybank.model.*;
import com.example.mybank.repository.*;

@Controller
public class RegisterController {
	@Autowired
    private UserRepository userRepo;
	
	@GetMapping(path="/register")
	public String register(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}

	@PostMapping(path="/register")
	public String registerHandle(User user) {
	    userRepo.save(user);
    	return "home";
	}

}
