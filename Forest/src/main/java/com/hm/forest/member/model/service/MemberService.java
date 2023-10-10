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
	int selectmembercount();

	List<Member> getmemberlists(PageInfo pageInfo);


	
	
	
	
//	List<Member> getMemberlists(String status, PageInfo pageInfo);
//
//	int selectMemberCountByType(String status);
//	
//	List<Member> getMemberlistsBySearchValue(String status, PageInfo pageInfo, String searchType, String keyWord);
//	
//	int selectMemberCountBySearchValue(String status, String searchType, String keyWord);
	

}
