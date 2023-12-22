package com.kh.khist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.khist.dao.NoticeDao;
import com.kh.khist.dto.NoticeDto;

@Controller
@RequestMapping("/notice")
public class NoticeController {

	@Autowired
	private NoticeDao noticeDao;
	
	@RequestMapping("/list")
	public String list(Model model) {
		List<NoticeDto> list = noticeDao.selectList();
		model.addAttribute("list", list);
		return "notice/list";
	}
	
	@GetMapping("/insert")
	public String insert() {
		return "notice/insert";
	}
	
	/*
	 * @PostMapping("/insert") public String insert(@ModelAttribute NoticeDto
	 * noticeDto, @ModelAttribute MemberDto memberDto)
	 */
}
