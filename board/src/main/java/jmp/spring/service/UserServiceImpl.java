package jmp.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jmp.spring.mapper.UserMapper;
import jmp.spring.vo.UserVO;
import lombok.Setter;

@Service
public class UserServiceImpl implements UserService{

	@Setter(onMethod_ = @Autowired)
	UserMapper um;
	
	@Override
	public UserVO get(UserVO user) {
		user = um.getUser(user);
		List<String> role = um.getUserRole(user);
		user.setUserRole(role);
		return user;
	}
	
	@Override
	public List<UserVO> getList() {
		return um.getUserList();
	}
	
	@Override
	public List<String> roles(UserVO user) {
		return um.getUserRole(user);
	}
}