package com.me.rentalme.login.find.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

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
			//System.out.println("����Ʈ�� ũ���(��)? : "+list.size());
			return loginFindDao.getId(email);
		}else {				//���̵� ������
			//System.out.println("����Ʈ�� ũ���?(��) : "+list.size());
			return list;
		}
	}

}
