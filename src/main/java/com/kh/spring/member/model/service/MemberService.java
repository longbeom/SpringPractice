package com.kh.spring.member.model.service;

import com.kh.spring.member.model.vo.Member;

public interface MemberService {

	Member login(Member member);
	int enrollMember(Member member);
	Member loginedMember(String userId);
	int memberUpdate(Member member);
}
