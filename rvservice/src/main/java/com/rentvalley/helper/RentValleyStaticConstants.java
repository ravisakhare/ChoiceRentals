package com.rentvalley.helper;

public final class RentValleyStaticConstants {
	
	public static final String TILES_PLUGIN = "/WEB-INF/config/tiles.xml";
	public static final String HOME_PAGE = "home";
		
	public static final String LOGIN_VIEW = "login";
	public static final String RENTEE_REGISTER = "rentee-register";
	public static final String CUSTOMER_REGISTER = "customer-register";
	public static final String REGISTRATION_SUCCESS = "registration-success";
	public static final String ACTIVATION_SUCCESS = "activation-success";
	public static final String ACTOVATION_FAILURE = "activation-failure";
	
	public static final String RENTEE_DASHBOARD = "rentee-dashboard";
	public static final String CUSTOMER_DASHBOARD = "customer-dashboard";
	
	public static final int RENTEE_ROLENO = 4;
	public static final int CUSTOMER_ROLENO = 3;
	
	public static final String SYSTEM_USER = "system";
	public static final String USER_REGISTERED_STATUS = "R";
	public static final String USER_ACTIVATED_STATUS = "A";
	
	public static final String MAIL_FROM = "noreply@rentvalley.com";
	public static final String MAIL_TO = "swathi.jakkula@s-force.org";
	public static final String MAIL_SUBJECT = "Welcome to RentValley";
	
	public static final String EMAIL_HOST = "mail.s-force.org";
	public static final int EMAIL_PORT = 2525;
	public static final String EMAIL_USERNAME = "swathi.jakkula@s-force.org";
	public static final String EMAIL_PASSWORD = "Winter18";
	public static final String HOST = "localhost:8081/rvrentee";
	
	public static final String RENTEE_VM_TEMPLATE = "/mail-templates/rentee-registration-mail-template.vm";
	
	public static final String FURNITURE_PRODUCTS = "furniture-products";
	public static final String VEHICLE_PRODUCTS = "vehicle-products";
	private RentValleyStaticConstants() {
		// singleton class
	}	
}
