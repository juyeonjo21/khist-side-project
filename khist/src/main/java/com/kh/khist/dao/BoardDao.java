package com.kh.khist.dao;

import java.util.List;

import com.kh.khist.dto.BoardDto;

public interface BoardDao {

	int sequence();
	void insert(BoardDto boardDto);
	boolean update(BoardDto boardDto);
	boolean delete(int boardNo);
	
	//boolean updateReadcount(int boardNo);//조회수
	
	//목록처리
	List<BoardDto> selectList();
	
	

}
