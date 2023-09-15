package com.hm.boot;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hm.boot.department.model.service.DepartmentService;
import com.hm.boot.department.model.vo.Department;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {
	// final 이므로 반드시 생성자에서 초기화해야함
	private final DepartmentService departmentService;
 	
	// 학과 정보 조회
	@GetMapping("/")
	public ModelAndView home(ModelAndView modelAndView) {
		List<Department> departments = departmentService.getDepartments();
				
		modelAndView.addObject("departments", departments);
		modelAndView.setViewName("index");
		
		return modelAndView;
	}

}
