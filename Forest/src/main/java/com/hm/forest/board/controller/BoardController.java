package com.hm.forest.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
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
		public ModelAndView communityFindAll (ModelAndView modelAndView, @RequestParam(defaultValue = "1") int page) {
			String type = "community";
			int listCount = 0;
			 PageInfo pageInfo = null;
			 List<Board> boardLists = null;

			 listCount = boardService.selectBoardCountByType(type);
			 pageInfo = new PageInfo(page, 10, listCount, 10);
			 boardLists = boardService.getBoardLists(type, pageInfo);
			 
			 modelAndView.addObject("pageName", "community");
			 modelAndView.addObject("pageInfo", pageInfo);
			 modelAndView.addObject("boardLists", boardLists);
			 
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
		
		// 특정 게시글 보기(& 조회수 업데이트 & 쿠키 정보로 조회수 중복 방지)
		@GetMapping("/view")
		public ModelAndView view (ModelAndView modelAndView, @RequestParam("no") int no) {
			Board board = boardService.getBoardByNo(no);
			
			modelAndView.addObject("pageName", "view");
			modelAndView.addObject("board", board);
			modelAndView.setViewName("page/board/view");
			
			return modelAndView;
		}
		
		// 글 작성하기로 이동
		@GetMapping("/write")
		public ModelAndView write (ModelAndView modelAndView) {
			modelAndView.addObject("pageName", "write");
			modelAndView.setViewName("page/board/write");
			
			return modelAndView;
		}
		
		// 게시글 작성(등록)
		@PostMapping("/write")
		public ModelAndView write (ModelAndView modelAndView, @RequestParam("type") String type, 
					   			   Board board) {
			log.info("■■■" + type);
			int result = 0;
			
			
			
			if (result > 0) {
				modelAndView.addObject("msg", "게시글 등록 성공");
				modelAndView.addObject("location", "/board/view?no" + board.getNo());
			} else {
				
			}
			modelAndView.addObject("pageName", "write");
			modelAndView.setViewName("page/board/write");
			
			return modelAndView;
		}
		
		// 글 수정하기로 이동
		@GetMapping("/update")
		public ModelAndView update (ModelAndView modelAndView) {
			
			modelAndView.addObject("pageName", "update");
			modelAndView.setViewName("page/board/update");
			
			return modelAndView;
		}
		
		
}
