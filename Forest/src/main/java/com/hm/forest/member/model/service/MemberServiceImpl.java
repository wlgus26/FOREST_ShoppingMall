package com.hm.forest.member.model.service;

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
		
		if (member.getNo() > 0) {
			// update
			result = mapper.updateMember(member);
		} else {
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


	
	
//	@Override
//	public int selectMemberCountByStatus(String status) {
//
//		return mapper.selectMemberCountByStatus(status);
//	}
//	
//	@Override
//	public List<Member> getMemberlists(String status, PageInfo pageInfo) {
//		int limit = pageInfo.getListLimit();
//		int offset = (pageInfo.getCurrentPage() - 1) * limit;
//		
//		RowBounds bounds = new RowBounds(offset, limit);
//		
//		
//		return mapper.selectMemberlistsByStatus(status,bounds);
//	}



}