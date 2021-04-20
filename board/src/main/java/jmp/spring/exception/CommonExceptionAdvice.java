package jmp.spring.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.log4j.Log4j;

@ControllerAdvice
@Log4j
public class CommonExceptionAdvice {

	@ExceptionHandler
	public String except(Exception e, Model model) {
		log.error("error>> "+e.getMessage());
		log.error(e);
		model.addAttribute("error",e);
		
		return "error_page";
	}
}
