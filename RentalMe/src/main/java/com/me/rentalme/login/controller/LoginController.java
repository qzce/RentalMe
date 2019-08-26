package com.me.rentalme.login.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.me.rentalme.login.service.LoginService;
import com.me.rentalme.model.entity.UserVo;

/**
* �α��� ��Ʈ�ѷ�
* 
* @author Ȳ����
* @version ver1.0
* @see 
* ������� : 2019.08.13
* �������� : 2019.08.14
*/
@Controller
public class LoginController {
	
	@Inject
	LoginService loginService;
	
	Logger log = LoggerFactory.getLogger(getClass());
	
	/**
	* �α��� ��
	* 
	* @param  
	* @return String 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		log.debug("�α��� �� ��Ʈ�ѷ�...");

		return "login/login";
	}
	
	/**
	* �α���
	* 
	* @param  UserVo userVo
	* @param  HttspSessio session
	* @return String 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(UserVo userVo, HttpSession session) {
		log.debug("�α��� ��Ʈ�ѷ�...");
		
		//1. �Է��� �α��� ���̵� DB�κ��� �����´�.
		String userId = userVo.getUserId();
		UserVo loginUser = loginService.getId(userId);
		
		//2. �Է��� ��й�ȣ�� hash ó���� ��й�ȣ�� ���Ѵ�.
		ModelAndView mav = new ModelAndView();

		if(loginUser != null) {
			String msg = "";
			String userPw = userVo.getUserPw();
			String loginPw = loginUser.getUserPw();
			String loginMbNo = loginUser.getMbNo();
			
			System.out.println("ȸ����ȣ:"+loginMbNo);
			
			//�Է��� ���̵� DB�� �ִ� ��� �Է��� ��й�ȣ�� DB�� ����� ��й�ȣ ��ȣȭ ���� ��
			if(BCrypt.checkpw(userPw, loginPw)) {
				//��ȣȭ�� ��й�ȣ�� ���� ��� ���ǿ� �����Ѵ�.(sessionId : loginUserId)
				session.setAttribute("loginUserId", userId);
				//ȸ����ȣ�� ���ǿ� ��´�.
				session.setAttribute("loginMbNo", loginMbNo);
				
				mav.setViewName("redirect:/");
			}else {
				//��ȣȭ�� ��й�ȣ�� �ٸ� ���
				msg = "pwFail";
				mav.addObject("msg", msg);
				mav.setViewName("login/login");
			}
		}
		
		return mav;
	}
	

}
