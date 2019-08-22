package com.me.rentalme.mp.user.service;

import java.sql.SQLException;
import java.util.List;


import com.me.rentalme.model.entity.CallVo;


public interface MpUserService {
	
	//�ֹ����� ����Ʈ ���
	List<CallVo> ordList() throws SQLException;
	
	//���ѻ�ǰ ����Ʈ ���
	List<CallVo> wishList() throws SQLException;
	
	//���ѻ�ǰ ����(CALL_STS_CD=2 �� ������Ʈ)
	public void deleteWish(CallVo callVo) throws SQLException;

}
