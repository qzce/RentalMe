package com.me.rentalme.join.service;

import com.me.rentalme.model.entity.UserVo;

/**
* ȸ������ ���� �������̽�
* 
* @author Ȳ����
* @version ver1.0
* @see 
*/
public interface JoinService {

	int 	addInfo(UserVo bean);  	//ȸ�����
	String 	getId(String userId); 	//���̵� �ߺ�üũ
	void 	addMemNoSeq();			//ȸ����ȣ ������ �߰�
	String 	getMemNo();				//ȸ����ȣ ��������
	
}
