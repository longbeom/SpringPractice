package com.kh.spring.member.model.dao;

import com.kh.spring.member.model.vo.Member;

public interface MemberDao {

	Member login(Member member);
	int enrollMember(Member member);
	Member loginedMember(String userId);
	int memberUpdate(Member member);
}
