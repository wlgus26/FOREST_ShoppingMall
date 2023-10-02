package com.hm.forest.board.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hm.forest.board.model.service.BoardService;
import com.hm.forest.board.model.vo.Board;
import com.hm.forest.board.model.vo.Reply;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/reply")
public class ReplyController {
	@Autowired
	private BoardService boardService;

	// 비동기 통신 응답
	// 댓글 조회
	@GetMapping("/{boardNo}")
	public ResponseEntity<Map<String, Object>> professor(@PathVariable("boardNo") int boardNo) {
		Map<String, Object> map = new HashMap<>();
		
		map.put("listCount", boardService.selectReplyCountByBoardNo(boardNo));
		map.put("replies", boardService.getRepliesByBoardNo(boardNo));
			
		return ResponseEntity.ok(map);
	}
			
	
	// 댓글 등록
	@PostMapping("/enroll")
	public ResponseEntity<Map<String, Object>> enroll(@RequestBody Reply reply)  {
		int result = 0;
		
		System.out.println(reply);
		System.out.println(reply.getCreateDate());
		
		Map<String, Object> map = new HashMap<>();
		
		result = boardService.save(reply);
		
		map.put("resultCode", result);
		map.put("reply", reply);
	
		
		return ResponseEntity.ok(map);
	}
	
	// 댓글 수정
		@PostMapping("/update")
		public ResponseEntity<Map<String, Object>> update(@RequestBody Reply reply)  {
			int result = 0;
			
			System.out.println(reply);
			
			Map<String, Object> map = new HashMap<>();
			
			result = boardService.save(reply);
			
			map.put("resultCode", result);
			map.put("reply", reply);
		
			return ResponseEntity.ok(map);
		}
		
		
		// 댓글 수정 테스트
		@GetMapping("/updateTest")
		public ModelAndView updateTest (ModelAndView modelAndView) {
			
			modelAndView.addObject("pageName", "boardUpdate");
			modelAndView.setViewName("page/board/update");
			
			return modelAndView;
		}
}
