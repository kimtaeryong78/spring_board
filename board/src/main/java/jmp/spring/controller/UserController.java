package jmp.spring.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.util.WebUtils;

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
	@GetMapping("/member")
	public void memberForm() {
		log.error("member.........................");
	}
	@PostMapping("/loginAction")
	public String loginProcess(UserVO vo, Model model, HttpServletRequest req) {
		String page = "";
		UserVO user = us.get(vo);
		if(user!=null) {
			HttpSession session =  req.getSession();
			session.setAttribute("user", user);
			/* page = "redirect:/board/list"; */
			page= "loginAction";
		} else {
			model.addAttribute("msg","fail");
			page = "login";
		}
		return page;
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest req, HttpServletResponse response) {
		Cookie loginCookie = WebUtils.getCookie(req, "loginCookie");
		if(loginCookie != null) {
			loginCookie.setMaxAge(0);
			loginCookie.setPath("/");
			response.addCookie(loginCookie);
		}
		HttpSession session = req.getSession();
		session.invalidate();
		
		return "login";
	}
	
	@PostMapping("/registerMember")
	public String register(UserVO user,Model model) {
		try {
			int res = us.add(user);
			if(res > 0) {
				return "forward:/loginAction";
			}
			else {
				model.addAttribute("msg","fail");
				return "/error";
			}
		} catch(Exception e) {
			return "/error";
		}
	}
	@GetMapping("/error")
	public void error() {}
	
	@GetMapping("/memberView")
	public void view() {	}
}
