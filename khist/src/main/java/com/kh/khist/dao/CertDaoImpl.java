package com.kh.khist.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.khist.dto.CertDto;

@Repository
public class CertDaoImpl implements CertDao{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void insert(CertDto certDto) {
		sqlSession.insert("cert.insert", certDto);
	}
	
	@Override
	public boolean delete(String certEmail) {
		return sqlSession.delete("cert.remove", certEmail) > 0;
	}
	
	@Override
	public CertDto selectOne(String certEmail) {
		CertDto certDto = sqlSession.selectOne("cert.findCert", certEmail);
		return certDto;
	}
}
