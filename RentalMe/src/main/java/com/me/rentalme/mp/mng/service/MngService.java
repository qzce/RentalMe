package com.me.rentalme.mp.mng.service;

import java.sql.SQLException;
import java.util.List;

import com.me.rentalme.common.Paging;
import com.me.rentalme.model.entity.CallVo;
import com.me.rentalme.model.entity.DeclVo;
import com.me.rentalme.model.entity.MngOrdDetailVo;
import com.me.rentalme.model.entity.MngOrdVo;
import com.me.rentalme.model.entity.ProductVo;
import com.me.rentalme.model.entity.RentalAppliVo;
import com.me.rentalme.model.entity.UsedVo;
import com.me.rentalme.model.entity.UserVo;

public interface MngService {
	List<MngOrdVo> selectOrd() throws SQLException;							//��ü �ֹ� ����Ʈ
	List<MngOrdDetailVo> selectOrdOne(String ordNo) throws SQLException;	//�ֹ� �󼼺���
	UserVo selectOrdOneInfo(String ordNo) throws SQLException;				//�ֹ��� ��������
	int updateStsPC(String ordNo) throws SQLException;						//��ǰ���� ����Ȯ������ �ٲٱ�
	
	List<CallVo> selectDep() throws SQLException;							//��ġ�� ����Ʈ
	List<CallVo> selectDepOne(String mbNo) throws SQLException;				//ȸ�� ��ġ�� ��
	

	List<UsedVo> selectUsed() throws SQLException;							//��ü �߰� ����Ʈ
	List<UsedVo> selectUsedSearch(String usedGdsNo) throws SQLException;	//�߰� �ϳ� ����
	int getUsedListCnt(UsedVo bean);										//��ü �߰���Ʈ �Խù� �Ѱ���
	
	List<MngOrdVo> selectReturn() throws SQLException;						//��ü ��ǰ ����Ʈ
	int updateStsRtn(String ordNo) throws SQLException;						//��ǰ���� ��ǰȮ������ �ٲٱ�
	
	List<DeclVo> selectDecl() throws SQLException;							//��ü �Ű� ����Ʈ
	int changeDeclSts(String declNo) throws SQLException;					//�Ű���� ó���Ϸ�� �ٲٱ�
	int selectDeclListCnt(DeclVo bean);										//��ü �Ű� ��

	int getUsedListCnt();													//��ü �߰���Ʈ �Խù� �Ѱ���
	
	List<UserVo> getUserInfo();												//����ڰ��� - ����� ����Ʈ 
	String delUserInfo(String mbNo);										//����ڰ��� - ����� Ż���ϱ�
	UserVo getUserDetail(String mbNo);										//����ڰ��� - ����� ������	
	int getMngUserListCnt();												//����ڰ��� - ����ڰ��� ���ο� ��ȸ			

	////�߰�--------------
	//��ǰ ����Ʈ
	List<RentalAppliVo> searchScGoods(String goodsNum) throws SQLException;
	
	long selectNum(String mGoodsNum,String sGoodsNum);
	
	//��Ż ��ǰ ����Ʈ ����¡
	List<RentalAppliVo> selectGoodsList(Paging apliPaging) throws SQLException;
	List<RentalAppliVo> lGoodsList(Paging apliPaging) throws SQLException;
	List<RentalAppliVo> sGoodsList(Paging apliPaging) throws SQLException;
	List<RentalAppliVo> kGoodsList(Paging apliPaging) throws SQLException;
	List<RentalAppliVo> fGoodsList(Paging apliPaging) throws SQLException;
	List<RentalAppliVo> otherGoodsList(Paging apliPaging) throws SQLException;
	List<RentalAppliVo> pacGoodsList(Paging apliPaging) throws SQLException;
	int goodsListCnt();
	int lGoodsListCnt();
	int sGoodsListCnt();
	int kGoodsListCnt();
	int fGoodsListCnt();
	int otherGoodsListCnt();
	int pacGoodsListCnt();
	
	void deleteAppli(String gdsCd) throws SQLException;
	
	//��Ż��ǰ���
	int rentalGoodsAdd100(RentalAppliVo rentalAppliVo);
	int rentalGoodsAdd200(ProductVo productVo);	
	
	//������ ����
	void rentalseq();	
}
