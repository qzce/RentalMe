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
	
	//�ı� ���
		@Override
		public int addReview(CallVo callVo) throws SQLException {
			log.debug("�ı� ��� ����...");
			
			
			return mpUserDao.InsertReview(callVo.getGdsCd(), callVo.getUserId(), callVo.getContent(), callVo.getGrade());
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

	//��ġ�� ����Ʈ
	@Override
	public List<CallVo> depositList() throws SQLException {
		
		return mpUserDao.selectDeposit();
	}
	
	//��ġ�� ����
	@Override
	public int insertCharge(CallVo callVo) throws SQLException {

		return mpUserDao.insertCharge(callVo.getUserId(), callVo.getDepositGbCd(), callVo.getChargeDeposit());
	}

	//���� ��ġ�� update
	@Override
	public void updateDeposit() throws SQLException {
		
		mpUserDao.updateDeposit();
		
	}

	@Override
	public CallVo userInfoList() throws SQLException {
		log.debug("���� ��� ����...");
		return mpUserDao.selectUserInfo();
	}


	


}
