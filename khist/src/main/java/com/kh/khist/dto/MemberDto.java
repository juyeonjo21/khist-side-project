package com.kh.khist.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class MemberDto {
	private String memberEmail;
	private String memberPw;
	private String memberName;
	private String memberBirth;
	private int memberLevel;
	private int memberPoint;
	private Date memberJoin;
	private Date memberLogin;
	private Date memberChange;
	private int courseNo;
}
