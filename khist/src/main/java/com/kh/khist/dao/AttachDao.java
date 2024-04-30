package com.kh.khist.dao;

import com.kh.khist.dto.AttachDto;

public interface AttachDao {
	void insert(AttachDto attachDto);
	int sequence();
	boolean delete(int attachNo);
	AttachDto selectOne(int attachNo);
	int findBoardNoByAttachNo(int attachNo);

}
