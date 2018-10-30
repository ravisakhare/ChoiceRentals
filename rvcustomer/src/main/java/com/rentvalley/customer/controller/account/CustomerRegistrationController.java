package com.rentvalley.customer.controller.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.rentvalley.customer.form.account.CustomerRegistrationForm;
import com.rentvalley.customer.validator.CustomerRegistrationValidator;
import com.rentvalley.dto.account.ContactInfoDto;
import com.rentvalley.dto.account.RoleDto;
import com.rentvalley.dto.account.UserAccountDto;
import com.rentvalley.helper.RentValleyStaticConstants;
import com.rentvalley.logger.RentvalleyLogger;
import com.rentvalley.service.useraccount.ManageUserAccountService;

@Controller
public class CustomerRegistrationController {

	private static final RentvalleyLogger logger = RentvalleyLogger.getInstance(CustomerRegistrationController.class);

	@Autowired(required = true)
	private ManageUserAccountService manageUserAccountService;
	
	@Autowired
	private CustomerRegistrationValidator customerRegistrationValidator;

	@GetMapping("/customer-register.htm")
	public String showRegistrationForm(Model model) {
		CustomerRegistrationForm registrationForm = null;

		registrationForm = new CustomerRegistrationForm();
		model.addAttribute("registrationForm", registrationForm);
		return RentValleyStaticConstants.CUSTOMER_REGISTER;
	}

	@PostMapping("/add-customer.htm")
	public String addRentee(@ModelAttribute("registrationForm") CustomerRegistrationForm registrationForm,
			BindingResult errors, Model model) {
		int customerNo = 0;
		RoleDto roleDto = null;
		ContactInfoDto contactInfoDto = null;
		UserAccountDto userAccountDto = null;
		
		logger.info("Adding rentee to the platform with  following deatils : " + registrationForm);

		if (customerRegistrationValidator.supports(registrationForm.getClass())) {
			customerRegistrationValidator.validate(registrationForm, errors);
		}

		if (errors.hasErrors()) {
			return RentValleyStaticConstants.CUSTOMER_REGISTER;
		}

		/**
		 * We will get below details from registration page registrationForm
		 * [firstName, lastName, emailAddress, mobile, password, retypePassword,
		 * role=Rentee]
		 */
		
		userAccountDto = new UserAccountDto();
		userAccountDto.setFirstName(registrationForm.getFirstName());
		userAccountDto.setLastName(registrationForm.getLastName());
		userAccountDto.setUserName(registrationForm.getEmailAddress());

		if (registrationForm.getPassword().equals(registrationForm.getRetypePassword()))
			userAccountDto.setPassword(registrationForm.getPassword());

		roleDto = new RoleDto(RentValleyStaticConstants.CUSTOMER_ROLENO, registrationForm.getRole());
		contactInfoDto = new ContactInfoDto(registrationForm.getMobile());

		userAccountDto.setRoleDto(roleDto);
		userAccountDto.setContactInfoDto(contactInfoDto);
		
		customerNo = manageUserAccountService.registerUserAccount(userAccountDto);

		logger.info("customer details has been saved " + customerNo);

		model.addAttribute("customerName",
				registrationForm.getFirstName() + " " + registrationForm.getLastName());
		model.addAttribute("emailAddress", registrationForm.getEmailAddress());
		return RentValleyStaticConstants.REGISTRATION_SUCCESS;
	}
}
