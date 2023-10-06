package com.hm.forest.admin.model.service;

import java.util.List;

import com.hm.forest.admin.model.vo.Product;
import com.hm.forest.common.util.PageInfo;
import com.hm.forest.member.model.vo.Member;

public interface AdminService {
	
	int save(Product product);

	int delete(int no);

	// 제품목록 리스트 
	int getProductBoardCount();

	List<Product> getProductBoardList(PageInfo pageInfo);

	Product getProductBoardByNo(int no);
	
//	List<Member> getMemberlists(String id, PageInfo pageInfo);
//
//	int findMemberById(String id);
}
