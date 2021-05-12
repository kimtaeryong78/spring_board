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
		UserVO user = new UserVO();
		user.setId("user01");
		user.setPwd("1234");
		um.getUser(user);
	}
	
	@Test
	public void test3() {
		UserVO user = new UserVO();
		user.setId("user01");
		user.setPwd("1234");
		user.setEmail("admin@google.com");
		user.setName("어드민");
		um.addUser(user);
	}
	
	@Test
	public void test4() {
		UserVO vo = new UserVO();
		vo.setId("user01");
		um.getUserRole(vo);
		log.error(um.getUserRole(vo));
	}
}
