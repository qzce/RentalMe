package com.me.rentalme.used.model;

import java.sql.SQLException;
import java.util.List;

import com.me.rentalme.model.entity.DeclVo;
import com.me.rentalme.model.entity.UsedCmtVo;
import com.me.rentalme.model.entity.UsedStoreVo;
import com.me.rentalme.model.entity.UsedVo;
import com.me.rentalme.model.entity.UserVo;

public interface UsedDao {
	UserVo userInfo(UserVo bean) throws SQLException; //����� ����
	String userId(String mbNo) throws SQLException;
	List<UsedVo> selectAll(UsedVo bean) throws SQLException;
	List<UsedVo> selectOne(UsedVo bean) throws SQLException; //�߰�ŷ� ����
	
	int seqInsert() throws SQLException;	//����������
	int InsertOne(UsedVo bean) throws SQLException; //�߰��ǰ �Է�
	
	UsedVo DetailOne(String usedGdsNo) throws SQLException; // �߰� ������
	
	List<UsedCmtVo> selectCmtAll(String usedGdsNo) throws SQLException;
	int cmtInsert(UsedCmtVo bean) throws SQLException;
	int usedComtDecl(DeclVo bean) throws SQLException;			//��۽Ű���
	
	List<UsedVo> mySelectAll(String mbNo) throws SQLException; //�� ���� ��ǰ��
	List<UsedVo> mySelectAllAlign(UsedVo bean) throws SQLException; //�� ���� ��ǰ ����
	
	int myStoreCmtInsert(UsedStoreVo bean) throws SQLException; //�� ���� �ı�ø���
	List<UsedStoreVo> myStoreCmtSelect(String storeNo) throws SQLException; // �� ���� �ı⺸��
	int usedStoreDecl(DeclVo bean) throws SQLException;						// ���� �Ű���
	
	int usedcount(UsedVo bean) throws SQLException;
	int delMyStoreListOne(String usedGdsNo) throws SQLException; // ���� �ø� ��� �� �Ѱ� �����
	

}
