package com.me.rentalme.login.dao;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.me.rentalme.model.entity.UserVo;

/**
* �α��� Dao
* 
* @author Ȳ����
* @version ver1.0
* ������� : 2019.08.26
* �������� : 2019.08.27
*/
@Repository
public class LoginDaoImpl implements LoginDao {

	Logger log = LoggerFactory.getLogger(getClass());
	
	@Inject
	SqlSession sqlSession;
	
	/**
	* ���̵� üũ
	* 
	* @param  String userId - ����� ���̵�
	* @return int
	* @author Ȳ����
	* @exception 
	*/
	@Override
	public UserVo getId(String userId) {
		log.debug("�α��� ���̵� üũ Dao");
		
		return sqlSession.selectOne("login.checkId", userId);
	}

	/**
	* ��й�ȣ �Է� ���� Ƚ�� �߰�
	* 
	* @param  int pwFailCnt - �Էº�й�ȣ����Ƚ��
	* @param  String userId - ����� ���̵�
	* @return int
	* @author Ȳ����
	* @exception 
	*/
	@Override
	public int addPwFailCnt(int pwFailCnt, String userId) {
		log.debug("��й�ȣ �Է� ���� Ƚ�� �߰� Dao");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pwFailCnt", pwFailCnt);
		map.put("userId", userId);

		return sqlSession.update("login.pwFailCntAdd", map);
	}

	/**
	* ������ ����ڷ� ����
	* 
	* @param  String userId - ����� ���̵�
	* @return None
	* @author Ȳ����
	* @exception 
	*/
	@Override
	public void setUserBann(String userId) {
		log.debug("������ ����ڷ� ���� Dao");
		
		sqlSession.update("login.updUserBann", userId);
	}

	/**
	* ��й�ȣ ����Ƚ�� �ʱ�ȭ
	* 
	* @param  String userId - ����� ���̵�
	* @return None
	* @author Ȳ����
	* @exception 
	*/
	@Override
	public void initPwFailCnt(String userId) {
		log.debug("��й�ȣ ����Ƚ�� �ʱ�ȭ Dao");
		
		sqlSession.update("login.initPwFailCnt", userId);		
	}

	/**
	* �α��� ����
	* 
	* @param  String userId - ����� ���̵�
	* @param  String sessionKey - ������Ű��
	* @param  String sessionDt - ������Ű����
	* @return None
	* @author Ȳ����
	* ������� : 2019-09-01
	*/
	@Override
	public void keepLogin(String userId, String sessionKey, Date sessionDt) {
		Map<String, Object> map = new HashMap<String, Object>();
		log.debug("�α��� ���� Dao");
		
		map.put("userId", userId);			//����ھ��̵�
		map.put("sessionKey", sessionKey);	//������Ű��
		map.put("sessionDt", sessionDt);	//������Ű����
						
		sqlSession.update("login.keepLogin", map);
	}

	/**
	* ������Ű�� üũ
	* 
	* @param  String value
	* @return None
	* @author Ȳ����
	* ������� : 2019-09-01
	*/
	@Override
	public UserVo checkLoginSessionKey(String value) {
		log.debug("������Ű�� üũ Dao");
		
		return sqlSession.selectOne("login.checkLoginSessionKey", value);
	}

}
