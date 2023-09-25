package com.hm.forest.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
		
		// 게시글 작성 페이지 요청
		@GetMapping("/write")
		public ModelAndView write (ModelAndView modelAndView, @RequestParam("type") String type) {
			modelAndView.addObject("pageName", "write");
			modelAndView.addObject("type", type);
			modelAndView.setViewName("page/board/write");
			
			return modelAndView;
		}
		
		// 게시글 작성(등록)
		@PostMapping("/write")
		public ModelAndView save (ModelAndView modelAndView, @RequestParam("type") String type, Board board) {
			int result = 0;
			board.setType(type);
			board.setWriterNo(1);
			
			result = boardService.save(board);
			
			if (result > 0) {
				modelAndView.addObject("msg", "게시글 등록 성공");
				modelAndView.addObject("location", "view?no=" + board.getNo());				
			} else {
				modelAndView.addObject("msg", "게시글 등록 실패");
				modelAndView.addObject("location", "write?type=" + board.getType());				

			}
			modelAndView.setViewName("page/common/msg");

			return modelAndView;
		}
		
		// 게시글 수정 페이지 요청
		@GetMapping("/update")
		public ModelAndView update (ModelAndView modelAndView, @RequestParam("no") int no) {
			Board board = boardService.getBoardByNo(no);
			
			modelAndView.addObject("pageName", "update");
			modelAndView.addObject("board", board);
			modelAndView.setViewName("page/board/update");
			
			return modelAndView;
		}
		
		// 게시글 수정
		@PostMapping("/update")
		public ModelAndView save (ModelAndView modelAndView, @RequestParam("no") int no,
						   		  @RequestParam("title") String title, @RequestParam("content") String content) {
			int result = 0;
			Board board = null;
			
			board = boardService.getBoardByNo(no);
			System.out.println(title);
			board.setTitle(title);
			System.out.println("★" + board.getTitle());
			board.setContent(content);
			
			result = boardService.save(board);
		
			if (result > 0) {
				modelAndView.addObject("msg", "게시글 수정 성공");
				modelAndView.addObject("location", "view?no=" + board.getNo());								
			} else {
				modelAndView.addObject("msg", "게시글 수정 실패");
				modelAndView.addObject("location", "update?no=" + board.getNo());			
			}
	
			modelAndView.setViewName("page/common/msg");

			return modelAndView;
		}
		
		// 게시글 삭제(상태값 변경)
		@GetMapping("/delete")
		public ModelAndView delete(ModelAndView modelAndView, @RequestParam("no") int no) {
			int result = 0;
			Board board = null;
			
			board = boardService.getBoardByNo(no);
			
//			if (board != null && board.getWriterId().equals(loginMember.getId())) {
				result = boardService.delete(board.getNo());
				
				if (result > 0) {
					modelAndView.addObject("msg", "게시글이 정상적으로 삭제되었습니다.");
					modelAndView.addObject("location", board.getType());			
				} else {				
					modelAndView.addObject("msg", "게시글 삭제에 실패하였습니다.");
					modelAndView.addObject("location", "/board/view?no=" + board.getNo());				
				}
//			} else {
//				modelAndView.addObject("msg", "잘못된 접근입니다.");
//				modelAndView.addObject("location", "/board/list");
//			}
			
			modelAndView.setViewName("page/common/msg");
			
			return modelAndView;
		}
		
}
