package com.rentvalley.rentee.controller.account;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.rentvalley.helper.RentValleyStaticConstants;

@Controller
public class ProductsController {
	
	@GetMapping("/furniture-products.htm")
	public String showFurnitureProducts(Model model) {
		return RentValleyStaticConstants.FURNITURE_PRODUCTS;
	}
	
	@GetMapping("/vehicle-products.htm")
	public String showVehicleProducts(Model model) {
		return RentValleyStaticConstants.VEHICLE_PRODUCTS;
	}
}
