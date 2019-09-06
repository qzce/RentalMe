package com.me.rentalme.mp.mng.service;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.me.rentalme.common.Paging;
import com.me.rentalme.model.entity.CallVo;
import com.me.rentalme.model.entity.DeclVo;
import com.me.rentalme.model.entity.MngOrdDetailVo;
import com.me.rentalme.model.entity.MngOrdVo;
import com.me.rentalme.model.entity.UsedVo;
import com.me.rentalme.model.entity.UserVo;
import com.me.rentalme.mp.mng.dao.MngDao;

@Service
public class MngServiceImpl implements MngService {

	@Inject
	MngDao mngDao;
	
	
	@Override
	public List<MngOrdVo> selectOrd() throws SQLException {
		return mngDao.selectOrd();								//��ü �ֹ� ����
	}

	@Override
	public List<MngOrdDetailVo> selectOrdOne(String ordNo) throws SQLException {
		return mngDao.selectOrdOne(ordNo);						//�ֹ� �� ����
	}

	@Override
	public UserVo selectOrdOneInfo(String ordNo) throws SQLException {
		return mngDao.selectOrdOneInfo(ordNo);					//�ֹ��� ��������
	}

	@Override
	public int updateStsPC(String ordNo) throws SQLException {
		return mngDao.updateStsPC(ordNo);						//��ǰ���� ����Ȯ������ �ٲٱ�
	}

	@Override
	public List<CallVo> selectDep() throws SQLException {
		return mngDao.selectDep();								//��ġ�� ����Ʈ
	}

	@Override
	public List<CallVo> selectDepOne(String mbNo) throws SQLException {
		return mngDao.selectDepOne(mbNo);						//ȸ�� ��ġ�� ��
	}
	
	

	@Override
	public List<UsedVo> selectUsed(Paging usedPage) throws SQLException {
		return mngDao.selectUsed(usedPage);								//��ü �߰� ����Ʈ
	}

	@Override
	public List<MngOrdVo> selectReturn() throws SQLException {
		return mngDao.selectReturn();							//��ü ��ǰ ����Ʈ
	}

	@Override
	public int updateStsRtn(String ordNo) throws SQLException {
		return mngDao.updateStsRtn(ordNo);						//��ǰ���� ��ǰȮ������ �ٲٱ�
	}

	@Override
	public List<UsedVo> selectUsedSearch(String usedGdsNo) throws SQLException {
		return mngDao.selectUsedSearch(usedGdsNo);				//�߰� �ϳ� ����
	}

	@Override
	public List<DeclVo> selectDecl() throws SQLException {
		return mngDao.selectDecl();								//��ü �Ű� ����Ʈ
	}

	@Override
	public int changeDeclSts(String declNo) throws SQLException {
		return mngDao.changeDeclSts(declNo);					//�Ű����� ó���Ϸ�� �ٲٱ�
	}
	
	@Override
	public int getUsedListCnt() {
		return mngDao.selectusedListCnt();
	}


}