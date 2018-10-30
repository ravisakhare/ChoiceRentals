package com.rentvalley.customer.boot;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.rentvalley.customer.config.RVCustomerWebMvcConfig;
import com.rentvalley.customer.config.RVSecurityConfig;
import com.rentvalley.service.config.RVRootConfig;

public class RVCustomerDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] {RVRootConfig.class, RVSecurityConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] {RVCustomerWebMvcConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"*.htm"};
	}

}
