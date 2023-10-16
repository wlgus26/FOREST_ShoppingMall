package com.hm.forest.admin.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.hm.forest.admin.model.service.AdminService;
import com.hm.forest.admin.model.vo.Product;
import com.hm.forest.board.model.service.BoardService;
import com.hm.forest.board.model.vo.Board;
import com.hm.forest.common.util.MultipartFileUtil;
import com.hm.forest.common.util.PageInfo;
import com.hm.forest.member.model.service.MemberService;
import com.hm.forest.member.model.vo.Member;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private BoardService boardservice;
	
	private final ResourceLoader resourceLoader;
	
	
	// 관리자페이지_매출관리로 이동
		@GetMapping("/salesMgmt")
		public ModelAndView salesMgmt (ModelAndView modlAndView) {
			

			modlAndView.addObject("pageName", "salesMgmt");
			modlAndView.setViewName("page/admin/salesMgmt");
			
			return modlAndView;
		}
		
		// 관리자페이지_제품관리로 이동
		@GetMapping("/productMgmt")
		public ModelAndView AdminMgmt (ModelAndView modelAndView) {
			
			modelAndView.addObject("pageName", "productMgmt");
			modelAndView.setViewName("page/admin/productMgmt");
			
			return modelAndView;
		}

		
		// 관리자페이지_제품등록
//		@PostMapping("/productMgmt/insert")
//		@ResponseBody
//		public String insert (Product  product) {
//
//			System.out.println("getName :" + product.getName());
//			System.out.println("getPrice :" + product.getPrice());
//			System.out.println("getColor :" + product.getColor());
//			
//			adminService.save(product);
//
//			return "redirect:/productMgmtList";
//		}
//		
	
	
        // 관리자페이지_제품등록
		@PostMapping("/productMgmt/insert")
		public ModelAndView insert(ModelAndView modelAndView,
								   Product product,
								   @RequestParam("upfile") MultipartFile upfile) {
			
			
		    int result = 0;
		    Map<String, Object> map = new HashMap<>();
		    
		    if (upfile != null && !upfile.isEmpty()) {
				String location = null;
				String renamedFileName = null;
				
				try {


					location = resourceLoader.getResource("/static/upload/product").getFile().getPath();

					renamedFileName = MultipartFileUtil.save(upfile, location);
					
					if (renamedFileName != null) {
						
						product.setImage(renamedFileName);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				System.out.println(location + "★★★★★★★");
			}
		    
	
		    result = adminService.save(product);

		    map.put("resultCode", result);
		    map.put("product", product);


		    if (result > 0) {
		        // Insert 성공
		    	modelAndView.addObject("msg", "제품이 등록되었습니다.");
		    } else {
		        // Insert 실패
		    	modelAndView.addObject("msg", "등록에 실패하였습니다.");
		    }

		    System.out.println(map);
		    
		    modelAndView.setViewName("redirect:/admin/productMgmtList");
		    
		    return modelAndView;
		}
		
		
		
		// 관리자 페이지_제품목록 리스트
		@GetMapping("/productMgmtList")
		public ModelAndView list(ModelAndView modelAndView, 
								 @RequestParam(defaultValue =  "1") int page) {
			
			int listCount = 0;
			PageInfo pageInfo = null;
			List<Product> productlists = null; 
			
			listCount = adminService.getProductBoardCount();
			pageInfo = new PageInfo(page, 10, listCount, 10);
			productlists = adminService.getProductBoardList(pageInfo);
			
			log.info("Page : {}", page);
			log.info("ListCount : {}", listCount);

			modelAndView.addObject("pageInfo", pageInfo);
			modelAndView.addObject("productlists", productlists);
			
			System.out.println();
			
			modelAndView.setViewName("page/admin/productMgmtList");
			
			return modelAndView;
		}
		
		
		@GetMapping("/productMgmtView")
		public ModelAndView view(ModelAndView modelAndView,
								 @RequestParam("no") int no) {
			
			log.info("view() 호출 - {}", no);

			Product product = null;
			
			product =adminService.getProductBoardByNo(no);
			
			modelAndView.addObject("pageName", "productMgmtView");
			modelAndView.addObject("product", product);
			modelAndView.setViewName("page/admin/ProductMgmtView");
			
			return modelAndView;	
		}
		
		// 관리자페이지_제품 상세 페이지에서 (수정버튼 누르면)수정 페이지 요청
		@GetMapping("/productMgmtUpdate")
		public ModelAndView update (ModelAndView modelAndView, @RequestParam("no") int no) {
			Product product = adminService.getProductBoardByNo(no);
			
			modelAndView.addObject("pageName", "productMgmtUpdate");
			modelAndView.addObject("product", product);
			modelAndView.setViewName("page/admin/productMgmtUpdate");
			
			return modelAndView;
		}
		
		
		
		 // 관리자페이지_제품 수정
		 @PostMapping("/productMgmtUpdate")
		 public ModelAndView update (ModelAndView modelAndView, 
				 					 @RequestParam("upfile") MultipartFile upfile,
				 					 @RequestParam("no") int no,
				 					 @RequestParam("name") String name,
				 					 @RequestParam("price") int price,
				 					 @RequestParam("content") String content ) {

			 
			 int result = 0;
			 Product product = null;

	 
			 product = adminService.getProductBoardByNo(no);
	 
			 
			 if (upfile != null && !upfile.isEmpty()) {
					 String location = null;
					 String renamedFileName = null;
					 
			
					 try {
						location = resourceLoader.getResource("/static/upload/product/")
						 						  .getFile()
						 						  .getPath();
						
						// 이전에 업로드된 첨부파일 삭제
						if (product.getImage() != null) {
							MultipartFileUtil.delete(location + "/" + product.getImage());
							log.info(location + "★삭제된 후 location★");
							
						}
						location = resourceLoader.getResource("/static/upload/product/")
		 						  .getFile()
		 						  .getPath();
							
						// 수정된 첨부파일을 저장한다.
						renamedFileName = MultipartFileUtil.save(upfile, location);
						
						System.out.println(upfile + "★upfile★");
						System.out.println(location + "★첨부파일 저장 후 location★");
						
						if (renamedFileName != null) {
						
							product.setImage(renamedFileName);
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				 }


			 product.setName(name);
			 product.setPrice(price);
			 product.setContent(content);
			 

			 log.info("★ 보드 : {}", product);
				 
		     result = adminService.save(product);
		     
		     
		     System.out.println(result + "★★★★result★★★");

			

			 product.setName(name);
			 product.setPrice(price);
			 product.setContent(content);
		
			 log.info("★ 보드 : {}", product);
				 
		     result = adminService.save(product);

		 
				 if ( result > 0 ) {
					 modelAndView.addObject("msg", "게시글 수정 성공");
					 modelAndView.addObject("location", "/admin/productMgmtView?no=" + product.getNo()); 
				 } else {
					 modelAndView.addObject("msg", "게시글 수정 실패");
					 modelAndView.addObject("location", "/admin/productMgmtUpdate?no=" + product.getNo()); 		 
				 }
				 
				 modelAndView.setViewName("page/common/msg");

				return modelAndView;
		 }
		 
		 
		 @GetMapping("/productMgmtDelete")
		 public ModelAndView delete(ModelAndView modelAndView,
				 					@RequestParam int no) {
			 int result = 0;
			 Product product = null;
			 
			 product = adminService.getProductBoardByNo(no);
			 result = adminService.delete(product.getNo());
			 
			 if (result > 0) {
					modelAndView.addObject("msg", "게시글이 정상적으로 삭제되었습니다.");
					modelAndView.addObject("location", "/admin/productMgmtList");			
				} else {				
					modelAndView.addObject("msg", "게시글 삭제에 실패하였습니다.");
					modelAndView.addObject("location", "/admin/productMgmtView?no=" + product.getNo());				
				}
			 
			 modelAndView.setViewName("page/common/msg");
				
				return modelAndView;
		 }
		 

		
		// 관리자페이지_프로그램관리로 이동
		@GetMapping("/programMgmt")
		public ModelAndView programMgmt (ModelAndView modlAndView) {
			
			modlAndView.addObject("pageName", "programMgmt");
			modlAndView.setViewName("page/admin/programMgmt");
			
			return modlAndView;
		}
		
		
		
		// 회원 목록 가져오기

		@GetMapping("/memberMgmt")
		public ModelAndView memberlist (ModelAndView modelAndView, @RequestParam(defaultValue = "1") int page, 
										@RequestParam(required = false) String searchType) {
			
			int listcount = 0;
			PageInfo pageInfo = null;
			List<Member> memberlists = null;
			
			log.info("@@@@ 검색 값: {}", searchType);
			log.info("Page : {}", page);
			log.info("ListCount : {}", listcount);
			
			// 검색값이 있는 경우
			 if (searchType != null) {
				 listcount = memberService.selectmembercountvalue(searchType);
				 pageInfo = new PageInfo(page, 10, listcount, 10);
				 memberlists = memberService.getmemberlistsvalue(searchType, pageInfo);
				 
				 modelAndView.addObject("pageName", "memberMgmt");
				 modelAndView.addObject("pageInfo", pageInfo);
				 modelAndView.addObject("memberlists", memberlists);
				 modelAndView.addObject("searchType", searchType); // 페이징 처리를 위해 searchType값을 넘겨준다. 
			
			// 검색값이 없는 경우
			} else {
				listcount = memberService.selectmembercount();
				pageInfo = new PageInfo(page, 10, listcount, 10);
				memberlists = memberService.getmemberlists(pageInfo);
				
				modelAndView.addObject("searchType", searchType);
				modelAndView.addObject("pageName", "memberMgmt");
				modelAndView.addObject("pageInfo", pageInfo);
				modelAndView.addObject("memberlists", memberlists);
			
			}
			 
			 log.info("ListCount : {}", listcount);
			 log.info("MemberLists : {}", memberlists);
			 
			 modelAndView.setViewName("page/admin/memberMgmt");
			 
			 return modelAndView;
		}
		
		
		// 사용계정 --> 휴면계정으로 바꾸기
		
		 @PostMapping("/updatememberstatus")
		 public String updateMemberStatus(@RequestParam("no") int no) {
			    int result = memberService.updatememberstatus("N", no);

			    if (result > 0) {
			        
			        return "redirect:/admin/memberMgmt";
			    } else {
			        
			        return "redirect:/admin/memberMgmt?error=사용자%20상태%20변경에%20실패했습니다.";
			    }
			}
		 
		// 휴면계정 --> 사용계정으로 바꾸기
		 
		 @PostMapping("/activateMember")
		 public String activateMember(@RequestParam("no") int no) {
		     int result = memberService.activateMember("Y", no);

		     if (result > 0) {
		    	 
		         return "redirect:/admin/memberMgmt";
		     } else {
		    	 
		         return "errorPage"; 
		     }
		 }
		 
		 
		 
		// 게시물 전체 목록 조회(검색 기능 포함)
		 @GetMapping("/boardMgmt")
		 public ModelAndView FindAll(ModelAndView modelAndView, @RequestParam(defaultValue = "1") int page,
				 				 	 @RequestParam(required = false) String searchType, @RequestParam(defaultValue = "") String keyWord) {
			 
			 int listCount = 0;
			 PageInfo pageInfo = null;
			 List<Board> boardLists = null;
			 
	
			 // 검색값이 있는 경우
			 if (searchType != null && !keyWord.trim().equals("")) {
				 listCount = boardservice.selectboardcountsearch(searchType, keyWord);
				 pageInfo = new PageInfo(page, 10, listCount, 10);
				 boardLists = boardservice.getboardlistsearch(pageInfo, searchType, keyWord);
				 
				 modelAndView.addObject("pageName", "boardMgmt");
				 modelAndView.addObject("pageInfo", pageInfo);
				 modelAndView.addObject("searchType", searchType); // 페이징 처리를 위해 searchType과 keyWord값을 넘겨준다. 
				 modelAndView.addObject("keyWord", keyWord);
				 modelAndView.addObject("boardLists", boardLists);
			
			// 검색값이 없는 경우
			} else {
				listCount = boardservice.selectboardcount();
				pageInfo = new PageInfo(page, 10, listCount, 10);
				boardLists = boardservice.getboardlist(pageInfo);
				
				modelAndView.addObject("pageName", "boardMgmt");
				modelAndView.addObject("pageInfo", pageInfo);
				modelAndView.addObject("boardLists", boardLists);
			
		      // log.info("boardLists : {}", boardLists);
			}
			 modelAndView.setViewName("page/admin/boardMgmt");
			 
			 return modelAndView;
		}
		 
		 
		 
		 
		 
		 

		// 관리자페이지_게시판관리로 이동
//		@GetMapping("/boardMgmt")
//		public ModelAndView boardMgmt (ModelAndView modlAndView) {
//			
//			modlAndView.addObject("pageName", "boardMgmt");
//			modlAndView.setViewName("page/admin/boardMgmt");
//			
//			return modlAndView;
//		}
	

}
