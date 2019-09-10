package com.me.rentalme.login.find.service;

import java.util.List;

import com.me.rentalme.model.entity.UserVo;

public interface LoginFindService {
	
	//�Է��� �̸��Ϸ� ���̵�� �������� ã��
	List<UserVo> getId(String email);

	//��й�ȣ ã�� - ������ ����
	String checkData(UserVo userVo);

	//��й�ȣ ����
	void modifyPw(UserVo userVo);

	//�Է��� �ڵ������� ���̵� ã��.
	List<UserVo> checkHpYn(String hp);
	
}
