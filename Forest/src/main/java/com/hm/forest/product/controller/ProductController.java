package com.hm.forest.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hm.forest.admin.model.service.AdminService;
import com.hm.forest.admin.model.vo.Product;
import com.hm.forest.common.util.PageInfo;
import com.hm.forest.product.model.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productservice;
	
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/kitchen")
		public ModelAndView list(ModelAndView modelAndView, 
				 				@RequestParam(defaultValue =  "1") int page) {
			
			int listCount = 0;
			PageInfo pageInfo = null;
			List<Product> productlists = null; 
			
			listCount = adminService.getProductBoardCount();
			pageInfo = new PageInfo(page, 10, listCount, 10);
			productlists = adminService.getProductBoardList(pageInfo);
			
			log.info("Page : {}", page);
			log.info("ListCount : {}", listCount);
			
			modelAndView.addObject("pageInfo", pageInfo);
			modelAndView.addObject("productlists", productlists);
			
			System.out.println();
			
			modelAndView.setViewName("page/products/kitchen");
			
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
	

	@GetMapping("/productdetail")
	private ModelAndView productdetail(@RequestParam("no") int no , ModelAndView modelAndView) {
		
		modelAndView.addObject("pageName", "productdetail");
		
		modelAndView.setViewName("page/products/productdetail");
		
		productservice.getProducts();
		
		return modelAndView;
	}
	

	
	

	
	
	

}
