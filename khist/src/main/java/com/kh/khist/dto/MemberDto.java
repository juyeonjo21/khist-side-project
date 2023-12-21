package com.kh.khist.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class MemberDto {
	String memberEmail;
	String memberPw;
	String memberName;
	String memberBirth;
	String memberContact;
	int memberLevel;
	int memberPoint;
	Date memberJoin;
	Date memberLogin;
	Date memberChange;
	int courseNo;
}
