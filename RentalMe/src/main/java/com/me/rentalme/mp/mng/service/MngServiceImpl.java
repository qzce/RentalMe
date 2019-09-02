package com.me.rentalme.mp.mng.service;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.me.rentalme.model.entity.CallVo;
import com.me.rentalme.model.entity.MngOrdDetailVo;
import com.me.rentalme.model.entity.MngOrdVo;
import com.me.rentalme.model.entity.UserVo;
import com.me.rentalme.mp.mng.dao.MngDao;

@Service
public class MngServiceImpl implements MngService {

	@Inject
	MngDao mngDao;
	
	@Override
	public List<MngOrdVo> selectOrd() throws SQLException {
		return mngDao.selectOrd();								//��ü �ֹ� ����
	}

	@Override
	public List<MngOrdDetailVo> selectOrdOne(String ordNo) throws SQLException {
		return mngDao.selectOrdOne(ordNo);						//�ֹ� �� ����
	}

	@Override
	public UserVo selectOrdOneInfo(String ordNo) throws SQLException {
		return mngDao.selectOrdOneInfo(ordNo);					//�ֹ��� ��������
	}

	@Override
	public List<CallVo> selectDep() throws SQLException {
		return mngDao.selectDep();								//��ġ�� ����Ʈ
	}

}
