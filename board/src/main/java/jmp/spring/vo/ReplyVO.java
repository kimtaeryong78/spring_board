package jmp.spring.vo;

import lombok.Data;

@Data
public class ReplyVO {
	int rno;				//reply number
	int bno;				//board number
	String reply;			//reply
	String replyer;			//replyer
	String replydate;			//reply regist date
	String updatedate;		//reply update date
}
