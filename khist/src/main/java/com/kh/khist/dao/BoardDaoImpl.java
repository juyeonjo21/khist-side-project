package com.kh.khist.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.khist.dto.AttachDto;
import com.kh.khist.dto.BoardDto;
import com.kh.khist.vo.BoardListVO;

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
	public List<BoardListVO> selectList() {
		return sqlSession.selectList("board.list");
	}

	@Override
	public BoardDto selectOne(int boardNo) {
		return sqlSession.selectOne("board.findOne", boardNo);
	}

	@Override
	public String selectMemberNameByEmail(String writerEmail) {
		return sqlSession.selectOne("board.selectMemberNameByEmail", writerEmail);
	}

	@Override
	public AttachDto findBoardImage(int boardNo) {
		return sqlSession.selectOne("board.findBoardImage", boardNo);
	}

	@Override
	public void connect(int boardNo, int attachNo) {
		Map<String, Object> params = new HashMap<>();
		params.put("boardNo", boardNo);
		params.put("attachNo", attachNo);
		sqlSession.insert("board.connect", params);
	}

}
