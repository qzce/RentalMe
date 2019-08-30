package com.me.rentalme.mp.user.service;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.me.rentalme.model.entity.CallVo;
import com.me.rentalme.model.entity.UserVo;
import com.me.rentalme.model.entity.UserVo;
import com.me.rentalme.mp.user.model.MpUserDao;

@Service
public class MpUserServiceImpl implements MpUserService{
	
	Logger log = LoggerFactory.getLogger(getClass());

	@Inject
	MpUserDao mpUserDao;
	
	
	//�ֹ����� ����Ʈ
	@Override
	public List<CallVo> ordList(String mbNo) throws SQLException {
		//log.debug("�ֹ����� ����");
		
		return mpUserDao.selectOrd(mbNo);
	}
	
	//�ı� ���
		@Override
		public int addReview(CallVo callVo) throws SQLException {
			log.debug("�ı� ��� ����...");
			
			
			return mpUserDao.InsertReview(callVo.getGdsCd(), callVo.getUserId(), callVo.getContent(), callVo.getGrade());
		}
	
	
	//��ٱ��� ����Ʈ
	@Override
	public List<CallVo> cartList(String mbNo) throws SQLException {
		// TODO Auto-generated method stub
		return mpUserDao.selectCart(mbNo);
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
		log.debug("��ġ�� ����Ʈ ����...");
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
		log.debug("���翹ġ�� ����...");
		return mpUserDao.selectUserInfo();
	}

	@Override
	public UserVo userInfo(String mbNo) throws SQLException {
		log.debug("�� ���� ��� ����");
		return mpUserDao.selectMyInfo(mbNo);
	}

	@Override
	public UserVo myinfo(String mbNo,UserVo userVo) throws SQLException {
		log.debug("�� ���� ���� ����...");
		return mpUserDao.updateMyInfo(mbNo, userVo.getUserNM(), userVo.getAddr(), userVo.getAddrDetail());
		
	}

	@Override
	public UserVo getName(String mbNo) throws SQLException {
		return mpUserDao.getName(mbNo);
	}

	@Override
	public List<CallVo> AuctList(String mbNo) throws SQLException {
		return mpUserDao.selectAuct(mbNo);
	}



	


}
