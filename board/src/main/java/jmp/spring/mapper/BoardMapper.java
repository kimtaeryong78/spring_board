package jmp.spring.mapper;

import java.util.List;

import jmp.spring.vo.BoardVO;

public interface BoardMapper {
	public List<BoardVO> getBoardList();
	
	public int insertBoard(BoardVO board); 
	
	public BoardVO getBoard(int bno);
	
	public int updateBoard(BoardVO board);
	
	public int deleteBoard(int bno);
}
