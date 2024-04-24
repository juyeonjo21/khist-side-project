package com.kh.khist.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class CourseDto {

	private int courseNo;
	private int teacherNo;
	private String courseName, coursePlace;
	private Date courseDate;

}
