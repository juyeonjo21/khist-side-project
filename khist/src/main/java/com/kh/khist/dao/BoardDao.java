package com.kh.khist.dao;

import java.util.List;

import com.kh.khist.dto.BoardDto;

public interface BoardDao {

	int sequence();
	void insert(BoardDto boardDto);
	boolean update(BoardDto boardDto);
	boolean delete(int boardNo);
	
	List<BoardDto> selectList();
	

}
