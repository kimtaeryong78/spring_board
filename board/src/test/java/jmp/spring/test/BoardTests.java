package jmp.spring.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import jmp.spring.mapper.BoardMapper;
import jmp.spring.vo.BoardVO;
import jmp.spring.vo.Criteria;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardTests {
	
	@Setter(onMethod_ = @Autowired)
	BoardMapper bm;
	
	@Test
	public void getBoardListTest() {
		log.info("========================================="+bm.getList());
	}//get board list
	
	@Test
	public void totalBoardTest() {
		Criteria cri = new Criteria();
		log.info(bm.totalBoard(cri));
	}
	
	@Test
	public void testinsert() {
		BoardVO board = new BoardVO();
		board.setTitle("test");
		board.setContent("testcontent");
		board.setWriter("tester");
		
		log.info("========================================"+bm.insertBoard(board));
		log.info(board.getBno());
	}
	
	@Test
	public void testPage() {
		Criteria cri = new Criteria();
		List<BoardVO> list = bm.getListWithPaging(cri);
		log.info(list);
	}
	
	@Test
	public void searchTest() {
		Criteria cri = new Criteria();
		cri.setAmount(10);
		cri.setPageNum(210);
		cri.setWord("es");
		cri.setType("TW");
		
		List<BoardVO> list = bm.getListWithPaging(cri);
		
		list.forEach(board -> log.info(board));
	}
	
	@Test
	public void test6() {
		bm.backup(1122);
	}
}
