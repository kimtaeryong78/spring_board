package jmp.spring.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import jmp.spring.mapper.UserMapper;
import jmp.spring.vo.UserVO;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class UserMapperTests {
	@Autowired
	UserMapper um;
	
	@Test
	public void test1() {
		um.getUserList();
		log.error("----------------------------------------------------------------------------------------------------------------------------------------------------------------");
		log.error("----------------------------------------------------------------------------------------------------------------------------------------------------------------");
		log.error("----------------------------------------------------------------------------------------------------------------------------------------------------------------");
		log.error("----------------------------------------------------------------------------------------------------------------------------------------------------------------");
		log.error("----------------------------------------------------------------------------------------------------------------------------------------------------------------");
		log.error("----------------------------------------------------------------------------------------------------------------------------------------------------------------");
		log.error("----------------------------------------------------------------------------------------------------------------------------------------------------------------");
		log.error("----------------------------------------------------------------------------------------------------------------------------------------------------------------");
		log.error("----------------------------------------------------------------------------------------------------------------------------------------------------------------");
		log.error("----------------------------------------------------------------------------------------------------------------------------------------------------------------");
	}
	
	@Test
	public void test2() {
		um.getUser("user01", "1234");
	}
	
	@Test
	public void test3() {
		UserVO user = new UserVO();
		user.setId("admin");
		user.setPwd("1234");
		user.setEmail("admin@google.com");
		user.setName("어드민");
		um.addUser(user);
	}
}
