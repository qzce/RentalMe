package com.me.rentalme.mp.mng.dao;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.me.rentalme.common.Paging;
import com.me.rentalme.model.entity.CallVo;
import com.me.rentalme.model.entity.DeclVo;
import com.me.rentalme.model.entity.MngOrdDetailVo;
import com.me.rentalme.model.entity.MngOrdVo;
import com.me.rentalme.model.entity.ProductVo;
import com.me.rentalme.model.entity.RentalAppliVo;
import com.me.rentalme.model.entity.UsedVo;
import com.me.rentalme.model.entity.UserVo;

@Repository
public class MngDaoImpl implements MngDao{

	@Inject
	SqlSession sqlSession;
	
	@Override
	public List<MngOrdVo> selectOrd() throws SQLException {
		
		return sqlSession.selectList("mpMng.selectOrd");				//��ü �ֹ�����Ʈ
	}

	@Override
	public List<MngOrdDetailVo> selectOrdOne(String ordNo) throws SQLException {
		return sqlSession.selectList("mpMng.selectOrdOne", ordNo);		//�ֹ� �󼼺���
	}

	@Override
	public UserVo selectOrdOneInfo(String ordNo) throws SQLException {
		return sqlSession.selectOne("mpMng.selectOrdOneInfo", ordNo);	//�ֹ��� ��������
	}

	@Override
	public int updateStsPC(String ordNo) throws SQLException {
		return sqlSession.update("mpMng.updateStsPC", ordNo);			//��ǰ���� ����Ȯ������ �ٲٱ�
	}

	@Override
	public List<CallVo> selectDep() throws SQLException {
		return sqlSession.selectList("mpMng.selectDep");		
	}

	@Override
	public List<CallVo> selectDepOne(String mbNo) throws SQLException {
		return sqlSession.selectList("mpMng.selectDepOne", mbNo);		//ȸ�� ��ġ�� ��
	}

	@Override
	public List<UsedVo> selectUsed(UsedVo bean) throws SQLException {
		return sqlSession.selectList("mpMng.selectUsed", bean);				//��ü �߰� ����Ʈ
	}

	@Override
	public List<MngOrdVo> selectReturn() throws SQLException {
		return sqlSession.selectList("mpMng.selectReturn");				//��ü ��ǰ ����Ʈ
	}

	@Override
	public int updateStsRtn(String ordNo) throws SQLException {
		return sqlSession.update("mpMng.updateStsRtn", ordNo);			//��ǰ���� ��ǰȮ������ �ٲٱ�
	}

	@Override
	public List<UsedVo> selectUsedSearch(String usedGdsNo) throws SQLException {
		return sqlSession.selectList("mpMng.selectUsedSearch", usedGdsNo);//�߰� �ϳ� ����
	}

	@Override
	public List<DeclVo> selectDecl(Paging usedPage) throws SQLException {
		return sqlSession.selectList("mpMng.selectDecl", usedPage);				//��ü �Ű� ����Ʈ
	}

	@Override
	public int changeDeclSts(String declNo) throws SQLException {
		return sqlSession.update("mpMng.changeDeclSts", declNo);		//�Ű���� ó���Ϸ�� �ٲٱ�
	}
	
	@Override
	public int selectusedListCnt(UsedVo bean) {
		return sqlSession.selectOne("mpMng.selectusedListCnt",bean);			//�߰���Ʈ �Ѱ���
	}

	@Override
	public int selectDeclListCnt(DeclVo bean) {
		return sqlSession.selectOne("mpMng.selectDeclListCnt",bean);			//�Ű���Ʈ �Ѱ���
	}

	
	
	
	//�μ�
	@Override
	public List<RentalAppliVo> selectGoodsList(Paging apliPaging) throws SQLException {
		
		return sqlSession.selectList("mpMng.selectRentalList",apliPaging);
	}

	@Override
	public int goodsListCnt() {
		return sqlSession.selectOne("mpMng.goodsListCnt");
	}

	
	@Override
	public int lGoodsListCnt() {
		return sqlSession.selectOne("mpMng.lGoodsListCnt");
	}

	@Override
	public List<RentalAppliVo> lGoodsList(Paging apliPaging) throws SQLException {
		// TODO Auto-generated method stub
		return sqlSession.selectList("mpMng.selectLgoodsList",apliPaging);
	}

	@Override
	public List<RentalAppliVo> sGoodsList(Paging apliPaging) throws SQLException {
		// TODO Auto-generated method stub
		return sqlSession.selectList("mpMng.sGoodsList",apliPaging);
	}

	@Override
	public List<RentalAppliVo> kGoodsList(Paging apliPaging) throws SQLException {
		// TODO Auto-generated method stub
		return sqlSession.selectList("mpMng.kGoodsList",apliPaging);
	}

	@Override
	public List<RentalAppliVo> fGoodsList(Paging apliPaging) throws SQLException {
		// TODO Auto-generated method stub
		return sqlSession.selectList("mpMng.fGoodsList",apliPaging);
	}

	@Override
	public List<RentalAppliVo> otherGoodsList(Paging apliPaging) throws SQLException {
		// TODO Auto-generated method stub
		return sqlSession.selectList("mpMng.otherGoodsList",apliPaging);
	}

	@Override
	public List<RentalAppliVo> pacGoodsList(Paging apliPaging) throws SQLException {
		// TODO Auto-generated method stub
		return sqlSession.selectList("mpMng.pacGoodsList",apliPaging);
	}

	@Override
	public int sGoodsListCnt() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("mpMng.sGoodsListCnt");
	}

	@Override
	public int kGoodsListCnt() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("mpMng.kGoodsListCnt");
	}

	@Override
	public int fGoodsListCnt() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("mpMng.fGoodsListCnt");
	}

	@Override
	public int otherGoodsListCnt() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("mpMng.otherGoodsListCnt");
	}

	@Override
	public int pacGoodsListCnt() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("mpMng.pacGoodsListCnt");
	}

	@Override
	public int selectusedListCnt() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("mpMng.selectusedListCnt");
	}
	public int rentalGoodsAdd100(RentalAppliVo rentalAppliVo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("mpMng.rentalGoodsAdd100", rentalAppliVo);
	}

	@Override
	public int rentalGoodsAdd300(ProductVo productVo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("mpMng.rentalGoodsAdd200",productVo);
	}
	
}
