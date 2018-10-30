package com.rentvalley.customer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import com.rentvalley.helper.RentValleyStaticConstants;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.rentvalley.customer.controller.account", "com.rentvalley.customer.validator", "com.rentvalley.customer.handler.security"})
public class RVCustomerWebMvcConfig extends WebMvcConfigurerAdapter{

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/home.htm").setViewName(RentValleyStaticConstants.HOME_PAGE);
		registry.addViewController("/rentee-dashboard.htm").setViewName(RentValleyStaticConstants.RENTEE_DASHBOARD);
		registry.addViewController("/customer-dashboard.htm").setViewName(RentValleyStaticConstants.CUSTOMER_DASHBOARD);
	}

	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer.setDefinitions("/WEB-INF/config/tiles.xml");
		tilesConfigurer.setCheckRefresh(true);
		return tilesConfigurer;
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {

		registry.viewResolver(new TilesViewResolver());
	}
	
}
