package com.me.rentalme.login.dao;

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
* �������� : 2019.08.26
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

}
