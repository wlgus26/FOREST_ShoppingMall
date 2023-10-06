package com.hm.forest.admin.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.hm.forest.admin.model.service.AdminService;
import com.hm.forest.admin.model.vo.Product;
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
					location = resourceLoader.getResource("classpath:/static/upload/product").getFile().getPath();

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
		    
//		    modelAndView.addObject("pageName", "productMgmtList"); // 리다이렉트 URL 설정
//		    modelAndView.setViewName("page/admin/productMgmtList");
//
//		    return modelAndView;
		    
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
				 					 @RequestParam("color") String color,
				 					 @RequestParam("amount") int amount,
				 					 @RequestParam("sizeSml") String sizeSml,
				 					 @RequestParam("content") String content) {
			 
			 int result = 0;
			 Product product = null;
	 
			 product = adminService.getProductBoardByNo(no);
			 
			 
			 if (upfile != null && !upfile.isEmpty()) {
					 String location = null;
					 String renamedFileName = null;
					 
					 try {
						location = resourceLoader.getResource("classpath:/static/upload/product/")
						 						  .getFile()
						 						  .getPath();
						
						// 이전에 업로드된 첨부파일 삭제
						if (product.getImage() != null) {
							MultipartFileUtil.delete(location + "/" + product.getImage());
							log.info(location + "★삭제된 후 location★");
							
						}
						location = resourceLoader.getResource("classpath:/static/upload/product/")
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
			 product.setColor(color);
			 product.setAmount(amount);
			 product.setSizeSml(sizeSml);
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
		@GetMapping("/memberMgmt")
		public ModelAndView programMgmt (ModelAndView modlAndView) {
			
			modlAndView.addObject("pageName", "memberMgmt");
			modlAndView.setViewName("page/admin/memberMgmt");
			
			return modlAndView;
		}
		
		
		
		
//		// 관리자페이지_회원관리로 이동
//		@GetMapping("/memberMgmt")
//		public ModelAndView memberMgmt (ModelAndView modlAndView, @RequestParam(defaultValue = "1") int page,
//										@RequestParam(defaultValue = "") String searchType, @RequestParam(defaultValue = "") String keyWord) {
//			
//			String status = "memberMgmt";
//			int listCount = 0;
//			PageInfo pageInfo = null;
//			List<Member> memberlists = null;
//			
//			if (searchType != null && ! keyWord.trim().equals("")) {
//				listCount = MemberService.selectMemberCountBySearchValue(status, searchType, keyWord);
//				pageInfo = new PageInfo(page, 10, listCount, 10);
//				memberlists = MemberService.getMemberlistsBySearchValue(status, pageInfo, searchType, keyWord);
//				
//			
//			}
//			
//			listCount = MemberService.selectMemberCountByStatus(status);
//			pageInfo = new PageInfo(page, 10, listCount, 10);
//			memberlists = MemberService.getMemberlists(status, pageInfo);
//			
//			modlAndView.addObject("pageName", "memberMgmt");
//			modlAndView.addObject("pageInfo", pageInfo);
//			modlAndView.addObject("memberlists", memberlists);
//			modlAndView.setViewName("page/admin/memberMgmt");
//			
//			return modlAndView;
//		}
		

		
		// 관리자페이지_게시판관리로 이동
		@GetMapping("/boardMgmt")
		public ModelAndView boardMgmt (ModelAndView modlAndView) {
			
			modlAndView.addObject("pageName", "boardMgmt");
			modlAndView.setViewName("page/admin/boardMgmt");
			
			return modlAndView;
		}
	



}
