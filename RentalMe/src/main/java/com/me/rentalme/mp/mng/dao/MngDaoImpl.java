package com.me.rentalme.mp.mng.dao;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.me.rentalme.model.entity.CallVo;
import com.me.rentalme.model.entity.MngOrdDetailVo;
import com.me.rentalme.model.entity.MngOrdVo;
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
	public List<CallVo> selectDep() throws SQLException {
		return sqlSession.selectList("mpMng.selectDep");		
	}
	
}
