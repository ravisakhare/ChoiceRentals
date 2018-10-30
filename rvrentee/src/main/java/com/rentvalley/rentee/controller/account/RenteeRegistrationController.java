package com.rentvalley.rentee.controller.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.rentvalley.dto.account.ContactInfoDto;
import com.rentvalley.dto.account.RoleDto;
import com.rentvalley.dto.account.UserAccountDto;
import com.rentvalley.helper.RentValleyStaticConstants;
import com.rentvalley.logger.RentvalleyLogger;
import com.rentvalley.rentee.form.account.RenteeRegistrationForm;
import com.rentvalley.rentee.validator.RenteeRegistrationValidator;
import com.rentvalley.service.useraccount.ManageUserAccountService;

@Controller
public class RenteeRegistrationController {

	private static final RentvalleyLogger logger = RentvalleyLogger.getInstance(RenteeRegistrationController.class);

	@Autowired(required = true)
	private RenteeRegistrationValidator renteeRegistrationValidator;

	@Autowired(required = true)
	private ManageUserAccountService manageRenteeAccountService;

	@GetMapping("/rentee-register.htm")
	public String showRenteeRegistrationForm(Model model) {
		RenteeRegistrationForm renteeRegistrationForm = null;

		renteeRegistrationForm = new RenteeRegistrationForm();
		model.addAttribute("renteeRegistrationForm", renteeRegistrationForm);
		return RentValleyStaticConstants.RENTEE_REGISTER;
	}

	@PostMapping("/add-rentee.htm")
	public String addRentee(@ModelAttribute("renteeRegistrationForm") RenteeRegistrationForm renteeRegistrationForm,
			BindingResult errors, Model model) {
		int renteeNo = 0;
		RoleDto roleDto = null;
		ContactInfoDto contactInfoDto = null;
		UserAccountDto userAccountDto = null;
		
		logger.info("Adding rentee to the platform with  following deatils : " + renteeRegistrationForm);

		if (renteeRegistrationValidator.supports(renteeRegistrationForm.getClass())) {
			renteeRegistrationValidator.validate(renteeRegistrationForm, errors);
		}

		if (errors.hasErrors()) {
			return RentValleyStaticConstants.RENTEE_REGISTER;
		}

		/**
		 * We will get below details from registration page RenteeRegistrationForm
		 * [firstName, lastName, emailAddress, mobile, password, retypePassword,
		 * role=Rentee]
		 */		
		userAccountDto = new UserAccountDto();
		userAccountDto.setFirstName(renteeRegistrationForm.getFirstName());
		userAccountDto.setLastName(renteeRegistrationForm.getLastName());
		userAccountDto.setUserName(renteeRegistrationForm.getEmailAddress());

		if (renteeRegistrationForm.getPassword().equals(renteeRegistrationForm.getRetypePassword()))
			userAccountDto.setPassword(renteeRegistrationForm.getPassword());

		roleDto = new RoleDto(RentValleyStaticConstants.RENTEE_ROLENO, renteeRegistrationForm.getRole());
		contactInfoDto = new ContactInfoDto(renteeRegistrationForm.getMobile());

		userAccountDto.setRoleDto(roleDto);
		userAccountDto.setContactInfoDto(contactInfoDto);
		
		renteeNo = manageRenteeAccountService.registerUserAccount(userAccountDto);

		logger.info("rentee details has been saved " + renteeNo);

		model.addAttribute("renteeName",
				renteeRegistrationForm.getFirstName() + " " + renteeRegistrationForm.getLastName());
		model.addAttribute("emailAddress", renteeRegistrationForm.getEmailAddress());
		return RentValleyStaticConstants.REGISTRATION_SUCCESS;
	}
}
