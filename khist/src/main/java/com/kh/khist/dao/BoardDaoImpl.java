package com.kh.khist.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.khist.dto.BoardDto;

@Repository
public class BoardDaoImpl implements BoardDao{

	@Autowired
	private SqlSession sqlSession;
	
	
	@Override
	public int sequence() {
		return sqlSession.selectOne("board.sequence");
	}

	@Override
	public void insert(BoardDto boardDto) {
		sqlSession.insert("board.add", boardDto);
	}

	@Override
	public boolean update(BoardDto boardDto) {
		Map<String, Object> params = new HashMap<>();
		params.put("boardNo", boardDto.getBoardNo());
		params.put("boardDto", boardDto);
		return sqlSession.update("board.edit", params) > 0;
	}

	@Override
	public boolean delete(int boardNo) {
		return sqlSession.delete("board.delete", boardNo) > 0;
	}

	@Override
	public List<BoardDto> selectList() {
		return sqlSession.selectList("board.list");
	}

}
