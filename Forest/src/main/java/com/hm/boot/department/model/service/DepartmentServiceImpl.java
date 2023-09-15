package com.hm.boot.department.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.boot.department.model.mapper.DepartmentMapper;
import com.hm.boot.department.model.vo.Department;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired 
	private final DepartmentMapper departmentMapper;
	
	@Override
	public List<Department> getDepartments() {
		return departmentMapper.selectAll();
	}

}
