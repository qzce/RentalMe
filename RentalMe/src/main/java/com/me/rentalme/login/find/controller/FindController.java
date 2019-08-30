package com.me.rentalme.login.find.controller;

import java.sql.Date;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.me.rentalme.login.find.service.LoginFindService;
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
public class FindController {
	
	Logger log = LoggerFactory.getLogger(getClass());
	
	@Inject
	LoginFindService loginFindService; 
	
	/**
	* ��ϵ� �̸��Ϸ� ���̵� ã��
	* 
	* @param  String email : �̸����ּ�
	* @return String 
	* @author Ȳ����
	* @exception
	* ������� : 2019-08-14 
	*/
	
	@RequestMapping(value = "/emailFindId", method = RequestMethod.GET)
	public @ResponseBody List<UserVo> findEmailId(@RequestParam("email") String email, Model model) {
		log.debug("��ϵ� �̸��Ϸ� ���̵� ã�� ��Ʈ�ѷ� ...");
		
		
		//����� �̸��Ϸ� ����� ������ ������´�.
		List<UserVo> infoList = loginFindService.getId(email);

		return infoList;
		
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
	@RequestMapping(value = "/login/email/findPw", method = RequestMethod.PUT)
	public String modifyChgPw(String chgPw1, String chgPw2) {
		log.debug("��й�ȣ ���� ��Ʈ�ѷ�...");
		
		//���� �ۼ�(������ ��й�ȣ, ������ ��й�ȣ Ȯ��, return int)
		
		return "login/login"; //���� : �α����������� �̵�
	}
	
}
