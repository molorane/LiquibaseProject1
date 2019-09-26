package com.dclm.controller;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.dclm.model.CustomUserDetails;
import com.dclm.model.User;
import com.dclm.model.UserInfo;
import com.dclm.service.IDenominationService;
import com.dclm.service.IRoleService;
import com.dclm.service.IUserService;

@RestController
public class HomeController {

	@Autowired
	private IUserService userService;

	@Autowired
	IRoleService roleService;
	
	@Autowired
	IDenominationService denominationService;

	public HomeController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping({"", "/", "/home"})
	public ModelAndView getSiteUser(Authentication authentication) {
		CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
		User user = userDetails.getUser();
		
		if(user.getUserInfo() == null) {
			ModelAndView modelAndView =  new ModelAndView("userInfo");
			modelAndView.addObject("user", user);
			return modelAndView;
		}
		
		List<String> roles = user.getRoles().stream().map(role -> role.getRole()).collect(Collectors.toList());
		System.out.println("User has authorities: " + userDetails.getAuthorities());
		System.out.println("User ID: " + user.getUser_id());
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("user", user);
		modelAndView.addObject("roles", roles);
		modelAndView.addObject("denomination", denominationService.getDenomination(1));
		return modelAndView;
	}

	@RequestMapping("/test")
	public ModelAndView getTest(Principal principal) {
		String username = principal.getName();
		User user = userService.findByUsername(username).get();
		System.out.println("User has authorities: " + user.getRoles());
		System.out.println("User ID: " + user.getUser_id());
		ModelAndView modelAndView = new ModelAndView("user");
		modelAndView.addObject("user", user);
		return modelAndView;
	}

	@RequestMapping("/add")
	public void addUser() {

		User user = userService.findByUsername("nomfundo").get();
		UserInfo ui = new UserInfo();
		ui.setFirst_name("Nomfundo");
		ui.setLast_name("Mahlalela");
		ui.setOther_name("Millicent");
		ui.setProfile("love.png");
		ui.setUser_id(user.getUser_id());
		user.setUserInfo(ui);

		System.out.print(user.getRoles());

		userService.addUser(user);
	}

	@RequestMapping("/allUsers")
	public List<User> getUsers() {
		return userService.findAll();
	}

}
