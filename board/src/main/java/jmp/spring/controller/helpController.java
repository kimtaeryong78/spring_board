package jmp.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jmp.spring.service.HelpService;
import jmp.spring.vo.UserVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/help")
@Log4j
public class helpController {
	
	@Setter(onMethod_ = @Autowired)
	HelpService hs;
	
	@GetMapping("/idInQuery")
	public void idCheckForm() {
		log.error("id찾기...............................................................................");
	}
	@GetMapping("/pwdInQuery")
	public void pwdCheckForm() {
		log.error("pwd찾기...............................................................................");
	}
	@PostMapping("/idCheck")
	public String idCheck(UserVO vo,Model model) {
		UserVO user = hs.idCheck(vo);
		try {
			if(user == null) {
				return "/error";
			}else {
				hs.sendId(user);
				model.addAttribute("msg","아이디가 가입했던 메일로 전송 되었습니다.");
				return "/login";
			}
		} catch (Exception e){
			return "/error";
		}
	}
	@PostMapping("/pwdCheck")
	public String pwdCheck(UserVO vo,Model model) {
		UserVO user = hs.pwdCheck(vo);
		try {
			if(user == null) {
				return "/error";
			}else {
				hs.updateTempPwd(user);
				model.addAttribute("msg","임시 비밀번호가 가입했던 메일로 전송 되었습니다.");
				return "/login";
			}
		} catch (Exception e){
			return "/error";
		}
	}
	
}
