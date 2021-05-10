package jmp.spring.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import jmp.spring.service.MailService;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MailServiceTests {

	@Setter(onMethod_ = @Autowired)
	MailService ms;

	/*
	 * @Setter(onMethod_ = @Autowired) private Properties prop;
	 * 
	 * @Test public void Test1() { log.error("prop..................... : " + prop);
	 * log.error("prop..................... : " + prop.getProperty("mail_id")); }
	 */
	@Test
	public void Test() {
		log.error("mail service test...................");
		long start = System.currentTimeMillis();
		long temp = ms.welcomeMailSend();
		long end = System.currentTimeMillis();
		log.error("auth_num....................... : "+temp);
		log.error("time : " + (end-start)/1000.0 +"초");
		log.error("==========================================");
	}
}
