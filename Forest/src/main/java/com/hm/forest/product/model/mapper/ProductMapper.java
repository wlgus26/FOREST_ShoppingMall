package com.hm.forest.product.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hm.forest.product.model.vo.Product;

@Mapper
public interface ProductMapper {
	List<Product> selectAllNo(@Param("no")String no);
}
