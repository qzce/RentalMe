package com.me.rentalme.used.model;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.me.rentalme.model.entity.DeclVo;
import com.me.rentalme.model.entity.UsedCmtVo;
import com.me.rentalme.model.entity.UsedStoreVo;
import com.me.rentalme.model.entity.UsedVo;
import com.me.rentalme.model.entity.UserVo;

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
    //����� ����	
	@Override
	public UserVo userInfo(UserVo bean) throws SQLException {
		return sqlSession.selectOne("used.userInfo",bean);
	}
	/**
	* �߰�ŷ� ����Ʈ ���
	* 
	* @param   
	* @return 
	* @author ����ȯ
	* @exception return("namespace.id��", �Ķ����)
	*/
	@Override
	public List<UsedVo> selectAll(UsedVo bean) throws SQLException {
		log.debug("�߰�ŷ� ����Ʈ ���...");
		
		return sqlSession.selectList("used.selectAll",bean);
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
	/**
	 * �߰�ŷ� ��� �ҷ�����
	 * 
	 * @param   
	 * @return 
	 * @author ����ȯ
	 * @exception return("namespace.id��", �Ķ����)
	 */
	@Override
	public List<UsedCmtVo> selectCmtAll(String usedGdsNo) throws SQLException {
		return sqlSession.selectList("used.seletCmt", usedGdsNo);
	}
	/**
	 * �߰�ŷ� ��� �ޱ�
	 * 
	 * @param   
	 * @return 
	 * @author ����ȯ
	 * @exception return("namespace.id��", �Ķ����)
	 */
	@Override
	public int cmtInsert(UsedCmtVo bean) throws SQLException {
		return sqlSession.insert("used.insertCmt", bean);
	}
	/**
	 * �� ������ǰ �ҷ�����
	 * 
	 * @param   
	 * @return 
	 * @author ����ȯ
	 * @exception return("namespace.id��", �Ķ����)
	 */
	@Override
	public List<UsedVo> mySelectAll(String mbNo) throws SQLException {
		return sqlSession.selectList("used.mySelectAll", mbNo);
	}

	@Override
	public int myStoreCmtInsert(UsedStoreVo bean) throws SQLException {
		return sqlSession.insert("used.storeCmt", bean);
	}

	@Override
	public List<UsedStoreVo> myStoreCmtSelect(String storeNo) throws SQLException {
		return sqlSession.selectList("used.myStoreCmtSelectAll", storeNo);
	}

	@Override
	public int usedcount(UsedVo bean) throws SQLException {
		return sqlSession.selectOne("used.usedcount", bean);
	}

	@Override
	public int delMyStoreListOne(String usedGdsNo) throws SQLException {
		return sqlSession.update("used.myselectDel", usedGdsNo);
	}

	@Override
	public List<UsedVo> mySelectAllAlign(UsedVo bean) throws SQLException {
		return sqlSession.selectList("used.mySelectAllAlign", bean);
	}
	@Override
	public int usedComtDecl(DeclVo bean) throws SQLException {
		return sqlSession.insert("used.usedComtDecl", bean);
	}
	@Override
	public int usedStoreDecl(DeclVo bean) throws SQLException {
		return sqlSession.insert("used.usedStoreDecl", bean);
	}



	
}
