package com.kh.spring.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring.member.model.vo.Member;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Autowired
	SqlSessionTemplate sqlSession;
	
	@Override
	public Member login(Member member) {
		return sqlSession.selectOne("member.login", member);
	}

	@Override
	public int enrollMember(Member member) {
		return sqlSession.insert("member.enrollMember", member);
	}

	@Override
	public Member loginedMember(String userId) {
		return sqlSession.selectOne("member.loginedMember", userId);
	}

	@Override
	public int memberUpdate(Member member) {
		return sqlSession.update("member.updateMember", member);
	}	
	
}
