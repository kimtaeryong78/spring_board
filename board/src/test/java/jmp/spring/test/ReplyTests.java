package jmp.spring.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import jmp.spring.mapper.ReplyMapper;
import jmp.spring.vo.Criteria;
import jmp.spring.vo.ReplyVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ReplyTests {
	ReplyVO reply;
	
	@Setter(onMethod_ = @Autowired)
	ReplyMapper rm;
	
	@Test
	public void test1() {
		reply = new ReplyVO();
		reply.setBno(222);
		reply.setReply("테스트");
		reply.setReplyer("test");
		
		log.info(reply);
		rm.insertReply(reply);
		log.info("success");
	}
	
	@Test
	public void test2() {
		log.info(rm.getList(222));
	}
	
	@Test
	public void test3() {
		rm.deleteReply(2);
	}
	
	@Test
	public void test4() {
		reply = new ReplyVO();
		reply.setRno(3);
		reply.setBno(222);
		reply.setReply("test");
		reply.setReplyer("테스트");
		
		rm.updateReply(reply);
	}
	
	@Test
	public void test5() {
		log.info(rm.totalReply(222));
	}
	
	@Test
	public void test6() {
		rm.getReply(3);
	}
	
	@Test
	public void test7() {
		rm.getListAfterPaging(new Criteria(), 222);
	}
	
	@Test
	public void test8() {
		rm.updateReplyCnt(222);
	}
}
