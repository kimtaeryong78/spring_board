package jmp.spring.mapper;

import java.util.List;

import jmp.spring.vo.Criteria;
import jmp.spring.vo.ReplyVO;

public interface ReplyMapper {

	public int insertReply(ReplyVO reply); // insert reply

	public List<ReplyVO> getList(int bno, Criteria cri); // total number in reply

	public ReplyVO getReply(int rno); // get reply by bno

	public int updateReply(ReplyVO reply); // update reply

	public int deleteReply(int rno); // delete reply by bno
}
