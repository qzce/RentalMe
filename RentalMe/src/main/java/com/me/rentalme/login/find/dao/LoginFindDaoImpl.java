package com.me.rentalme.login.find.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.me.rentalme.model.entity.UserVo;

/**
* ���̵�/��й�ȣ ã�� Dao
* 
* @author Ȳ����
* @version ver1.0
* @see 
* ������� : 2019.08.28
*/
@Repository
public class LoginFindDaoImpl implements LoginFindDao {
	
	Logger log = LoggerFactory.getLogger(getClass());

	@Inject
	SqlSession sqlSession;
	/**
	* �Է��� �̸����� ��ϵ� �̸������� üũ (1���̻� : ��ϵ� ���̵�, 0�� : ��ϵ� ���̵� x)
	* 
	* @param  String email : �̸����ּ�
	* @return String 
	* @author Ȳ����
	* @exception
	*/
	@Override
	public int checkEmail(String email) {
		log.debug("�̸��Ϸ� ���̵� ��/�� üũ Dao");
		
		return sqlSession.selectOne("loginFind.checkId", email);
	}
	
	/**
	* ��ϵ� �̸��Ϸ� ���̵� ã�� - ���̵�, ��������
	* 
	* @param  String email : �̸����ּ�
	* @return String 
	* @author Ȳ����
	* @exception
	*/	
	@Override
	public List<UserVo> getId(String email) {
		log.debug("�̸��Ϸ� ���̵� ã�� Dao");
		
		return sqlSession.selectList("loginFind.getId", email);
	}

}
