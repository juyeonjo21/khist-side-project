package com.kh.khist.dao;



import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.khist.dto.MemberDto;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Repository
public class MemberDaoImpl implements MemberDao{

	@Autowired private SqlSession sqlSession;
	
	@Override
	public void join(MemberDto memberDto) {
		sqlSession.insert("member.join", memberDto);
	}

	@Override
	public MemberDto selectOne(String memberEmail) {
		MemberDto memberDto = sqlSession.selectOne("member.selectOne", memberEmail);
		return memberDto;
	}
}
