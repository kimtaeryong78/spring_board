package jmp.spring.mapper;

import jmp.spring.vo.UserVO;

public interface HelpMapper {
	int tempPwdSetting(UserVO user);
	
	UserVO getUserByNameAndEmail(UserVO user);
	
	UserVO getUserByIDAndEmail(UserVO user);
}
