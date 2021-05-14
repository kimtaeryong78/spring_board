package jmp.spring.test;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class PasswordEncodeTests {
	
	@Test
	public void test1() {
		log.error("test1..");
		log.error("test1....");
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(4);
		log.error("1234 값 : "+encoder.encode("1234") + "  ............................................................1");
		log.error("1234 값 : "+encoder.encode("1234") + "  ............................................................2");
		log.error("1234 값 : "+encoder.encode("1234") + "  ............................................................3");
		log.error("1234 값 : "+encoder.encode("1234") + "  ............................................................4");
		log.error("1234 값 : "+encoder.encode("1234") + "  ............................................................5");
		log.error("1234 값 : "+encoder.encode("1234") + "  ............................................................6");
		log.error("1234 값 : "+encoder.encode("1234") + "  ............................................................7");
		log.error("1234 값 : "+encoder.encode("1234") + "  ............................................................7");
		log.error("1234 값 : "+encoder.encode("1234") + "  ............................................................7");
		log.error("1234 값 : "+encoder.encode("1234") + "  ............................................................7");
		log.error("1234 값 : "+encoder.encode("1234") + "  ............................................................7");
		log.error("1234 값 : "+encoder.encode("1234") + "  ............................................................7");
		log.error("1234 값 : "+encoder.encode("1234") + "  ............................................................7");
		log.error("1234 값 : "+encoder.encode("1234") + "  ............................................................7");
		log.error("1234 값 : "+encoder.encode("1234") + "  ............................................................7");
		log.error("1234 값 : "+encoder.encode("1234") + "  ............................................................7");
		log.error("1234 값 : "+encoder.encode("1234") + "  ............................................................7");
		log.error("1234 값 : "+encoder.encode("1234") + "  ............................................................7");
		log.error("1234 값 : "+encoder.encode("1234") + "  ............................................................7");
		log.error("1234 값 : "+encoder.encode("1234") + "  ............................................................7");
		log.error("1234 값 : "+encoder.encode("1234") + "  ............................................................7");
		log.error("1234 값 : "+encoder.encode("1234") + "  ............................................................7");
		log.error("1234 값 : "+encoder.encode("1234") + "  ............................................................7");
		log.error("1234 값 : "+encoder.encode("1234") + "  ............................................................7");
		log.error("1234 값 : "+encoder.encode("1234") + "  ............................................................7");
		log.error("1234 값 : "+encoder.encode("1234") + "  ............................................................7");
		log.error("1234 값 : "+encoder.encode("1234") + "  ............................................................7");
		log.error("1234 값 : "+encoder.encode("1234") + "  ............................................................7");
		log.error("1234 값 : "+encoder.encode("1234") + "  ............................................................7");
		log.error("1234 값 : "+encoder.encode("1234") + "  ............................................................7");
		log.error("1234 값 : "+encoder.encode("1234") + "  ............................................................7");
		log.error("1234 값 : "+encoder.encode("1234") + "  ............................................................7");
		log.error("1234 값 : "+encoder.encode("1234") + "  ............................................................7");
		log.error("1234 값 : "+encoder.encode("1234") + "  ............................................................7");
		log.error("1234 값 : "+encoder.encode("1234") + "  ............................................................7");
		log.error("1234 값 : "+encoder.encode("1234") + "  ............................................................7");
		log.error("1234 값 : "+encoder.encode("1234") + "  ............................................................7");
		log.error("1234 값 : "+encoder.encode("1234") + "  ............................................................7");
		log.error("1234 값 : "+encoder.encode("1234") + "  ............................................................8");
		System.out.println(encoder.matches("1234", "$2a$10$mt1lvW0kP7W2EkEHvOB3S.z8drP53IAOA0QPX/x3rVZbE/hkk39Ri"));//t
		System.out.println(encoder.matches("1234", "$2a$10$gBCXSlL8MBgamOoE3EoeRe8UyqanzPwbXoJOXSKl3EtVxdXbAu8eW"));//t
		System.out.println(encoder.matches("1234", "$2a$10$gBCXSlL8MBgamOoE3EoeRe8UyqanzPwbXoJOXSKl3EtVxdXbAu8ew"));//f
		log.error("end..........................");
	}
	
	@Test
	public void test2() {
		System.err.println(UUID.randomUUID().toString().substring(0,7));
	}
	
}
