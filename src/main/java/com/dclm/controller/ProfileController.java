package com.dclm.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dclm.model.User;
import com.dclm.service.IDenominationService;
import com.dclm.service.IUserService;

@Controller
public class ProfileController {
	

	@Autowired
	private IUserService userService;
	
	@Autowired
	IDenominationService denominationService;
	
	@RequestMapping("/profile")
	public String profile(Principal principal,Model model) {
		String username = principal.getName();
		User user = userService.findByUsername(username).get();
		System.out.println("User has authorities: " + user.getRoles());
		System.out.println("User ID: " + user.getUser_id());
		model.addAttribute("user", user);
		model.addAttribute("denomination", denominationService.getDenomination(1));
		return "profile";
	}

}
