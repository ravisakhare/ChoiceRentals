package com.rentvalley.rentee.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import com.rentvalley.helper.RentValleyStaticConstants;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.rentvalley.rentee.controller.account", " com.rentvalley.rentee.handler.security",
		"com.rentvalley.rentee.validator" })
public class RVRenteeWebMvcConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/home.htm").setViewName(RentValleyStaticConstants.HOME_PAGE);
		registry.addViewController("/rentee-dashboard.htm").setViewName(RentValleyStaticConstants.RENTEE_DASHBOARD);
		registry.addViewController("/customer-dashboard.htm").setViewName(RentValleyStaticConstants.CUSTOMER_DASHBOARD);
	}

	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer.setDefinitions(RentValleyStaticConstants.TILES_PLUGIN);
		tilesConfigurer.setCheckRefresh(true);
		return tilesConfigurer;
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		TilesViewResolver viewResolver = null;
		viewResolver = new TilesViewResolver();
		viewResolver.setViewClass(TilesView.class);
		registry.viewResolver(viewResolver);
	}
}
