package jmp.spring.vo;

import lombok.Data;

@Data
public class Page {
	final int PAGING = 10;	//탭 표시 갯수 : 10개
	int start, end, realEnd;//탭 처음, 탭 마지막 = (처음 + 9), 탭 진짜 마지막 숫자		//고정하기 싫다면 index 5를 분기로 중간에 무조껀 위치하게 start+1 고정시키기
	boolean prev,next;		//next와  preview 버튼 표시 처리
	
	int total;				//게시글 총 갯수
	Criteria cri;			//pagenum + amount
	
	public Page(int total, Criteria cri) {
		this.total = total;
		this.cri = cri;
		
		this.end = (int)Math.ceil((cri.getPageNum()/(PAGING * 1.0))) * PAGING;
		
		this.start = this.end - (PAGING - 1);
		
		realEnd = (int)Math.ceil( (total  * 1.0) / cri.getAmount());
		
		if(realEnd < this.end) this.end = realEnd;
		if(this.start < 0) this.start = 1;
		
		this.prev = this.start > 1;
		
		this.next = this.end < realEnd;
		
	}
}