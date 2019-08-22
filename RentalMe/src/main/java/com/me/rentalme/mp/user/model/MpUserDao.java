package com.me.rentalme.mp.user.model;

import java.sql.SQLException;
import java.util.List;

import com.me.rentalme.model.entity.CallVo;

/**
	* ����������_���� Dao �������̽�
	* 
	* @author ������
	* @version ver1.0
	* @see 
	*/
public interface MpUserDao {
	
	//�ֹ����� ����Ʈ ���
	List<CallVo> selectOrd() throws SQLException;
	
	//���ѻ�ǰ ����Ʈ ���
	List<CallVo> selectWish() throws SQLException;
	
	//���ѻ�ǰ ����(CALL_STS_CD=2 �� ������Ʈ)
	public void deleteWish(CallVo callVo) throws SQLException;
	
	
}
