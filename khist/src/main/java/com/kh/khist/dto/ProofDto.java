package com.kh.khist.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class ProofDto {
	
	private String memberEmail;
	private int attachNo, courseNo;

}
