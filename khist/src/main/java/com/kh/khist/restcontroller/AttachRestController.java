package com.kh.khist.restcontroller;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.khist.configuration.FileUploadProperties;
import com.kh.khist.dao.AttachDao;
import com.kh.khist.dao.BoardDao;
import com.kh.khist.dto.AttachDto;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Tag(name = "이미지 관리", description = "이미지 관리를 위한 컨트롤러")
@CrossOrigin
@RestController
@RequestMapping("/attach")
public class AttachRestController {
	
	@Autowired
	private AttachDao attachDao;
	
	@Autowired
	private BoardDao boardDao;
	
	//초기 디렉터리 설정
	@Autowired
	private FileUploadProperties props;
	private File dir;
	
	@PostConstruct
	public void init() {
		dir = new File(props.getHome());
		dir.mkdirs();
	}
	
	@GetMapping("/board/{boardNo}")
	public ResponseEntity<ByteArrayResource>downloadBoardImage(@PathVariable int boardNo) throws IOException{
		
		AttachDto attachDto = boardDao.findBoardImage(boardNo);
		
		if(attachDto == null) { //파일이 없으면
			return ResponseEntity.notFound().build(); //404반환
		}

		String home = "c:\\upload";
		File dir = new File(home, "khist");
		
		File target = new File(dir,String.valueOf(attachDto.getAttachNo()));
		
		byte[] data = FileUtils.readFileToByteArray(target);//파일 정보 불러오기
		ByteArrayResource resource = new ByteArrayResource(data);
		
		
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_ENCODING, StandardCharsets.UTF_8.name())
				.contentLength(attachDto.getAttachSize())
				.header(HttpHeaders.CONTENT_TYPE, attachDto.getAttachType())
				.contentType(MediaType.APPLICATION_OCTET_STREAM)
				.header("content-Disposition", "attachment;filename=" + attachDto.getAttachName())
				.body(resource);
		
	}
	
	@GetMapping("/{attachNo}")
	public ResponseEntity<ByteArrayResource>downloadImage(@PathVariable int attachNo) throws IOException{
		
		AttachDto attachDto = attachDao.selectOne(attachNo);
		
		File target = new File(dir,String.valueOf(attachNo));
		byte[] data = FileUtils.readFileToByteArray(target);
		ByteArrayResource resource = new ByteArrayResource(data);
		
		
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_ENCODING, StandardCharsets.UTF_8.name())
				.contentLength(attachDto.getAttachSize())
				.header(HttpHeaders.CONTENT_TYPE, attachDto.getAttachType())
				.contentType(MediaType.APPLICATION_OCTET_STREAM)
				.header("content-Disposition", "attachment;filename=" + attachDto.getAttachName())
				.body(resource);
	}
	
	
}
