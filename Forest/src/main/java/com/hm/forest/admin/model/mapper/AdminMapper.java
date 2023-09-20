package com.hm.forest.admin.model.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.hm.forest.admin.model.vo.Product;

@Mapper
public interface AdminMapper {
	
	int insertProduct(Product product);

}
