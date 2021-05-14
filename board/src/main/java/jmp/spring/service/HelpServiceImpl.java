package jmp.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jmp.spring.mapper.HelpMapper;
import jmp.spring.vo.UserVO;
import lombok.Setter;

@Service
public class HelpServiceImpl implements HelpService{

	@Setter(onMethod_ = @Autowired)
	HelpMapper hm;
	
	@Setter(onMethod_ = @Autowired)
	MailService ms;
	
	@Override
	public void sendId(UserVO user) {
		ms.idMailSend(user);
	}
	
	@Override
	public int updateTempPwd(UserVO user) {
		String tempStr = ms.pwdMailSend(user);
		user.setPwd(tempStr);
		return hm.tempPwdSetting(user);
	}
	
	@Override
	public UserVO idCheck(UserVO user) {
		return hm.getUserByNameAndEmail(user);
	}
	
	@Override
	public UserVO pwdCheck(UserVO user) {
		return hm.getUserByIDAndEmail(user);
	}
}