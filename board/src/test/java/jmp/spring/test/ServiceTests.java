package jmp.spring.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import jmp.spring.service.BoardService;
import jmp.spring.vo.BoardVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ServiceTests {
	
	@Setter(onMethod_ = @Autowired)
	BoardService service;

	@Test
	public void service() {
		log.info("service================="+service.getList());
	}
	
	@Test
	public void get() {
		service.getBoard(1058);
	}
	
	@Test
	public void insert() {
		BoardVO board = new BoardVO();
		board.setTitle("test");
		board.setContent("test");
		board.setWriter("test");
		log.info("service================"+ service.insertBoard(board));	
	}
	
	@Test
	public void delete() {
		int bno = 39;
		log.info("delete==============="+ service.deleteBoard(bno));
	}
	
	@Test
	public void modify() {
		
		BoardVO board = service.getBoard(1058);
		
		board.setContent("test eclipse");
		board.setTitle("titletitle");
		
		log.info("modify=================================" + service.updateBoard(board));
	}
	@Test
	public void modifyTx() {
		BoardVO board = service.getBoard(1058);
		board.setContent("test eclipse tx");
		board.setTitle("titletitle tx");
		
		log.info("modify=================================" + service.updateBoard(board));
	}
}
