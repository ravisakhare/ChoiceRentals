package com.rentvalley.rentee.controller.account;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.rentvalley.helper.RentValleyStaticConstants;

@Controller
public class LoginController {
	@GetMapping("/login.htm")
	public String showLoginForm(Model model) {
		return RentValleyStaticConstants.LOGIN_VIEW;
	}
	
}
