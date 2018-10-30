package com.rentvalley.service.config;

import java.io.IOException;
import java.util.Properties;

import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.VelocityException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.ui.velocity.VelocityEngineFactory;

import com.rentvalley.helper.RentValleyStaticConstants;


@Configuration
@ComponentScan(basePackages = { "com.rentvalley.mail.transport", "com.rentvalley.mail.service", "com.rentvalley.mail.helper" })
public class RVMailTrasportConfig {

	@Bean
	public JavaMailSender newMailSender() {
		JavaMailSenderImpl mailSender = null;
		Properties javaProperties = null;

		mailSender = new JavaMailSenderImpl();
		mailSender.setHost(RentValleyStaticConstants.EMAIL_HOST);
		mailSender.setPort(RentValleyStaticConstants.EMAIL_PORT);
		mailSender.setUsername(RentValleyStaticConstants.EMAIL_USERNAME);
		mailSender.setPassword(RentValleyStaticConstants.EMAIL_PASSWORD);
		javaProperties = new Properties();
		javaProperties.put("mail.smtp.auth", "true");
		javaProperties.put("mail.debug", "true");
		mailSender.setJavaMailProperties(javaProperties);
		return mailSender;
	}

	@Bean
    public VelocityEngine getVelocityEngine() throws VelocityException, IOException {
        VelocityEngineFactory factory = new VelocityEngineFactory();
        Properties props = new Properties();
        props.put("resource.loader", "class");
        props.put("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
 
        factory.setVelocityProperties(props);
        return factory.createVelocityEngine();
    } 
}
