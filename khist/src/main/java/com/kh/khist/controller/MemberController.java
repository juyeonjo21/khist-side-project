package com.kh.khist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

	@Autowired 
	private MemberDao memberDao;
	
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
	
//	@PostMapping("/login")
//		public String login(@ModelAttribute MemberDto memberDto, HttpSession session) {
//		int result = memberDao.login(memberDto);
//		// 1 = 아이디 x, 2 = 비번 일치 x, 3 = 성공
//		if(result == 3) {
//			session.setAttribute("email", memberDto.getMemberEmail());
//			session.setAttribute("level", memberDto.getMemberLevel());
//			session.setAttribute("course", memberDto.getCourseNo());
//			return "redirect:/";
//		}
//		else {
//			return "redirect:login?error";
//		}
//	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("email");
		session.removeAttribute("level");
		session.removeAttribute("course");
		return "redirect:/";
	}
	
	@RequestMapping("/mypage")
	public String mypage(HttpSession session, Model model) {
		String memberEmail = (String) session.getAttribute("email");
		MemberDto memberDto = memberDao.selectOne(memberEmail);
		model.addAttribute("memberDto", memberDto);
		return "member/mypage";
	}
	
}
