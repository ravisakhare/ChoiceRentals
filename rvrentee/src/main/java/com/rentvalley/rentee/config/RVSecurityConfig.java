package com.rentvalley.rentee.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.rentvalley.rentee.handler.security.UserAuthenticationSuccessHandler;
import com.rentvalley.service.security.account.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity
@ComponentScan(basePackages = "com.rentvalley.rentee.handler.security")
public class RVSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;

	@Autowired(required = true)
	private UserAuthenticationSuccessHandler userAuthenticationSuccessHandler;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override

	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/rentee-dashboard.htm").hasAuthority("Rentee")
				.antMatchers("/customer-dashboard.htm").hasAuthority("customer").and().formLogin()
				.loginPage("/login.htm").loginProcessingUrl("/rentee-security-check").usernameParameter("j_user")
				.passwordParameter("j_password").successHandler(userAuthenticationSuccessHandler);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder);
	}
}
