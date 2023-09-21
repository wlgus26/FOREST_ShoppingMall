package com.hm.forest.product.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hm.forest.product.model.vo.Product;

@Mapper
public interface ProductMapper {
//	String listProduct(Product product);
	
	List<Product> listProduct(Product product);
}
