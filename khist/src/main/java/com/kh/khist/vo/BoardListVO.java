package com.kh.khist.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class BoardListVO {
	 private int boardNo;
	 private String boardWriter;
	 private String boardTitle;
	 private String boardContent;
	 private Date boardDate;
	 private String boardCategory;
	 private int boardReadCount;
	 private String writerName;

}
