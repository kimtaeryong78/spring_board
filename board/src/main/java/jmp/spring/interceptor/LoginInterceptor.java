package jmp.spring.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import jmp.spring.service.UserService;
import jmp.spring.vo.UserVO;

public class LoginInterceptor 
		extends HandlerInterceptorAdapter{

	@Autowired
	UserService userService;

	/**
	 * 컨트롤러의 실행 전에 실행 합니다
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		return true;
	}

	/**
	 * 컨트롤러의 실행 이후 실행 합니다
	 * /loginAction 이 실행된 이후 처리
	 *  
	 * 조건 >> 세션에 유저객체가 생성 되어 있다
	 *       자동로그인에 체크가 되어 있다
	 *  
	 *  1. 자동로그인을 위한 쿠키를 생성 합니다.
	 *  2. DB 에 세션 키값과 유효기간을 저장 합니다.
	 *  
	 *  --> 저장된 자동로그인 쿠키(loginCookie)의 value(sessionId)값을 
	 *  users테이블에서 조회 해서 일치하는 값이 있으면 자동 로그인 처리를  해줍니다.
	 *  
	 *  세션 / 쿠키 => request
	 *  
	 *  저장후 users테이블에 sessionkey값이 저장되었는지 확인
	 *  브라우저에 loginCookie가 생성되었는지 확인
	 *  
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {
		System.out.println("LoginInterceptor.postHandle"+"================");
		// request로 부터 세션을 구해옵니다
		HttpSession session = request.getSession();
		
		UserVO user = (UserVO)session.getAttribute("user");
		// * 조건 >> 세션에 유저객체가 생성 되어 있다
		// *       자동로그인에 체크가 되어 있다
		if(user != null 
				&& request.getParameter("useCookie") != null) {
			//*  1. 자동로그인을 위한 쿠키를 생성 합니다.
			Cookie loginCookie = new Cookie("loginCookie", session.getId());
			// 쿠키 유효기간 설정
			loginCookie.setMaxAge(60*60*24*7);
			// 패스 설정
			loginCookie.setPath("/");
			response.addCookie(loginCookie);
			
			//*  2. DB 에 세션 키값과 유효기간을 저장 합니다.
			// loginCooki의 value값과 동일한 값을 입력 합니다.
			// ---->> 자동로그인시 저장된 쿠키값을 DB에서 조회 합니다.
			user.setSessionKey(session.getId());
			userService.loginSessionKey(user);
			
			// 자동로그인을 위해 생성한 쿠키를 response 객체에 저장 합니다.
			response.addCookie(loginCookie);
			
		}
		
		// 만약 자동로그인시 저장된 tmpUri가 세션에 존재 한다면
		// 원래 요청한 페이지가 있었다면 그 요청 페이지로 이동 시켜 주고 싶어요
		String tmpUri = (String)session.getAttribute("tmpUri");
		
		if(!StringUtils.isEmpty(tmpUri)) {
			response.sendRedirect(tmpUri);
		}
		
	
	}
}













