package com.hm.forest.product.model.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.hm.forest.product.model.vo.Product;

@Mapper
public interface ProductMapper {
	
	int insertproduct(Product product);

}
