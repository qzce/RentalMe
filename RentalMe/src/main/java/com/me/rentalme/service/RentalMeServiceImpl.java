package com.me.rentalme.service;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.me.rentalme.model.RentalMeDao;
import com.me.rentalme.model.entity.CallVo;
import com.me.rentalme.model.entity.RentalMeVo;

@Service
public class RentalMeServiceImpl implements RentalMeService {
	
	@Inject
	RentalMeDao rentalmeDao;

	@Override
	public List<RentalMeVo> list() throws SQLException {
		return rentalmeDao.selectAll();
	}
	
	//�ǽð� ���� ��Ȳ ����Ʈ
	@Override
	public List<CallVo> ordList() throws SQLException {
		return rentalmeDao.selectOrdList();
	}

	//����Ʈ ������ ����Ʈ
	@Override
	public List<CallVo> bestList() throws SQLException {
		return rentalmeDao.selectBestList();
	}


}
