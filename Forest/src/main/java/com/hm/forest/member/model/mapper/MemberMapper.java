package com.hm.forest.member.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hm.forest.member.model.vo.Member;

@Mapper
public interface MemberMapper {

	Member selectMemberById(@Param("id") String id);
	
	int insertMember(Member member);
	
	int updateMember(Member member);
	
	int updateMemberStatus(@Param("status") String status, @Param("no") int no);
}
