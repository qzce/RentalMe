package com.me.rentalme.login.dao;

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

}
