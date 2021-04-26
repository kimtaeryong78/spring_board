package jmp.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jmp.spring.service.ReplyService;
import jmp.spring.vo.Criteria;
import jmp.spring.vo.ReplyVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@RestController
@RequestMapping("/replies/*")
public class ReplyController {
	
	@Setter(onMethod_ = @Autowired)
	ReplyService service;

	@PostMapping(value = "/insert")
	public ResponseEntity<Map<String,Object>> create(@RequestBody ReplyVO reply){
		int result = service.insertReply(reply);
		
		Map<String, Object> map  = new HashMap<String, Object>();
		
		if( result > 0) {
			map.put("result", "success");
			return new ResponseEntity<Map<String,Object>>(map , HttpStatus.OK);
		} else {
			map.put("result", "fail");
			return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		}
	}// board list

	@GetMapping("/pages/{bno}/{pageNum}")
	public ResponseEntity<List<ReplyVO>> getList(@PathVariable("bno") int bno,@PathVariable("pageNum") int pageNum) {
		Criteria cri = new Criteria(pageNum, 10);
		List<ReplyVO> list = service.getListAfterPaging(cri, bno);
		return new ResponseEntity<List<ReplyVO>>(list,HttpStatus.OK);
	}
	
	@PostMapping("/delete/{rno}")
	public ResponseEntity<String> delete(@PathVariable("rno") int rno){
		int result = service.deleteReply(rno);
		log.info("result >>" + result + "개");
		if( result > 0) {
			return new ResponseEntity<String>("success", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/update")
	/*
	 * update reply
	 * front data -> json -> ReplyVO reply -> DB
	 * @param vo
	 * @return Map<String, String>
	 * 
	 */
	public ResponseEntity<Map<String,String>> update(@RequestBody ReplyVO reply){
		log.info("update.........");
		
		int result = service.updateReply(reply);
		
		Map<String, String> map = new HashMap<String, String>();
		
		if( result > 0) {
			map.put("result", "success");
			return new ResponseEntity<Map<String,String>>(map , HttpStatus.OK);
		} else {
			map.put("result", "fail");
			return new ResponseEntity<Map<String,String>>(map, HttpStatus.OK);
		}
	}
	
	@GetMapping("/get/{rno}")
	public ResponseEntity<ReplyVO> get(@PathVariable("rno") int rno){
		ReplyVO result = service.getReply(rno);
		
		return new ResponseEntity<ReplyVO>(result,HttpStatus.OK);
	}
	
	@GetMapping("/delete/{rno}")
	public ResponseEntity<Map<String,String>> remove(@PathVariable("rno") int rno){
		int result = service.deleteReply(rno);
		Map<String, String> map  = new HashMap<String, String>();
		if( result > 0) {
			map.put("result", "success");
			return new ResponseEntity<Map<String,String>>(map , HttpStatus.OK);
		} else {
			map.put("result", "fail");
			return new ResponseEntity<Map<String,String>>(map, HttpStatus.OK);
		}
	}
}
