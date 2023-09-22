package com.hm.forest.admin.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hm.forest.admin.model.vo.Product;

@Mapper
public interface AdminMapper {
	
	int insertProduct(Product product);

	int deleteProduct(Product product);
	
	List<Product> selectAll();

}
