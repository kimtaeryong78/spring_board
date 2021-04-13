package jmp.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jmp.spring.mapper.BoardMapper;
import jmp.spring.vo.BoardVO;
import lombok.Setter;

@Service
public class BoardServiceImpl implements BoardService{

	@Setter(onMethod_ = @Autowired)
	BoardMapper bm;
	
	@Override
	public List<BoardVO> getList(){
		return bm.getList();
	}// get board list

	@Override
	public int insertBoard(BoardVO board) {
		return bm.insertBoard(board);
	}//insertBoard

	@Override
	public BoardVO getBoard(int bno) {
		return bm.getBoard(bno);
	}//get board by bno

	@Override
	public int updateBoard(BoardVO board) {
		return bm.updateBoard(board);
	}//insert board

}