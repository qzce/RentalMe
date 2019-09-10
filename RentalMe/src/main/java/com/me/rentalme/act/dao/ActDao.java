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
	
	List<ActVo> selectMngActList() throws SQLException;
	int insertAct300(ActVo actVo) throws SQLException;
	int insertAct100(ActVo actVo) throws SQLException;
	List<ActVo> selectGoodsList(String goodsNum) throws SQLException;
	//ActVo selectGoodsInfo(String goodsNum) throws SQLException;

}
