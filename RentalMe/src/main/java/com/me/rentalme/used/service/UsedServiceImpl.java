package com.me.rentalme.used.service;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.me.rentalme.model.entity.RentalMeVo;
import com.me.rentalme.model.entity.UsedVo;
import com.me.rentalme.used.model.UsedDao;

@Service
public class UsedServiceImpl implements UsedService {

	Logger log = LoggerFactory.getLogger(getClass());
	
	@Inject
	UsedDao usedDao;
	
	@Override
	public List<UsedVo> list() throws SQLException {
		log.debug("�߰�ŷ� ����...");
		return usedDao.selectAll();
	}

	@Override
	public List<UsedVo> oneList(UsedVo bean) throws SQLException {
		log.debug("�߰�ŷ� ��...");
		return usedDao.selectOne(bean);
	}
	
	@Override
	public int seqUp() throws SQLException {
		log.debug("�⺻Ű 1����");
		return usedDao.seqInsert();
	}

	@Override
	public int addUsed(UsedVo bean) throws SQLException {
		log.debug("�߰�ǰ �Է�...");
		return usedDao.InsertOne(bean);
	}

	@Override
	public UsedVo detail(String usedGdsNo) throws SQLException {
		log.debug("�߰�ǰ �󼼺���...");
		return usedDao.DetailOne(usedGdsNo);
	}


}