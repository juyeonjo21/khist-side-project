package com.kh.khist.dao;



import java.util.Map;

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
	public int login(MemberDto memberDto) {
		MemberDto findDto = selectOne(memberDto.getMemberEmail());
		if (findDto != null) {// 아이디가 존재한다면
			boolean result = encoder.matches(memberDto.getMemberPw(), findDto.getMemberPw());
			if (result == true) {// 비밀번호가 암호화 도구에 의해 맞다고 판정된다면
				return 3;//로그인 성공
			}
			else {
				return 2;//비밀번호 일치하지 않음
			}
		}
		else {
			return 1;//아이디 존재하지 않음
		}
	}
	
	@Override
	public void loginUpdage(String memberEmail) {
		sqlSession.update("member.loginUpdate", memberEmail);
	}
	
	@Override
	public int changePw(MemberDto memberDto, String newPw) {
		MemberDto findDto = selectOne(memberDto.getMemberEmail());
		if(findDto != null) {
			boolean result = encoder.matches(memberDto.getMemberPw(), findDto.getMemberPw());
			if(result) {
				boolean samePwAgain = encoder.matches(newPw, findDto.getMemberPw());
				if(samePwAgain) {
					return 4;
				}
				else {
					String encrypt = encoder.encode(newPw);
					Map<String, Object> param = Map.of("memberEmail", memberDto.getMemberEmail(), "memberPw", encrypt);
					sqlSession.update("member.changePw", param);
					return 3;	
				}
			}
			else return 2;//비밀번호 불일치
		}
		else return 1;//아이디 없음
	}
}
