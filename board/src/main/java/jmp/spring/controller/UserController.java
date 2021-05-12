package jmp.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
	public String loginProcess(UserVO vo, Model model,HttpServletRequest req) {
		String page = "";
		UserVO user = us.get(vo);
		if(user!=null) {
			HttpSession session =  req.getSession();
			session.setAttribute("user", user);
			page = "redirect:/board/list";
		} else {
			model.addAttribute("msg","fail");
			page = "login";
		}
		return page;
	}
	
	@GetMapping("/logout")
	public String logout(Model model,HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.invalidate();
		return "redirect:/login";
	}
}
