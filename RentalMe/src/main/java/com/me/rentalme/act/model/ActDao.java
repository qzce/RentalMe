package com.me.rentalme.act.model;

import java.sql.SQLException;
import java.util.List;

import com.me.rentalme.model.entity.RentalAppliVo;

public interface ActDao {

	//��� ������ ����Ʈ
	List<RentalAppliVo> selectActRun() throws SQLException;

	//��� ����� ����Ʈ
	List<RentalAppliVo> selectActEnd() throws SQLException;

}
