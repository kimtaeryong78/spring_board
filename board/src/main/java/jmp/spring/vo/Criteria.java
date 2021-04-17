package jmp.spring.vo;

import lombok.Data;

@Data
public class Criteria {
	public Criteria() {	//초기에 1page 10개 띄우기
		this(1,10);
	}
	
	public Criteria(int pageNum, int amount) {
		super();
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	int pageNum;
	int amount;
}
