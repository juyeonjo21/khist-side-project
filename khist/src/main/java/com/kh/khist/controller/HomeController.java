package com.kh.khist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String home(Model model, HttpSession session) {
		String MemberEmail = (String) session.getAttribute("email");
		model.addAttribute("email", MemberEmail);
		return "home";
	}
}