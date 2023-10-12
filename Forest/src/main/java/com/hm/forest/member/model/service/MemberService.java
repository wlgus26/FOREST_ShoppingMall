package com.hm.forest.member.model.service;

import java.util.List;

import com.hm.forest.common.util.PageInfo;
import com.hm.forest.member.model.vo.Member;

public interface MemberService {

	int save(Member member);

	Boolean isDuplicateId(String id);

	Member findMemberById(String id);

	int delete(int no);

	// 수정2
	
	// 회원 수 가져오기
	int selectmembercount(String type, String searchType, String status);
	// 회원 목록 가져오기
	List<Member> getmemberlists(String searchType, PageInfo pageInfo);
	
//	List<Member> getmemberlists(String status, String searchType, String type, PageInfo pageInfo);
	
	// 사용계정
	int updatememberstatus(String status, int no);
	
	int activateMember(String status, int no);


	
	
	
	
//
//	int selectMemberCountByType(String status);
//	
//	List<Member> getMemberlistsBySearchValue(String status, PageInfo pageInfo, String searchType, String keyWord);
//	
//	int selectMemberCountBySearchValue(String status, String searchType, String keyWord);


}
