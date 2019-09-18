package com.me.rentalme.mp.user.service;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.me.rentalme.common.Paging;
import com.me.rentalme.cs.entity.CsVo;
import com.me.rentalme.login.service.LoginService;
import com.me.rentalme.model.entity.CallVo;
import com.me.rentalme.model.entity.UserVo;
import com.me.rentalme.model.entity.UserVo;
import com.me.rentalme.mp.user.model.MpUserDao;

@Service
public class MpUserServiceImpl implements MpUserService{
	
	Logger log = LoggerFactory.getLogger(getClass());

	@Inject
	MpUserDao mpUserDao;
	
	@Inject
	LoginService loginService;
	
	//�ֹ����� ����Ʈ
	@Override
	public List<CallVo> ordList(String mbNo) throws SQLException {
		//log.debug("�ֹ����� ����");
		
		return mpUserDao.selectOrd(mbNo);
	}
	
	//�ı� ���
		@Override
		public int addReview(CallVo callVo, String mbNo) throws SQLException {
			log.debug("�ı� ��� ����...");
			
			
			return mpUserDao.InsertReview(callVo.getGdsCd(), callVo.getUserId(), callVo.getContent(), callVo.getGrade(),callVo.getOdrNo(),mbNo);
		}
	
	
	//��ٱ��� ����Ʈ
	@Override
	public List<CallVo> cartList(String mbNo) throws SQLException {
		return mpUserDao.selectCart(mbNo);
	}
	
	//��ٱ��� ���û���
	@Override
	public void deleteCart(String gdsCd, String mbNo, String cartSeq) throws SQLException {
		mpUserDao.deleteCart(gdsCd,mbNo,cartSeq);
	}

	
	//���ѻ�ǰ ����Ʈ
	@Override
	public List<CallVo> wishList(String mbNo) throws SQLException {
		//log.debug("����������(���ѻ�ǰ) ����");
		
		return mpUserDao.selectWish(mbNo);
	}
	
	//���ѻ�ǰ ����
	@Override
	public void deleteWish(String usedGdsNo,String mbNo) throws SQLException {
		
		mpUserDao.deleteWish(usedGdsNo,mbNo);
	}

	//��ġ�� ����Ʈ
	@Override
	public List<CallVo> depositList(String mbNo) throws SQLException {
		log.debug("��ġ�� ����Ʈ ����...");
		return mpUserDao.selectDeposit(mbNo);
	}
	
	//��ġ�� ����
	@Override
	public int insertCharge(CallVo callVo,String mbNo) throws SQLException {

		return mpUserDao.insertCharge(callVo.getUserId(), callVo.getDepositGbCd(), callVo.getChargeDeposit(),mbNo);
	}
	
	//��ġ�� ȯ�� ��û
	@Override
	public int refundCharge(String refund, String mbNo) throws SQLException {
		return mpUserDao.refundCharge(refund,mbNo);
		
	}
	
	//���� 1:1���Ǻ���
	@Override
	public List<CsVo> myList(CsVo csVo,HttpSession session,int startListNum, int listSize) throws SQLException {
		System.out.println("dao��...");
		return  mpUserDao.myQuestList(csVo,session,startListNum,listSize);
	}
 
	//���� 1:1���� ��
	@Override
	public CsVo myInqDetail(CsVo csVo) throws SQLException {
		System.out.println("1��1 �� service");
		return mpUserDao.myQuestDetail(csVo);
	}

	//�� ���� ����
	@Override
	public int myQuestDel(CsVo csVo) throws SQLException {
		
			return mpUserDao.myQuestDel(csVo);	
	}


	//���� ��ġ�� update
	@Override
	public void updateDeposit(String chargeDeposit, String mbNo) throws SQLException {
		
		mpUserDao.updateDeposit(chargeDeposit, mbNo);
		
	}

	@Override
	public CallVo userInfoList(String mbNo) throws SQLException {
		log.debug("���翹ġ�� ����...");
		return mpUserDao.selectUserInfo(mbNo);
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

	@Override
	public UserVo getInfo(String userId) throws SQLException {
		log.debug("�α��ε� ���̵��� ��й�ȣã��...");
		return mpUserDao.selectPw(userId);
	}

	//
	@Override
	public String checkPw(String userId, String userPw) throws SQLException {
		log.debug("��й�ȣ DB�� Ȯ��");
		
		//DB����� ����
		UserVo userVo = loginService.getId(userId); 
		String targetPw = userVo.getUserPw();
		String msg = "";
		
		//�Է��� ��й�ȣ�� Ÿ�ٺ�й�ȣ�� ������ üũ
		if(BCrypt.checkpw(userPw, targetPw)) {
			msg = "equals";
		}else {
			msg = "not equals";
		}
		
		return msg;
	}
	
	@Override
	public int changePw(String userId, String userPw) {
		
		//��й�ȣ ��ȣȭ
		String hashPw = BCrypt.hashpw(userPw, BCrypt.gensalt());
		
		int result = mpUserDao.updPw(userId, hashPw);
		
		System.out.println("service�� �Ѿ�� �� : "+result);
		
		return result;
	}

	//�� ���� ����Ʈ ����
	@Override
	public int inquiryListCnt(HttpSession session) throws SQLException {
		
		return mpUserDao.myInquiryListCnt(session);
	}

}
