package com.kh.khist.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.khist.dto.ReplyDto;


@Repository
public class ReplyDaoImpl implements ReplyDao{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int sequence() {
		return sqlSession.selectOne("reply.sequence");
	}

	//등록
	@Override
	public void insert(ReplyDto replyDto) {
		sqlSession.insert("reply.add", replyDto);
	}

	//수정
	@Override
	public boolean update(ReplyDto replyDto) {
		Map<String,Object> params = new HashMap<>();
		params.put("replyNo", replyDto.getReplyNo());
		params.put("replyDto", replyDto);
		return sqlSession.update("reply.edit",params) > 0;
	}

	
	@Override
	public boolean delete(int replyNo) {
		return sqlSession.delete("reply.delete", replyNo) > 0;
	}

	
	@Override
	public List<ReplyDto> selectList() {
		return sqlSession.selectList("reply.findAll");
	}

	@Override
	public ReplyDto selectOne(int replyNo) {
		return sqlSession.selectOne("reply.findByReplyNo", replyNo);
	}

}
