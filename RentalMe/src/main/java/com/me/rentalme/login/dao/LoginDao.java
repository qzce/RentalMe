package com.me.rentalme.login.dao;

import java.sql.Date;

import com.me.rentalme.model.entity.UserVo;

public interface LoginDao {
	
	void keepLogin(String userId, String sessionKey, Date sessionDt);	//�α��� ���� 
	
	UserVo checkLoginSessionKey(String value);							//����Ű�� üũ

	UserVo getId(String userId); 										//�α��� ���̵� üũ

	int addPwFailCnt(int pwFailCnt, String userId);						//��й�ȣ �Է� ���� ī��Ʈ 1 �߰�

	void setUserBann(String userId);									//��������ڷ� ����

	void initPwFailCnt(String userId);									//��й�ȣ ����Ƚ�� �ʱ�ȭ

	void updLoginStsCd(String userId, String browserStsCd);				//�α��� ���� ������Ʈ

	void updLogoutStsCd(String userId);									//�α׾ƿ� ���� ������Ʈ

}
