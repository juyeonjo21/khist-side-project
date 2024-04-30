package com.kh.khist.restcontroller;
	
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.khist.dao.MemberDao;
import com.kh.khist.dto.MemberDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/member")
public class MemberRestController {
	
	@Autowired
	private MemberDao memberDao;
	
	@GetMapping("/{memberEmail}")
	public MemberDto findMember(@PathVariable String memberEmail) {
		MemberDto memberDto = memberDao.selectOne(memberEmail);
		return memberDto;
	}
}
