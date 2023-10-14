package com.hm.forest.member.model.service;

import com.hm.forest.member.model.vo.Member;

public interface MemberService {

	int save(Member member);

	Boolean isDuplicateId(String id);

	Member findMemberById(String id);

	int delete(int no);

	boolean changePassword(int no, String newPassword, String pcode, String address1, String address2);

}
