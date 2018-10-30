package com.rentvalley.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@Import({ RVPersistenceConfig.class, RVMailTrasportConfig.class })
@ComponentScan(basePackages = { "com.rentvalley.service.security.account" , "com.rentvalley.service.useraccount"})
public class RVRootConfig {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
