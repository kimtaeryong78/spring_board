package jmp.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jmp.spring.mapper.ReplyMapper;
import jmp.spring.vo.Criteria;
import jmp.spring.vo.ReplyVO;
import lombok.Setter;

@Service
public class ReplyServiceImpl implements ReplyService{
	
	@Setter(onMethod_ = @Autowired)
	ReplyMapper rm;
	
	@Override
	public int insertReply(ReplyVO reply) {
		return rm.insertReply(reply);
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
		return rm.updateReply(reply);
	}

	@Override
	public int deleteReply(int rno) {
		return rm.deleteReply(rno);
	}

	@Override
	public int totalReply() {
		return rm.totalReply();
	}
	
	@Override
	public List<ReplyVO> getListAfterPaging(Criteria cri, int bno) {
		return rm.getListAfterPaging(cri, bno);
	}

}