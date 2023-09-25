package com.hm.forest.member.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hm.forest.member.model.repository.MemberRepository;
import com.hm.forest.member.model.vo.Member;

@Service
public class MemberService implements UserDetailsService {
    @Autowired
    private MemberRepository userRepository;

    // 아이디 중복 체크 메서드
    public boolean isUsernameUnique(String username) {
        Member existingUser = userRepository.findByUsername(username);
        return existingUser == null;
    }

    // UserDetailsService 메서드 구현
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = userRepository.findByUsername(username);
        if (member == null) {
            throw new UsernameNotFoundException(username);
        }
        return new org.springframework.security.core.userdetails.User(member.getUsername(), member.getPassword(), new ArrayList<>());
    }
}