package com.me.rentalme.act.model;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.me.rentalme.model.entity.ActVo;
import com.me.rentalme.model.entity.RentalAppliVo;

@Repository
public class ActDaoImpl implements ActDao{

	@Inject
	SqlSession sqlSession;
	
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
	public List<RentalAppliVo> selectActDetail(RentalAppliVo rentalAppliVo,String gdsCdDetail) throws SQLException {
		
		return sqlSession.selectList("act.selectActDetail",gdsCdDetail);
	}

	//��� �� ������2
	@Override
	public List<ActVo> selectActDetail2(String gdsCdDetail) {
		return sqlSession.selectList("act.selectActDetail2",gdsCdDetail);
	}

}
