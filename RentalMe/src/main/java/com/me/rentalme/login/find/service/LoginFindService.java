package com.me.rentalme.login.find.service;

import java.util.List;

import com.me.rentalme.model.entity.UserVo;

public interface LoginFindService {
	
	//�Է��� �̸��Ϸ� ���̵�� �������� ã��
	List<UserVo> getId(String email);
	
}
