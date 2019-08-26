package com.me.rentalme.used.model;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.me.rentalme.model.entity.UsedVo;

/**
* �߰�ŷ� Dao
* 
* @author ����ȯ
* @version ver1.0
* @see 
*/
@Repository
public class UsedDaoImpl implements UsedDao {

	Logger log = LoggerFactory.getLogger(getClass());
	
	@Inject
	SqlSession sqlSession;
	
	/**
	* �߰�ŷ� ����Ʈ ���
	* 
	* @param   
	* @return 
	* @author ����ȯ
	* @exception return("namespace.id��", �Ķ����)
	*/
	@Override
	public List<UsedVo> selectAll() throws SQLException {
		log.debug("�߰�ŷ� ����Ʈ ���...");
		
		return sqlSession.selectList("used.selectAll");
	}
	
	/**
	* �߰�ŷ� �ǿ� ���� ���(��������, ��������...)
	* 
	* @param   
	* @return 
	* @author ����ȯ
	* @exception return("namespace.id��")
	*/
	@Override
	public List<UsedVo> selectOne(UsedVo bean) throws SQLException {
		log.debug("�߰�ŷ� �ǿ� ���� ���(��������, ��������...)");
		return sqlSession.selectList("used.selectOne",bean);
	}
	
	/**
	* ������ 1����
	* 
	* @param   
	* @return 
	* @author ����ȯ
	* @exception return("namespace.id��")
	*/
	@Override
	public int seqInsert() throws SQLException {
		log.debug("������ 1����...");
		
		return sqlSession.insert("used.seqInsert");
	}

	/**
	 * �߰�ŷ� �Է�
	 * 
	 * @param   
	 * @return 
	 * @author ����ȯ
	 * @exception return("namespace.id��", �Ķ����)
	 */
	@Override
	public int InsertOne(UsedVo bean) throws SQLException {
		log.debug("�߰�ŷ� �Է�...");
		
		return sqlSession.insert("used.insertOne", bean);
	}
	/**
	 * �߰�ŷ� ��
	 * 
	 * @param   
	 * @return 
	 * @author ����ȯ
	 * @exception return("namespace.id��", �Ķ����)
	 */

	@Override
	public UsedVo DetailOne(String usedGdsNo) throws SQLException {
		return (UsedVo) sqlSession.selectOne("used.detailOne", usedGdsNo);
	}



	
}
