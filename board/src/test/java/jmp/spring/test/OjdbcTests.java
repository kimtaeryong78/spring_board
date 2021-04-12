package jmp.spring.test;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class OjdbcTests {

	@Setter(onMethod_ = @Autowired)
	DataSource ds;

	@Setter(onMethod_ = @Autowired)
	SqlSessionFactory sqlFactory;
	
	@Test
	public void ojdbcTest() {
		try (Connection conn = ds.getConnection();) {
			log.info("=========================================================");
			log.info(conn);
			log.info("=========================================================");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}//ojdbcTest
	
	@Test
	public void factoryTest() {
		try(SqlSession session = sqlFactory.openSession();
				Connection conn = session.getConnection();){
			log.info("=========================================================");
			log.info(session);
			log.info(conn);
			log.info("=========================================================");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
