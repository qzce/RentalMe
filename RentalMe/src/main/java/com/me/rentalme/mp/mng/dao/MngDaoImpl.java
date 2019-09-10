package com.me.rentalme.mp.mng.dao;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.me.rentalme.common.Paging;
import com.me.rentalme.model.entity.CallVo;
import com.me.rentalme.model.entity.DeclVo;
import com.me.rentalme.model.entity.MngOrdDetailVo;
import com.me.rentalme.model.entity.MngOrdVo;
import com.me.rentalme.model.entity.UsedVo;
import com.me.rentalme.model.entity.UserVo;

@Repository
public class MngDaoImpl implements MngDao{

	@Inject
	SqlSession sqlSession;
	
	@Override
	public List<MngOrdVo> selectOrd() throws SQLException {
		
		return sqlSession.selectList("mpMng.selectOrd");				//��ü �ֹ�����Ʈ
	}

	@Override
	public List<MngOrdDetailVo> selectOrdOne(String ordNo) throws SQLException {
		return sqlSession.selectList("mpMng.selectOrdOne", ordNo);		//�ֹ� �󼼺���
	}

	@Override
	public UserVo selectOrdOneInfo(String ordNo) throws SQLException {
		return sqlSession.selectOne("mpMng.selectOrdOneInfo", ordNo);	//�ֹ��� ��������
	}

	@Override
	public int updateStsPC(String ordNo) throws SQLException {
		return sqlSession.update("mpMng.updateStsPC", ordNo);			//��ǰ���� ����Ȯ������ �ٲٱ�
	}

	@Override
	public List<CallVo> selectDep() throws SQLException {
		return sqlSession.selectList("mpMng.selectDep");		
	}

	@Override
	public List<CallVo> selectDepOne(String mbNo) throws SQLException {
		return sqlSession.selectList("mpMng.selectDepOne", mbNo);		//ȸ�� ��ġ�� ��
	}

	@Override
	public List<UsedVo> selectUsed(Paging usedPage) throws SQLException {
		return sqlSession.selectList("mpMng.selectUsed", usedPage);				//��ü �߰� ����Ʈ
	}

	@Override
	public List<MngOrdVo> selectReturn() throws SQLException {
		return sqlSession.selectList("mpMng.selectReturn");				//��ü ��ǰ ����Ʈ
	}

	@Override
	public int updateStsRtn(String ordNo) throws SQLException {
		return sqlSession.update("mpMng.updateStsRtn", ordNo);			//��ǰ���� ��ǰȮ������ �ٲٱ�
	}

	@Override
	public List<UsedVo> selectUsedSearch(String usedGdsNo) throws SQLException {
		return sqlSession.selectList("mpMng.selectUsedSearch", usedGdsNo);//�߰� �ϳ� ����
	}

	@Override
	public List<DeclVo> selectDecl(Paging usedPage) throws SQLException {
		return sqlSession.selectList("mpMng.selectDecl", usedPage);				//��ü �Ű� ����Ʈ
	}

	@Override
	public int changeDeclSts(String declNo) throws SQLException {
		return sqlSession.update("mpMng.changeDeclSts", declNo);		//�Ű���� ó���Ϸ�� �ٲٱ�
	}
	
	@Override
	public int selectusedListCnt() {
		return sqlSession.selectOne("mpMng.selectusedListCnt");			//�߰���Ʈ �Ѱ���
	}
	
}
