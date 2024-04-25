package com.kh.khist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.khist.dao.MemberDao;
import com.kh.khist.dto.MemberDto;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired private MemberDao memberDao;
	
	@GetMapping("/join")
	public String join() {
		return "member/join";
	}
	
	@PostMapping("/join")
	public String join(@ModelAttribute MemberDto memberDto) {
		memberDao.join(memberDto);
		return "redirect:joinFinish";
	}
	
	@RequestMapping("/joinFinish")
	public String joinFinish() {
		return "member/joinFinish";
	}
	
	@GetMapping("/login")
	public String login() {
		return "member/login";
	}
	
	@PostMapping("/login")
		public String login(@ModelAttribute MemberDto memberDto, HttpSession session) {
		String memberEmail = memberDto.getMemberEmail();
		MemberDto findMemberDto = memberDao.selectOne(memberEmail);
		if(findMemberDto == null) return "redirect:login?error";
		
		boolean correctPw = memberDto.getMemberPw().equals(findMemberDto.getMemberPw());
		
		if(correctPw) {
			session.setAttribute("email", findMemberDto.getMemberEmail());
			session.setAttribute("level", findMemberDto.getMemberLevel());
			session.setAttribute("course", findMemberDto.getCourseNo());
		}
		else {
			return "redirect:login?error";
		}
		
		return "redirect:/";
	}
}
