package com.me.rentalme.login.service;

import java.sql.Date;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.me.rentalme.login.dao.LoginDao;
import com.me.rentalme.model.entity.UserVo;

/**
* �α��� ����
* 
* @author Ȳ����
* @version ver1.0
* @see 
* ������� : 2019.08.13
* �������� : 2019.08.27
*/
@Service
public class LoginServiceImpl implements LoginService {
	
	Logger log = LoggerFactory.getLogger(getClass());

	@Inject
	LoginDao loginDao; 
	
	/**
	* �Է��� �α��� ���̵� üũ
	* 
	* @param  UserVo
	* @return String 
	* @author Ȳ����
	* @exception none
	*/
	@Override
	public UserVo getId(String userId) {
		log.debug("�α��� ���̵� üũ");
		
		return loginDao.getId(userId);
	}

	/**
	* ��й�ȣ ����Ƚ�� 1ȸ ī��Ʈ
	* 
	* @param  int pwFailCnt
	* @param  String userId
	* @return String 
	* @author Ȳ����
	* @exception none
	*/
	@Override
	public int addPwFailCnt(int pwFailCnt, String userId) {
		log.debug("��й�ȣ �Է½��� ����Ƚ�� 1ȸ ī��Ʈ service");
		
		return loginDao.addPwFailCnt(pwFailCnt, userId);
	}

	/**
	* ��������ڷ� ����
	* 
	* @param  String userId
	* @return None 
	* @author Ȳ����
	* @exception none
	*/
	@Override
	public void setUserBann(String userId) {
		log.debug("���� ����ڷ� ���� service");
		
		loginDao.setUserBann(userId);
	}

	/**
	* ��й�ȣ ����Ƚ�� �ʱ�ȭ
	* 
	* @param  String userId
	* @return None 
	* @author Ȳ����
	* @exception none
	*/
	@Override
	public void initPwFailCnt(String userId) {
		log.debug("��й�ȣ ����Ƚ�� �ʱ�ȭ service");
		
		loginDao.initPwFailCnt(userId);
	}

	/**
	* �α��� ����
	* 
	* @param  String userId		- ����ھ��̵�
	* @param  String sessionKey	- ������Ű��
	* @param  String sessionDt	- ������Ű����
	* @return None 
	* @author Ȳ����
	* ������� : 2019-09-01
	*/
	@Override
	public void keepLogin(String userId, String sessionKey, Date sessionDt) {
		log.debug("�α��� ���� service");
		
		loginDao.keepLogin(userId, sessionKey, sessionDt);
	}

	/**
	* ������Ű�� üũ
	* 
	* @param  String userId
	* @return None 
	* @author Ȳ����
	* @exception none
	* ������� : 2019-09-01
	*/
	@Override
	public UserVo checkLoginSessionKey(String value) {
		log.debug("������Ű�� üũ service");
		
		return loginDao.checkLoginSessionKey(value);
	}


}
