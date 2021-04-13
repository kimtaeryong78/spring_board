package jmp.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jmp.spring.service.BoardService;
import jmp.spring.vo.BoardVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/board/*")
public class BoardController {

	@Setter(onMethod_ = @Autowired)
	BoardService service;

	@GetMapping("list")
	public void boardList(Model model) {
		List<BoardVO> boardList = null;
		boardList = service.getList();
		try {
			if (boardList == null) {
				throw new Exception();
			}
		} catch (Exception e) {
			log.error("error>> nullPointerException(boardList)");
		}
		model.addAttribute("list", boardList);
	}// board list
	
	@GetMapping("register")
	public String boardForm() {
		return "/board/register";
	}// Form to insert board

	@PostMapping("register")
	public String insertBoard(BoardVO board) {
		
		int temp = service.insertBoard(board);
		try {if (temp == 0) throw new Exception();
		} catch (Exception e) {log.error("error>> insert fail");
		} return "redirect:/board/list";
	}// insert board
}
