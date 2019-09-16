package com.me.rentalme.login.controller;


import java.sql.Date;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

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
	* @param  Model model - LoginInterceptor UserVo�� ����ϱ� ���ؼ� ���
	* @return ModelAndView mav
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(UserVo userVo, HttpSession session, Model model, HttpServletRequest req) {
		log.debug("�α��� ��Ʈ�ѷ�...(���񽺿��� �ۼ��߾�� �ϳ�... ����ٺ��� ��Ʈ�ѷ��� ���� �̵�[����])");
		
		String msg = "";
		
		/* �α��� ��ȿ�� üũ */
		//�Է��� ���̵�
		String userId = userVo.getUserId();
		
		/* �Է��� ���̵��� ������ DB�κ��� �����´�. */
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
					
					//����ϰ� �ִ� ������ Ȯ�� üũ
					String userAgent = req.getHeader("User-Agent");
					String browser = "";										//����ڰ� �α��� �� ������
					String browserStsCd = "";									//DB�� �Է��� ������ �ڵ�
					
					System.out.println("�α��� �������� : "+loginUser.toString());
					
					String loginStsCd   		= loginUser.getLoginStsCd();	//�α��λ��� üũ
					String loginBrowserStsCD 	= loginUser.getBrowserStsCd();	//�α��� ������ �ڵ�
					String loginBrowserNm = "";									//�α����� ������ �ڵ��
					
					//Db�� ����� �α��� �� ������ ������
					if(loginBrowserStsCD.equals("1")) {
						loginBrowserNm = "IE";
					}else if(loginBrowserStsCD.equals("2")) {
						loginBrowserNm = "Opera";
					}else if(loginBrowserStsCD.equals("3")) {
						loginBrowserNm = "Firefox";
					}else if(loginBrowserStsCD.equals("4")) {
						loginBrowserNm = "Chrome";
					}else if(loginBrowserStsCD.equals("5")) {
						loginBrowserNm = "Safari";
					}

					//�α����Ϸ��� ����� ������
					if (userAgent.indexOf("Trident") > 0 || userAgent.indexOf("MSIE") > 0) {
						browser = "IE";
						browserStsCd = "1";
					} else if (userAgent.indexOf("Opera") > 0) {
						browser = "Opera";
						browserStsCd = "2";
					} else if (userAgent.indexOf("Firefox") > 0) {
						browser = "Firefox";
						browserStsCd = "3";
					} else if (userAgent.indexOf("Safari") > 0) {
						if (userAgent.indexOf("Chrome") > 0) {
							browser = "Chrome";
							browserStsCd = "4";
						} else {
							browser = "Safari";
							browserStsCd = "5";
						}
					}
					
					System.out.println("�Է��� ���� ������ :  "+browser);
					System.out.println("�α��� ���� ���°� :  "+loginStsCd+", �α��� ���� ������ : "+ loginBrowserNm);
					
					//�α����� �Ǿ��ְ� ���� �������� ��� �̹� ������� ���̵� �̴�.
					if(loginStsCd.equals("1") && loginBrowserNm.equals(browser)) {	
						msg = "usingId";
						mav.addObject("msg", msg);
						System.out.println("������ξ��̵� : "+msg);
						mav.setViewName("login/login");
						return mav;								
					}else {					//������� ���̵� �ƴ� ���
						if(loginStsCd.equals("1")) {
							if(!loginBrowserNm.equals(browser)) {
								//���� �ٸ� �������̹Ƿ� �α����� ����
								System.out.println("�Է��� ���� ������ : "+ browser 
										+ ", �α��� ���� ���� ������ : "+ loginBrowserNm);
							}
						}else {
							loginService.chgLoginStsCd(userId, browserStsCd);
							session.setAttribute("flag", "Y");
						}
					}									
					
					if(pwFailCnt > 0) {
						//��й�ȣ ����Ƚ�� �ʱ�ȭ
						loginService.initPwFailCnt(loginId);
					}
					
					//�α��� ����������� model ��ü�� ��´�.(�α��� session�� LoginInterceptor���� ó���Ѵ�.)
					model.addAttribute("loginUser", loginUser);
					
					//�ڵ��α��ο� üũ�� �Ǿ����� ���
					if(userVo.isUseLogin()) {
						//������Ű���� ������ �´�.
						String sessionKey = session.getId();
						//��Ű���� �ð� ����
						int sessionCookieTime = 60*60*24*7; //7��
						Date sessionDt = new Date(System.currentTimeMillis() + (1000 * sessionCookieTime));
						
						//�α��� ����
						loginService.keepLogin(userId, sessionKey, sessionDt);
					}
					
					mav.setViewName("redirect:/main");
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
	public String logout(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
		log.debug("�α׾ƿ� ��Ʈ�ѷ�");
		
		//���ǿ� ��� ����� ���̵�
		String sessionUserId = (String)session.getAttribute("loginUserId");
		String sessionMbNo = (String)session.getAttribute("loginMbNo");
		
		
		//������ ���� ���� ���
		if(sessionUserId != null && sessionMbNo != null) {
			String userId = sessionUserId;
			
			
			System.out.println("flag���� : "+session.getAttribute("flag"));
			//����α����� ����� �� 
			//�α��λ���, �������ڵ� �ʱ�ȭ
			if(session.getAttribute("flag") != null) {
				loginService.chgLogoutStsCd(userId);
				session.removeAttribute("flag");
			}
			
			session.removeAttribute("flag");
			session.removeAttribute("loginUserId");
			session.removeAttribute("loginMbNo");
			
			//������ ��� ������ ���� ����
			session.invalidate();
			
			//��Ű����
			Cookie loginCookie = WebUtils.getCookie(req, "loginCookie");
			
			//��Ű������ ������ ���� ���
			if(loginCookie != null) {
				loginCookie.setPath("/");
				loginCookie.setMaxAge(0);
				resp.addCookie(loginCookie);
				
				Date sessionDt = new Date(System.currentTimeMillis() + (1000 * 0));
				loginService.keepLogin(userId, "none", sessionDt);
			}
		}

		return "redirect:/main";
	}
	

}
