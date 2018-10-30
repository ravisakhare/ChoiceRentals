package com.rentvalley.rentee.handler.security;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.rentvalley.dto.security.account.UserDetailsImpl;

@Component
public class UserAuthenticationSuccessHandler  extends SavedRequestAwareAuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		System.out.println("In Success handler");
		UserDetailsImpl userDetails = null;
		String redirectUrl = null;

		if (authentication.getClass().isAssignableFrom(AnonymousAuthenticationToken.class) == false) {
			userDetails = (UserDetailsImpl) authentication.getPrincipal();
			if (userDetails.getRoleName().equalsIgnoreCase("Rentee")) {
				redirectUrl = "/rentee-dashboard.htm";
			} else {
				redirectUrl = "/customer-dashboard.htm";
			}
		}
		super.getRedirectStrategy().sendRedirect(request, response, redirectUrl);
	}

}
