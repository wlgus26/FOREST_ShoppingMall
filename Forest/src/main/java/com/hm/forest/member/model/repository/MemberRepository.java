package com.hm.forest.member.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hm.forest.member.model.vo.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByUsername(String username);
}
