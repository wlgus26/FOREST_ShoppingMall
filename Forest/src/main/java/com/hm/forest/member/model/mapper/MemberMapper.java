package com.hm.forest.member.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

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
}
