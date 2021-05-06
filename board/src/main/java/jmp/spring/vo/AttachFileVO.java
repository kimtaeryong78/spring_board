package jmp.spring.vo;

import lombok.Data;

@Data
public class AttachFileVO {
	//첨부파일 번호
	private int attachNo;
	//uuid
	private String uuid;
	//년\\월\\일
	private String uploadPath;
	//file 진짜 이름
	private String fileName;
	//file 타입
	private String fileType;
	//등록 날짜
	private String regdate;
	//저장 경로
	private String savePath;
	//썸네일 저장 경로
	private String s_savePath;
	
}
