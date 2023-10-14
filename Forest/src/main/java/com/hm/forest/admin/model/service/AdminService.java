package com.hm.forest.admin.model.service;

import java.util.List;

import com.hm.forest.admin.model.vo.Product;
import com.hm.forest.common.util.PageInfo;
import com.hm.forest.member.model.vo.Cart;

public interface AdminService {
	
	// 관리자_제품등록,제품수정
	int save(Product product);

	// 관리자_제품삭제
	int delete(int no);

	// 관리자_제품목록 리스트 
	int getProductBoardCount();

	// 관리자_제품 전체 목록 조회
	List<Product> getProductBoardList(PageInfo pageInfo);

	// 관리자_특정 제품 조회
	Product getProductBoardByNo(int no);
	
	// 메인_(제품보기) 제품 리스트 카테고리별로 전체 목록 조회
	List<Product> getProductBoardList(String category, PageInfo pageInfo);
	
	// 메인_(제품보기) 제품 목록 카테고리별 리스트 전체 개수
	int getProductBoardCountByCategory(String category);

	// 단품 주문시 제품 정보 조회
	Product getItemListsByProductNoAndDetailNo(int productNo, int detailNo);

}
