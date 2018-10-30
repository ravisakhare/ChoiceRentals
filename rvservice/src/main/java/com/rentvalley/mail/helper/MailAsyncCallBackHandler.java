package com.rentvalley.mail.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rentvalley.bo.account.MailMessage;
import com.rentvalley.exception.EmailActivationLinkFailedException;
import com.rentvalley.logger.RentvalleyLogger;
import com.rentvalley.mail.transport.RentValleyTransport;

@Component
public class MailAsyncCallBackHandler {
	
	private static final RentvalleyLogger logger = RentvalleyLogger.getInstance(MailAsyncCallBackHandler.class);
	
	@Autowired
	private RentValleyTransport rentValleyTransport;
	
	public void sendActivationLink(final MailMessage mailMessage, final MailTemplateStandard mailTemplateStandard) {
		new Thread() {
			public void run() {
				try {
					logger.info("sending via email call back handler");
					rentValleyTransport.send(mailMessage, mailTemplateStandard);
					logger.info("sending has completed");
				} catch(EmailActivationLinkFailedException e) {
					logger.error("activation link has not been sent to provided email ID", e);
					throw new EmailActivationLinkFailedException("activation link has not been sent to provided email ID");
				}
			}
		}.start();
	}
}
