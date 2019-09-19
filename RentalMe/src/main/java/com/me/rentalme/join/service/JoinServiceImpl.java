package com.me.rentalme.join.service;

import javax.inject.Inject;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.me.rentalme.join.model.JoinDao;
import com.me.rentalme.model.entity.UserVo;

/**
* ȸ������ ����
* 
* @author Ȳ����
* @version ver1.0
* @see 
*/
@Service
public class JoinServiceImpl implements JoinService{
	
	Logger log = LoggerFactory.getLogger(getClass());
	
	@Inject
	JoinDao joinDao;
	
	/**
	* ȸ������ ������ �߰�
	* 
	* @param   
	* @return void
	* @author Ȳ����
	* @exception None
	*/
	@Override
	public void addMemNoSeq() {
		log.debug("ȸ����ȣ ������ ����");
		
		joinDao.insertMemnoSeq();
	}
	
	/**
	* ȸ����ȣ ��ȸ
	* 
	* @param   
	* @return void
	* @author Ȳ����
	* @exception None
	*/
	@Override
	public String getMemNo() {
		log.debug("ȸ����ȣ ��ȸ ����");
		
		String memNo = joinDao.getMemNo();
		return memNo;
	}

	/**
	* ȸ������ �Է�
	* 
	* @param  UserVo 
	* @return int result - �����
	* @author Ȳ����
	* @exception None
	*/
	@Override
	public int addInfo(UserVo bean) {
		log.debug("ȸ������ �Է� ����...");
		
		//ȸ����ȣ ���
		String memNo = getMemNo();
		bean.setMbNo(memNo);
		
		//��й�ȣ ��ȣȭ
		String hashPw = BCrypt.hashpw(bean.getUserPw(), BCrypt.gensalt());
		bean.setUserPw(hashPw);
		
		String levelGbCd = "1"; //�Ϲ�ȸ��
		bean.setLevelGbCd(levelGbCd); //�Ϲ�ȸ������ ���
		
		//�ڵ��� ���ſ���
		if(bean.getHpYn() == null) {
			bean.setHpYn("N");
		}
		
		//�̸��� Ű �����ڵ� -> Y
		String emailKey = "Y";
		bean.setEmailKey(emailKey);
		
		//�������(yyyy-mm-dd to yyyymmdd)�� ����
		String birthDay = bean.getBirthDay(); 
		birthDay = birthDay.replace("-", "");
		bean.setBirthDay(birthDay);
		
		return joinDao.insertJoin(bean);
	}
	
	/**
	* ���̵� �ߺ�üũ
	*
	* @param  String userId 
	* @return String msg (dupl - �ߺ�, notDupl - �ߺ�x)
	* @author Ȳ����
	* @exception None
	*/
	@Override
	public String getId(String userId) {
		log.debug("���̵� �ߺ�üũ ����...");
		
		String msg = "";
		
		int result = joinDao.selectId(userId);
		if(result > 0) {
			msg = "dupl";		// ���̵� �ߺ�
		}else {
			msg = "notDupl";	// ���̵� �ߺ� x
		}
		return msg;
	}

	/**
	* ȸ����ġ�� �ʱ�ȭ
	* 
	* @param  String mbNo - ����� ȸ����ȣ
	* @return int
	* @author ����ȯ
	* @exception 
	*/
	@Override
	public int insertMb(String mbNo) {
		return joinDao.insertMb(mbNo);
	}




}