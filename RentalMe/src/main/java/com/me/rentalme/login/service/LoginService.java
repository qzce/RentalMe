package com.me.rentalme.login.service;

import javax.servlet.http.HttpServletRequest;

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
	
	int login(UserVo bean, HttpServletRequest req); //�α���;
}
