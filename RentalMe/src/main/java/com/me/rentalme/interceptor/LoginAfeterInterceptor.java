package com.me.rentalme.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginAfeterInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		/*�α��� ó�� �� �����ϸ� �ȵǴ� �������� ���´�.*/
		HttpSession session = request.getSession();
		
		// �α������� ���
		if(session.getAttribute("loginUserId") != null) {
			response.sendRedirect("redirect:/");
			return false;
		}
		
		
		return true;
	}

}
