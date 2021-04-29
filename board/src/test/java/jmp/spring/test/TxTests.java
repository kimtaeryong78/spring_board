package jmp.spring.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import jmp.spring.service.Smtx;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class TxTests {
	@Setter(onMethod_ = @Autowired)
	Smtx service;
	
	@Test
	public void test1() {
		String str = "12345678901234567";
		
		log.info(str.getBytes().length);
		
		service.addData(str);
	}
}
