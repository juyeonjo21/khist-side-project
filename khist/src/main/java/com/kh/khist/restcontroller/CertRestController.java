package com.kh.khist.restcontroller;

import java.text.DecimalFormat;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.khist.dao.CertDao;
import com.kh.khist.dto.CertDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/cert")
public class CertRestController {

	@Autowired
	private JavaMailSender sender;

	@Autowired
	private CertDao certDao;

	@PostMapping("/{memberEmail}")
	public void send(@PathVariable String memberEmail) {
		Random r = new Random();
		int no = r.nextInt(1000000);
		DecimalFormat fm = new DecimalFormat("000000");
		String certNo = fm.format(no);

		// 발송
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(memberEmail);
		message.setSubject("[Khist] 이메일 인증번호를 안내드립니다");
		message.setText("인증번호 확인 후 입력하세요. [ " + certNo + " ]");
		sender.send(message);

		certDao.delete(memberEmail);
		CertDto certDto = new CertDto();
		certDto.setCertEmail(memberEmail);
		certDto.setCertNumber(certNo);
		certDao.insert(certDto);
	}
	
	@PostMapping("/check")
	public boolean check(@ModelAttribute CertDto certDto) {
		log.debug("certDto = {}", certDto);
		CertDto findDto = certDao.selectOne(certDto.getCertEmail());
		log.debug("findDto = {}", findDto);
		if(findDto != null) {
			boolean isValid = findDto.getCertNumber().equals(certDto.getCertNumber());
			log.debug("isValid = {}", isValid);
			if(isValid) {
				certDao.delete(certDto.getCertEmail());
				return true;
			}
		}
		return false;
	}

}
