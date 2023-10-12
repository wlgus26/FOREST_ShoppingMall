package com.hm.forest.member.model.service;

import java.util.List;

import com.hm.forest.common.util.PageInfo;
import com.hm.forest.member.model.vo.Cart;
import com.hm.forest.member.model.vo.Member;

public interface MemberService {

	int save(Member member);

	Boolean isDuplicateId(String id);

	Member findMemberById(String id);

	int delete(int no);

	// 수정2
	int selectmembercount(String type, String searchType, String status);

	List<Member> getmemberlists(String searchType, PageInfo pageInfo);
	
//	List<Member> getmemberlists(String status, String searchType, String type, PageInfo pageInfo);

	int updatememberstatus(String status, int no);
	
	int activateMember(String status, int no);

	// 장바구니 제품 담기
	int save(Cart cart);

	// 장바구니 제품 목록 조회
	List<Cart> getCartListsByMemberNo(int memberNo);

	// 장바구니 제품 목록 삭제
	int delete(String cartNo);


	
	
	
	
//
//	int selectMemberCountByType(String status);
//	
//	List<Member> getMemberlistsBySearchValue(String status, PageInfo pageInfo, String searchType, String keyWord);
//	
//	int selectMemberCountBySearchValue(String status, String searchType, String keyWord);


}
