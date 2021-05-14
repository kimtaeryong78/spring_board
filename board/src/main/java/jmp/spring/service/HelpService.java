package jmp.spring.service;

import jmp.spring.vo.UserVO;

public interface HelpService {
	void sendId(UserVO user);

	int updateTempPwd(UserVO user);
	
	UserVO idCheck(UserVO user);
	
	UserVO pwdCheck(UserVO user);
}
