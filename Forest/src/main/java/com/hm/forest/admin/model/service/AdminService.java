package com.hm.forest.admin.model.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hm.forest.admin.model.vo.Product;
import com.hm.forest.common.util.PageInfo;

public interface AdminService {
	
	// 제품등록,제품수정
	int save(Product product);

	// 제품삭제
	int delete(int no);

	// 제품목록 리스트 
	int getProductBoardCount();

	// 제품
	List<Product> getProductBoardList(PageInfo pageInfo);

	// 제품
	Product getProductBoardByNo(int no);


	

}
