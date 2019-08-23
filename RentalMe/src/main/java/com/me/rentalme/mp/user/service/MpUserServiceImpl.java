package com.me.rentalme.mp.user.service;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.me.rentalme.model.entity.CallVo;
import com.me.rentalme.mp.user.model.MpUserDao;

@Service
public class MpUserServiceImpl implements MpUserService{
	
	Logger log = LoggerFactory.getLogger(getClass());

	@Inject
	MpUserDao mpUserDao;
	
	
	//�ֹ����� ����Ʈ
	@Override
	public List<CallVo> ordList() throws SQLException {
		//log.debug("�ֹ����� ����");
		
		return mpUserDao.selectOrd();
	}
	
	//��ٱ��� ����Ʈ
	@Override
	public List<CallVo> cartList() throws SQLException {
		// TODO Auto-generated method stub
		return mpUserDao.selectCart();
	}
	
	//���ѻ�ǰ ����Ʈ
	@Override
	public List<CallVo> wishList() throws SQLException {
		//log.debug("����������(���ѻ�ǰ) ����");
		
		return mpUserDao.selectWish();
	}
	
	//���ѻ�ǰ ����
	@Override
	public void deleteWish(CallVo callVo) throws SQLException {
		
		mpUserDao.deleteWish(callVo);
	}

	

	


}
