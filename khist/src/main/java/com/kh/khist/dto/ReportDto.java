package com.kh.khist.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class ReportDto {

	private int reportNo;
	private String reportReporter, reportReported;
	private Date reportDate;
	private String reportContent;
	
}
