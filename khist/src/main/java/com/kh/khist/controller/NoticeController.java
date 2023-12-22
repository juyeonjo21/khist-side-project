package com.kh.khist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.khist.dao.NoticeDao;
import com.kh.khist.dto.MemberDto;
import com.kh.khist.dto.NoticeDto;

@Controller
@RequestMapping("/notice")
public class NoticeController {

	@Autowired
	private NoticeDao noticeDao;

	//조회
	@RequestMapping("/list")
	public String list(Model model) {
		List<NoticeDto> list = noticeDao.selectList();
		model.addAttribute("list", list);
		return "notice/list";
	}

	//등록
	@GetMapping("/insert")
	public String insert() {
		return "notice/insert";
	}

	 @PostMapping("/insert") 
	 public String insert(@ModelAttribute NoticeDto noticeDto) {
		 String memberEmail = "test1@user.kh"; //임시
		 int noticeNo = noticeDao.sequence(); 
		 noticeDto.setMemberEmail(memberEmail);
		 noticeDto.setNoticeNo(noticeNo);
		 noticeDao.insert(noticeDto);
		return "redirect:/notice/list";
	 }
	 
	 //상세
	 @RequestMapping("detail")
	 public String detail(Model model, @RequestParam int noticeNo) {
		 NoticeDto noticeDto = noticeDao.selectOne(noticeNo);
		 model.addAttribute("noticeDto", noticeDto);
		 return "notice/detail";
	 }
	 
//	 //삭제
//	 @RequestMapping("/delete")
	 
	 
}
