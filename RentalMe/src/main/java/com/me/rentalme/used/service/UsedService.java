package com.me.rentalme.used.service;

import java.sql.SQLException;
import java.util.List;

import com.me.rentalme.model.entity.UsedVo;

public interface UsedService {
	List<UsedVo> list() throws SQLException; 
	List<UsedVo> oneList(int GDS_MCLASS_CD) throws SQLException;
	int seqUp() throws SQLException; //������ ����
	int addUsed(UsedVo bean) throws SQLException;
}
