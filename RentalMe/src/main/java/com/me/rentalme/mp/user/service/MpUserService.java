package com.me.rentalme.mp.user.service;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import com.me.rentalme.common.Paging;
import com.me.rentalme.cs.entity.CsVo;
import com.me.rentalme.model.entity.CallVo;
import com.me.rentalme.model.entity.UserVo;


public interface MpUserService {

	
	//�ֹ����� ����Ʈ ���
	List<CallVo> ordList(String mbNo) throws SQLException;
	
	//�ı� ���
	int addReview(CallVo callVo, String mbNo) throws SQLException;
	
	//��ٱ��� ����Ʈ ���
	List<CallVo> cartList(String mbNo) throws SQLException;
	
	//��ٱ��� ���� ����
	public void deleteCart(String gdsCd,String mbNo,String cartSeq) throws SQLException;
	
	//���ѻ�ǰ ����Ʈ ���
	List<CallVo> wishList(String mbNo) throws SQLException;
	
	//���ѻ�ǰ ����(CALL_STS_CD=2 �� ������Ʈ)
	public void deleteWish(String usedGdsNo,String mbNo) throws SQLException;

	//��ġ�� ��볻�� ����Ʈ ���
	List<CallVo> depositList(String mbNo) throws SQLException;

	//��ġ�� ����
	int insertCharge(CallVo callVo,String mbNo) throws SQLException;
	
	//��ġ�� ȯ�ҿ�û
	int refundCharge(String refund,String mbNo) throws SQLException;

	//���� ��ġ�� ������Ʈ
	public void updateDeposit(String chargeDeposit, String mbNo) throws SQLException;

	//���� ��ġ�� ���
	public CallVo userInfoList(String mbNo) throws SQLException;

	//�� ���� ���
	public UserVo userInfo(String mbNo) throws SQLException;

	//�� ���� ����
	public UserVo myinfo(String mbNo,UserVo userVo) throws SQLException;

	//�̸� �����ϱ�
	public UserVo getName(String mbNo) throws SQLException;

	List<CallVo> AuctList(String mbNo) throws SQLException;

	
	//���� 1:1���� ����Ʈ ���
	List<CsVo> myList(CsVo csVo,HttpSession session,int startListNum, int listSize) throws SQLException;
	
	//�� ���� ����Ʈ ����
	int inquiryListCnt(HttpSession session) throws SQLException;
	
	//�� ���� �� ������
	CsVo myInqDetail(CsVo csVo) throws SQLException;
	
	//�� ���� ����
	int myQuestDel(CsVo csVo) throws SQLException;

	//�������̵��� ��й�ȣ�� DB���� �������� 
	UserVo getInfo(String userId) throws SQLException;

	//�Է��� ��й�ȣ üũ
	String checkPw(String userId, String userPw) throws SQLException;

	//��й�ȣ ����
	int changePw(String userId, String userPw);

	
	
	

}
