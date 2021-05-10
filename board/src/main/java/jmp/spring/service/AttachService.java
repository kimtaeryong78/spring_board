package jmp.spring.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import jmp.spring.vo.AttachFileVO;

public interface AttachService {
	public int sequence();
	
	public List<AttachFileVO> getList(int attachNo);
	
	public int insert(AttachFileVO vo);
	
	public int delete(@Param("uuid") String uuid, @Param("attachNo") int attachNo);
	
	public AttachFileVO get(@Param("uuid") String uuid, @Param("attachNo") int attachNo);
	
	public int allDelete(int attachNo);
}
