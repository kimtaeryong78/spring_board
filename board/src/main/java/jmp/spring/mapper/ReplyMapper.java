package jmp.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import jmp.spring.vo.Criteria;
import jmp.spring.vo.ReplyVO;

public interface ReplyMapper {

	public int insertReply(ReplyVO reply); // insert reply

	public List<ReplyVO> getList(int bno); // total number in reply

	public ReplyVO getReply(int rno); // get reply by bno

	public int updateReply(ReplyVO reply); // update reply

	public int deleteReply(int rno); // delete reply by bno
	
	public int totalReply();		//total reply
	
	public List<ReplyVO> getListAfterPaging(@Param("cri") Criteria cri, @Param("bno") int bno);
	//reply after paging precess
}
