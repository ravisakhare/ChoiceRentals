package com.rentvalley.customer.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.rentvalley.customer.form.account.CustomerRegistrationForm;
import com.rentvalley.logger.RentvalleyLogger;
import com.rentvalley.service.useraccount.ManageUserAccountService;
import com.rentvalley.util.ValidatorUtil;


@Component
public class CustomerRegistrationValidator implements Validator {
	private static final RentvalleyLogger logger = RentvalleyLogger.getInstance(CustomerRegistrationValidator.class);

	@Autowired
	private ManageUserAccountService manageRenteeAccountService;

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(CustomerRegistrationForm.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		CustomerRegistrationForm registrationForm = null;
		ValidatorUtil validatorUtil = null;

		registrationForm = (CustomerRegistrationForm) target;
		validatorUtil = new ValidatorUtil();
		
		if(validatorUtil.isEmpty(registrationForm.getEmailAddress()) != true) {
			int userNo = 0;
			userNo = manageRenteeAccountService.isUserAlreadyExists(registrationForm.getEmailAddress());
			if (userNo > 0 ) 
				errors.rejectValue("customer/rentee", "user already exists, Please login");
		}
		
		if (validatorUtil.isEmpty(registrationForm.getRole()) == true) {
			logger.trace("role is not defined in the registration page");
			errors.rejectValue("customer/rentee", "can you please retry after sometime");
		}

		if (!registrationForm.getPassword().equals(registrationForm.getRetypePassword())) {
			logger.trace("password and retypePassword fields are does not match");
			errors.rejectValue("password", "password fields does not match");
		}
	}

}
