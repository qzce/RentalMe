package com.me.rentalme.mp.user.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.me.rentalme.cs.entity.CsVo;
import com.me.rentalme.model.entity.CallVo;
import com.me.rentalme.model.entity.UserVo;


public interface MpUserService {
	
	//�ֹ����� ����Ʈ ���
	List<CallVo> ordList(String mbNo) throws SQLException;
	
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

	//���� ��ġ�� ������Ʈ
	public void updateDeposit() throws SQLException;

	//���� ��ġ�� ���
	public CallVo userInfoList() throws SQLException;

	//�� ���� ���
	public UserVo userInfo(String mbNo) throws SQLException;

	//�� ���� ����
	public UserVo myinfo(String mbNo,UserVo userVo) throws SQLException;

	//�̸� �����ϱ�
	public UserVo getName(String mbNo) throws SQLException;

	List<CallVo> AuctList(String mbNo) throws SQLException;

	
	//���� 1:1���� ����Ʈ ���
	List<CsVo> myList(CsVo csVo,HttpSession session) throws SQLException;
	
	//�� ���� �� ������
	CsVo myInqDetail(CsVo csVo) throws SQLException;
	
	//�� ���� ����
	int myQuestDel(CsVo csVo) throws SQLException;
}
