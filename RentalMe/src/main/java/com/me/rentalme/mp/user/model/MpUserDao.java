package com.me.rentalme.mp.user.model;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.me.rentalme.cs.entity.CsVo;
import com.me.rentalme.model.entity.CallVo;
import com.me.rentalme.model.entity.UserVo;

/**
	* ����������_���� Dao �������̽�
	* 
	* @author ������
	* @version ver1.0
	* @see 
	*/
public interface MpUserDao {
	
	//�ֹ����� ����Ʈ ���
	List<CallVo> selectOrd(String mbNo) throws SQLException;
	
	//�ı� ���
	int InsertReview(String gdsCd, String userId, String content,String grade, String mbNo) throws SQLException;
	
	//��ٱ��� ����Ʈ ���
	List<CallVo> selectCart(String mbNo) throws SQLException;
	
	//��ٱ��� ���û���
	public void deleteCart(String gdsCd,String mbNo,String cartSeq) throws SQLException;
	
	//���ѻ�ǰ ����Ʈ ���
	List<CallVo> selectWish(String mbNo) throws SQLException;
	
	//���ѻ�ǰ ����(CALL_STS_CD=2 �� ������Ʈ)
	public void deleteWish(String usedGdsNo,String mbNo) throws SQLException;

	//��ġ�� ����Ʈ ���
	List<CallVo> selectDeposit(String mbNo) throws SQLException;

	//��ġ�� ����
	int insertCharge(String userId, String depositGbCd, String chargeDeposit,String mbNo) throws SQLException;

	//���� ��ġ�� ������Ʈ
	public void updateDeposit(String chargeDeposit, String mbNo) throws SQLException;

	//���� ��ġ�� ���
	public CallVo selectUserInfo(String mbNo) throws SQLException;

	//�� ���� ���
	public UserVo selectMyInfo(String mbNo) throws SQLException;

	//�� ���� ������Ʈ
	public UserVo updateMyInfo(String mbNo,String userNm, String addr, String addrDetail) throws SQLException;
	
	//�̸� ��������
	public UserVo getName(String mbNo) throws SQLException;

	//��ų��� ����Ʈ ���
	List<CallVo> selectAuct(String mbNo) throws SQLException;

	//1:1���ǳ�������Ʈ
	List<CsVo> myQuestList(CsVo csVo,HttpSession session) throws SQLException;
	
	CsVo myQuestDetail(CsVo csVo) throws SQLException;
	
	int myQuestDel(CsVo csVo) throws SQLException;

	
}
