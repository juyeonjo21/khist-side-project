package com.kh.khist.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class MeetingDto {
	private int meetingNo;
	private int board_no;
	private String meetingTitle;
	private String meetingContent;
	private String meetingLocation;
	private String meetingStatus;
	private Date meetingDate;
}
