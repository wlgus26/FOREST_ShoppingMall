package com.hm.forest.product.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hm.forest.admin.model.vo.Product;
import com.hm.forest.product.model.vo.Products;

@Mapper
public interface ProductMapper {

	List<Products> listProduct();

	Products findById(int no);

	List<Products> selectAll();

//	List<Products> selectProductByNo();
	
	Products selectProductByNo(@Param("no") int no);
	//@Param("no") 

	Products getProductByNo(int no);

	List<Product> getAllProducts();
	}
