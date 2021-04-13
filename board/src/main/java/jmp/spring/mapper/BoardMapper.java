package jmp.spring.mapper;

import java.util.List;

import jmp.spring.vo.BoardVO;

public interface BoardMapper {
	public List<BoardVO> getList();				//get board list
	
	public int insertBoard(BoardVO board); 		//insert board
	
	public BoardVO getBoard(int bno);			//get board by bno
	
	public int updateBoard(BoardVO board);		//update board
	
	//public int deleteBoard(int bno);			//delete board by bno
}
