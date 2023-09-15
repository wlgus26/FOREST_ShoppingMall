package com.hm.boot.student.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.boot.student.model.mapper.StudentMapper;
import com.hm.boot.student.model.vo.Student;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
	@Autowired
	private final StudentMapper studentMapper;
	
	@Override
	public List<Student> getStudentsByDeptNoAndAbsenceYn(String deptNo, String absenceYn) {
		return studentMapper.selectAllByDeptNoAndAbsenceYn(deptNo, absenceYn);
	}

	@Override
	public int delete(String studentNo) {
		return studentMapper.deleteStudent(studentNo);
	}

}
