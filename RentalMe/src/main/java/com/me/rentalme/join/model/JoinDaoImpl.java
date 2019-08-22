package com.me.rentalme.join.model;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.me.rentalme.model.entity.UserVo;

/**
* ȸ������ Dao
* 
* @author Ȳ����
* @version ver1.0
* @see 
*/
@Repository
public class JoinDaoImpl implements JoinDao {
	
	Logger log = LoggerFactory.getLogger(getClass());
	
	@Inject
	SqlSession sqlSession;
	
	/**
	* ȸ����ȣ ������ �߰�
	* 
	* @param   
	* @return void
	* @author Ȳ����
	* @exception None
	*/
	@Override
	public void insertMemnoSeq() {
		log.debug("ȸ����ȣ ������ �߰� dao");
		
		sqlSession.insert("join.insertMemNoSeq");
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
		log.debug("ȸ����ȣ ��ȸ dao");
		
		return sqlSession.selectOne("join.getMemNo"); //mbNo
	}
	/**
	* ȸ������ �Է�
	* 
	* @param  UserVo 
	* @return int result - �����(���� : 1)
	* @author Ȳ����
	* @exception return("namespace.id��", �Ķ����)
	*/
	@Override
	public int insertJoin(UserVo bean) {
		
		log.debug("ȸ������ �Է� Dao...");
		
		
		return sqlSession.insert("join.insertOne", bean);
	}

	/**
	* �̸��� ���� ���� ����
	* 
	* @param  
	* @return 
	* @author Ȳ����
	* @exception return("namespace.id��", �Ķ����)
	*/
	@Override
	public int getKey(String userId, String key) {
		
		log.debug("�̸��� ���� ���� ���� Dao...");
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		map.put("emailKey", key);
		
		return sqlSession.update("join.updateKeyOne", map);
	}

	/**
	* �̸��� �����ϱ� �Ϸ� (�̸�������Ȯ�� �÷� Y�� ������Ʈ)
	* 
	* @param  
	* @return 
	* @author Ȳ����
	* @exception return("namespace.id��", �Ķ����)
	*/
	@Override
	public int updEmailKey(String userId, String key) {
		
		log.debug("�̸��� �����ϱ� ����(Y) ������Ʈ Dao...");
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		map.put("emailKey", key);
		
		return sqlSession.update("join.updateKeyYn", map);
	}

	/**
	* ���̵��ߺ�üũ
	* 
	* @param  String userId - ����� ���̵�
	* @return int
	* @author Ȳ����
	* @exception 
	*/
	@Override
	public int selectId(String userId) {
		log.debug("���̵��ߺ�üũ Dao...");
		
		int result = sqlSession.selectOne("join.checkId", userId);
		
		return result;
	}


}
