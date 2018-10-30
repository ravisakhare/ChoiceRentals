package com.rentvalley.rentee.boot;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import com.rentvalley.rentee.config.RVRenteeWebMvcConfig;
import com.rentvalley.rentee.config.RVSecurityConfig;
import com.rentvalley.service.config.RVRootConfig;

public class RVRenteeDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] {RVRootConfig.class, RVSecurityConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] {RVRenteeWebMvcConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"*.htm"};
	}

}
