package jmp.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jmp.spring.service.BoardService;
import jmp.spring.vo.BoardVO;
import jmp.spring.vo.Criteria;
import lombok.Setter;

@RestController
public class Reply_practice {
	
	@Setter(onMethod_ = @Autowired)
	BoardService service;
	
	@GetMapping("/reply/test/{bno}")
	public BoardVO restTest(@PathVariable("bno") Integer bno) {
		return service.getBoard(bno);
	}
	
	@GetMapping("reply/test2")
	public ResponseEntity<List<BoardVO>> restTest1(){
		Criteria cri = new Criteria();
		return new ResponseEntity<List<BoardVO>>(service.getListWithPaging(cri), HttpStatus.OK);
	}
	
	@GetMapping("reply/test1")
	public ResponseEntity<List<BoardVO>> restTest2(){
		Criteria cri = new Criteria();
		return new ResponseEntity<List<BoardVO>>(service.getListWithPaging(cri), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
