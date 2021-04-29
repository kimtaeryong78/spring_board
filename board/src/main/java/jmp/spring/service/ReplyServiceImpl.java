package jmp.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jmp.spring.mapper.ReplyMapper;
import jmp.spring.vo.Criteria;
import jmp.spring.vo.ReplyVO;
import lombok.Setter;

@Service
public class ReplyServiceImpl implements ReplyService{
	
	@Setter(onMethod_ = @Autowired)
	ReplyMapper rm;
	
	@Transactional
	@Override
	public int insertReply(ReplyVO reply) {
		int res = rm.insertReply(reply);
		
		rm.updateReplyCnt(reply.getBno());
		return res;
	}

	@Override
	public List<ReplyVO> getList(int bno) {
		return rm.getList(bno);
	}

	@Override
	public ReplyVO getReply(int rno) {
		return rm.getReply(rno);
	}

	@Override
	public int updateReply(ReplyVO reply) {
		rm.updateReplyCnt(reply.getBno());
		return rm.updateReply(reply);
	}

	@Override
	public int deleteReply(int rno) {
		ReplyVO reply = rm.getReply(rno);
		
		int res = rm.deleteReply(rno);
		
		rm.updateReplyCnt(reply.getBno());
		return res;
	}

	@Override
	public int totalReply(int bno) {
		return rm.totalReply(bno);
	}
	
	@Override
	public List<ReplyVO> getListAfterPaging(Criteria cri, int bno) {
		return rm.getListAfterPaging(cri, bno);
	}

}