package com.me.rentalme.login.service;

import java.sql.Date;

import com.me.rentalme.model.entity.UserVo;

/**
* �α��� ���� �������̽�
* 
* @author Ȳ����
* @version ver1.0
* @see 
* ������� : 2019.08.13
*/
public interface LoginService {
	
	//�α��� ����
	void keepLogin(String userId, String sessionKey, Date sessionDt);
	
	//������Ű�� üũ
	UserVo checkLoginSessionKey(String value);

	//�Է��� �α��� ���̵� üũ
	UserVo getId(String userId);

	//��й�ȣ ����Ƚ�� ī��Ʈ +1
	int addPwFailCnt(int pwFailCnt, String userId);

	//����ڸ� ��������ڷ� ����
	void setUserBann(String userId);

	//��й�ȣ ����Ƚ�� �ʱ�ȭ
	void initPwFailCnt(String userId);
	
	
}
