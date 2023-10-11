package com.hm.forest;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hm.forest.member.model.vo.Member;

@RestController
public class HomeController {
	
	
	// home으로 이동
	@GetMapping("/")
	public ModelAndView home (ModelAndView modlAndView, @AuthenticationPrincipal Member loginMember) {
		modlAndView.addObject("pageName", "home");
		modlAndView.addObject("loginMember", loginMember);
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
	
	// 캠페인 페이지_mbci으로 이동
	@GetMapping("/campaign/mbci")
	public ModelAndView mbci (ModelAndView modlAndView) {
		modlAndView.addObject("pageName", "mbci");
		modlAndView.setViewName("page/campaign/mbci");
		
		return modlAndView;
	}
	
	// about으로 이동
	@GetMapping("/about")
	public ModelAndView about (ModelAndView modlAndView,  @AuthenticationPrincipal Member loginMember) {
		
		modlAndView.addObject("pageName", "about");
		modlAndView.addObject("loginMember", loginMember);
		modlAndView.setViewName("page/about");
		
        return modlAndView;
	}
	
	// 참여하기로 이동
	@GetMapping("/program")
	public ModelAndView program (ModelAndView modlAndView, @AuthenticationPrincipal Member loginMember) {
		
		modlAndView.addObject("pageName", "program");
		modlAndView.addObject("loginMember", loginMember);
		modlAndView.setViewName("page/program");
		
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
//	@GetMapping("/cart")
//	public ModelAndView cart (ModelAndView modlAndView, @AuthenticationPrincipal Member loginMember) {
//		
//		modlAndView.addObject("pageName", "cart");
//		modlAndView.addObject("loginMember", loginMember);
//		modlAndView.setViewName("page/cart");
//		
//		return modlAndView;
//	}
	
	@GetMapping("/myPage")
	public ModelAndView myPage (ModelAndView modlAndView, @AuthenticationPrincipal Member loginMember) {
		
		modlAndView.addObject("pageName", "myPage");
		modlAndView.addObject("loginMember", loginMember);
		modlAndView.setViewName("page/products/myPage");
		
		return modlAndView;
	}


	// 제품 페이지로 이동
	@GetMapping("/kitchen")
	public ModelAndView products (ModelAndView modlAndView, @AuthenticationPrincipal Member loginMember) {
		
		modlAndView.addObject("pageName", "kitchen");
		modlAndView.addObject("loginMember", loginMember);
		modlAndView.setViewName("page/products/kitchen");
		
		return modlAndView;
	}

}
