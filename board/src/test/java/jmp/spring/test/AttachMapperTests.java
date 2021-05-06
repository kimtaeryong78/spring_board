package jmp.spring.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import jmp.spring.mapper.AttachMapper;
import jmp.spring.service.AttachService;
import jmp.spring.vo.AttachFileVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class AttachMapperTests {
	int temp_seq = 0;
	
	@Setter(onMethod_ = @Autowired)
	AttachMapper am;
	
	@Test
	public void Test1() {
		temp_seq = am.getSeq();
		log.error(temp_seq);
	}
	
	@Test
	public void Test2() {
		AttachFileVO vo = new AttachFileVO();
		vo.setAttachNo(8);
		vo.setFileName("1");
		vo.setFileType("1");
		vo.setUploadPath("1");
		vo.setUuid("3");
		log.info(am.insertAttach(vo));
	}
	
	@Test
	public void Test3() {
		am.getList(7);
	}
	
	@Setter(onMethod_ = @Autowired)
	AttachService service;
	
	@Test
	public void test4() {
		log.error(service.sequence());
	}
	
	@Test
	public void test5() {
		log.error(service.getList(7));
	}
	
	@Test
	public void test6() {
		AttachFileVO vo = new AttachFileVO();
		vo.setAttachNo(8);
		vo.setFileName("1");
		vo.setFileType("1");
		vo.setUploadPath("1");
		vo.setUuid("4");
		log.info(service.insert(vo));
	}
	
	@Test
	public void test7() {
		am.deleteAttach("01cdac2e-0616-46ce-9ac4-1b5d4189f294", 68);
	}
	
	@Test
	public void test8() {
		service.delete("2b0bb0c5-c154-40e8-be3c-6fc358f7d770", 68);
	}
}
