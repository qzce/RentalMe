package com.me.rentalme.act.service;

import java.sql.SQLException;
import java.util.List;

import com.me.rentalme.model.entity.ActResultVo;
import com.me.rentalme.common.Paging;
import com.me.rentalme.model.entity.ActVo;
import com.me.rentalme.model.entity.CallVo;
import com.me.rentalme.model.entity.RentalAppliVo;

public interface ActService {

	//������ ��Ű��� ����Ʈ
	List<ActVo> mngListAct(Paging actPaging) throws SQLException;
	
	int addAct100(ActVo actVo) throws SQLException;
	int addAct300(ActVo actVo) throws SQLException;
	List<ActVo> goodsList(String goodsNum) throws SQLException;
	//ActVo goodsInfo(String goodsNum) throws SQLException;
	
	
	
	List<RentalAppliVo> actList() throws SQLException;


	List<RentalAppliVo>  actEndList() throws SQLException;

	RentalAppliVo actDetail(String gdsCdDetail) throws SQLException;

	ActVo actDetailAuction(String gdsCdDetail);
	
	//��� ������
	int selectMyMb(String mbno) throws SQLException;
	
	//��� ������ �����Ϳ� ����
	int insertActResult(ActResultVo bean) throws SQLException;
	
	int updateBidWin(String gdsCd) throws SQLException;
	
	//������ ��� ���� Ȯ��
	List<ActResultVo> SelectMngActSpec() throws SQLException;
	
	int updateMngBidCancel(String gdsCd) throws SQLException;
	
	//�������
	int updateActEnd(String gdsCd) throws SQLException;
	
	//��Ż�ǰ ����Ʈ ����
	void deleteAct(String gdsCd) throws SQLException;
	
	//��Ż�ǰ����Ʈ ����
	int actListCnt() throws SQLException;
	int updateMngActStsCd(String gdsCd) throws SQLException;
	int insertUserActMoney(CallVo bean) throws SQLException;
	int updateUserActMoney(CallVo bean) throws SQLException;
}
