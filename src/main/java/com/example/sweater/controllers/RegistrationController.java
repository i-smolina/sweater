package com.example.sweater.controllers;

import java.util.Collections;

import javax.persistence.CollectionTable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.sweater.domain.Role;
import com.example.sweater.domain.User;
import com.example.sweater.repos.UserRepo;
import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;

@Controller
public class RegistrationController {
	
	@Autowired
	private UserRepo userRepo;

	@GetMapping("/registration")
	public String registratiion(Model model) {
		return "registration";
	}
	
	@PostMapping("/registration")
	public String addUser(User user, Model model) {
		
		User userFromDb = userRepo.findByUsername(user.getUsername());
		
		/*
		 * if (userFromDb != null) { model.addAttribute("message", "user exists!");
		 * return "registration"; }
		 */
		
		user.setActive(true);
		user.setRoles(Collections.singleton(Role.USER));
		userRepo.save(user);

		return "redirect:/login";
	}
}
