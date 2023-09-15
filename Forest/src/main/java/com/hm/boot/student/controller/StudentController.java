package com.hm.boot.student.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hm.boot.student.model.service.StudentService;
import com.hm.boot.student.model.vo.Student;

import lombok.RequiredArgsConstructor;

@RestController // 모든 요청을 비동기통신으로 할 거라 여기서는 RestController 사용
@RequiredArgsConstructor
public class StudentController {
	@Autowired
	private final StudentService studentService;
	 
	@GetMapping("/students")
	public Map<String, List<Student>> students(@RequestParam String deptNo, @RequestParam String absenceYn) {
		Map<String, List<Student>> map = new HashMap<>();
		
		System.out.println(absenceYn);
		map.put("students", studentService.getStudentsByDeptNoAndAbsenceYn(deptNo, absenceYn));

		return map;
	}
	
	// 비동기 통신 응답
	// @pathVariable 어노테이션이 없으면 안됨 
	@DeleteMapping("/students/{studentNo}")
	public Map<String, Object> delete(@PathVariable String studentNo) {
		Map<String, Object> map = new HashMap<>();
		
		// resultCode가 1이면 삭제성공, 0이면 삭제 실패
		map.put("resultCode", studentService.delete(studentNo));
		
		return map;
	}
}
