package com.me.rentalme.login.find.dao;

import java.util.List;

import com.me.rentalme.model.entity.UserVo;

public interface LoginFindDao {

	//�̸��Ϸ� ���̵� ã���� ��� ���̵� ã�´�
	List<UserVo> getEmailFindId(String email);
	
	//�ڵ������� ���̵� ã���� ��� ���̵� ã�´�.
	List<UserVo> getHpFindId(String hp);

	//�Է��� �̸��� ��/�� üũ
	int checkEmail(String email);

	//��й�ȣã�� - �̸��Ϸ� ã�� - ������ üũ
	int checkPwEmail(String userId, String email);

	//��й�ȣ ����
	int updPw(String userPw, String userId, String email);

	//�Է��� �ڵ�����ȣ�� ���ǿ��θ� üũ�Ѵ�.
	int selectHpYn(String hp);

}
