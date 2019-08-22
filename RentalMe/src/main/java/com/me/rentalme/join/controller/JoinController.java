package com.me.rentalme.join.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.me.rentalme.auth.service.MailAuthService;
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
	
	@Inject
	MailAuthService mailAuthService;
	
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
	* ȸ������ ��� ��
	* 
	* @param  None 
	* @return String 
	* @author Ȳ����
	* @exception None
	*/
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public String info() {
		log.debug("ȸ������ ��� �� ��Ʈ�ѷ�");
		
		return "join/info";
	}
	
	/**
	* ȸ������ �Է�
	* 
	* @param  UserVo userVo 
	* @param  HttpServletREquest req  
	* @return String 
	* @author Ȳ����
	* @exception None
	*/
	@RequestMapping(value = "/info", method = RequestMethod.POST)
	public ModelAndView registerInfo(UserVo userVo, HttpServletRequest req) {
		log.debug("ȸ������ �Է� ��Ʈ�ѷ�...");
		
		//ȸ����ȣ �������߰�
		joinService.addMemNoSeq();
		
		//ȸ����ȣ ��ȸ
		joinService.getMemNo();
		
		//ȸ������
		joinService.addInfo(userVo);
		
		//���� ���� ������ 
		mailAuthService.mailSendWithUserKey(userVo.getEmail(), userVo.getUserId(), req);
		
		
		return new ModelAndView("join/compl");
	}

	/**
	* ���̵� �ߺ�üũ
	* 
	* @param  String uesrId - ����� ���̵�
	* @return String 
	* @author Ȳ����
	* @exception None
	*/
	@RequestMapping(value = "/checkId", method = RequestMethod.GET)
	public void checkId (@RequestParam("userId")String userId, HttpServletResponse res) {
		log.debug("���̵� �ߺ�üũ ��Ʈ�ѷ�");
		
		//���̵� �ߺ�üũ
		String msg = joinService.getId(userId);
		
		try {
			res.getWriter().write(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}		

	}
	
	/**
	* ȸ������ �� ��������(Y) ������Ʈ
	* 
	* @param  String userId   : ����ھ��̵�
	* @param  String emailKey : ����� �̸��� Ű(����)
	* @return String 
	* @author Ȳ����
	* @exception None
	*/
	@RequestMapping(value = "/key_alter", method = RequestMethod.GET)
	public String updateEmailConfirm(@RequestParam String userId,@RequestParam String emailKey) {
		log.debug("ȸ������ �� ��������(Y) ������Ʈ ��Ʈ�ѷ�");
		
		mailAuthService.updateEamilConfirm(userId, emailKey);
		
		return "join/authRegCompl";
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
