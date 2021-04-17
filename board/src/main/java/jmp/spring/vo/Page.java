package jmp.spring.vo;

import lombok.Data;

@Data
public class Page {
	int start, end, realEnd;
	boolean prev,next;
	
	int total;
	Criteria cri;
	
	public Page(int total, Criteria cri) {
		this.total = total;
		this.cri = cri;
		
		this.end = (int)Math.ceil((cri.getPageNum()/10.0))  *  10;
		
		this.start = this.end - cri.getAmount()+1;
		
		this.realEnd = (int)Math.ceil( (total  * 1.0)  / cri.getAmount());
		
		if(realEnd < this.end) this.end = realEnd;
		
		this.prev = this.start > 1;
		
		this.next = this.end < this.realEnd;

	}
}
	
