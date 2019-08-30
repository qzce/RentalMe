package com.me.rentalme.mp.user.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.me.rentalme.cs.entity.CsVo;
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

	int insertCharge(CallVo callVo) throws SQLException;
	
	//���� 1:1���� ����Ʈ ���
	List<CsVo> myList(CsVo csVo,HttpSession session) throws SQLException;
	
	//�� ���� �� ������
	CsVo myInqDetail(CsVo csVo) throws SQLException;
	
	//�� ���� ����
	int myQuestDel(CsVo csVo) throws SQLException;
}
