package com.me.rentalme.mp.mng.service;

import java.sql.SQLException;
import java.util.List;

import com.me.rentalme.model.entity.CallVo;
import com.me.rentalme.model.entity.MngOrdDetailVo;
import com.me.rentalme.model.entity.MngOrdVo;
import com.me.rentalme.model.entity.UserVo;

public interface MngService {
	List<MngOrdVo> selectOrd() throws SQLException;							//��ü �ֹ� ����Ʈ
	List<MngOrdDetailVo> selectOrdOne(String ordNo) throws SQLException;	//�ֹ� �󼼺���
	UserVo selectOrdOneInfo(String ordNo) throws SQLException;				//�ֹ��� ��������
	
	List<CallVo> selectDep() throws SQLException;							//��ġ�� ����Ʈ
}
