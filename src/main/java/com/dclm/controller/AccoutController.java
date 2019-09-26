package com.dclm.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccoutController {
	
	
	@RequestMapping(value = "public/account/{accountNumber}")
	public String getPublicClientData(@PathVariable final int accountNumber) {
		
		return "Public account lined to: "+accountNumber;
	}
	
	@RequestMapping("private/account/{accountNumber}")
	public String getPrivateClientData(@PathVariable final int accountNumber) {
		
		return "Private account lined to: "+accountNumber;
	}

}
