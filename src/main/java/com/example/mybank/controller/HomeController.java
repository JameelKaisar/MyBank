package com.example.mybank.controller;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

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
	public String home(
			Model model,
			Authentication authentication,
			@RequestParam("tab") Optional<String> tab,
			@RequestParam("type") Optional<String> type,
			@RequestParam("query") Optional<String> query
	) {
		String email = authentication.getName();
		User user = userRepo.findByEmail(email);
		List<User> users = userRepo.findAllUsers();
		List<User> queryUsers = new ArrayList<User>();
		String paramTab = tab.orElse("home");
		String paramType = type.orElse("");
		String paramQuery = query.orElse("");
		if (paramTab.equals("search")) {
			try {
				if (paramType.equals("name")) {
					queryUsers = userRepo.findUsersByName(paramQuery);
				}
				else if (paramType.equals("aadhar")) {
					queryUsers = userRepo.findUsersByAadhar(paramQuery);
				}
				else if (paramType.equals("phone")) {
					queryUsers = userRepo.findUsersByPhone(paramQuery);
				}
			} catch (Exception e) {
				return "redirect:/home?qerror&action=search";
			}
		}
		model.addAttribute("tab", paramTab);
		model.addAttribute("email", user.getEmail());
		model.addAttribute("name", user.getName());
		model.addAttribute("address", user.getAddress());
		model.addAttribute("city", user.getCity());
		model.addAttribute("pin", user.getPin());
		model.addAttribute("aadhar", user.getAadhar());
		model.addAttribute("phone", user.getPhone());
		model.addAttribute("admin", user.getAdmin());
		model.addAttribute("users", users);
		model.addAttribute("paramType", paramType);
		model.addAttribute("paramQuery", paramQuery);
		model.addAttribute("queryUsers", queryUsers);
		return "home";
	}

	@PostMapping(path="/home")
	public String home(
			Authentication authentication,
			@RequestParam("tab") Optional<String> tab,
			@RequestParam("email") Optional<String> user_email,
			@RequestParam("name") Optional<String> new_name,
			@RequestParam("address") Optional<String> new_address,
			@RequestParam("city") Optional<String> new_city,
			@RequestParam("pin") Optional<String> new_pin,
			@RequestParam("aadhar") Optional<String> new_aadhar,
			@RequestParam("phone") Optional<String> new_phone,
			@RequestParam("role") Optional<String> new_role
	) {
		String paramTab = tab.orElse("home");
		if (paramTab.equals("update")) {
			try {
				String email = authentication.getName();
				User user = userRepo.findByEmail(email);
				if (new_name.isPresent())
					user.setName(new_name.get());
				if (new_address.isPresent())
					user.setAddress(new_address.get());
				if (new_city.isPresent())
					user.setCity(new_city.get());
				if (new_pin.isPresent())
					user.setPin(new_pin.get());
				if (new_aadhar.isPresent())
					user.setAadhar(new_aadhar.get());
				if (new_phone.isPresent())
					user.setPhone(new_phone.get());
				userRepo.save(user);
			} catch (Exception e) {
				return "redirect:/home?error&tab=update";
			}
		}
		else if (paramTab.equals("list")) {
			try {
				String email = user_email.get();
				User user = userRepo.findByEmail(email);
				if (new_name.isPresent())
					user.setName(new_name.get());
				if (new_address.isPresent())
					user.setAddress(new_address.get());
				if (new_city.isPresent())
					user.setCity(new_city.get());
				if (new_pin.isPresent())
					user.setPin(new_pin.get());
				if (new_aadhar.isPresent())
					user.setAadhar(new_aadhar.get());
				if (new_phone.isPresent())
					user.setPhone(new_phone.get());
				if (new_role.isPresent())
					user.setAdmin(new_role.get().equals("1") ? true : false);
				userRepo.save(user);
			} catch (Exception e) {
				return "redirect:/home?lerror&tab=list";
			}
		}
		return String.format("redirect:/home?tab=%s", paramTab);
	}

}
