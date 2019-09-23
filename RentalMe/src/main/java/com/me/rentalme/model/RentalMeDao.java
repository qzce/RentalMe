package com.me.rentalme.model;

import java.sql.SQLException;
import java.util.List;

import com.me.rentalme.cs.entity.CsVo;
import com.me.rentalme.model.entity.CallVo;
import com.me.rentalme.model.entity.RentalMeVo;

public interface RentalMeDao {
	
	List<RentalMeVo> selectAll() throws SQLException;

	//�ǽð� ���� ��Ȳ ����Ʈ
	List<CallVo> selectOrdList() throws SQLException;

	//����Ʈ ������ ����Ʈ
	List<CallVo> selectBestList() throws SQLException;
	//���ο� ������ ����Ʈ
	List<CallVo> selectNewList() throws SQLException;

	//�������� ����Ʈ
	List<CsVo> selectCsList() throws SQLException;


	
}
