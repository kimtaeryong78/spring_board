package jmp.spring.service;

import java.util.List;

import jmp.spring.vo.BoardVO;

public interface BoardService {
	
	public List<BoardVO> getList();			//get board list
	
	public int insertBoard(BoardVO board); 	//insert board
	
	public BoardVO getBoard(int bno);		//get board by bno
	
	public int updateBoard(BoardVO board);		//update board
}
