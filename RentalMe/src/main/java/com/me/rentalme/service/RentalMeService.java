package com.me.rentalme.service;

import java.sql.SQLException;
import java.util.List;

import com.me.rentalme.cs.entity.CsVo;
import com.me.rentalme.model.entity.CallVo;
import com.me.rentalme.model.entity.RentalMeVo;

public interface RentalMeService {
	
	List<RentalMeVo> list() throws SQLException;

	//�ǽð� ���� ��Ȳ ����Ʈ
	List<CallVo> ordList() throws SQLException;

	//����Ʈ ������ ����Ʈ
	List<CallVo> bestList() throws SQLException;
	//���ο� ������ ����Ʈ
	List<CallVo> newList() throws SQLException;

	//�������� ����Ʈ
	List<CsVo> csList() throws SQLException;

	

}
