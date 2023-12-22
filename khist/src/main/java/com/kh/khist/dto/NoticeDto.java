package com.kh.khist.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class NoticeDto {
	
	private int noticeNo;
	private String memberEmail;
	private String noticeTitle, noticeContent;
	private Date noticeTime;

}
