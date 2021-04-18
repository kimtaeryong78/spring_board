package jmp.spring.vo;

import lombok.Data;

@Data
public class Criteria {
	
	public Criteria() {	//초기에 1page 10개 띄우기(9개 안이쁨, 11개 조금 아래인 느낌 10개가 적당한듯)
		this(1,10);
	}
	
	public Criteria(int pageNum, int amount) {
		super();
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
