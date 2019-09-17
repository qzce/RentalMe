package com.me.rentalme.mp.mng.service;

import java.sql.SQLException;
import java.util.List;

import com.me.rentalme.common.Paging;
import com.me.rentalme.model.entity.CallVo;
import com.me.rentalme.model.entity.DeclVo;
import com.me.rentalme.model.entity.MngOrdDetailVo;
import com.me.rentalme.model.entity.MngOrdVo;
import com.me.rentalme.model.entity.UsedVo;
import com.me.rentalme.model.entity.UserVo;

public interface MngService {
	List<MngOrdVo> selectOrd() throws SQLException;							//��ü �ֹ� ����Ʈ
	List<MngOrdDetailVo> selectOrdOne(String ordNo) throws SQLException;	//�ֹ� �󼼺���
	UserVo selectOrdOneInfo(String ordNo) throws SQLException;				//�ֹ��� ��������
	int updateStsPC(String ordNo) throws SQLException;						//��ǰ���� ����Ȯ������ �ٲٱ�
	
	List<CallVo> selectDep() throws SQLException;							//��ġ�� ����Ʈ
	List<CallVo> selectDepOne(String mbNo) throws SQLException;				//ȸ�� ��ġ�� ��
	
	List<UsedVo> selectUsed() throws SQLException;							//��ü �߰� ����Ʈ
	List<UsedVo> selectUsedSearch(String usedGdsNo) throws SQLException;	//�߰� �ϳ� ����
	
	List<MngOrdVo> selectReturn() throws SQLException;						//��ü ��ǰ ����Ʈ
	int updateStsRtn(String ordNo) throws SQLException;						//��ǰ���� ��ǰȮ������ �ٲٱ�
	
	List<DeclVo> selectDecl(Paging usedPage) throws SQLException;			//��ü �Ű� ����Ʈ
	int changeDeclSts(String declNo) throws SQLException;					//�Ű���� ó���Ϸ�� �ٲٱ�
	
	int getUsedListCnt();													//��ü �߰���Ʈ �Խù� �Ѱ���
	
	
	//�߰�(2019.09.11)
	List<UserVo> getUserInfo();												//����ڰ��� - ����� ����Ʈ 
	
	//�߰�(2019.09.15)
	String delUserInfo(String mbNo);										//����ڰ��� - ����� Ż���ϱ�
	UserVo getUserDetail(String mbNo);										//����ڰ��� - ����� ������
	
	//�߰�(2019.09.16)
	int getMngUserListCnt();												//����ڰ��� - ����ڰ��� ���ο� ��ȸ			
}
