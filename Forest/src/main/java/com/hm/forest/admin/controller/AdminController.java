package com.hm.forest.admin.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.hm.forest.admin.model.service.AdminService;
import com.hm.forest.admin.model.vo.Product;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
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
		
		// 관리자페이지_제품관리로 이동
		@GetMapping("/productMgmt")
		public ModelAndView AdminMgmt (ModelAndView modlAndView) {
			
			modlAndView.addObject("pageName", "productMgmt");
			modlAndView.setViewName("page/admin/productMgmt");
			
			return modlAndView;
		}
		
		// 관리자페이지_제품등록
		@PostMapping("/productMgmt/insert")
		@ResponseBody
		public String insert (Product  product) {

			System.out.println("getName :" + product.getName());
			System.out.println("getPrice :" + product.getPrice());
			System.out.println("getColor :" + product.getColor());
			
			adminService.save(product);

			return "제품이 등록되었습니다.";
		}
	






		
		

		
		// 관리자페이지_제품삭제
//		@PostMapping("/productMgmt/insert")
//		@ResponseBody
//		public ModelAndView delete(ModelAndView modlAndView, Product product) {
//
//			System.out.println("getName :" + product.getName());
//			System.out.println("getPrice :" + product.getPrice());
//			System.out.println("getColor :" + product.getColor());
//			System.out.println("amount :" + product.getAmount());
//			
//			adminService.delete(product);
//			
//			modlAndView.addObject("pageName", "productMgmt");
//			modlAndView.setViewName("page/admin/productMgmt");
//			
//			return modlAndView;
//
//		}
		

		
		
		// 관리자페이지_제품등록(이미지업로드)
//		@PostMapping(value = "/image/upload")
//		public ModelAndView image(MultipartHttpServletRequest request) throws Exception {
//			// ckeditor는 이미지 업로드 후 이미지 표시하기 위해 uploaded 와 url을 json 형식으로 받아야 함
//			// modelandview를 사용하여 json 형식으로 보내기위해 모델앤뷰 생성자 매개변수로 jsonView 라고 써줌
//			// jsonView 라고 쓴다고 무조건 json 형식으로 가는건 아니고 @Configuration 어노테이션을 단 
//			// WebConfig 파일에 MappingJackson2JsonView 객체를 리턴하는 jsonView 매서드를 만들어서 bean으로 등록해야 함 
//			
//			ModelAndView mav = new ModelAndView("jsonView");
//
//			// ckeditor 에서 파일을 보낼 때 upload : [파일] 형식으로 해서 넘어오기 때문에 upload라는 키의 밸류를 받아서 uploadFile에 저장함
//			MultipartFile uploadFile = request.getFile("upload");
//
//			// 파일의 오리지널 이름
//			String originalFileName = uploadFile.getOriginalFilename();
//
//			// 파일의 확장자
//			String ext = originalFileName.substring(originalFileName.indexOf("."));
//
//			// 서버에 저장될 때 중복된 파일 이름인 경우를 방지하기 위해 uuid에 확장자를 붙여 새로운 파일 이름 생성
//			String newFileName = UUID.randomUUID() + ext;
//
//			// 이미지를 현재 경로와 연관된 파일에 저장하기 위해 현재 경로를 알아냄
//			String realPath = request.getServletContext().getRealPath("/");
//
//			// 현재경로/upload/파일명 저장경로
//			String savePath = realPath + "upload/" + newFileName;
//	  
//			// 브라우저에서 이미지 불러올 때 절대 경로로 불러오면 보안의 위험 있어 상대경로를 쓰거나 이미지 불러오는 jsp 또는 클래스 파일을 만들어 가져오는 식으로 우회해야 함
//			// 때문에 savePath와 별개로 상대 경로인 uploadPath 만들어줌
//			String uploadPath = "./upload/" + newFileName; 
//
//			// 저장경로로 파일 객체 생성
//			File file = new File(savePath);
//
//			// 파일 업로드
//			uploadFile.transferTo(file);
//
//			// uploaded, url 값을 modelandview를 통해 보냄
//			mav.addObject("uploaded", true); // 업로드 완료
//			mav.addObject("url", uploadPath); // 업로드 파일의 경로
//
//			return mav;
//		}
		@PostMapping("/image/upload")
		@ResponseBody
		public Map<String, Object> image(MultipartHttpServletRequest request) throws Exception {
		    Map<String, Object> response = new HashMap<>();

		    try {
		        MultipartFile uploadFile = request.getFile("upload");
		        String originalFileName = uploadFile.getOriginalFilename();
		        String ext = originalFileName.substring(originalFileName.lastIndexOf("."));
		        String newFileName = UUID.randomUUID().toString() + ext;

		        String realPath = request.getServletContext().getRealPath("/");
		        String savePath = realPath + "upload/" + newFileName;
		        String uploadPath = "/upload/" + newFileName;

		        File file = new File(savePath);
		        uploadFile.transferTo(file);

		        // JSON 응답 생성
		        response.put("uploaded", true);
		        response.put("url", uploadPath);
		    } catch (Exception e) {
		        response.put("uploaded", false);
		        response.put("error", "파일 업로드에 실패했습니다.");
		        e.printStackTrace();
		    }

		    return response;
		}
		
		


		

		
		
		// 관리자페이지_클래스관리로 이동
		@GetMapping("/programMgmt")
		public ModelAndView programMgmt (ModelAndView modlAndView) {
			
			modlAndView.addObject("pageName", "programMgmt");
			modlAndView.setViewName("page/admin/programMgmt");
			
			return modlAndView;
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
