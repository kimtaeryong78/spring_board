package jmp.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String insertBoard(BoardVO board, RedirectAttributes rttr) {
		log.info(board);
		int temp = service.insertBoard(board);
		
		rttr.addFlashAttribute("resMsg",board.getBno()+"번 게시물 등록 되었습니다.");
		log.info("=========================================="+board.getBno());
		try {if (temp == 0) throw new Exception();
		} catch (Exception e) {log.error("error>> insert fail");} 
		
		return "redirect:/board/list";
	}// insert board
	
	@GetMapping("get")
	public String getBoardByBno(@RequestParam int bno, Model model) {
		BoardVO board = null;
		board = service.getBoard(bno);
		try {
			if (board == null) {
				throw new Exception();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("board", board);
		return "/board/get";
	}// get board by bno
	
	@PostMapping("edit")
	public String updateBoard(BoardVO board) {
		int temp = service.updateBoard(board);
		try {
			if (temp == 0) {
				throw new Exception();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/board/get";
	}// update board
}
