package com.example.mybank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;

import com.example.mybank.model.*;
import com.example.mybank.repository.*;

@Controller
public class HomeController {

	@Autowired
    private UserRepository userRepo;
	
	@GetMapping(path="/home")
	public String home(Model model, Authentication authentication) {
		String username = authentication.getName();
		User user = userRepo.findByUsername(username);
		model.addAttribute("admin", user.getAdmin());
		return "home";
	}

}
