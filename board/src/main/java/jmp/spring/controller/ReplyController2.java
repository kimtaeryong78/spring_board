package jmp.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jmp.spring.service.ReplyService;
import jmp.spring.vo.Criteria;
import jmp.spring.vo.Page;
import jmp.spring.vo.ReplyVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/board/*")
public class ReplyController2 {
	
	@Setter(onMethod_ = @Autowired)
	ReplyService service;

	@GetMapping("reply")
	public void boardList(Criteria cri, Model model){
		
		int total = service.totalReply();
		
	}// board list

}
