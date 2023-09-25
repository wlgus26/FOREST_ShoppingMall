package com.hm.forest.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hm.forest.admin.controller.AdminController;
import com.hm.forest.product.model.service.ProductService;
import com.hm.forest.product.model.vo.Products;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productservice;
	
	@GetMapping("/kitchen")
	private ModelAndView kitchen (ModelAndView modelAndView) {
		
		modelAndView.addObject("pageName", "kitchen");
		modelAndView.setViewName("page/products/kitchen");
		
		productservice.getProducts();
		
		return modelAndView;
	}
	

	
	@GetMapping("/style")
	private ModelAndView style (ModelAndView modelAndView) {
		
		modelAndView.addObject("PageName", "style");
		modelAndView.setViewName("page/products/style");
		
		productservice.getProducts();
		
		return modelAndView;
	}
	
	@GetMapping("/eco")
	private ModelAndView eco (ModelAndView modelAndView) {
		
		modelAndView.addObject("PageName", "eco");
		modelAndView.setViewName("page/products/eco");
		
		productservice.getProducts();
		
		return modelAndView;
	}
	
	@GetMapping("/{productno}")
	public ModelAndView viewProductDetails(Products products, ModelAndView modelAndView) {
		
		
		modelAndView.addObject("product", products);
		modelAndView.setViewName("page/products/productdetail");
		
		return modelAndView;
	}
	
	
//	@GetMapping("/productdetail")
//	private ModelAndView productdetail (ModelAndView modelAndView) {
//		
//		modelAndView.addObject("PageName", "productdetail");
//		modelAndView.setViewName("page/products/productdetail");
//		
//		productservice.getProducts();
//		
//		return modelAndView;
//	}
	
	
	

}
