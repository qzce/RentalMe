package com.me.rentalme.join.model;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.me.rentalme.model.entity.UserVo;

/**
* @brief ȸ������ Dao 
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
		
		int result = sqlSession.insert("join.insertOne", bean);
		
		return result;
	}

}
