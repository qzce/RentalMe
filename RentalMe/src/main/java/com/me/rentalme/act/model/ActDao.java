package com.me.rentalme.act.model;

import java.sql.SQLException;
import java.util.List;

import com.me.rentalme.model.entity.ActVo;
import com.me.rentalme.model.entity.RentalAppliVo;

public interface ActDao {

	//경매 진행중 리스트
	List<RentalAppliVo> selectActRun() throws SQLException;

	//경매 종료된 리스트
	List<RentalAppliVo> selectActEnd() throws SQLException;

	//경매 상품 상세페이지
	List<RentalAppliVo> selectActDetail(RentalAppliVo rentalAppliVo,String gdsCdDetail) throws SQLException;

	//경매 상품 상세페이지2
	List<ActVo> selectActDetail2(String gdsCdDetail);

}
