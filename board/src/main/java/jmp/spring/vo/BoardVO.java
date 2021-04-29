package jmp.spring.vo;

/*import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;*/

import lombok.Data;

@Data
public class BoardVO {
	int bno;				//board number
	String title;			//board title
	String content;			//board content
	String writer;			//board writer
	/* @DateTimeFormat(pattern = "yy/MM/dd") */
	/*Date */ String regdate;			//board regist date
	/* @DateTimeFormat(pattern = "yy/MM/dd") */
	/*Date*/ String updatedate;		//board update date
	int replycnt;
}
