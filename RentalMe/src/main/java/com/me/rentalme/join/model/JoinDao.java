package com.me.rentalme.join.model;

import com.me.rentalme.model.entity.UserVo;

/**
* ȸ������ Dao �������̽�
* 
* @author Ȳ����
* @version ver1.0
* @see 
*/
public interface JoinDao {

	int insertJoin(UserVo bean); 						//ȸ����� 

	int getKey(String userId, String key);				//���� ����Ű ���� �޼���

	int updEmailKey(String userId, String emailKey); 	//���� ����Ű Y�� �ٲ��ִ� �޼���

	int selectId(String userId); 						//ȸ�� ���̵� �ߺ� üũ

	void insertMemnoSeq(); 								//ȸ����ȣ ������ �߰�

	String getMemNo();									//ȸ����ȣ ��ȸ
	
	int insertMb(String mbNo);							//ȸ����ġ�� 0��

}
