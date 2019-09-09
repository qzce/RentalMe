package com.me.rentalme.login.find.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.me.rentalme.login.find.dao.LoginFindDao;
import com.me.rentalme.model.entity.UserVo;


/**
* ���̵�/��й�ȣ ã�� ����
* 
* @author Ȳ����
* @version ver1.0
* @see 
* ������� : 2019.08.28
*/
@Service
public class LoginFindServiceImpl implements LoginFindService {
	
	Logger log = LoggerFactory.getLogger(getClass());
	
	@Inject
	LoginFindDao loginFindDao;
	
	/**
	* ��ϵ� �̸��Ϸ� ���̵� ã��
	* 
	* @param  String email : �̸����ּ�
	* @return String 
	* @author Ȳ����
	* @exception
	*/
	@Override
	public List<UserVo> getId(String email) {
		
		log.debug("��ϵ� �̸��Ϸ� ���̵� ã�� service");
		
		//�Է��� �̸����� ��ϵ� �̸������� Ȯ��
		int result = loginFindDao.checkEmail(email);
		
		List<UserVo> list = new ArrayList<UserVo>();
		
		if(result > 0) {	//���̵� ������
			return loginFindDao.getId(email);
		}else {				//���̵� ������
			return list;
		}
	}
	
	/**
	* ��й�ȣ ã�� - ������ ����
	* 
	* @param  UserVo userVo
	* @return boolean 
	* @author Ȳ����
	* ������� : 2019-09-04
	*/
	@Override
	public String checkData(UserVo userVo) {
		log.debug("��й�ȣ ã�� - ������ ���� service");
		
		if(!userVo.getEmail().equals("") && userVo.getEmail()!=null) {	//�̸���ã�� �� ���
			String userId 	= userVo.getUserId();		//�Է��� ����� ���̵�
			String email	= userVo.getEmail();		//�Է��� ����� �̸���
			
			int result = loginFindDao.checkPwEmail(userId, email);	//�Է��� �����͸� üũ
			
			if(result > 0) {	//�����Ͱ� ��ġ
				return "not empty";
			}else {				//�����Ͱ� ����ġ
				return "empty";
			}	

		}else if(!userVo.getHp().equals("") && userVo.getHp()!=null) {	//�ڵ���ã�� �� ���

		}		
		
		return "empty";
	}

	/**
	* ��й�ȣ ����
	* 
	* @param  UserVo userVo
	* @return boolean 
	* @author Ȳ����
	* ������� : 2019-09-04
	*/
	@Override
	public void modifyPw(UserVo userVo) {
		log.debug("��й�ȣ ���� service");
		
		//��й�ȣ ����� ��ȣȭ�ؼ� �����Ѵ�.
		String userPw = BCrypt.hashpw(userVo.getUserPw(), BCrypt.gensalt()); 
		String userId = userVo.getUserId();
		String email  = userVo.getEmail();
		loginFindDao.updPw(userPw, userId, email);
	}
	
	
	
	

}
