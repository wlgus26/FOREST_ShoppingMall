package com.hm.boot.student.model.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hm.boot.student.model.vo.Student;

public interface StudentService {

	List<Student> getStudentsByDeptNoAndAbsenceYn(@Param("deptNo") String deptNo, String absenceYn);

	int delete(@Param("studentNo") String studentNo);

}
