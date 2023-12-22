package com.kh.khist.dao;

import java.util.List;

import com.kh.khist.dto.NoticeDto;

public interface NoticeDao {

	int sequence();
	public void insert(NoticeDto noticeDto);
	boolean delete(int noticeNo);
	boolean update(NoticeDto noticeDto);
	List<NoticeDto> selectList();
	NoticeDto selectOne(int noticeNo);
}
