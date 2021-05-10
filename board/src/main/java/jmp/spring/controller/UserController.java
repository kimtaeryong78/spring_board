package jmp.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sun.mail.iap.Response;

import jmp.spring.service.UserService;
import jmp.spring.vo.UserVO;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class UserController {
	
	@Autowired
	UserService us;
	
	@GetMapping("/login")
	public void login() {
		log.error("login.........................");
	}
	
	@PostMapping("/loginAction")
	public String loginProcess(@RequestParam("id") String id, @RequestParam("pwd") String pwd, Model model) {
		String page = "";
		UserVO user = us.get(id, pwd);
		//HttpSession session = 
		if(user!=null) {
			
			model.addAttribute("user",user);
			page = "loginAction";
		} else {
			model.addAttribute("result","fail");
			page = "login";
		}
		return page;
	}
}
