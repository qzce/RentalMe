package com.me.rentalme.act.service;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.me.rentalme.act.model.ActDao;
import com.me.rentalme.model.entity.ActVo;
import com.me.rentalme.model.entity.RentalAppliVo;

@Service
public class ActServiceImpl implements ActService{
	
	Logger log = LoggerFactory.getLogger(getClass());
	
	@Inject
	ActDao actDao;
	
	//��� ������ ����Ʈ
	@Override
	public List<RentalAppliVo> actList() throws SQLException {
		return actDao.selectActRun();
	}

	//��� ����� ����Ʈ
	@Override
	public List<RentalAppliVo> actEndList() throws SQLException {
		return actDao.selectActEnd();
	}

	//��� ��ǰ �������� (RentalAppliVo���� ������)
	@Override
	public List<RentalAppliVo> actDetail(RentalAppliVo rentalAppliVo, String gdsCdDetail) throws SQLException {
		return actDao.selectActDetail(rentalAppliVo, gdsCdDetail);
	}

	//��� ��ǰ ��������2 (ActVo���� ������)
	@Override
	public Object actDetailAuction(String gdsCdDetail) {
		return actDao.selectActDetail2(gdsCdDetail);
	}

}
