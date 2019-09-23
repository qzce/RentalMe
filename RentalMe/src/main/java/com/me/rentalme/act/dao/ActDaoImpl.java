package com.me.rentalme.act.dao;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.me.rentalme.model.entity.ActResultVo;
import com.me.rentalme.common.Paging;
import com.me.rentalme.model.entity.ActVo;
import com.me.rentalme.model.entity.CallVo;
import com.me.rentalme.model.entity.RentalAppliVo;

@Repository
public class ActDaoImpl implements ActDao{

	@Inject
	SqlSession sqlSession;
	
	
	@Override
	public List<ActVo> selectMngActList() throws SQLException {
		System.out.println("sql������ ����Ʈ�̱�");
		return sqlSession.selectList("actRental.actList");
	}

	@Override
	public int insertAct300(ActVo actVo) throws SQLException {
		System.out.println("insert sql300");
		return sqlSession.insert("actRental.actAdd300", actVo);
	}

	
	  @Override public int insertAct100(ActVo actVo) throws SQLException {
	  System.out.println("insert sql100"); return
	  sqlSession.insert("actRental.actAdd", actVo); }
	 
	
	//��� ������ ����Ʈ
	@Override
	public List<RentalAppliVo> selectActRun() throws SQLException {
		return sqlSession.selectList("act.selectActRun");
	}

	//��� ����� ����Ʈ
	@Override
	public List<RentalAppliVo> selectActEnd() throws SQLException {
		return sqlSession.selectList("act.selectActEnd");
	}
	
	//��� �� ������
	@Override
	public RentalAppliVo selectActDetail(String gdsCdDetail) throws SQLException {
		
		return sqlSession.selectOne("act.selectActDetail",gdsCdDetail);
	}

	//��� �� ������2
	@Override
	public ActVo selectActDetail2(String gdsCdDetail) {
		return sqlSession.selectOne("act.selectActDetail2",gdsCdDetail);
	}
	
	
	@Override
	public List<ActVo> selectGoodsList(String goodsNum) throws SQLException {
		System.out.println("��ǰ�ڵ��ȣ����");
		
		System.out.println(goodsNum);
		return sqlSession.selectList("actRental.goodsList",goodsNum);
	}
	@Override
	public int insertActResult(ActResultVo bean) throws SQLException {
		return sqlSession.insert("act.insertActResult",bean);
	}

	@Override
	public int updateBidWin(String gdsCd) throws SQLException {
		return sqlSession.update("act.updateBidWin", gdsCd);
	}

	@Override
	public List<ActResultVo> SelectMngActSpec() throws SQLException {
		return sqlSession.selectList("act.SelectMngActSpec");
	}

	@Override
	public int updateMngBidCancel(String gdsCd) throws SQLException {
		return sqlSession.update("act.updateMngBidCancel", gdsCd);
	}

	@Override
	public int updateActEnd(String gdsCd) throws SQLException {
		return sqlSession.update("act.updateActEnd", gdsCd);
	}

	@Override
	public int selectMyMb(String mbno) throws SQLException {
		return sqlSession.selectOne("act.selectMyMb", mbno);
	}
	//��Ż�ǰ ����
	@Override
	public void deleteActList(String gdsCd) throws SQLException {
		System.out.println("��Ż�ǰ ���� dao");
		
		System.out.println(gdsCd);
		sqlSession.delete("actRental.deleteList", gdsCd);
	}

	//��Ż�ǰ ����Ʈ ����
	@Override
	public int actListCnt() throws SQLException {
		System.out.println("rental����¡ dao");
		int cnt=0;
		cnt=sqlSession.selectOne("actRental.actListCnt");
		System.out.println("inq����:"+cnt);
		return cnt;
	}

	@Override
	public int updateMngActStsCd(String gdsCd) throws SQLException {
		return sqlSession.update("act.updateMngActStsCd", gdsCd);
	}

	@Override
	public int insertUserActMoney(CallVo bean) throws SQLException {
		return sqlSession.insert("act.insertUserActMoney", bean);
	}

	@Override
	public int updateUserActMoney(CallVo bean) throws SQLException {
		return sqlSession.update("act.updateUserActMoney", bean);
	}
}
