package jmp.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jmp.spring.mapper.BoardMapper;
import jmp.spring.vo.BoardVO;
import lombok.Setter;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	@Setter(onMethod_ = @Autowired)
	BoardMapper bm;

	@GetMapping("list")
	public String boardList(Model model) {
		List<BoardVO> boardList = null;
		boardList = bm.getBoardList();
		try {
			if (boardList == null) {
				throw new Exception();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("list", boardList);
		return "/board/list";
	}// board list

	@GetMapping("register")
	public String boardForm() {
		return "/board/register";
	}// Form to insert board

	@PostMapping("register")
	public String insertBoard(BoardVO board) {
		int temp = bm.insertBoard(board);
		try {
			if (temp == 0) {
				throw new Exception();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/board/list";
	}// insert board

	@GetMapping("get")
	public String getBoardByBno(@RequestParam int bno, Model model) {
		BoardVO board = null;
		board = bm.getBoard(bno);
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
		int temp = bm.updateBoard(board);
		try {
			if (temp == 0) {
				throw new Exception();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/board/get";
	}// update board

	@GetMapping("delete")
	public String deleteBoard(@RequestParam int bno) {
		int temp = bm.deleteBoard(bno);
		try {
			if (temp == 0) {
				throw new Exception();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/board/list";
	}
}
