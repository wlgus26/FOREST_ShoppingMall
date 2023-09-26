package com.hm.forest.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hm.forest.admin.controller.AdminController;
import com.hm.forest.admin.model.service.AdminService;
import com.hm.forest.admin.model.vo.Product;
import com.hm.forest.board.model.vo.Board;
import com.hm.forest.common.util.PageInfo;
import com.hm.forest.product.model.service.ProductService;
import com.hm.forest.product.model.vo.Products;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productservice;
	private AdminService adminService;
	
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
	
//	@GetMapping("/products/{no}")
//	public ModelAndView productdetail(@PathVariable int no, ModelAndView modelAndView) {
//		
//	    Products product = productservice.getProductsById(no);
//	    
//	    modelAndView.addObject("product", product);
//	    modelAndView.setViewName("page/products/productdetail");
//	    return modelAndView;
//	}

	@GetMapping("/productdetail")
	public ModelAndView productdetail(ModelAndView modelAndView) {
		List<Products> List = null;
		PageInfo pageInfo = null;
		
		List = productservice.getProductList(pageInfo);
		
		modelAndView.addObject("pageInfo", pageInfo);
		modelAndView.addObject("List", List);
		
		System.out.println();
		
		modelAndView.setViewName("page/products/productdetail");
		
		return modelAndView;
	}
	
	@RequestMapping("/productdetailview/{no}")
	public ModelAndView view(ModelAndView modelAndView,
							 @RequestParam("no") int no) {
		
		Products products = null;
		
		products = productservice.getProductByNo(no);
		
		modelAndView.addObject("pageName", products);
		modelAndView.setViewName("page/products/productdetail");
		
		return modelAndView;
	}
	
//	@GetMapping("/productdetailview")
//	public ModelAndView view(ModelAndView modelAndView, 
//							 @RequestParam("no") int no) {
//		
//		log.info("view() 호출 - {}", no);
//		
//		Products product = null;
//		
//		product = productservice.getProductByNo(no);
//		
//		modelAndView.addObject("pageName", "productdetailview");
//		modelAndView.addObject("product", product);
//		modelAndView.setViewName("page/products/productdetailview");
//		
//		return modelAndView;
//	}	
	
	
//	@GetMapping("/products/{productno}")
//	public ModelAndView productdetail(@PathVariable int no, ModelAndView modelAndView) {
//		
//		modelAndView.addObject("products", no);
//		modelAndView.setViewName("page/products/productdetail");
//		
//		return modelAndView;
//	}
	
	

	
	
	

}
