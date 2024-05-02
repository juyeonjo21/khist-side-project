package com.kh.khist.dao;

import java.util.List;

import com.kh.khist.dto.BoardDto;
import com.kh.khist.vo.BoardListVO;

public interface BoardDao {

	int sequence();
	void insert(BoardDto boardDto);
	boolean update(BoardDto boardDto);
	boolean delete(int boardNo);
	
	//boolean updateReadcount(int boardNo);//조회수
	
	//목록처리
	List<BoardListVO> selectList();
	BoardDto selectOne(int boardNo);
	
	//회원 이메일로 이름 가져오기
	String selectMemberNameByEmail(String writerEmail);

    

}
