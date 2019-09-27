package com.dclm.controller;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.dclm.model.User;
import com.dclm.model.UserInfo;
import com.dclm.service.IRoleService;
import com.dclm.service.IUserService;

@Controller
public class HomeController {

	@Autowired
	private IUserService userService;

	@Autowired
	IRoleService roleService;

	public HomeController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping({"", "/", "/home"})
	public String showHome() {
		return "index";
	}
}
