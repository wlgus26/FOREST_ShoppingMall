package com.hm.forest.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

<<<<<<< HEAD
=======
import com.hm.forest.admin.model.service.AdminService;
import com.hm.forest.admin.model.vo.Product;
import com.hm.forest.common.util.PageInfo;
>>>>>>> 06a49d1f52ba0c1426d0c9372fd7200ebfa2421a
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
	
<<<<<<< HEAD
//	@GetMapping("/products/{no}")
//	public ModelAndView productdetail(@PathVariable int no, ModelAndView modelAndView) {
//		
//	    Products product = productservice.getProductsById(no);
//	    
//	    modelAndView.addObject("product", product);
//	    modelAndView.setViewName("page/products/productdetail");
//	    return modelAndView;
//	}
	
	@GetMapping("/products/productDetail")
	private ModelAndView detail (ModelAndView modelAndView) {
=======

	@GetMapping("/productdetail")
	private ModelAndView productdetail(@RequestParam("no") int no , ModelAndView modelAndView) {
>>>>>>> 06a49d1f52ba0c1426d0c9372fd7200ebfa2421a
		
		modelAndView.addObject("PageName", "productDetail");
		modelAndView.setViewName("page/products/productDetail");
		
		
		
		return modelAndView;
	}
<<<<<<< HEAD
=======
	

	
	
>>>>>>> 06a49d1f52ba0c1426d0c9372fd7200ebfa2421a

	
	 @GetMapping("/productdetail/{no}")
	    public ModelAndView productdetail(ModelAndView modelAndView, @RequestParam(name = "no" , required = true) int no) {
//		 Products products = null;
//		 
//		 products = ProductService.selectProductByNo();
//		 
//		 modelAndView.addObject("products", products);
//		 
//		 modelAndView.setViewName("page/products/productdetail");
//
		 System.out.println("★★no값 : " + no);
		 // 여기서 데이터베이스에서 상품 정보를 가져오는 로직을 수행
//		 products = productservice.selectProductByNo(no);
//
//		 System.out.println("★★products값 : " + products);
//	        // 모델에 상품 정보를 추가
//	        modelAndView.addObject("no",4);
//	        modelAndView.addObject("name","name");
//	        modelAndView.addObject("price",12000);
//	        modelAndView.addObject("content","ㅁㅁㅁㅁ");
//	        modelAndView.addObject("color","red");
//	        modelAndView.addObject("amount",1000);
//	        modelAndView.addObject("sizeSml","s");
//	        
//	       modelAndView.setViewName("/products/productdetail");
//
//	        // Thymeleaf 템플릿을 렌더링할 뷰 이름 반환
		 
		  modelAndView.addObject("pageName", "productdetail");
		  modelAndView.addObject("no", no);
		  
		  modelAndView.setViewName("page/products/productdetail");
		 
	        return modelAndView;
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
