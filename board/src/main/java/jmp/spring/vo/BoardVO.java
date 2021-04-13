package jmp.spring.vo;

import lombok.Data;

@Data
public class BoardVO {
	int bno;				//board number
	String title;			//board title
	String content;			//board content
	String writer;			//board writer
	String regdate;			//board regist date
	String updatedate;		//board update date
}
