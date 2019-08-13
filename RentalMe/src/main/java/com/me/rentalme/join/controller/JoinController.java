package com.me.rentalme.join.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.me.rentalme.join.service.JoinService;
import com.me.rentalme.model.entity.UserVo;

/**
* ȸ������ ��Ʈ�ѷ�
* 
* @author Ȳ����
* @version ver1.0
* @see 
* ������� : 2019.08.12
* �������� : 2019.08.13
*/
@Controller
@RequestMapping(value="/join")
public class JoinController {
	
	Logger log = LoggerFactory.getLogger(getClass());
	
	@Inject
	JoinService joinService; 
	
	/**
	* ȸ������ ������ 
	* 
	* @param  none
	* @return String 
	* @author Ȳ����
	* @exception none
	*/
	@RequestMapping(value="/signup", method = RequestMethod.GET)
	public String getSignUp() {
		log.debug("ȸ������ ��Ʈ�ѷ� ������...");
		
		return "join/joinus";
	}
	
	/**
	* ������� ������ 
	* 
	* @param  none
	* @return String 
	* @author Ȳ����
	* @exception none
	*/
	@RequestMapping(value="/terms", method=RequestMethod.GET)
	public String getTerms() {
		log.debug("������� ��Ʈ�ѷ�...");
		
		return "join/terms";
	}
	
	/**
	* ȸ������ �Է�
	* 
	* @param  UserVo 
	* @return String 
	* @author Ȳ����
	* @exception None
	*/
	@RequestMapping(value = "/info", method = RequestMethod.POST)
	public String registerInfo(UserVo bean) {
		log.debug("ȸ������ �Է� ��Ʈ�ѷ�...");
		
		int result = joinService.addInfo(bean);
		
		//ȸ������ �Է� ���� �� ���ԿϷ� �������� �̵�
		if(result > 0) {
			return "join/compl";		
		}
		//ȸ������ �Է� ���� �� �Է��������� �ٽ� �̵� (��й�ȣ�� �ʱ�ȭ �ǰ� ������ �� ����)
		return null;
		
	}
	
	/**
	* ���ԿϷ� ������
	* 
	* @param  None 
	* @return String - �α����������� �̵�
	* @author Ȳ����
	* @exception None
	*/
	@RequestMapping(value = "/compl", method = RequestMethod.POST)
	public String getCompl() {
		log.debug("���ԿϷ� ��Ʈ�ѷ�...");
	
		return "login/login";
	}
}
