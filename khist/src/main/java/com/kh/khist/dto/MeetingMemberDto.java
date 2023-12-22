package com.kh.khist.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class MeetingMemberDto {
	private int meetingNo;
	private String memberEmail;
	private String meetingMemberStatus;
}
