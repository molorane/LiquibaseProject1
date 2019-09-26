package com.dclm.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dclm.model.CustomUserDetails;
import com.dclm.model.User;

@Controller
public class LockScreenController {
	
	
	@RequestMapping("/lockscreen")
	public ModelAndView lockScreen(Authentication authentication) {
		
		CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
		User user = userDetails.getUser();
		
		ModelAndView modelAndView = new ModelAndView("lock-screen");
		modelAndView.addObject("user", user);
		
		return modelAndView;
	}

}
