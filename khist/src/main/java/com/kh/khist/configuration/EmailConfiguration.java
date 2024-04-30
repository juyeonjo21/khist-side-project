package com.kh.khist.configuration;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class EmailConfiguration {
	
	@Autowired 
	private EmailProperties emailProperties;
	
	@Bean
	public JavaMailSender sender() {
		JavaMailSenderImpl sender = new JavaMailSenderImpl();
		sender.setHost(emailProperties.getHost());//업체주소 
		sender.setPort(emailProperties.getPort());//업체포트 
		sender.setUsername(emailProperties.getUsername());
		sender.setPassword(emailProperties.getPassword());
		
		Properties props = new Properties();
		props.setProperty("mail.smtp.auth", "true");//인증 후 이용 설정(필수)
		props.setProperty("mail.smtp.debug", "true");//디버깅 기능 이용 설정(선택)
		props.setProperty("mail.smtp.starttls.enable", "true");//TLS 사용 설정(필수)
		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");//TLS 버전 설정(필수)
		props.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");//신뢰할 수 있는 대상 설정(필수)
		sender.setJavaMailProperties(props);
		return sender;
	}
}
