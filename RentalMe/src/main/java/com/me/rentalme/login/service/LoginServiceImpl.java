package com.me.rentalme.login.service;

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
* �������� : 2019.08.26
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


}
