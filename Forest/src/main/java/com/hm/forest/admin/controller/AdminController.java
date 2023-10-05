package com.hm.forest.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.hm.forest.admin.model.service.AdminService;
import com.hm.forest.admin.model.vo.Product;
import com.hm.forest.admin.model.vo.Program;
import com.hm.forest.common.util.PageInfo;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	
	// 관리자페이지_매출관리로 이동
		@GetMapping("/salesMgmt")
		public ModelAndView salesMgmt (ModelAndView modlAndView) {
			
			modlAndView.addObject("pageName", "salesMgmt");
			modlAndView.setViewName("page/admin/salesMgmt");
			
			return modlAndView;
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
	
        // 관리자페이지_제품등록(map으로 가져와서 리스트 페이지로 포워딩까지)
		@PostMapping("/productMgmt/insert")
		public ModelAndView insert(@ModelAttribute("Product") Product product) {
		    int result = 0;
		    Map<String, Object> map = new HashMap<>();

		    result = adminService.save(product);

		    map.put("resultCode", result);
		    map.put("product", product);

		    ModelAndView modelAndView = new ModelAndView();

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
		
		// 제품 상세 페이지에서 수정버튼 누르면 수정 페이지 요청
		@GetMapping("/productMgmtUpdate")
		public ModelAndView update (ModelAndView modelAndView, @RequestParam("no") int no) {
			Product product = adminService.getProductBoardByNo(no);
			
			modelAndView.addObject("pageName", "productMgmtUpdate");
			modelAndView.addObject("product", product);
			modelAndView.setViewName("page/admin/productMgmtUpdate");
			
			return modelAndView;
		}
		
		
		
		 // ★★★ 관리자페이지_제품 수정
		 @PostMapping("/productMgmtUpdate")
		 public ModelAndView update (ModelAndView modelAndView, 
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
		 
		 // ★★★
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
	
		
		
	

		// 관리자페이지_제품등록(이미지 업로드)
//		@PostMapping("/image/upload")
//		@ResponseBody
//		public Map<String, Object> image(MultipartHttpServletRequest request) throws Exception {
//		    Map<String, Object> response = new HashMap<>();
//
//		    try {
//		        MultipartFile uploadFile = request.getFile("upload");
//		        String originalFileName = uploadFile.getOriginalFilename();
//		        String ext = originalFileName.substring(originalFileName.lastIndexOf("."));
//		        String newFileName = UUID.randomUUID().toString() + ext;
//		        int maxSize = 10485760;
//
//		        String realPath = request.getServletContext().getRealPath("/static/upload/main_file");
//		        String savePath = realPath + "upload/" + newFileName;
//		        String uploadPath = "./upload/" + newFileName;
//
//		        File file = new File(savePath);
//		        uploadFile.transferTo(file);
//
//		        // JSON 응답 생성
//		        response.put("uploaded", true);
//		        response.put("url", uploadPath);
//		    } catch (Exception e) {
//		        response.put("uploaded", false);
//		        response.put("error", "파일 업로드에 실패했습니다.");
//		        e.printStackTrace();
//		    }
//
//		    return response;
//		}

		
		// 관리자페이지_프로그램관리로 이동
		@GetMapping("/programMgmt")
		public ModelAndView programMgmt (ModelAndView modlAndView) {
			
			modlAndView.addObject("pageName", "programMgmt");
			modlAndView.setViewName("page/admin/programMgmt");
			
			return modlAndView;
		}
		
		// 관리자 페이지_프로그램 등록
		@PostMapping("/programMgmt/insert")
		public ModelAndView insert(@ModelAttribute("Program") Program program) {
			int result = 0;
			Map<String, Object> map = new HashMap<>();
			
			result = adminService.save(program);
			
			map.put("resultCode", result);
			map.put("program", program);
			
			ModelAndView modelAndView = new ModelAndView();
			
			if (result > 0) {
				// insert 성공
				modelAndView.addObject("msg", "프로그램 등록을 성공했습니다.");
			} else {
				//insert 실패
				modelAndView.addObject("msg", "프로그램 등록을 실패하였습니다.");
			}
			
			System.out.println(map);
			
			modelAndView.addObject("pageName", "programMgmtList");
			modelAndView.setViewName("redirect:/admin/programMgmtList");
			
			return modelAndView;
		}
		
		// 관리자페이지_회원관리로 이동
		@GetMapping("/memberMgmt")
		public ModelAndView memberMgmt (ModelAndView modlAndView) {
			
			modlAndView.addObject("pageName", "memberMgmt");
			modlAndView.setViewName("page/admin/memberMgmt");
			
			return modlAndView;
		}
		
		// 관리자페이지_게시판관리로 이동
		@GetMapping("/boardMgmt")
		public ModelAndView boardMgmt (ModelAndView modlAndView) {
			
			modlAndView.addObject("pageName", "boardMgmt");
			modlAndView.setViewName("page/admin/boardMgmt");
			
			return modlAndView;
		}
	



}
