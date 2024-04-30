package com.kh.khist.dao;

import com.kh.khist.dto.CertDto;

public interface CertDao {
	
	void insert(CertDto certDto);
	boolean delete(String certEmail);
	CertDto selectOne(String certEmail);
}
