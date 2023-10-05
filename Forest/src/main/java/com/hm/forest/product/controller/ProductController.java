package com.hm.forest.product.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

	
	 @GetMapping("/productdetailview")
	    public String productdetail(Model model, int no) {
		 Products products = null;
//		 
//		 products = ProductService.selectProductByNo();
//		 
//		 modelAndView.addObject("products", products);
//		 
//		 modelAndView.setViewName("page/products/productdetail");

		 // 여기서 데이터베이스에서 상품 정보를 가져오는 로직을 수행
		 products = productservice.selectProductByNo(no);

	        // 모델에 상품 정보를 추가
	        model.addAttribute("no",4);
	        model.addAttribute("name","name");
	        model.addAttribute("price",12000);
	        model.addAttribute("content","ㅁㅁㅁㅁ");
	        model.addAttribute("color","red");
	        model.addAttribute("amount",1000);
	        model.addAttribute("sizeSml","s");

	        // Thymeleaf 템플릿을 렌더링할 뷰 이름 반환
	        return "productdetail";
	 }
	 
	 
//	   @GetMapping("/products/productdetail?no=4")
//	    public String productdetail(@PathVariable("no") int no, Model model) {
//		   
//		   Products products = null;
//		   products = productservice.getProductByNo(no);
//
//	        // 뷰에 데이터 전달 및 뷰 이름 반환
//	        return "productdetail";
//	    }
	 
	 
	 
	 
//	 @GetMapping("/productdetail")
//	 private ModelAndView productdetail(@RequestParam("no") int no , ModelAndView modelAndView) {
//		 
//		 log.debug("no : ${no}");
//		 
//		 Map<String, Object> map = new HashMap<>();
//		 
//		 map.put("no",4);
//		 map.put("name","name");
//		 map.put("price",12000 );
//		 map.put("content","ㅁㅁㅁㅁ" );
//		 map.put("color","red");
//		 map.put("amount",1000);
//		 map.put("sizeSml","s");
//		 map.put("stock","aa");
//		 map.put("company","회가");
//		 map.put("discountrate",10);
//		 map.put("status","y");
//		 map.put("image","../images/product_ki1.PNG");
//		 map.put("wish",1);
//		 
//		 modelAndView.addObject("pageName", "productdetail");
//		 
//		 modelAndView.setViewName("page/products/productdetail");
//		 
////		productservice.getProducts();
//		 
//		 return modelAndView;
//	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 

}
