package com.me.rentalme.used.service;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.me.rentalme.model.entity.DeclVo;
import com.me.rentalme.model.entity.RentalMeVo;
import com.me.rentalme.model.entity.UsedCmtVo;
import com.me.rentalme.model.entity.UsedStoreVo;
import com.me.rentalme.model.entity.UsedVo;
import com.me.rentalme.model.entity.UserVo;
import com.me.rentalme.used.model.UsedDao;

@Service
public class UsedServiceImpl implements UsedService {

	Logger log = LoggerFactory.getLogger(getClass());
	
	@Inject
	UsedDao usedDao;
	
	@Override
	public UserVo userInfo(UserVo bean) throws SQLException {
		return usedDao.userInfo(bean);
	}
	
	@Override
	public List<UsedVo> list(UsedVo bean) throws SQLException {
		log.debug("�߰�ŷ� ����...");
		return usedDao.selectAll(bean);
	}

	@Override
	public List<UsedVo> oneList(UsedVo bean) throws SQLException {
		log.debug("�߰�ŷ� ��...");
		return usedDao.selectOne(bean);
	}
	
	@Override
	public int seqUp() throws SQLException {
		log.debug("�⺻Ű 1����");
		return usedDao.seqInsert();
	}

	@Override
	public int addUsed(UsedVo bean) throws SQLException {
		log.debug("�߰�ǰ �Է�...");
		return usedDao.InsertOne(bean);
	}

	@Override
	public UsedVo detail(String usedGdsNo) throws SQLException {
		log.debug("�߰�ǰ �󼼺���...");
		return usedDao.DetailOne(usedGdsNo);
	}

	@Override
	public List<UsedCmtVo> cmtList(String usedGdsNo) throws SQLException {
		return usedDao.selectCmtAll(usedGdsNo);
	}

	@Override
	public int addCmt(UsedCmtVo bean) throws SQLException {
		return usedDao.cmtInsert(bean);
	}

	@Override
	public List<UsedVo> myUsedAll(String mbNo) throws SQLException {
		return usedDao.mySelectAll(mbNo);
	}

	@Override
	public int addMyStoreCmt(UsedStoreVo bean) throws SQLException {
		return usedDao.myStoreCmtInsert(bean);
	}

	@Override
	public List<UsedStoreVo> listMyStoreCmt(String storeNo) throws SQLException {
		return usedDao.myStoreCmtSelect(storeNo);
	}

	@Override
	public int usedcount(UsedVo bean) throws SQLException {
		return usedDao.usedcount(bean);
	}

	@Override
	public int delMyStoreListOne(String usedGdsNo) throws SQLException {
		return usedDao.delMyStoreListOne(usedGdsNo);
	}

	@Override
	public List<UsedVo> mySelectAllAlign(UsedVo bean) throws SQLException {
		return usedDao.mySelectAllAlign(bean);
	}

	@Override
	public int usedComtDecl(DeclVo bean) throws SQLException {
		return usedDao.usedComtDecl(bean);					//�߰��� �Ű�
	}

	@Override
	public int usedStoreDecl(DeclVo bean) throws SQLException {
		return usedDao.usedStoreDecl(bean);					//�����ı� ��� �Ű�
	}

	@Override
	public String userId(String mbNo) throws SQLException {
		return usedDao.userId(mbNo);
	}

	@Override
	public int updateStoreSts(String usedGdsNo) throws SQLException {
		return usedDao.updateStoreSts(usedGdsNo);
	}

}