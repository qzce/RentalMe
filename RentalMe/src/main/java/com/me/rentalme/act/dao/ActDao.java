package com.me.rentalme.act.dao;

import java.sql.SQLException;
import java.util.List;

import com.me.rentalme.model.entity.ActVo;
import com.me.rentalme.model.entity.RentalAppliVo;

public interface ActDao {

	//��� ������ ����Ʈ
	List<RentalAppliVo> selectActRun() throws SQLException;

	//��� ����� ����Ʈ
	List<RentalAppliVo> selectActEnd() throws SQLException;

	//��� ��ǰ ��������
	List<RentalAppliVo> selectActDetail(RentalAppliVo rentalAppliVo,String gdsCdDetail) throws SQLException;

	//��� ��ǰ ��������2
	List<ActVo> selectActDetail2(String gdsCdDetail);

}
