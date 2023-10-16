package com.hm.forest.admin.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.hm.forest.admin.model.vo.Product;
import com.hm.forest.board.model.vo.Board;
import com.hm.forest.member.model.vo.Cart;


@Mapper
public interface AdminMapper {
	
	int selectProductBoardCount();

	int insertProduct(Product product);

	int updateProduct(Product product);

	
	List<Product> selectAll(RowBounds bounds);
	
	// 관리자_특정 제품 조회(view)
	Product selectProductBoardByNo(@Param("no") int no);

	// 관리자_제품 삭제
	int updateProductStatus(@Param("no") int no, @Param("status") String status);

	
	// 카테고리 별 제품 전체 목록 조회
	List<Product> selectProductListByCategory(@Param("category") String category, RowBounds bounds);

	// 카테고리 별 제품 목록 전체 개수
	int selectProductCountByCategory(String category);


	// 제품 등록 후 비동기로 제품 정보 보여주기
	List<Product> selectDetailsByProductNo();

	// 단품 주문시 상품 정보 조회
	Product selectItemLists(int productNo, int detailNo);


}
