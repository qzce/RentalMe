package com.me.rentalme.mp.user.service;

import java.sql.SQLException;
import java.util.List;


import com.me.rentalme.model.entity.CallVo;


public interface MpUserService {
	
	//�ֹ����� ����Ʈ ���
	List<CallVo> ordList() throws SQLException;
	
	//�ı� ���
	int addReview(CallVo callVo) throws SQLException;
	
	//��ٱ��� ����Ʈ ���
	List<CallVo> cartList() throws SQLException;
	
	//���ѻ�ǰ ����Ʈ ���
	List<CallVo> wishList() throws SQLException;
	
	//���ѻ�ǰ ����(CALL_STS_CD=2 �� ������Ʈ)
	public void deleteWish(CallVo callVo) throws SQLException;

	//��ġ�� ��볻�� ����Ʈ ���
	List<CallVo> depositList() throws SQLException;

	//��ġ�� ����
	int insertCharge(CallVo callVo) throws SQLException;

	//���� ��ġ�� update
	public void updateDeposit() throws SQLException;

	public CallVo userInfoList() throws SQLException;
}
