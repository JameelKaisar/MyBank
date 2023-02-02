package com.example.mybank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

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
		try {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String plainPassword = user.getPassword();
			String encodedPassword = passwordEncoder.encode(plainPassword);
			user.setPassword(encodedPassword);
			userRepo.save(user);

			Authentication authentication = new UsernamePasswordAuthenticationToken(user.getEmail(), plainPassword);
			SecurityContextHolder.getContext().setAuthentication(authentication);
		} catch (Exception e) {
			return "redirect:/register?error";
		}

		return "redirect:/home";
	}

}
