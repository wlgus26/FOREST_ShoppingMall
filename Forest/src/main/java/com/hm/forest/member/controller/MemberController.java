package com.hm.forest.member.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.hm.forest.member.model.service.MemberService;
import com.hm.forest.member.model.vo.Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
// Model 객체에 loginMember라는 키값으로 Attribute가 추가되면 
// 해당 Attribute를 세션 영역에 추가하는 어노테이션이다.
public class MemberController {

	@Autowired
	private MemberService service;
	
	@PostMapping("/enroll")
	public ModelAndView enroll(ModelAndView modelAndView, Member member) {
		
		int result = service.save(member);
		
		if (result > 0) {
			modelAndView.addObject("msg", "회원 가입 성공");
			modelAndView.addObject("location", "/");
		} else {
			modelAndView.addObject("msg", "회원 가입 실패");
			modelAndView.addObject("location", "/enroll");			
		}
		
		modelAndView.setViewName("page/common/msg");
		
		return modelAndView;
	}
	
	@GetMapping("/member/idCheck")
	public ResponseEntity<Map<String, Boolean>> idCheck(@RequestParam String userId) {
		Map<String, Boolean> map = new HashMap<>();
		
		map.put("duplicate", service.isDuplicateId(userId));
		
		return ResponseEntity.ok()
							 .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
							 .body(map);
	}
	
	// 회원 정보 수정
	// 메소드의 리턴 타입이 void일 경우 Mapping URL을 유추해서 뷰를 찾는다.	
	@PostMapping("/member/update")
	public ModelAndView update(ModelAndView modelAndView,
							   @SessionAttribute("loginMember") Member loginMember,
						 	   Member member) {
		
		member.setNo(loginMember.getNo());
		
		log.info("update() 호출 - {}", member.toString());
		
		int result = service.save(member);
		
		if (result > 0) {
			modelAndView.addObject("loginMember", service.findMemberById(loginMember.getId()));
			modelAndView.addObject("msg", "회원 정보 수정 완료");
		} else {
			modelAndView.addObject("msg", "회원 정보 수정 실패");
		}
		
		modelAndView.addObject("location", "/member/myPage");			
		modelAndView.setViewName("common/msg");
		
		return modelAndView;
	}
	
	// 회원 삭제
	@GetMapping("/member/delete")
	public ModelAndView delete(ModelAndView modelAndView,
							   @SessionAttribute Member loginMember) {
		
		log.info("delete() 호출 - {}", loginMember.toString());
		
		int result = service.delete(loginMember.getNo());
		
		if (result > 0) {
			modelAndView.addObject("msg", "정상적으로 탈퇴되었습니다.");
			modelAndView.addObject("location", "/logout");
		} else {
			modelAndView.addObject("msg", "탈퇴에 실패하였습니다.");
			modelAndView.addObject("location", "/member/myPage");			
		}
		
		modelAndView.setViewName("common/msg");
		
		return modelAndView;
	}
	
	
	
	
}









