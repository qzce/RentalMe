package com.me.rentalme.act.dao;

import java.sql.SQLException;
import java.util.List;

import com.me.rentalme.model.entity.ActResultVo;
import com.me.rentalme.common.Paging;
import com.me.rentalme.model.entity.ActVo;
import com.me.rentalme.model.entity.RentalAppliVo;

public interface ActDao {
	//��� ������ ����Ʈ
	List<RentalAppliVo> selectActRun() throws SQLException;

	//��� ����� ����Ʈ
	List<RentalAppliVo> selectActEnd() throws SQLException;
	
	//������ ��� ����Ʈ
	List<ActVo> selectMngActList(Paging actPaging) throws SQLException;
	int insertAct300(ActVo actVo) throws SQLException;
	int insertAct100(ActVo actVo) throws SQLException;
	List<ActVo> selectGoodsList(String goodsNum) throws SQLException;
	//ActVo selectGoodsInfo(String goodsNum) throws SQLException;

	//��� ��ǰ ��������
	RentalAppliVo selectActDetail(String gdsCdDetail) throws SQLException;

	//��� ��ǰ ��������2
	ActVo selectActDetail2(String gdsCdDetail);
	
	//��� ������
	int selectMyMb(String mbno) throws SQLException;
	
	//��� ������ �����Ϳ� ����
	int insertActResult(ActResultVo bean) throws SQLException;
	
	//��� ������ Ȯ��
	int updateBidWin(String gdsCd) throws SQLException;
	
	//������ ��� ���� Ȯ��
	List<ActResultVo> SelectMngActSpec() throws SQLException;
	
	//�������
	int updateMngBidCancel(String gdsCd) throws SQLException;
	
	//�������
	int updateActEnd(String gdsCd) throws SQLException;

	void deleteActList(String gdsCd) throws SQLException;
	int actListCnt() throws SQLException;
	int updateMngActStsCd(String gdsCd) throws SQLException;
}
