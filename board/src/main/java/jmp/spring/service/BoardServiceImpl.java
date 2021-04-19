package jmp.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jmp.spring.mapper.BoardMapper;
import jmp.spring.vo.BoardVO;
import jmp.spring.vo.Criteria;
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
	public List<BoardVO> getListWithPaging(Criteria cri) {
		return bm.getListWithPaging(cri);
	}//get list after paging process
	
	@Override
	public int totalBoard(Criteria cri) {
		return bm.totalBoard(cri);
	}//total number in board
	
	@Override
	public int insertBoard(BoardVO board) {
		return bm.insertBoard(board);
	}//insert Board

	@Override
	public BoardVO getBoard(int bno) {
		return bm.getBoard(bno);
	}//get board by bno

	@Override
	public int updateBoard(BoardVO board) {
		return bm.updateBoard(board);
	}//update board

	@Override
	public int deleteBoard(int bno) {
		return bm.deleteBoard(bno);
	}//delete board

}