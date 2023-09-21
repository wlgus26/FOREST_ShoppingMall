package com.hm.forest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

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
	
	// 캠페인 페이지_brita으로 이동
	@GetMapping("/campaign/brita")
	public ModelAndView brita (ModelAndView modlAndView) {
		modlAndView.addObject("pageName", "brita");
		modlAndView.setViewName("page/campaign/brita");
		
		return modlAndView;
	}
	
	// 캠페인 페이지_melixir으로 이동
	@GetMapping("/campaign/melixir")
	public ModelAndView melixir (ModelAndView modlAndView) {
		modlAndView.addObject("pageName", "melixir");
		modlAndView.setViewName("page/campaign/melixir");
		
		return modlAndView;
	}
	
	// 캠페인 페이지_boonbastick으로 이동
	@GetMapping("/campaign/boonbastick")
	public ModelAndView boonbastick (ModelAndView modlAndView) {
		modlAndView.addObject("pageName", "boonbastick");
		modlAndView.setViewName("page/campaign/boonbastick");
		
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
	
	// 소통하기_공지사항으로 이동
	@GetMapping("/board/notice")
	public ModelAndView notice (ModelAndView modlAndView) {
		
		modlAndView.addObject("pageName", "notice");
		modlAndView.setViewName("page/board/notice");
		
		return modlAndView;
	}
	
	// 소통하기_자주묻는질문으로 이동
	@GetMapping("/board/faq")
	public ModelAndView faq (ModelAndView modlAndView) {
		
		modlAndView.addObject("pageName", "faq");
		modlAndView.setViewName("page/board/faq");
		
		return modlAndView;
	}
	
	// 소통하기_자유게시판으로 이동
	@GetMapping("/board/community")
	public ModelAndView community (ModelAndView modlAndView) {
		
		modlAndView.addObject("pageName", "community");
		modlAndView.setViewName("page/board/community");
		
		return modlAndView;
	}
	
	// 소통하기_실천인증으로 이동
	@GetMapping("/board/act")
	public ModelAndView act (ModelAndView modlAndView) {
		
		modlAndView.addObject("pageName", "act");
		modlAndView.setViewName("page/board/act");
		
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
