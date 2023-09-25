package com.hm.forest.member.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hm.forest.member.model.vo.Member;

@Mapper
public interface MemberMapper {

	int selectCount();
	
	Member selectMemberById(@Param("id") String id);

}
