package jmp.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import jmp.spring.vo.UserVO;
import lombok.extern.log4j.Log4j;

@Log4j
public class SampleInterceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		UserVO user = (UserVO)session.getAttribute("user");
		if(user==null) {
			response.sendRedirect("/login");
			return false;
		}
		log.error("=========================");
		log.error(request);
		log.error(response);
		log.error(handler);
		log.error("=========================");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		log.error("=========================");
		log.error(request);
		log.error(response);
		log.error(handler);
		log.error(modelAndView);
		log.error("=========================");
	}
	
}
