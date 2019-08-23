package com.me.rentalme.login.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
//	@Inject
//	LoginService loginService;
	
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
	* @param  UserVo
	* @param  HttpServletRequest - sessionó���ϱ� ����.
	* @return String 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(UserVo bean, HttpServletRequest req) {
		log.debug("�α��� ��Ʈ�ѷ�...");
		
		//Service���� ���� ó�� 
		//int result = loginService.login(bean, req);
		
		return "redirect:/";
	}
	

}
