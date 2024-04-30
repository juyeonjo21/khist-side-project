package com.kh.khist.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.khist.dto.AttachDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class AttachDaoImpl implements AttachDao{

	@Autowired
	private SqlSession sqlSession;
	
	
	
	@Override
	public void insert(AttachDto attachDto) {
		sqlSession.insert("attach.add", attachDto);
	}

	@Override
	public int sequence() {
		return sqlSession.selectOne("attach.sequence");
	}

	@Override
	public boolean delete(int attachNo) {
		return sqlSession.delete("attach.delete", attachNo) > 0;
	}

	@Override
	public AttachDto selectOne(int attachNo) {
		return sqlSession.selectOne("attach.find",attachNo);
	}

	@Override
	public int findBoardNoByAttachNo(int attachNo) {
		return sqlSession.selectOne("attach.findBoardNoByAttachNo", attachNo);
	}
	

}
