package com.hm.forest.member.model.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hm.forest.member.model.mapper.MemberMapper;
import com.hm.forest.member.model.vo.Member;

@Service
public class MemberServiceImpl implements MemberService {
//	@Autowired
//	private MemberDao dao;
	
//	@Autowired
//	private SqlSession session;
	
	@Autowired
	private MemberMapper mapper;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public Member findMemberById(String id) {
		
		return mapper.selectMemberById(id);
	}

	@Override
	@Transactional
	public int save(Member member) {
		int result = 0;
		
		if (member.getNo() == 0) {
		
		// insert
			member.setPassword(passwordEncoder.encode(member.getPassword()));
			
			result = mapper.insertMember(member);
		}
		
//		if (true) {
//			throw new RuntimeException("회원 가입 중 에러 발생");
//		}
		
		return result;
	}

	@Override
	public Boolean isDuplicateId(String id) {
		
		return this.findMemberById(id) != null;
	}

	@Override
	@Transactional
	public int delete(int no) {

		return mapper.updateMemberStatus("N", no);
	}

	@Override
	public boolean changePassword(int no, String newPassword, String pcode, String address1, String address2) {
	    Map<String, Object> paramMap = new HashMap<>();

	    paramMap.put("no", no);
	    paramMap.put("newPassword", passwordEncoder.encode(newPassword));
	    paramMap.put("pcode", pcode);
	    paramMap.put("address1", address1);
	    paramMap.put("address2", address2);

	    int updatedRows = mapper.updatePassword(paramMap);

	    return updatedRows > 0;
	}
}