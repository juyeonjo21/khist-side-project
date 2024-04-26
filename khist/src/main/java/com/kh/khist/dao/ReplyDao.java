package com.kh.khist.dao;

import java.util.List;

import com.kh.khist.dto.ReplyDto;

public interface ReplyDao {
	int sequence();
	void insert(ReplyDto replyDto);//등록
	boolean update(ReplyDto replyDto);//수정
	boolean delete(int replyNo);//삭제
	
	List<ReplyDto> selectList();
	ReplyDto selectOne(int replyNo);
	

}
