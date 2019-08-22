package com.me.rentalme.join.service;

import java.text.SimpleDateFormat;

import javax.inject.Inject;

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
		
		String levelGbCd = "1"; //�Ϲ�ȸ��
		
		bean.setlevelGbCd(levelGbCd); //�Ϲ�ȸ������ ���
		
		//�������(yyyy-mm-dd to yyyymmdd)�� ����
		String birthDay = bean.getBirthDay(); 
		birthDay = birthDay.replace("-", "");
		bean.setBirthDay(birthDay);
		
		return joinDao.insertJoin(bean);
	}

}
