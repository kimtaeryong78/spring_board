package jmp.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jmp.spring.mapper.AttachMapper;
import jmp.spring.vo.AttachFileVO;
import lombok.Setter;

@Service
public class AttachServiceImpl implements AttachService{

	@Setter(onMethod_ = @Autowired)
	AttachMapper am;
	
	@Override
	public List<AttachFileVO> getList(int attachNo) {
		return am.getList(attachNo);
	}

	@Override
	public int insert(AttachFileVO vo) {
		return am.insertAttach(vo);
	}

	@Override
	public int sequence() {
		return am.getSeq();
	}
	
	@Override
	public int delete(String uuid, int attachNo) {
		return am.deleteAttach(uuid, attachNo);
	}
	
	@Override
	public AttachFileVO get(String uuid, int attachNo) {
		return am.getFile(uuid, attachNo);
	}
	
	@Override
	public int allDelete(int attachNo) {
		return am.deleteAllAttach(attachNo);
	}
}
