package com.hm.forest.admin.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.hm.forest.admin.model.vo.Product;
import com.hm.forest.admin.model.vo.Program;

@Mapper
public interface AdminMapper {
	
	int selectProductBoardCount();

	int insertProduct(Product product);

	int updateProduct(Product product);

	
	List<Product> selectAll(RowBounds bounds);
	
	Product selectProductBoardByNo(@Param("no") int no);

	int updateProductStatus(@Param("no") int no, @Param("status") String status);

	
	int selectProgramBoardCount();
	
	int insertProgram(Program program);
	
	int updateProgram(Program program);
	
	Program selectProgramBoardByNo (@Param("no") int no);
	
	List<Program> SelectAll (RowBounds rowBounds);
	
	
}
