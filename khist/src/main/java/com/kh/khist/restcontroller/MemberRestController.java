package com.kh.khist.restcontroller;
	
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.khist.dao.MemberDao;
import com.kh.khist.dto.MemberDto;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
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
	
	@PostMapping("/login")
	public int login(
					HttpServletResponse response,
					@ModelAttribute MemberDto memberDto, 
					HttpSession session, 
					@RequestParam(required = false, defaultValue = "false") boolean remember
			) {
		int result = memberDao.login(memberDto);
		
		if(result == 3) {
			session.setAttribute("email", memberDto.getMemberEmail());
			session.setAttribute("level", memberDto.getMemberLevel());
			session.setAttribute("course", memberDto.getCourseNo());
			if(remember) {//아이디 저장
				Cookie cookie = new Cookie("saveEmail", memberDto.getMemberEmail());
				cookie.setMaxAge(4*7*24*60*60);
				response.addCookie(cookie);
			}
			else {
				Cookie cookie = new Cookie("saveEmail", memberDto.getMemberEmail());
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
		}
		return result;
	}
}
