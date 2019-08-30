package com.me.rentalme.login.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
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
	* @param  HttpServletRequest req
	* @return ModelAndView mav 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest req) {
		log.debug("�α��� �� ��Ʈ�ѷ�...");
		
		ModelAndView mav = new ModelAndView("login/login");
		
		//�̸��Ϸ� ���̵�ã�⿡�� �Ѿ�� ���̵� ���� ������ userId���� ��� �α��� �������� �̵�
		if(req.getParameter("userId") != null) {
			String userId = req.getParameter("userId");
			mav.addObject("userId", userId);
		}

		return mav;
	}
	
	/**
	* �α���
	* 
	* @param  UserVo userVo
	* @param  HttspSessio session
	* @return ModelAndView mav
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(UserVo userVo, HttpSession session) {
		log.debug("�α��� ��Ʈ�ѷ�...");
		
		String msg = "";
		
		/* �α��� ��ȿ�� üũ */
		
		/* �Է��� ���̵��� ������ DB�κ��� �����´�. */
		String userId = userVo.getUserId();
		UserVo loginUser = loginService.getId(userId);
		
		/*
		 * ��й�ȣ ����
		 * 1. �α��� ����ڴ� ȸ�����̺� �����ؾ� �Ѵ�. 
		 * 2. �α��� ����ڴ� ����� �����ڵ尡 ����
		 * 3. �̸��� ���� Y
		 * 4. �Է��� ��й�ȣ�� ��ȣȭ�� ��й�ȣ�� ��ġ
		 * 5. ����Ƚ���� 5ȸ �̸�
		 * */ 
		ModelAndView mav = new ModelAndView();

		if(loginUser != null) {
			String userPw 		= userVo.getUserPw();							//�Է��� ��й�ȣ
			String loginId 		= loginUser.getUserId();						//DB�� ��� ���̵�
			String loginPw 		= loginUser.getUserPw();						//DB�� ��� ��й�ȣ
			String loginMbNo 	= loginUser.getMbNo();							//DB�� ��� ȸ����ȣ
			String emailKey 	= loginUser.getEmailKey();						//�̸��� Ű��(Y : ����, ����key : ������)
			int userStsCd		= Integer.parseInt(loginUser.getUserStsCd());	//���� ���� �ڵ�(1: ����, 2: ����-�������, 3: ����-����Ż��)
			int pwFailCnt		= Integer.parseInt(loginUser.getPwFailCnt());	//��й�ȣ ���� Ƚ��(5ȸ�̻� ��������ڷ� ����)
			
			/*����Ƚ�� 5ȸ�̻��� ��� ���� ����*/
			if(pwFailCnt >= 5) {
				//����� �����ڵ带 ���� ���·� ����.
				loginService.setUserBann(loginId);
										
				msg = "pwFailCntOver";
				mav.addObject("msg", msg);
				mav.setViewName("login/login");
				return mav;
			}

			if(userStsCd == 2) {				//���������
				msg = "bannedId";
				mav.addObject("msg", msg);
				mav.setViewName("login/login");
				return mav;
			}else if(userStsCd == 3) {			//����Ż�� �����(���Ұ� ����� �Դϴ�.)
				msg = "kickId";
				mav.addObject("msg", msg);
				mav.setViewName("login/login");
				return mav;
			}

			//�̸��� ������ �� ����� �̰� ����� ���°� ������ �����
			if(emailKey.equals("Y") && userStsCd == 1) {
				//�Է��� ���̵� DB�� �ִ� ��� �Է��� ��й�ȣ�� DB�� ����� ��й�ȣ ��ȣȭ ���� ��
				if(BCrypt.checkpw(userPw, loginPw)) {
					
					if(pwFailCnt > 0) {
						//��й�ȣ ����Ƚ�� �ʱ�ȭ
						loginService.initPwFailCnt(loginId);
					}
					
					//��ȣȭ�� ��й�ȣ�� ���� ��� ���ǿ� �����Ѵ�.(sessionId : loginUserId)
					session.setAttribute("loginUserId", userId);
					//ȸ����ȣ�� ���ǿ� �����Ѵ�.(sessionMbNo : loginMbNo)
					session.setAttribute("loginMbNo", loginMbNo);
					
					mav.setViewName("redirect:/");
					return mav;
				}else {
					/*����Ƚ���� 1ȸ �����Ѵ�.*/
					pwFailCnt += 1;
					loginService.addPwFailCnt(pwFailCnt, loginId);
					
					/*��ȣȭ�� ��й�ȣ�� �ٸ� ���*/
					msg = "pwFail";
					mav.addObject("msg", msg);
					mav.setViewName("login/login");
					return mav;
				}
			}else {				
				//�̸��� ������ ���� ���� ������� ���
				msg = "notEmailKey";
				mav.addObject("msg", msg);
				mav.setViewName("login/login");
				return mav;
			}
		}
		//��ϵ� ����ڰ� �ƴѰ��
		msg = "notUserId";
		mav.addObject("msg", msg);
		mav.setViewName("login/login");
		return mav;
	}
	
	/**
	* �α׾ƿ�
	* 
	* @param  HttspSessio session
	* @return String 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		log.debug("�α׾ƿ� ��Ʈ�ѷ�");
		
		//������ ��� ������ ���� ����
		session.invalidate();
		
		return "redirect:/";
	}
	

}
