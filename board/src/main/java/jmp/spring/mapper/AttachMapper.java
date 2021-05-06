package jmp.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import jmp.spring.vo.AttachFileVO;

public interface AttachMapper {
	public int getSeq();
	
	public List<AttachFileVO> getList(int attachNo);
	
	public AttachFileVO getFile(@Param("uuid") String uuid, @Param("attachNo") int attachNo);
	
	public int insertAttach(AttachFileVO vo);
	
	public int deleteAttach(@Param("uuid") String uuid, @Param("attachNo") int attachNo);
	
}
