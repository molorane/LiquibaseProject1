package com.dclm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dclm.model.User;
import com.dclm.service.IUserService;

@Controller
public class AuthenticationController {
	
	@Autowired
	private IUserService userService;
	
	
	@GetMapping("/login")
    public ModelAndView login() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		ModelAndView loginView = new ModelAndView("login");
		if (!(auth instanceof AnonymousAuthenticationToken)) {
		    /* The user is logged in :) */
		    return new ModelAndView("redirect:/home");
		}
		return loginView;
    }
	
	@GetMapping("/register")
    public ModelAndView register() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		ModelAndView loginView = new ModelAndView("register");
		loginView.addObject("user", new User());
		if (!(auth instanceof AnonymousAuthenticationToken)) {
		    /* The user is logged in :) */
		    return new ModelAndView("redirect:/home");
		}
		return loginView;
    }
	
	@PostMapping("/register")
	public String registerUser(@ModelAttribute("user") @Valid User saveUser,  BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasErrors()) {
			return "register";
		}

		User user = userService.findByUsername(saveUser.getUsername()).orElse(null);
		if(user != null) {
			model.addAttribute("error", "exist_username");
			return "register";
		}
		
		user = userService.findByEmail(saveUser.getEmail()).orElse(null);
		if(user != null) {
			model.addAttribute("error", "exist_email");
			return "register";
		}
		
		userService.addUser(saveUser);
		
		return "redirect:/login";
	}
	
	
	@GetMapping("/access-denied")
    public String accessDenied() {
		return "error/403";
    }
	

}
