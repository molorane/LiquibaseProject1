package com.dclm.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dclm.service.IDenominationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.dclm.model.CustomUserDetails;
import com.dclm.model.User;


@Component
public class ApplicationAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
	
	private static final int SESSION_INACTIVE_INTERVAL_HOURS = 2;
    public static final int SESSION_INACTIVE_INTERVAL_SECONDS = SESSION_INACTIVE_INTERVAL_HOURS * 60 * 60;


    @Autowired
    IDenominationService denominationService;
    
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication
            authentication) throws IOException, ServletException {
    	CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
		User user = userDetails.getUser();
        HttpSession session = request.getSession();
        session.setAttribute("authenticated_user", user);
        session.setAttribute("denomination", denominationService.getDenomination(1));
        session.setMaxInactiveInterval(SESSION_INACTIVE_INTERVAL_SECONDS); // Possible to have this value change between Roles

        System.out.println(String.format("User %s successfully logged in", user.getEmail()));

        super.onAuthenticationSuccess(request, response, authentication);
    }

}
