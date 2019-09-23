package com.me.rentalme.interceptor;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import com.me.rentalme.login.service.LoginService;
import com.me.rentalme.model.entity.UserVo;

public class LoginRememberInterceptor extends HandlerInterceptorAdapter {
	
	@Inject
	LoginService loginService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");

		//������ ����ڰ� ��Ű�� ������ ���� ���
		if(loginCookie != null) {
			//��Ű���� üũ�Ͽ� ����������� ��ȸ
			UserVo userVo = loginService.checkLoginSessionKey(loginCookie.getValue());
			
			//��ȣȭ�� ��й�ȣ�� ���� ��� ���ǿ� �����Ѵ�.(sessionId : loginUserId)
			session.setAttribute("loginUserId", userVo.getUserId());
			//ȸ����ȣ�� ���ǿ� �����Ѵ�.(sessionMbNo : loginMbNo)
			session.setAttribute("loginMbNo", userVo.getMbNo());
		}
		
		return true;
	}

}
