package com.hm.forest.member.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.hm.forest.common.util.PageInfo;
import com.hm.forest.member.model.vo.Cart;
import com.hm.forest.member.model.vo.Member;

@Mapper
public interface MemberMapper {
	
	int selectCount();

	Member selectMemberById(@Param("id") String id);
	
	int insertMember(Member member);
	
	int updateMember(Member member);
	
	int updateMemberStatus(@Param("status") String status, @Param("no") int no);
	
	
	int selectMemberCountByStatus(@Param("status") String status);
	
	List<Member> selectMemberlistsByStatus(@Param("status") String status, RowBounds bounds);

	// 관리자_멤버 (민지)
	
	List<Member> getmemberlists(@Param("searchType") String searchType, @Param("pageInfo") PageInfo pageInfo);
	
//	List<Member> getmemberlists (@Param("status") String status, @Param("type") String type,@Param("searchType") String searchType, RowBounds rowBounds);

	int selectmembercount(@Param("status") String status, @Param("type") String type,@Param("searchType") String searchType);
	
	int updatememberstatus(@Param("status") String status,@Param("no") int no);
	
	int activateMember(@Param("status") String status, @Param("no") int no);
	
	// 장바구니 상품 담기
	int insertIntoCart(Cart cart);

	// 장바구니 제품 목록 조회
	List<Cart> selectCartLists(@Param("memberNo") int memberNo);

	// 장바구니 제품 목록 삭제
	int deleteSelectedCartList(@Param("cartNo") String cartNo);

	// 장바구니 제품 목록 개수
	int selectCartItemsCount(@Param("memberNo") int memberNo);
}
