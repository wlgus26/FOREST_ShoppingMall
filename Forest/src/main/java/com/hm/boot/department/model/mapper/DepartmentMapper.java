package com.hm.boot.department.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hm.boot.department.model.vo.Department;

@Mapper
public interface DepartmentMapper {

	List<Department> selectAll();
}
