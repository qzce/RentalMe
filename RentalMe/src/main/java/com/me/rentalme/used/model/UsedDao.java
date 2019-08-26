package com.me.rentalme.used.model;

import java.sql.SQLException;
import java.util.List;

import com.me.rentalme.model.entity.UsedCmtVo;
import com.me.rentalme.model.entity.UsedVo;

public interface UsedDao {
	List<UsedVo> selectAll() throws SQLException;
	List<UsedVo> selectOne(UsedVo bean) throws SQLException; //�߰�ŷ� ����
	int seqInsert() throws SQLException;	//����������
	int InsertOne(UsedVo bean) throws SQLException; //�߰��ǰ �Է�
	UsedVo DetailOne(String usedGdsNo) throws SQLException; // �߰� ������
	List<UsedCmtVo> selectCmtAll(String usedGdsNo) throws SQLException;
	int cmtInsert(UsedCmtVo bean) throws SQLException;
}
