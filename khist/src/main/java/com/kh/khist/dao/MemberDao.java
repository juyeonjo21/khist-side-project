package com.kh.khist.dao;

import com.kh.khist.dto.MemberDto;

public interface MemberDao {
	void join(MemberDto memberDto);
	MemberDto selectOne(String memberEmail); 
	int login(MemberDto memberDto);
	void loginUpdage(String memberEmail);
	int changePw(MemberDto memberDto, String newPw);
}
