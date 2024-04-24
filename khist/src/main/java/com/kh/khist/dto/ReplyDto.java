package com.kh.khist.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class ReplyDto {
	private int replyNo;
	private int boardNo;
	private String replyWriter, replyContent;
	private Date replyDate;
	private int replyParent, replyDepth, replyGroup;
	private String replyBlind;
 
}
