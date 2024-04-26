package com.kh.khist.dao;



import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.kh.khist.dto.MemberDto;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Repository
public class MemberDaoImpl implements MemberDao{

	@Autowired 
	private SqlSession sqlSession;
	
	@Autowired 
	private BCryptPasswordEncoder encoder;
	
	@Override
	public void join(MemberDto memberDto) {
		String originPw = memberDto.getMemberPw();
		String encrypt = encoder.encode(originPw);
		memberDto.setMemberPw(encrypt);
		sqlSession.insert("member.join", memberDto);
	}

	@Override
	public MemberDto selectOne(String memberEmail) {
		MemberDto memberDto = sqlSession.selectOne("member.selectOne", memberEmail);
		return memberDto;
	}
	
	@Override
	public MemberDto login(MemberDto memberDto) {
		MemberDto findDto = selectOne(memberDto.getMemberEmail());
		if (findDto != null) {// 아이디가 존재한다면
			boolean result = encoder.matches(memberDto.getMemberPw(), findDto.getMemberPw());
			if (result == true) {// 비밀번호가 암호화 도구에 의해 맞다고 판정된다면
				return findDto;
			}
		}
		return null;
	}
}
