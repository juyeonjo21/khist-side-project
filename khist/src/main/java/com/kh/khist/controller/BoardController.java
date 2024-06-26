package com.kh.khist.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kh.khist.dao.AttachDao;
import com.kh.khist.dao.BoardDao;
import com.kh.khist.dto.AttachDto;
import com.kh.khist.dto.BoardDto;
import com.kh.khist.vo.BoardListVO;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardDao boardDao;
	
	@Autowired
	private AttachDao attachDao;
	
	
	
	//게시판 조회
	@RequestMapping("/list")
	public String list(Model model) {
		List<BoardListVO> list = boardDao.selectList();
		
		//각 게시물 작성자 이메일로 회원 이름 조회하여 설정
		 for (BoardListVO board : list) {
		      String writerEmail = board.getBoardWriter();
		      String writerName = boardDao.selectMemberNameByEmail(writerEmail);
		      board.setWriterName(writerName);
		    }
		 
		model.addAttribute("list", list); 
		return "board/list";
	}
	
	//게시글 작성
	@GetMapping("/write")
	public String write() {
		return "board/write";
	}
	
	@PostMapping("/write")
	public String write(@ModelAttribute BoardDto boardDto, HttpSession session, 
						@RequestParam MultipartFile attach) throws IllegalStateException, IOException {
		int boardNo = boardDao.sequence();//번호 구하고
		boardDto.setBoardNo(boardNo);//dto에 추가
		
		String memberEmail = (String) session.getAttribute("email");//id불러오고
		boardDto.setBoardWriter(memberEmail);
		boardDao.insert(boardDto);//글 등록
		
		if(!attach.isEmpty()) { //파일이 있으면
			int attachNo = attachDao.sequence();
			
			String home = "c:\\upload";
			File dir = new File(home, "khist");
			dir.mkdirs();
			
			
			File target = new File(dir, String.valueOf(attachNo));//attachNo로 저장될 파일
			attach.transferTo(target);//저장
			
			AttachDto attachDto = new AttachDto();//파일 정보들 저장
			attachDto.setAttachNo(attachNo);
			attachDto.setAttachName(attach.getOriginalFilename());
			attachDto.setAttachSize(attach.getSize());
			attachDto.setAttachType(attach.getContentType());
			attachDao.insert(attachDto);//등록
			
			//연결
			boardDao.connect(boardNo, attachNo);
			
		}
		return "redirect:/board/list";
	}
	
	
	
	//게시글 상세
	@RequestMapping("/detail")
	public String detail(Model model, @RequestParam int boardNo) {
		BoardDto boardDto = boardDao.selectOne(boardNo);
		model.addAttribute("boardDto",boardDto);
		
		// 이메일로부터 회원의 이름 가져오기
		String writerEmail = boardDto.getBoardWriter();
	    String writerName = boardDao.selectMemberNameByEmail(writerEmail);
	    model.addAttribute("writerName", writerName);
		return "board/detail";
	}
	
}
