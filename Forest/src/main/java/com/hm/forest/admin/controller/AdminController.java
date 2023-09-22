package com.hm.forest.admin.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;

import com.hm.forest.admin.model.service.AdminService;
import com.hm.forest.admin.model.vo.Product;

import groovyjarjarpicocli.CommandLine.Model;
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
		
		// 관리자페이지_제품관리로 이동
		@GetMapping("/productMgmt")
		public ModelAndView AdminMgmt (ModelAndView modlAndView) {
			
			modlAndView.addObject("pageName", "productMgmt");
			modlAndView.setViewName("page/admin/productMgmt");
			
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
		    
		    modelAndView.addObject("location", "page/admin/productMgmtList"); // 리다이렉트 URL 설정
		    modelAndView.setViewName("page/admin/productMgmtList");

		    return modelAndView;
		}
		
		
		//관리자페이지_제품목록
//		@GetMapping("/productMgmtList")
//		@ResponseBody
//		public ModelAndView productList(ModelAndView modelAndView) {
//			List<Product> productLists = adminService.getProductLists();
//			
//			modelAndView.addObject("productLists", productLists);
//			modelAndView.setViewName("page/admin/productMgmtList");
//			
//			System.out.println("productLists");
//			
//			return modelAndView;
//		}
		
	

		

	

		
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
//
//		        String realPath = request.getServletContext().getRealPath("/");
//		        String savePath = realPath + "/upload/upload/product_file/" + newFileName;
//		        String uploadPath = "/upload/" + newFileName;
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
