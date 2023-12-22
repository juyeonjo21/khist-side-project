package com.kh.khist.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class VoteDto {
	private int voteNo;
	private int boardNo;
	private String voteSubject;
	private Date voteStart;
	private Date voteFinish;
	private String voteDuplication;
	private String voteAnonymous;
}
