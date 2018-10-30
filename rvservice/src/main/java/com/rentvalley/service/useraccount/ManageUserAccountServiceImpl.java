package com.rentvalley.service.useraccount;

import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rentvalley.bo.account.ContactInfoBo;
import com.rentvalley.bo.account.MailMessage;
import com.rentvalley.bo.account.RoleBo;
import com.rentvalley.bo.account.UserAccountBo;
import com.rentvalley.dao.account.AccountDao;
import com.rentvalley.dto.account.UserAccountDto;
import com.rentvalley.exception.UserAccountActivationFailedException;
import com.rentvalley.exception.UserAccountRegistrationFailedException;
import com.rentvalley.helper.RentValleyStaticConstants;
import com.rentvalley.logger.RentvalleyLogger;
import com.rentvalley.mail.helper.MailAsyncCallBackHandler;
import com.rentvalley.mail.helper.MailTemplateStandard;

@Service
public class ManageUserAccountServiceImpl implements ManageUserAccountService {

	private static final RentvalleyLogger logger = RentvalleyLogger.getInstance(ManageUserAccountServiceImpl.class);

	@Autowired
	private AccountDao accountDao;

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private MailAsyncCallBackHandler mailAsyncCallBackHandler;
	
	@Override
	public int isUserAlreadyExists(String userName) {
		return accountDao.isUserAlreadyExists(userName);
	}

	@Override
	@Transactional(readOnly = false)
	public int registerUserAccount(UserAccountDto userAccountDto) {
		UserAccountBo userAccountBo = null;
		ContactInfoBo contactInfoBo = null;
		RoleBo roleBo = null;
		MailTemplateStandard mailTemplateStandard = null;
		
		String activationCode = null;
		MailMessage mailMessage = null;
		int systemUserNo = 0;
		int contactInfoNo = 0;

		userAccountBo = new UserAccountBo();
		BeanUtils.copyProperties(userAccountDto, userAccountBo);
		/**
		 * encrypting the password using BCryptPassword Algoritham
		 */
		userAccountBo.setPassword(encoder.encode(userAccountDto.getPassword()));

		activationCode = "act" + UUID.randomUUID().toString();
		userAccountBo.setActivationCode(activationCode.substring(0, 6));

		contactInfoBo = new ContactInfoBo(userAccountDto.getContactInfoDto().getContactNo(),
				userAccountDto.getUserName());
		roleBo = new RoleBo(userAccountDto.getRoleDto().getRoleNo(), userAccountDto.getRoleDto().getRoleName());
		userAccountBo.setContactInfoBo(contactInfoBo);
		userAccountBo.setRoleBo(roleBo);
		try {
			contactInfoNo = accountDao.saveContactInfo(contactInfoBo);
			systemUserNo = accountDao.saveUserAccount(userAccountBo, contactInfoNo);
		} catch (UserAccountRegistrationFailedException e) {
			logger.error("user registration has failed", e);
			throw new UserAccountRegistrationFailedException("user registration has failed");
		}

		/**
		 * build mailMessage here, from email is taking from RVMailTrasportConfig
		 */

		mailMessage = new MailMessage();
		
		mailMessage.setFrom(RentValleyStaticConstants.MAIL_FROM);
		// mailMessage.setTo(userAccountDto.getUserName());
		mailMessage.setTo(RentValleyStaticConstants.MAIL_TO);
		mailMessage.setSubject(RentValleyStaticConstants.MAIL_SUBJECT);

		mailTemplateStandard = new MailTemplateStandard(systemUserNo, userAccountBo.getFirstName(),
				userAccountBo.getActivationCode());

		mailAsyncCallBackHandler.sendActivationLink(mailMessage, mailTemplateStandard);
		return systemUserNo;
	}

	@Transactional(readOnly = false)
	public void activateUser(int userId, String activationCode) {
		try {
			accountDao.activateUser(userId, activationCode);
		} catch (UserAccountActivationFailedException e) {
			logger.error("activation link has expired / activation code has wrong", e);
			throw new UserAccountActivationFailedException("activation link has expired/activation code has wrong");
		}
	}

	@Override
	public int saveSystemUserRole(int userId, int roleNo) {
		int systemUserNo = 0;
		try {
			systemUserNo = accountDao.saveSystemUserRole(userId, roleNo);
		} catch(UserAccountActivationFailedException e) {
			logger.error("activation has failed : saveSystemUserRole() ", e);
			throw new UserAccountActivationFailedException("activation has failed : saveSystemUserRole()");
		}
		return systemUserNo;
	}

	
	
}
