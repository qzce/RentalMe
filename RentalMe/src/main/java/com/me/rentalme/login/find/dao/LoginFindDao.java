package com.me.rentalme.login.find.dao;

import java.util.List;

import com.me.rentalme.model.entity.UserVo;

public interface LoginFindDao {

	//�Է��� ���̵� ������ ���̵�� ���Գ�¥�� ������ �´�.
	List<UserVo> getId(String email);

	//�Է��� �̸��� ��/�� üũ
	int checkEmail(String email);

}
