package com.kh.khist.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.khist.dto.NoticeDto;

@Repository
public class NoticeDaoImpl implements NoticeDao{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int sequence() {
		return sqlSession.selectOne("notice.sequence");
	}

	@Override
	public void insert(NoticeDto noticeDto) {
		sqlSession.insert("notice.add", noticeDto);
	}

	@Override
	public boolean delete(int noticeNo) {
		return sqlSession.delete("notice.delete", noticeNo) > 0;
	}

	@Override
	public boolean update(NoticeDto noticeDto) {
		Map<String, Object> params = new HashMap<>();
		params.put("noticeNo", noticeDto.getNoticeNo());
		params.put("noticeDto", noticeDto);
		return sqlSession.update("notice.edit", params) > 0;
	}

	@Override
	public List<NoticeDto> selectList() {
		return sqlSession.selectList("notice.list");
	}

}
