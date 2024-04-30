package com.kh.khist.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class BoardDto {
	private int boardNo;
	private int courseNo;
	private String memberName;
	private String boardWriter, boardTitle, boardContent;
	private Date boardDate;
	private String boardCategory, boardBlind;

}
