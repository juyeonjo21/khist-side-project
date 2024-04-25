package com.kh.khist.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.khist.dto.ReplyDto;


@Repository
public class ReplyDaoImpl implements ReplyDao{
	
	@Autowired
	private SqlSession session;

	@Override
	public int sequence() {
		return 0;
	}

	@Override
	public void insert(ReplyDto replyDto) {
		
	}

	@Override
	public boolean update(ReplyDto replyDto) {
		return false;
	}

	@Override
	public boolean delete(int replyNo) {
		return false;
	}

	@Override
	public List<ReplyDto> selectList() {
		return null;
	}

	


}
