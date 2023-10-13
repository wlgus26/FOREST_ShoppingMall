package com.hm.forest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hm.forest.admin.model.service.AdminService;
import com.hm.forest.admin.model.vo.Product;
import com.hm.forest.member.model.vo.Member;
import com.hm.forest.member.model.vo.Order;

import lombok.extern.slf4j.Slf4j;



@Slf4j
@RestController
public class HomeController {
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/success")
	public ModelAndView success(ModelAndView modelAndView, @RequestParam String paymentType, @AuthenticationPrincipal Member loginMember) {
		
		System.out.println(paymentType);
		modelAndView.addObject("pageName", "paysv");
		modelAndView.addObject("loginMember", loginMember);
		modelAndView.addObject("paymentType", paymentType);
		modelAndView.setViewName("page/paysv");
    
//		modelAndView.addObject("msg", "결제가 완료되었습니다.");
//		modelAndView.addObject("location", "view?no=" + board.getNo());	
//	}	
//} else {
//	modelAndView.addObject("msg", "게시글 등록에 실패하였습니다.");
//	modelAndView.addObject("location", "write?type=" + board.getType());				
//
//}
//modelAndView.setViewName("page/common/msg");
//		
//		
        return modelAndView;
		
	}

	
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
	
	// 결제페이지로 이동 
	@GetMapping("/pay")
	public ModelAndView pay (ModelAndView modlAndView, @AuthenticationPrincipal Member loginMember,
							 @RequestParam("productNo") int productNo, @RequestParam("detailNo") int detailNo,
						     @RequestParam("quantity") int quantity) {
		Product product = null;
		product = adminService.getProductBoardByNo(productNo);
		
		System.out.println(productNo +  detailNo + quantity);
		
		modlAndView.addObject("pageName", "pay");
		modlAndView.addObject("product", product);
		modlAndView.addObject("loginMember", loginMember);
		modlAndView.setViewName("page/pay");
		
		return modlAndView;
	}
	
	// 제품 주문하기 -> 결제페이지 
	@PostMapping("/pay")
	public ModelAndView pay (ModelAndView modlAndView, @AuthenticationPrincipal Member loginMember, @RequestBody Order order) {
		
		log.info("@@@@@@@: {}", order);
		
		modlAndView.addObject("pageName", "pay");
		modlAndView.addObject("loginMember", loginMember);
		modlAndView.setViewName("page/pay");
		
		return modlAndView;
	}
	
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
