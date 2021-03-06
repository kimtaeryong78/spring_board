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
import jmp.spring.vo.Criteria;
import jmp.spring.vo.Page;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Setter(onMethod_ = @Autowired)
	BoardService service;

	@GetMapping("list")
	public void boardList(Criteria cri, Model model){
		List<BoardVO> boardList = null;
		
		int total = service.totalBoard(cri);
		
		boardList = service.getListWithPaging(cri);
		
		model.addAttribute("list", boardList);
		model.addAttribute("pageValues",new Page(total,cri)) ;
		
	}// board list
	
	@GetMapping("register")
	public String boardForm() {
		log.info("===================");
		return "/board/register";
	}// Form to insert board

	@PostMapping("register")
	public String insertBoard(BoardVO board, RedirectAttributes rttr) {
		log.info(board);
		int temp = service.insertBoard(board);
		
		try {
			if (temp < 0) throw new Exception();
			else {
				/* rttr.addFlashAttribute("resMsg",board.getBno()+"번 게시물 등록 되었습니다."); */
				rttr.addFlashAttribute("result",board.getBno());
				log.info("==========================================insert"+board.getBno());
			}
		} catch (Exception e) {log.error("error>> insert fail");} 
		
		return "redirect:/board/list";
	}// insert board
	
	@GetMapping("get")
	public String getBoardByBno(@RequestParam int bno,Criteria cri, Model model) {
		BoardVO board = null;
		board = service.getBoard(bno);
		
		model.addAttribute("board", board);
		return "/board/get";
	}// get board by bno
	
	@GetMapping("edit")
	public String updateBoardForm(@RequestParam int bno, Criteria cri, Model model) {
		model.addAttribute("board",service.getBoard(bno));
		
		return "/board/edit";
	}//edit form
	
	@PostMapping("edit")
	public String updateBoard(BoardVO board, Criteria cri, RedirectAttributes rttr) {
		rttr.addFlashAttribute("bno",board.getBno());
		
		int temp = service.updateBoard(board);
		
		try {
			if (temp < 1) {
				rttr.addFlashAttribute("result","error");
				throw new Exception();
			} else {
				/* rttr.addFlashAttribute("resMsg",board.getBno()+"번 게시물 수정 되었습니다."); */
				rttr.addFlashAttribute("result","modify");
				
				rttr.addAttribute("pageNum",cri.getPageNum());
				rttr.addAttribute("amount",cri.getAmount());
				rttr.addAttribute("word",cri.getWord());
				rttr.addAttribute("type",cri.getType());
				log.info("==========================================update"+board.getBno());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/board/list";
	}// update board
	
	@GetMapping("delete")
	public String deleteBoard(@RequestParam int bno, Criteria cri, RedirectAttributes rttr) {
		int temp = service.deleteBoard(bno);
		try {
			if (temp < 1) {
				rttr.addFlashAttribute("result","error");
				throw new Exception();
			} else {
				/* rttr.addFlashAttribute("resMsg", bno + "번 게시물 삭제 되었습니다."); */
				rttr.addFlashAttribute("bno",bno);
				rttr.addFlashAttribute("result","delete");
				
				rttr.addAttribute("pageNum",cri.getPageNum());
				rttr.addAttribute("amount",cri.getAmount());
				rttr.addAttribute("word",cri.getWord());
				rttr.addAttribute("type",cri.getType());
				log.info("==========================================delete" + bno);
			}
		} catch (Exception e) {
			log.error("error> delete fail");
		}
		return "redirect:/board/list";
	}//delete
	
	@GetMapping("RestTest")
	public void RestTest() {
		
	}
}
