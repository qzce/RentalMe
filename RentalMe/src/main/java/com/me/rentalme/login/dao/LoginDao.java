package com.me.rentalme.login.dao;

import com.me.rentalme.model.entity.UserVo;

public interface LoginDao {

	UserVo getId(String userId); 						//�α��� ���̵� üũ

	int addPwFailCnt(int pwFailCnt, String userId);		//��й�ȣ �Է� ���� ī��Ʈ 1 �߰�

	void setUserBann(String userId);					//��������ڷ� ����

	void initPwFailCnt(String userId);					//��й�ȣ ����Ƚ�� �ʱ�ȭ

}
