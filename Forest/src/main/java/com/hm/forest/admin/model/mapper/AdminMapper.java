package com.hm.forest.admin.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.hm.forest.admin.model.vo.Product;

@Mapper
public interface AdminMapper {
	
	int selectProductBoardCount();

	int insertProduct(Product product);

	int updateProduct(Product product);

	
	List<Product> selectAll(RowBounds bounds);
	
	Product selectProductBoardByNo(@Param("no") int no);

	int updateProductStatus(@Param("no") int no, @Param("status") String status);

	

	


}
