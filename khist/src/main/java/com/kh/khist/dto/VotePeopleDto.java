package com.kh.khist.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class VotePeopleDto {
	private String memberEmail;
	private int voteListNo;
}
