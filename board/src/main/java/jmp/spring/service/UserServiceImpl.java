package jmp.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import jmp.spring.mapper.UserMapper;
import jmp.spring.vo.UserVO;
import lombok.Setter;

@Service
public class UserServiceImpl implements UserService{

	@Setter(onMethod_ = @Autowired)
	UserMapper um;
	
	@Setter(onMethod_ = @Autowired)
	MailService ms;
	
	@Override
	public UserVO get(UserVO user) {
		UserVO LoginUser = um.getUser(user);
		
		if(LoginUser != null) {
			BCryptPasswordEncoder encorder = new BCryptPasswordEncoder();
			if(!encorder.matches(user.getPwd(),LoginUser.getPwd())) {
				return null;
			}
			
			List<String> role = um.getUserRole(LoginUser);
			LoginUser.setUserRole(role);
		}
		return LoginUser;
	}
	
	@Override
	public List<UserVO> getList() {
		return um.getUserList();
	}
	
	@Override
	public List<String> roles(UserVO user) {
		return um.getUserRole(user);
	}
	
	@Override
	public int autoLogin(UserVO user) {
		return um.autoLogin(user);
	}
	
	@Override
	public UserVO loginSessionKey(UserVO user) {
		return um.getSessionKey(user);
	}
	
	@Override
	public int add(UserVO user) {
		BCryptPasswordEncoder encorder = new BCryptPasswordEncoder();
		user.setPwd(encorder.encode(user.getPwd()));
		int res = um.addUser(user);
		if(res>0) {
			res = um.addtUserRole(user.getId(),"ROLE_USER");
		}
		return res;
	}
}