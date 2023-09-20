package com.hm.forest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hm.forest.product.model.service.ProductService;
import com.hm.forest.product.model.vo.Product;

@Controller
public class HomeController {
	
	
	// home으로 이동
	@GetMapping("/")
	public ModelAndView home (ModelAndView modlAndView) {
		modlAndView.addObject("pageName", "home");
		modlAndView.setViewName("page/home");
    
        return modlAndView;
	}
	
	// 캠페인 페이지_aesop으로 이동
	@GetMapping("/campaign/aesop")
	public ModelAndView aseop (ModelAndView modlAndView) {
		modlAndView.addObject("pageName", "aesop");
		modlAndView.setViewName("page/campaign/aesop");
    
        return modlAndView;
	}
	
	// 캠페인 페이지_biotherm으로 이동
	@GetMapping("/campaign/biotherm")
	public ModelAndView biotherm (ModelAndView modlAndView) {
		modlAndView.addObject("pageName", "biotherm");
		modlAndView.setViewName("page/campaign/biotherm");
		
		return modlAndView;
	}
	
	// about으로 이동
	@GetMapping("/about")
	public ModelAndView about (ModelAndView modlAndView) {
		
		modlAndView.addObject("pageName", "about");
		modlAndView.setViewName("page/about");
		
        return modlAndView;
	}
	
	// 참여하기로 이동
	@GetMapping("/program")
	public ModelAndView program (ModelAndView modlAndView) {
		
		modlAndView.addObject("pageName", "program");
		modlAndView.setViewName("page/program");
		
		return modlAndView;
	}
	
	// 제품보기_주방으로 이동
	@GetMapping("/product/kitchen")
	public ModelAndView kitchen (ModelAndView modlAndView) {
		
		modlAndView.addObject("pageName", "kitchen");
		modlAndView.setViewName("page/product/kitchen");
		
		return modlAndView;
		}
		
	// 제품보기_패션으로 이동
	@GetMapping("/product/style")
	public ModelAndView style (ModelAndView modlAndView) {
		
		modlAndView.addObject("pageName", "style");
		modlAndView.setViewName("page/product/style");
		
		return modlAndView;
	}
	
	// 제품보기_친환경제품로 이동
	@GetMapping("/product/eco")
	public ModelAndView product (ModelAndView modlAndView) {
		
		modlAndView.addObject("pageName", "eco");
		modlAndView.setViewName("page/product/eco");
		
		return modlAndView;
	}
	
	// 관리자페이지_매출관리로 이동
	@GetMapping("/admin/salesMgmt")
	public ModelAndView salesMgmt (ModelAndView modlAndView) {
		
		modlAndView.addObject("pageName", "salesMgmt");
		modlAndView.setViewName("page/admin/salesMgmt");
		
		return modlAndView;
	}
	
	// 관리자페이지_제품관리로 이동
	@GetMapping("/admin/productMgmt")
	public ModelAndView productMgmt (ModelAndView modlAndView) {
		
		modlAndView.addObject("pageName", "productMgmt");
		modlAndView.setViewName("page/admin/productMgmt");
		
		return modlAndView;
	}
	
	
	
	
	// 관리자페이지_클래스관리로 이동
	@GetMapping("/admin/programMgmt")
	public ModelAndView programMgmt (ModelAndView modlAndView) {
		
		modlAndView.addObject("pageName", "programMgmt");
		modlAndView.setViewName("page/admin/programMgmt");
		
		return modlAndView;
	}
	
	// 관리자페이지_회원관리로 이동
	@GetMapping("/admin/memberMgmt")
	public ModelAndView memberMgmt (ModelAndView modlAndView) {
		
		modlAndView.addObject("pageName", "memberMgmt");
		modlAndView.setViewName("page/admin/memberMgmt");
		
		return modlAndView;
	}
	
	// 관리자페이지_게시판관리로 이동
	@GetMapping("/admin/boardMgmt")
	public ModelAndView boardMgmt (ModelAndView modlAndView) {
		
		modlAndView.addObject("pageName", "boardMgmt");
		modlAndView.setViewName("page/admin/boardMgmt");
		
		return modlAndView;
	}
	
	// 로그인 페이지로 이동 
	@GetMapping("/login")
	public ModelAndView login (ModelAndView modlAndView) {
		
		modlAndView.addObject("pageName", "login");
		modlAndView.setViewName("page/login");
		
		return modlAndView;
	}
	
	// 회원가입 페이지로 이동 
	@GetMapping("/enroll")
	public ModelAndView enroll (ModelAndView modlAndView) {
		
		modlAndView.addObject("pageName", "enroll");
		modlAndView.setViewName("page/enroll");
		
		return modlAndView;
	}
	
	// 장바구니로 이동 
	@GetMapping("/cart")
	public ModelAndView cart (ModelAndView modlAndView) {
		
		modlAndView.addObject("pageName", "cart");
		modlAndView.setViewName("page/cart");
		
		return modlAndView;
	}
	
	// 마이페이지로 이동 
	@GetMapping("/myPage")
	public ModelAndView myPage (ModelAndView modlAndView) {
		
		modlAndView.addObject("pageName", "myPage");
		modlAndView.setViewName("page/myPage");
		
		return modlAndView;
	}

}
