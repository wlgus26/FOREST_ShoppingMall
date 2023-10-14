package com.hm.forest;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hm.forest.admin.model.service.AdminService;
import com.hm.forest.admin.model.vo.Product;
import com.hm.forest.member.model.service.MemberService;
import com.hm.forest.member.model.vo.Cart;
import com.hm.forest.member.model.vo.Member;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
public class HomeController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private MemberService memberService;
	
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
	public ModelAndView home (ModelAndView modelAndView, @AuthenticationPrincipal Member loginMember) {
		modelAndView.addObject("pageName", "home");
		modelAndView.addObject("loginMember", loginMember);
		modelAndView.setViewName("page/home");
    
        return modelAndView;
	}
	
	// 캠페인 페이지_aesop으로 이동
	@GetMapping("/campaign/aesop")
	public ModelAndView aseop (ModelAndView modelAndView) {
		modelAndView.addObject("pageName", "aesop");
		modelAndView.setViewName("page/campaign/aesop");
    
        return modelAndView;
	}
	
	// 캠페인 페이지_biotherm으로 이동
	@GetMapping("/campaign/biotherm")
	public ModelAndView biotherm (ModelAndView modelAndView) {
		modelAndView.addObject("pageName", "biotherm");
		modelAndView.setViewName("page/campaign/biotherm");
		
		return modelAndView;
	}
	
	// 캠페인 페이지_brita으로 이동
	@GetMapping("/campaign/brita")
	public ModelAndView brita (ModelAndView modelAndView) {
		modelAndView.addObject("pageName", "brita");
		modelAndView.setViewName("page/campaign/brita");
		
		return modelAndView;
	}
	
	// 캠페인 페이지_melixir으로 이동
	@GetMapping("/campaign/melixir")
	public ModelAndView melixir (ModelAndView modelAndView) {
		modelAndView.addObject("pageName", "melixir");
		modelAndView.setViewName("page/campaign/melixir");
		
		return modelAndView;
	}
	
	// 캠페인 페이지_boonbastick으로 이동
	@GetMapping("/campaign/boonbastick")
	public ModelAndView boonbastick (ModelAndView modelAndView) {
		modelAndView.addObject("pageName", "boonbastick");
		modelAndView.setViewName("page/campaign/boonbastick");
		
		return modelAndView;
	}
	
	// 캠페인 페이지_mbci으로 이동
	@GetMapping("/campaign/mbci")
	public ModelAndView mbci (ModelAndView modelAndView) {
		modelAndView.addObject("pageName", "mbci");
		modelAndView.setViewName("page/campaign/mbci");
		
		return modelAndView;
	}
	
	// about으로 이동
	@GetMapping("/about")
	public ModelAndView about (ModelAndView modelAndView,  @AuthenticationPrincipal Member loginMember) {
		
		modelAndView.addObject("pageName", "about");
		modelAndView.addObject("loginMember", loginMember);
		modelAndView.setViewName("page/about");
		
        return modelAndView;
	}
	
	// 참여하기로 이동
	@GetMapping("/program")
	public ModelAndView program (ModelAndView modelAndView, @AuthenticationPrincipal Member loginMember) {
		
		modelAndView.addObject("pageName", "program");
		modelAndView.addObject("loginMember", loginMember);
		modelAndView.setViewName("page/program");
		
		return modelAndView;
	}
	
	
	
	
	// 로그인 페이지로 이동 
	@GetMapping("/login")
	public ModelAndView login (ModelAndView modelAndView) {
		
		modelAndView.addObject("pageName", "login");
		modelAndView.setViewName("page/login");
		
		return modelAndView;
	}
	
	// 회원가입 페이지로 이동 
	@GetMapping("/enroll")
	public ModelAndView enroll (ModelAndView modelAndView) {
		
		modelAndView.addObject("pageName", "enroll");
		modelAndView.setViewName("page/enroll");
		
		return modelAndView;
	}

	
	// (장바구니/제품상세페이지) 주문하기 -> 결제페이지 
	@PostMapping("/pay")
	public ResponseEntity<String> pay(@RequestParam("cartNo") String cartNo, @RequestParam("totalPrice") int totalPrice, HttpSession session) {

	    // 데이터를 세션에 저장
	    session.setAttribute("cartNo", cartNo);
	    session.setAttribute("totalPrice", totalPrice);
	    
	    return ResponseEntity.ok().build(); // 응답은 비어있는 상태로 반환
	}
	
	// 결제페이지로 이동 
	@GetMapping("/pay")
	public ModelAndView pay (ModelAndView modelAndView, HttpSession session, @AuthenticationPrincipal Member loginMember) {
		String cartNo = (String) session.getAttribute("cartNo");
	    int totalPrice = (int) session.getAttribute("totalPrice");

	    log.info("Received cartNo: {}", cartNo);
		log.info("&&& totalPrie: {}", totalPrice);
		
		List<Cart> cartLists = null; // 결제할 상품 목록들을 담을 객체
		
		// 로그인멤버별 주문서 상품 목록 조회
		int memberNo = loginMember.getNo();
		cartLists = memberService.getCartListsByMemberNoAndCartNo(memberNo, cartNo);
		
		log.info("??@@cartLists: {}", cartLists);
		
		modelAndView.addObject("pageName", "pay");
		modelAndView.addObject("cartLists", cartLists);
	    modelAndView.addObject("totalPrice", totalPrice);
	    modelAndView.addObject("loginMember", loginMember);
	    
	    modelAndView.setViewName("page/pay");
	    
	    return modelAndView;

	}
	
	
	@GetMapping("/myPage")
	public ModelAndView myPage (ModelAndView modelAndView, @AuthenticationPrincipal Member loginMember) {
		
		modelAndView.addObject("pageName", "myPage");
		modelAndView.addObject("loginMember", loginMember);
		modelAndView.setViewName("page/products/myPage");
		
		return modelAndView;
	}


	// 제품 페이지로 이동
	@GetMapping("/kitchen")
	public ModelAndView products (ModelAndView modelAndView, @AuthenticationPrincipal Member loginMember) {
		
		modelAndView.addObject("pageName", "kitchen");
		modelAndView.addObject("loginMember", loginMember);
		modelAndView.setViewName("page/products/kitchen");
		
		return modelAndView;
	}

}
