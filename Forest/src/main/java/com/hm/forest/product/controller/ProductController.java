package com.hm.forest.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hm.forest.product.model.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/products")
@Controller
public class ProductController {
	
	@Autowired
	private ProductService productservice;
	
	@GetMapping("/kitchen")
	private ModelAndView kitchen (ModelAndView modelAndView) {
		
		modelAndView.addObject("pageName", "kitchen");
		modelAndView.setViewName("page/product/kitchen");
		
		productservice.getProducts();
		
		return modelAndView;
	}
	
	@GetMapping("/style")
	private ModelAndView style (ModelAndView modelAndView) {
		
		modelAndView.addObject("PageName", "style");
		modelAndView.setViewName("page/product/style");
		
		productservice.getProducts();
		
		return modelAndView;
	}
	
	@GetMapping("/eco")
	private ModelAndView eco (ModelAndView modelAndView) {
		
		modelAndView.addObject("PageName", "eco");
		modelAndView.setViewName("page/product/eco");
		
		productservice.getProducts();
		
		return modelAndView;
	}
	

}
