package com.me.rentalme.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.me.rentalme.model.entity.UserVo;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		HttpSession session = request.getSession();
		ModelMap modelMap = modelAndView.getModelMap();
		UserVo userVo = (UserVo)modelMap.get("loginUser");
		
		if(userVo!=null) {
			/*���ǰ� ����*/
			//��ȣȭ�� ��й�ȣ�� ���� ��� ���ǿ� �����Ѵ�.(sessionId : loginUserId)
			session.setAttribute("loginUserId", userVo.getUserId());
			//ȸ����ȣ�� ���ǿ� �����Ѵ�.(sessionMbNo : loginMbNo)
			session.setAttribute("loginMbNo", userVo.getMbNo());
			
			//�ڵ��α��� üũ�� �Ǿ����� ���
			if(request.getParameter("isUseLogin") != null) {
				//��Ű����
				Cookie loginCookie = new Cookie("loginCookie", session.getId());
				loginCookie.setPath("/");
				loginCookie.setMaxAge(60*60*24*7); // 7��
				
				//������ ��Ű�� ������ ����
				response.addCookie(loginCookie);
			}	
		}
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		
		//������ �α��� ������ ����
		if(session.getAttribute("loginUserId") != null && session.getAttribute("loginMbNo") != null) {
			session.removeAttribute("loginUserId");
			session.removeAttribute("loginMbNo");
		}
		
		return true;
	}

}
