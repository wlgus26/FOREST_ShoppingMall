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

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller

@RequestMapping("/products")
public class ProductController {
		
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/kitchen")
	public ModelAndView kitchen(ModelAndView modelAndView, 
							 @RequestParam(defaultValue =  "1") int page) {
		
		String category = "kitchen";
		int listCount = 0;
		PageInfo pageInfo = null;
		List<Product> productlists = null; 
		
//		listCount = adminService.getProductBoardCount(); // 모든 제품 개수 가져오기
		listCount = adminService.getProductBoardCountByCategory(category);  // 카테고리별 제품 개수 가져오기
		pageInfo = new PageInfo(page, 10, listCount, 8);
		productlists = adminService.getProductBoardList(category, pageInfo);
		
		log.info("Page : {}", page);
		log.info("ListCount : {}", listCount);

		modelAndView.addObject("pageName", "kitchen");
		modelAndView.addObject("pageInfo", pageInfo);
		modelAndView.addObject("productlists", productlists);
		
		System.out.println();
		
		modelAndView.setViewName("page/products/kitchen");
		
		return modelAndView;
	}

	
	@GetMapping("/style")
	private ModelAndView style (ModelAndView modelAndView, 
			 @RequestParam(defaultValue =  "1") int page) {
		
		String category = "style";
		int listCount = 0;
		PageInfo pageInfo = null;
		List<Product> productlists = null; 
		
		listCount = adminService.getProductBoardCountByCategory(category);
		pageInfo = new PageInfo(page, 10, listCount, 8);
		productlists = adminService.getProductBoardList(category, pageInfo);
		
		log.info("Page : {}", page);
		log.info("ListCount : {}", listCount);

		modelAndView.addObject("pageName", "style");
		modelAndView.addObject("pageInfo", pageInfo);
		modelAndView.addObject("productlists", productlists);
		
		System.out.println();
		
		modelAndView.setViewName("page/products/style");
		
		return modelAndView;
	}
	
	@GetMapping("/eco")
	private ModelAndView kit (ModelAndView modelAndView, 
			 @RequestParam(defaultValue =  "1") int page) {
		
		String category = "eco";
		int listCount = 0;
		PageInfo pageInfo = null;
		List<Product> productlists = null; 
		
		listCount = adminService.getProductBoardCountByCategory(category);
		pageInfo = new PageInfo(page, 10, listCount, 8);
		productlists = adminService.getProductBoardList(category, pageInfo);
		
		log.info("Page : {}", page);
		log.info("ListCount : {}", listCount);

		modelAndView.addObject("pageName", "eco");
		modelAndView.addObject("pageInfo", pageInfo);
		modelAndView.addObject("productlists", productlists);
		
		System.out.println();
		
		modelAndView.setViewName("page/products/eco");
		
		return modelAndView;
	}

	
	
	
	@GetMapping("/view")
	public ModelAndView view(ModelAndView modelAndView,
							 @RequestParam("no") int no) {
		
		log.info("view() 호출 - {}", no);

		Product product = null;
		
		product =adminService.getProductBoardByNo(no);
		
		modelAndView.addObject("pageName", "view");
		modelAndView.addObject("products", product);
		modelAndView.setViewName("page/products/view");
		
		return modelAndView;	
	}
	

}
