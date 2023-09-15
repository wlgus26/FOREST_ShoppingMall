package com.hm.boot.student.model.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	private String no;
	
	private String deptNo;
	
	private String name;
	
	private String ssn;
	
	private String address;
	
	private Date entranceDate;
	
	private String absenceYn;
	
	private String coachProfessorNo;

}
