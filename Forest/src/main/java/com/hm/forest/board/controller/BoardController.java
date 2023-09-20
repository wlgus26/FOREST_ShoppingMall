package com.hm.forest.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hm.forest.board.model.vo.Board;
import com.hm.forest.board.service.BoardService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {
		@Autowired
		private BoardService boardService;
	
		 @GetMapping("/notice")
		 public ModelAndView FindAll(ModelAndView modelAndView) {
			 String type = "notice";
			 List<Board> boardLists = boardService.getBoardLists(type);

			 
			 modelAndView.addObject("pageName", "notice");
			 modelAndView.addObject("boardLists", boardLists);
			 modelAndView.setViewName("page/board/notice");
			 return modelAndView;
		 }
		
		// 자주묻는질문으로 이동
		@GetMapping("/faq")
		public ModelAndView faq (ModelAndView modlAndView) {
			
			
			modlAndView.addObject("pageName", "faq");
			modlAndView.setViewName("page/board/faq");
			
			return modlAndView;
		}
		
		// 자유게시판으로 이동
		@GetMapping("/community")
		public ModelAndView communityFindAll (ModelAndView modlAndView) {
			
			modlAndView.addObject("pageName", "community");
			modlAndView.setViewName("page/board/community");
			
			return modlAndView;
		}
		
		// 실천인증으로 이동
		@GetMapping("/act")
		public ModelAndView act (ModelAndView modlAndView) {
			
			modlAndView.addObject("pageName", "act");
			modlAndView.setViewName("page/board/act");
			
			return modlAndView;
		}
		

				

		
		
		
		
}
