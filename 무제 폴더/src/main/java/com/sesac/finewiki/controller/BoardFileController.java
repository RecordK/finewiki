package com.sesac.finewiki.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sesac.finewiki.persistence.BoardFileDAO;
import com.sesac.finewiki.util.MediaUtils;
import com.sesac.finewiki.util.UploadFileUtils; 


@RestController
@RequestMapping("/file")
public class BoardFileController {

	private static final Logger logger = LoggerFactory.getLogger(BoardFileController.class);

	private final BoardFileDAO boardFileDAO;

	@Inject
	public BoardFileController(BoardFileDAO boardFileDAO) {
		this.boardFileDAO = boardFileDAO;
	}

	// 파일 저장 기본 경로 bean 등록
	@Resource(name = "uploadPath")
	private String uploadPath;

	// 업로드 파일
	@RequestMapping(value = "/upload", method = RequestMethod.POST, produces = "text/pliain;charset=UTF-8")
	public ResponseEntity<String> uploadFile(MultipartFile file) throws Exception {
		logger.info("========================================= FILE UPLOAD =========================================");
		logger.info("ORIGINAL FILE NAME : " + file.getOriginalFilename());
		logger.info("FILE SIZE : " + file.getSize());
		logger.info("CONTENT TYPE : " + file.getContentType());
		logger.info("===============================================================================================");
		return new ResponseEntity<String>(
				UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes()),
				HttpStatus.CREATED);
	}

	// 게시글 첨부파일 조회
	@RequestMapping(value = "/list/{data_no}")
	public ResponseEntity<List<String>> fileList(@PathVariable("data_no") Integer data_no) throws Exception {
		ResponseEntity<List<String>> entity = null;
		try {
			entity = new ResponseEntity<List<String>>(boardFileDAO.getAttach(data_no), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<String>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	// 업로드 파일 보여주기
	@RequestMapping(value = "/display")
	public ResponseEntity<byte[]> displayFile(String file_name) throws Exception {
		// InputStream : 바이트 단위로 데이터를 읽는다. 외부로부터 읽어 들이는 기능관련 클래스
		InputStream inputStream = null;
		ResponseEntity<byte[]> entity = null;
		logger.info("file name : " + file_name);
		try {
			// 파일 확장자 추출
			String formatName = file_name.substring(file_name.lastIndexOf(".") + 1);
			// 이미지 파일 여부 확인, 이미지 파일일 경우 이미지 MINEType 지정
			MediaType mediaType = MediaUtils.getMediaType(formatName);
			// HttpHeaders 객체 생성
			HttpHeaders httpHeaders = new HttpHeaders();
			// 실제 경로의 파일을 읽어들이고 InputStream 객체 생성
			inputStream = new FileInputStream(uploadPath + file_name);
			// 이미지 파일일 경우
			if (mediaType != null) {
				httpHeaders.setContentType(mediaType);
				// 이미지 파일이 아닐 경우
			} else {
				// 디렉토리 + UUID 제거
				file_name = file_name.substring(file_name.indexOf("_") + 1);
				// 다운로드 MIME Type 지정
				httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				// 한글이름의 파일 인코딩처리
				httpHeaders.add("Content-Disposition",
						"attachment; filename=\"" + new String(file_name.getBytes("UTF-8"), "ISO-8859-1") + "\"");
			}
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(inputStream), httpHeaders, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			inputStream.close();
		}
		return entity;
	}

	// 단일 파일 데이터 삭제1 : 게시글 작성화면
	@ResponseBody
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ResponseEntity<String> boardWriteRemoveFile(String file_name) throws Exception {
		// 파일 삭제
		UploadFileUtils.removeFile(uploadPath, file_name);
		return new ResponseEntity<String>("DELETED", HttpStatus.OK);
	}

	// 단일 파일 데이터 삭제2 : 게시글 수정화면
	@Transactional
	@ResponseBody
	@RequestMapping(value = "/delete/{data_no}", method = RequestMethod.POST)
	public ResponseEntity<String> boardMofifyRemoveFile(@PathVariable("data_no") Integer data_no, String file_name,
			HttpServletRequest request) throws Exception {
		// DB에서 파일명 제거
		boardFileDAO.deleteAttach(file_name);
		// 첨부파일 갯수 갱신
		boardFileDAO.updateAttachCnt(data_no);
		// 파일 삭제
		UploadFileUtils.removeFile(uploadPath, file_name);
		return new ResponseEntity<String>("DELETED", HttpStatus.OK);
	}

	// 전체 파일 삭제 : 게시글 삭제 처리시
	@ResponseBody
	@RequestMapping(value = "/delete/all", method = RequestMethod.POST)
	public ResponseEntity<String> boardDeleteRemoveAllFiles(@RequestParam("files[]") String[] files) {
		// 파일이 없을 경우 메서드 종료
		if (files == null || files.length == 0) {
			return new ResponseEntity<String>("DELETED", HttpStatus.OK);
		}
		// 파일이 존재할 경우 반복문 수행
		for (String file_name : files) {
			// 파일 삭제
			UploadFileUtils.removeFile(uploadPath, file_name);
		}
		return new ResponseEntity<String>("DELETED", HttpStatus.OK);
	}
}
