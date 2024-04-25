package com.kh.khist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.khist.dao.BoardDao;
import com.kh.khist.dto.BoardDto;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardDao boardDao;
	
	
	//게시판 조회
	@RequestMapping("/list")
	public String list(Model model) {
		List<BoardDto> list = boardDao.selectList();
		model.addAttribute("list", list);
		return "board/list";
	}
	
	//게시글 작성
	@GetMapping("/write")
	public String write() {
		return "board/write";
	}
	
	@PostMapping("/write")
	public String write(@ModelAttribute BoardDto boardDto, HttpSession session) {
		int boardNo = boardDao.sequence();//번호 구하고
		boardDto.setBoardNo(boardNo);//dto에 추가
		
		String memberEmail = (String) session.getAttribute("name");//id불러오고
		boardDto.setBoardWriter(memberEmail);
		boardDao.insert(boardDto);//글 등록
		return "redirect:/board/list";
	}
	
}
