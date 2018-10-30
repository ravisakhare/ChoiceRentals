package com.rentvalley.rentee.controller.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rentvalley.helper.RentValleyStaticConstants;
import com.rentvalley.service.useraccount.ManageUserAccountService;

@Controller
public class RenteeActivationController {

	@Autowired
	private ManageUserAccountService manageUserAccountService;

	@GetMapping("/activation.htm")
	public String doActivationRentee(@RequestParam("userId") String userId,
			@RequestParam("activationCode") String activationCode, Model model) {

		manageUserAccountService.activateUser(Integer.parseInt(userId), activationCode);

		return (manageUserAccountService.saveSystemUserRole(Integer.parseInt(userId),
				RentValleyStaticConstants.RENTEE_ROLENO) > 0) ? RentValleyStaticConstants.ACTIVATION_SUCCESS
						: RentValleyStaticConstants.ACTOVATION_FAILURE;
	}

}
