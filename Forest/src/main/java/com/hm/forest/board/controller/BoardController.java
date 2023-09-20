package com.hm.forest.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hm.forest.board.model.vo.Board;
import com.hm.forest.board.service.BoardService;
import com.hm.forest.common.util.PageInfo;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("/board")
public class BoardController {
		@Autowired
		private BoardService boardService;
	
		 @GetMapping("/notice")
		 public ModelAndView FindAll(ModelAndView modelAndView, @RequestParam(defaultValue = "1") int page) {
			 String type = "notice";
			 int listCount = 0;
			 PageInfo pageInfo = null;
			 List<Board> boardLists = null;

			 listCount = boardService.selectBoardCountByType(type);
			 pageInfo = new PageInfo(page, 10, listCount, 10);
			 boardLists = boardService.getBoardLists(type, pageInfo);
			 
			 modelAndView.addObject("pageName", "notice");
			 modelAndView.addObject("pageInfo", pageInfo);
			 modelAndView.addObject("boardLists", boardLists);
			 
			 modelAndView.setViewName("page/board/notice");
			 return modelAndView;

		 }
		
		// 자주묻는질문으로 이동
		@GetMapping("/faq")
		public ModelAndView faq (ModelAndView modelAndView) {
			
			modelAndView.addObject("pageName", "faq");
			modelAndView.setViewName("page/board/faq");
			
			return modelAndView;
		}
		
		// 자유게시판으로 이동
		@GetMapping("/community")
		public ModelAndView communityFindAll (ModelAndView modelAndView) {
			String type = "community";
			// List<Board> boardLists = boardService.getBoardLists(type);

			modelAndView.addObject("pageName", "community");
		//	modelAndView.addObject("boardLists", boardLists);
			modelAndView.setViewName("page/board/community");
			
			return modelAndView;
		}
		
		// 실천인증으로 이동
		@GetMapping("/act")
		public ModelAndView act (ModelAndView modelAndView) {
			
			modelAndView.addObject("pageName", "act");
			modelAndView.setViewName("page/board/act");
			
			return modelAndView;
		}
		
}
