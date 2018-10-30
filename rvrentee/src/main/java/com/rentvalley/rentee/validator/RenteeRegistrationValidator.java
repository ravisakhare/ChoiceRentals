package com.rentvalley.rentee.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.rentvalley.logger.RentvalleyLogger;
import com.rentvalley.rentee.form.account.RenteeRegistrationForm;
import com.rentvalley.service.useraccount.ManageUserAccountService;
import com.rentvalley.util.ValidatorUtil;

@Component
public class RenteeRegistrationValidator implements Validator {
	private static final RentvalleyLogger logger = RentvalleyLogger.getInstance(RenteeRegistrationValidator.class);
	
	@Autowired
	private ManageUserAccountService manageRenteeAccountService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(RenteeRegistrationForm.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidatorUtil validatorUtil = null;
		RenteeRegistrationForm renteeRegistrationForm = null;

		renteeRegistrationForm = (RenteeRegistrationForm) target;
		validatorUtil = new ValidatorUtil();
		
		if(validatorUtil.isEmpty(renteeRegistrationForm.getEmailAddress()) != true) {
			int userNo = 0;
			userNo = manageRenteeAccountService.isUserAlreadyExists(renteeRegistrationForm.getEmailAddress());
			if (userNo > 0 ) 
				errors.rejectValue("emailAddress", "user already exists, Please login");
		}
		if (validatorUtil.isEmpty(renteeRegistrationForm.getRole()) == true) {
			logger.trace("role is not defined in the registration page");
			errors.rejectValue("role", "role is not defined; can you please retry after sometime");
		}

		if (!renteeRegistrationForm.getPassword().equals(renteeRegistrationForm.getRetypePassword())) {
			logger.trace("password and retypePassword fields are does not match");
			errors.rejectValue("password", "password fields does not match");
		}
	}
}
