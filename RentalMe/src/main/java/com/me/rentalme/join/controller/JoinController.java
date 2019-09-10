package com.me.rentalme.join.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.me.rentalme.auth.service.HpAuthService;
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
* �������� : 2019.09.02
*/
@Controller
@RequestMapping(value="/join")
public class JoinController {
	
	Logger log = LoggerFactory.getLogger(getClass());
	
	@Inject
	JoinService joinService; 
	
	@Inject
	MailAuthService mailAuthService;
	
	@Inject
	HpAuthService hpAuthService;
	
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
		
		//���� ���� ������ (2019-08-27 : ȸ������ ��Ŀ��� �����ϴ� ������� �������� ���� ����)
		//mailAuthService.mailSendWithUserKey(userVo.getEmail(), userVo.getUserId(), req);
		
		
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
	* �ڵ��� �����ڵ� �߼�
	* 
	* @param  String hp - �Է��� �ڵ��� ��ȣ
	* @return String 
	* @author Ȳ����
	* ������� : 2019-09-05
	*/	
	@RequestMapping(value="/hpCodeSend", method = RequestMethod.POST)
	public void sendHpCode(@RequestParam String hp, HttpServletResponse res) {
		//System.out.println("view���� �Ѿ�� �ڵ�����ȣ : "+hp);
		//�ڵ������� ���� ��ȣ ������
		
		String key = hpAuthService.sendHp(hp);
		
		try {
			res.getWriter().write(key);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	* �̸��� �����ڵ� �߼�
	* 
	* @param  String uesrId - ����� ���̵�
	* @return  
	* @author Ȳ����
	* @exception None
	*/
	@RequestMapping(value = "/emailCodeSend", method = RequestMethod.GET)
	public void sendEmailCode (@RequestParam("email") String email, HttpServletResponse res) {
		log.debug("�����ڵ� �߼� ��Ʈ�ѷ�");
		
		//���� ���� ������ 
		String key = mailAuthService.mailSendWithUserEmail(email);
		
		try {
			res.getWriter().write(key);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	* ȸ������ �� ��������(Y) ������Ʈ (2019-08-27 : ȸ������ ��Ŀ��� �����ϴ� ������� �������� ���� ����)
	* 
	* @param  String userId   : ����ھ��̵�
	* @param  String emailKey : ����� �̸��� Ű(����)
	* @return String 
	* @author Ȳ����
	* @exception None
	*/
//	@RequestMapping(value = "/key_alter", method = RequestMethod.GET)
//	public String updateEmailConfirm(@RequestParam String userId,@RequestParam String emailKey) {
//		log.debug("ȸ������ �� ��������(Y) ������Ʈ ��Ʈ�ѷ�");
//		
//		mailAuthService.updateEamilConfirm(userId, emailKey);
//		
//		return "join/authRegCompl";
//	}
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
