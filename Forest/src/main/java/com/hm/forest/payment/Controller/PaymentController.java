package com.hm.forest.payment.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hm.forest.admin.model.service.AdminService;
import com.hm.forest.admin.model.vo.Detail;
import com.hm.forest.admin.model.vo.Product;
import com.hm.forest.member.model.service.MemberService;
import com.hm.forest.member.model.vo.Cart;
import com.hm.forest.member.model.vo.Member;
import com.hm.forest.payment.model.service.PaymentService;
import com.hm.forest.payment.model.vo.Delivery;
import com.hm.forest.payment.model.vo.Order;
import com.hm.forest.payment.model.vo.Payment;
import com.hm.forest.payment.model.vo.Request;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/pay")
public class PaymentController {
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private PaymentService paymentService;
	
	
	// [주문하기] 장바구니 주문하기 -> 결제페이지 
	@PostMapping
	public ResponseEntity<String> pay(@RequestParam("cartNo") String cartNo, @RequestParam("totalPrice") int totalPrice, HttpSession session) {
		
	    // 데이터를 세션에 저장
	    session.setAttribute("cartNo", cartNo);
	    session.setAttribute("totalPrice", totalPrice);
	    
	    return ResponseEntity.ok().build(); // 응답은 비어있는 상태로 반환
	}
	
	// [주문하기] 장바구니 주문하기 -> 결제페이지로 이동 
	@GetMapping
	public ModelAndView pay (ModelAndView modelAndView, HttpSession session, @AuthenticationPrincipal Member loginMember) {
		String cartNo = (String) session.getAttribute("cartNo");
	    int totalPrice = (int) session.getAttribute("totalPrice");

	    log.info("Received cartNo: {}", cartNo);
		log.info("totalPrie: {}", totalPrice);
		
		List<Cart> cartLists = null; // 결제할 상품 목록들을 담을 객체
		
		// 로그인멤버별 주문서 상품 목록 조회
		int memberNo = loginMember.getNo();
		cartLists = memberService.getCartListsByMemberNoAndCartNo(memberNo, cartNo);
		
		log.info("cartLists: {}", cartLists);
		
		modelAndView.addObject("pageName", "pay");
		modelAndView.addObject("cartLists", cartLists);
	    modelAndView.addObject("totalPrice", totalPrice);
	    modelAndView.addObject("loginMember", loginMember);
	    
	    modelAndView.setViewName("page/pay");
	    
	    return modelAndView;
	}
	
	// [주문하기] 제품상세페이지 주문하기 -> 결제페이지 
	@GetMapping("/order")
	public ModelAndView pay(ModelAndView modelAndView, @AuthenticationPrincipal Member loginMember,
							@RequestParam("productNo") int productNo,
					        @RequestParam("detailNo") int detailNo,
					        @RequestParam("quantity") int quantity) {
		int totalPrice = 0;
	    Product product = null;
	    Cart cart = new Cart(); 
	    List<Cart> cartLists = new ArrayList<>();
	    
	    // 해당하는 제품 세부 정보 조회
	    product = adminService.getItemListsByProductNoAndDetailNo(productNo, detailNo);
	    
	    List<Detail> details = product.getDetails();
	    Detail detail = details.get(0); // 제품 세부정보는 Detail 객체로 가져오기

	    // cart객체 생성
	    cart.setNo(0); 
	    cart.setMemberNo(loginMember.getNo());
	    cart.setProductNo(product.getNo());
	    cart.setDetailNo(detail.getNo());
	    cart.setColor(detail.getColor());
	    cart.setSize(detail.getSizeSml());
	    cart.setStock(detail.getStock());
	    cart.setCategory(product.getCategory());
	    cart.setName(product.getName());
	    cart.setImage(product.getImage());
	    cart.setPrice(product.getPrice());
	    cart.setDiscountrate(product.getDiscountrate());
	    cart.setStatus(product.getStatus());
	    cart.setQuantity(quantity);
	  
	    // cart 객체를 cartLists에 추가
	    cartLists.add(cart); 
	    
	    int amount = (cart.getPrice() * cart.getQuantity());
	    totalPrice = amount >= 30000 ? amount : (amount + 2500);
	   
	    modelAndView.addObject("pageName", "pay");
		modelAndView.addObject("cartLists", cartLists);
	    modelAndView.addObject("totalPrice", totalPrice);
	    modelAndView.addObject("loginMember", loginMember);
	    
	    modelAndView.setViewName("page/pay");

	    return modelAndView; 
	}
	
	// 결제 요청 처리
	@PostMapping("/request")
	public ResponseEntity<Map<String, Object>> request(@AuthenticationPrincipal Member loginMember, 
												   	   @RequestBody Payment paymentRequest) {
		int memberNo = 0;
		int totalPrice = 0;
		int paymentSaveResult = 0;
		int orderSaveResult = 0;
		int deliverySaveresult = 0;
		Payment payment = new Payment();
		Map<String, Object> map = new HashMap<>();
		List<Order> orderLists = paymentRequest.getOrderLists();
		Delivery delivery = paymentRequest.getDelivery();

		// 결제하기 클릭 시 입력되는 정보들
		// 1. 결제 정보 설정(입력)
		payment.setMemberNo(loginMember.getNo()); // 주문자 번호 
		payment.setTotalPrice(paymentRequest.getTotalPrice()); // 총결제금액
		
		paymentSaveResult = paymentService.save(payment);
		
		// 2. 해당 결제에 관련된 주문정보 
		orderSaveResult = paymentService.insertOrderLists(payment.getNo(), orderLists); 
		
		// 3. 해당 결제에 관련된 배송정보
		deliverySaveresult = paymentService.save(payment.getNo(), delivery); 

		// 결제 관련 정보 입력 성공 시 
		 if (paymentSaveResult > 0 && orderSaveResult > 0 && deliverySaveresult > 0) {
	            map.put("message", "성공");
	     } else {
	            map.put("message", "실패");
	     }
		 
		map.put("no", payment.getNo()); // 결제 no 
		log.info("obj.paymentNo: ", payment.getNo());
		
		return ResponseEntity.ok(map);
	}
	
	// 결제 요청 처리(결제 성공시 처리 로직)
	@GetMapping("/request")
	public ModelAndView request(ModelAndView modelAndView, @RequestParam String paymentType, @AuthenticationPrincipal Member loginMember, @RequestParam("no") int no) {
		// 결제 실패 TEST용 코드
		// paymentType = "UNNORMAL";
		log.info("PaymentNo : ", no);
		log.info("paymentType : ", paymentType);
		
		// paymentType = NORMAL값 받는경우(결제성공) 처리할 로직(update)_컨트롤러 넘길값: productNo, deatilNo, quantity,Member loginMember
		// 1) 주문수량만큼 해당 제품의 재고테이블 수량 감소_productNo, detailNo, quantity 필요
		// 2) 결제 테이블 loginMemberNo 받아서 Status Y 로 변경 
		// 3) 결제정보 상품 리스트 출력
		
		// 결제 성공 시 
		if (paymentType.equals("NORMAL")) {
			// 1. 재고 수량 감소
			// 주문수량 확인
			log.info("PaymentNo : ",no);
			//List<Order> orderQuantity = paymentService.getOrderQuantityByNo(no);
			
//			for (Order order : orderQuantity) {
//			    System.out.println("ProductNo: " + order.getProductNo());
//			    System.out.println("DetailNo: " + order.getDetailNo());
//			    System.out.println("Quantity: " + order.getQuantity());
//			}
			
			modelAndView.addObject("pageName", "paysv");
			modelAndView.addObject("loginMember", loginMember);
			modelAndView.setViewName("page/paysv");
		} else {
			modelAndView.addObject("msg", "결제에 실패하였습니다.");
			modelAndView.addObject("location", "/");	
			modelAndView.setViewName("page/common/msg");
		}
	
	
        return modelAndView;
		
	}
	
	

}
