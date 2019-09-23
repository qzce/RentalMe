package com.me.rentalme.used.service;

import java.sql.SQLException;
import java.util.List;

import com.me.rentalme.model.entity.DeclVo;
import com.me.rentalme.model.entity.UsedCmtVo;
import com.me.rentalme.model.entity.UsedStoreVo;
import com.me.rentalme.model.entity.UsedVo;
import com.me.rentalme.model.entity.UserVo;

public interface UsedService {
	UserVo userInfo(UserVo bean) throws SQLException;
	String userId(String mbNo) throws SQLException;
	List<UsedVo> list(UsedVo bean) throws SQLException; 
	List<UsedVo> oneList(UsedVo bean) throws SQLException;
	
	int seqUp() throws SQLException; //������ ����
	int addUsed(UsedVo bean) throws SQLException;
	
	UsedVo detail(String usedGdsNo) throws SQLException;
	
	List<UsedCmtVo> cmtList(String usedGdsNo) throws SQLException;
	int addCmt(UsedCmtVo bean) throws SQLException;
	int usedComtDecl(DeclVo bean) throws SQLException;			//��۽Ű���
	
	List<UsedVo> myUsedAll(String mbNo) throws SQLException;
	List<UsedVo> mySelectAllAlign(UsedVo bean) throws SQLException; //�� ���� ��ǰ ����
	
	int addMyStoreCmt(UsedStoreVo bean) throws SQLException;
	List<UsedStoreVo> listMyStoreCmt(String storeNo) throws SQLException;
	int usedStoreDecl(DeclVo bean) throws SQLException;						// ���� �Ű���
	
	int usedcount(UsedVo bean) throws SQLException;
	int delMyStoreListOne(String usedGdsNo) throws SQLException; // ���� �ø� ��� �� �Ѱ� �����
	int updateStoreSts(String usedGdsNo) throws SQLException; // �߰��ǰ �ǸſϷ�
}
