package jmp.spring.vo;

import lombok.Data;

@Data
public class Criteria {
	
	public Criteria() {	//초기에 1page 10개 띄우기(9개 안이쁨, 12개 조금 아래인 느낌 10~11개가 적당한듯, 늘리려면 태그 수정해서 헤드 고정시켜야할듯)
		/* this(1,10); */
		this.pageNum = 1;
		this.amount = 10;
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}//
	
	public String[] getTypeArr() {
		return this.type == null ? new String[] {}: this.type.split("");
	}
	int pageNum;
	int amount;
	
	String type;
	String word;
}
