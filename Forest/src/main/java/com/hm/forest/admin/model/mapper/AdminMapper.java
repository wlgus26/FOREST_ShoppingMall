package com.hm.forest.admin.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.hm.forest.admin.model.vo.Product;
import com.hm.forest.board.model.vo.Board;

@Mapper
public interface AdminMapper {
	
	int selectProductBoardCount();

	int insertProduct(Product product);

	int updateProduct(Product product);

	
	List<Product> selectAll(RowBounds bounds);
	
	Product selectProductBoardByNo(@Param("no") int no);

	// 관리자_제품 삭제
	int updateProductStatus(@Param("no") int no, @Param("status") String status);
	
	// 카테고리 별 제품 전체 목록 조회
	List<Product> selectProductListByCategory(@Param("category") String category, RowBounds bounds);

	// 카테고리 별 제품 목록 전체 개수
	int selectProductCountByCategory(String category);



}
