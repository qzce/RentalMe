package com.me.rentalme.login.service;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.me.rentalme.model.entity.UserVo;

/**
* �α��� ����
* 
* @author Ȳ����
* @version ver1.0
* @see 
* ������� : 2019.08.13
*/
@Service
public class LoginServiceImpl implements LoginService {
	
	Logger log = LoggerFactory.getLogger(getClass());
	
	//@Inject
	//LoginDao loginDao; 
	
	/**
	* �α���
	* 
	* @param  UserVo
	* @return String 
	* @author Ȳ����
	* @exception none
	*/
	@Override
	public int login(UserVo bean, HttpServletRequest req) {
		
		//HttpSession session = req.getSession();
		
		//�α��� �ٿ� �̵�
		
		//loginDao.loginCheck();
		
		//����ó��
		
		return 0;
	}

}
