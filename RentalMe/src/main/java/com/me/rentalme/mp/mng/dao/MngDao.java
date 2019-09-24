package com.me.rentalme.mp.mng.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.me.rentalme.common.Paging;
import com.me.rentalme.model.entity.CallVo;
import com.me.rentalme.model.entity.DeclVo;
import com.me.rentalme.model.entity.MngOrdDetailVo;
import com.me.rentalme.model.entity.MngOrdVo;
import com.me.rentalme.model.entity.ProductVo;
import com.me.rentalme.model.entity.QuestVo;
import com.me.rentalme.model.entity.RefundVo;
import com.me.rentalme.model.entity.RentalAppliVo;
import com.me.rentalme.model.entity.UsedVo;
import com.me.rentalme.model.entity.UserVo;

public interface MngDao {
	List<MngOrdVo> selectOrd() throws SQLException;							//��ü �ֹ� ����Ʈ
	List<MngOrdDetailVo> selectOrdOne(String ordNo) throws SQLException;	//�ֹ� �󼼺���
	UserVo selectOrdOneInfo(String ordNo) throws SQLException;				//�ֹ��� ��������
	int updateStsPC(String ordNo) throws SQLException;						//��ǰ���� ����Ȯ������ �ٲٱ�
	
	List<CallVo> selectDep() throws SQLException;							//��ġ�� ����Ʈ
	List<CallVo> selectDepOne(String mbNo) throws SQLException;				//ȸ�� ��ġ�� ��
	

	List<UsedVo> selectUsed() throws SQLException;							//��ü �߰� ����Ʈ
	List<UsedVo> selectUsedSearch(String usedGdsNo) throws SQLException;	//�߰� �ϳ� ����
	int selectusedListCnt(UsedVo bean);										//��ü �߰� ����Ʈ �Ѱ���
	
	List<MngOrdVo> selectReturn() throws SQLException;						//��ü ��ǰ ����Ʈ
	int updateStsRtn(String ordNo) throws SQLException;						//��ǰ���� ��ǰȮ������ �ٲٱ�
	
	List<DeclVo> selectDecl() throws SQLException;							//��ü �Ű� ����Ʈ
	int changeDeclSts(String declNo) throws SQLException;					//�Ű���� ó���Ϸ�� �ٲٱ�
	
	int selectusedListCnt();												//��ü �߰� ����Ʈ �Ѱ���
	
	List<UserVo> selectUserList();											//����ڰ��� - ��������� ����Ʈ	
	int updUserinfo(String mbNo);											//����ڰ��� - ȸ��Ż��
	UserVo selectUserDetail(String mbNo);									//����ڰ��� - ����� ������
	int selectMngUserListCnt();												//����ڰ��� - ȸ�� �� �ο� ��
	int selectDeclListCnt(DeclVo bean);										//��ü �Ű� ��
	
	//2019.09.24 �߰�
	int updateUserInfoInit(String mbNo);									//����ڰ��� - �����ʱ�ȭ
		
	//��Ż ��ü ��ǰ ����Ʈ

	//�߰�--------------
	//��Ż ��ü ��ǰ ����Ʈ(ī��Ʈ)
	List<RentalAppliVo> searchScGoods(String goodsNum) throws SQLException;
	List<RentalAppliVo> selectGoodsList() throws SQLException;
	List<RentalAppliVo> selectGoodsList(String gdsMclassCd) throws SQLException;
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
	
	//��Ż ��ǰ ���
	int rentalGoodsAdd100(RentalAppliVo rentalAppliVo);

	int rentalGoodsAdd300(ProductVo productVo);
	
	long selectNum(String mGoodsNum,String sGoodsNum);
	
	//������ ����
	void rentalSeq();
	
	List<RefundVo> selectRefundList() throws SQLException;						//������ ȸ�� ȯ�� ����Ʈ���
	int updateRefundConfirm(String mbNo) throws SQLException;					//������ ȸ�� ȯ�� Ȯ��	
	int updateRefundCancel(String mbNo) throws SQLException;					//������ ȸ�� ȯ�� Ȯ��	
	void deleteAppli(String gdsCd) throws SQLException;
	
	List<QuestVo> selectQuestList() throws SQLException;						//������ ȸ�� ������ ����Ʈ ���
	int updateQuest(String questNo) throws SQLException;						//������ ȸ�� ��� Ȯ��
	
}
