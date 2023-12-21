package com.kh.khist.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class MessageDto {
	int messageNo;
	String messageSender;
	String messageReceiver;
	String messageContent;
	Date messageDate;
	String messageStatus;
}
