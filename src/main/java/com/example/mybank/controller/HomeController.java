package com.example.mybank.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
		String email = authentication.getName();
		User user = userRepo.findByEmail(email);
		List<User> users = userRepo.findAllUsers();
		model.addAttribute("email", user.getEmail());
		model.addAttribute("name", user.getName());
		model.addAttribute("admin", user.getAdmin());
        model.addAttribute("users", users);
		return "home";
	}

	@PostMapping(path="/home")
	public String home(Authentication authentication, @RequestParam("name") String new_name) {
		try {
			String email = authentication.getName();
			User user = userRepo.findByEmail(email);
			user.setName(new_name);
			userRepo.save(user);
		} catch (Exception e) {
			return "redirect:/home?error";
		}
		return "redirect:/home";
	}

}
