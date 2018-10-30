package com.rentvalley.mail.transport;

import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import com.rentvalley.bo.account.MailMessage;
import com.rentvalley.helper.RentValleyStaticConstants;
import com.rentvalley.logger.RentvalleyLogger;
import com.rentvalley.mail.helper.MailTemplateStandard;

@Component
public class RentValleyTransport {
	
	private static final RentvalleyLogger logger = RentvalleyLogger.getInstance(RentValleyTransport.class);
	@Autowired
	private MailSender mailSender;
	
	@Autowired
	private VelocityEngine velocityEngine;
	
	public void send(MailMessage mailMessage, MailTemplateStandard  mailTemplateStandard) {
		logger.info("RentValleyTransport : send() method called "); 
		SimpleMailMessage simpleMailMessage = null;
		Template template = null;
		VelocityContext velocityContext = null;
		StringWriter writer = null;
		
		simpleMailMessage = new SimpleMailMessage();
		if (mailMessage.getTo() != null && mailMessage.getTo().trim().length() > 0) {
			simpleMailMessage.setTo(mailMessage.getTo());
		}
		simpleMailMessage.setFrom(mailMessage.getFrom());
		simpleMailMessage.setSubject(mailMessage.getSubject());
		
		template = velocityEngine.getTemplate(RentValleyStaticConstants.RENTEE_VM_TEMPLATE);
		logger.info(RentValleyStaticConstants.RENTEE_VM_TEMPLATE);
		velocityContext = new VelocityContext();
		writer = new StringWriter();
		/**
		 * this velocityContext object replaces the tokens and merges the dynamic text data
		 */
		velocityContext.put("userName", mailTemplateStandard.getUserName());
		velocityContext.put("host", RentValleyStaticConstants.HOST);
		velocityContext.put("systemUserNo", mailTemplateStandard.getUserId());
		velocityContext.put("activationCode", mailTemplateStandard.getActivationCode());
		
		template.merge(velocityContext, writer);
		simpleMailMessage.setText(writer.toString());
		
		mailSender.send(simpleMailMessage);
	}
}
