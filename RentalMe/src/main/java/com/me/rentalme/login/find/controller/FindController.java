package com.me.rentalme.login.find.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.me.rentalme.model.entity.UserVo;

/**
* ���̵�, ��й�ȣ ã�� ��Ʈ�ѷ�
* 
* @author Ȳ����
* @version ver1.0
* @see 
* ������� : 2019.08.14
*/
@Controller
@RequestMapping("/login")
public class FindController {
	
	Logger log = LoggerFactory.getLogger(getClass());

	/**
	* ��ϵ� �̸��Ϸ� ���̵� ã�� ��
	* 
	* @param  
	* @return String 
	* @author Ȳ����
	* @exception
	* ������� : 2019-08-14 
	*/
	@RequestMapping(value = "/email/findId", method = RequestMethod.GET)
	public String findEmailId() {
		log.debug("��ϵ� �̸��Ϸ� ���̵� ã�� �� ��Ʈ�ѷ�...");
		
		return "login/find/emailId";
	}
	
	/**
	* ��ϵ� �̸��Ϸ� ���̵� ã��
	* 
	* @param  String email : �̸����ּ�
	* @return String 
	* @author Ȳ����
	* @exception
	* ������� : 2019-08-14 
	*/
	@RequestMapping(value = "/email/findId", method = RequestMethod.POST)
	public ModelAndView findEmailId(String email) {
		log.debug("��ϵ� �̸��Ϸ� ���̵� ã�� ��Ʈ�ѷ� ...");
		
		//Service �ۼ� - return : bean, parameter : email
		//UserVo bean = findService.findEmailId(email);
		
		ModelAndView mav = new ModelAndView();
		//���� : ��ϵ� �̸��� ���̵�ã�� ���
		//mav.addObject("bean", bean); // ���̵�, �������� ����
		mav.setViewName("login/find/resultId");
		
		return mav;
	}
	
	/**
	* ��ϵ� �̸��Ϸ� ��й�ȣ ã�� ��
	* 
	* @param  
	* @return String 
	* @author Ȳ����
	* @exception
	* ������� : 2019-08-14 
	*/
	@RequestMapping(value = "/email/findPw", method = RequestMethod.GET)
	public String findEmailPw() {
		log.debug("��ϵ� �̸��Ϸ� ��й�ȣ ã�� �� ��Ʈ�ѷ�");
		
		return "login/find/emailPw";
	}
	
	/**
	* ��ϵ� �̸��Ϸ� ��й�ȣ ã�� 
	* 
	* @param  UserVo
	* @return String 
	* @author Ȳ����
	* @exception
	* ������� : 2019-08-14 
	*/
	@RequestMapping(value = "/email/findPw", method = RequestMethod.POST)
	public String findEmailPw(UserVo bean) {
		log.debug("��ϵ� �̸��Ϸ� ��й�ȣ ã�� ��Ʈ�ѷ�");
		
		//���� �ۼ�(bean - id, email)
		
		return "login/find/changePw";
	}
	
	/**
	* ��й�ȣ ����
	* 
	* @param  String chgPw1	- ������ ��й�ȣ
	* @param  String chhPw2	- ������ ��й�ȣ Ȯ��
	* @return String 
	* @author Ȳ����
	* @exception
	* ������� : 2019-08-14 
	*/
	@RequestMapping(value = "/login/email/findPw", method = RequestMethod.POST)
	public String modifyChgPw(String chgPw1, String chgPw2) {
		log.debug("��й�ȣ ���� ��Ʈ�ѷ�...");
		
		//���� �ۼ�(������ ��й�ȣ, ������ ��й�ȣ Ȯ��, return int)
		
		return "login/login"; //���� : �α����������� �̵�
	}
	
}
