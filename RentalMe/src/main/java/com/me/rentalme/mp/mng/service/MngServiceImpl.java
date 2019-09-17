package com.me.rentalme.mp.mng.service;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
import com.thoughtworks.qdox.parser.ParseException;

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
	public List<DeclVo> selectDecl(Paging usedPage) throws SQLException {
		return mngDao.selectDecl(usedPage);								//��ü �Ű� ����Ʈ
	}

	@Override
	public int changeDeclSts(String declNo) throws SQLException {
		return mngDao.changeDeclSts(declNo);					//�Ű���� ó���Ϸ�� �ٲٱ�
	}
	
	@Override
	public int getUsedListCnt() {
		return mngDao.selectusedListCnt();
	}
	
	/**
	* ����� ����Ʈ service
	* 
	* @param  None
	* @return List - ��������� 
	* @author Ȳ����
	* ������� : 2019.09.11
	*/	
	@Override
	public List<UserVo> getUserInfo() {
		List<UserVo> userInfo = mngDao.selectUserList();
		
		for(UserVo userVo : userInfo) {
			//����(1:�� 2:��)
			if(userVo.getGenderGbCd().equals("1")) {
				userVo.setGenderGbCd("��");
			}else if(userVo.getGenderGbCd().equals("2")) {
				userVo.setGenderGbCd("��");
			}else {
				userVo.setGenderGbCd("x");
			}
			
			//����ڻ����ڵ�(1:����, 2:����[��й�ȣ����Ƚ�� 5ȸ �ʰ�], 3:����(Ż��))
			if(userVo.getUserStsCd().equals("1")) {
				userVo.setUserStsCd("����");
			}else if(userVo.getUserStsCd().equals("2")){
				userVo.setUserStsCd("����");
			}else if(userVo.getUserStsCd().equals("3")){
				userVo.setUserStsCd("����");
			}else {
				userVo.setUserStsCd("x");
			}
			
		}

		return userInfo;
	}
	
	/**
	* ����� Ż���ϱ� service
	* 
	* @param  String mbNo - ȸ����ȣ
	* @return void 
	* @author Ȳ����
	* ������� : 2019.09.15
	*/	
	@Override
	public String delUserInfo(String mbNo) {
		
		int result = mngDao.updUserinfo(mbNo);
		String msg = "";
		
		if(result > 0) {
			msg = "success";
		}else {
			msg = "fail";
		}
		
		return msg;
	}

	/**
	* ����� ������ service
	* 
	* @param  String mbNo - ȸ����ȣ
	* @return UserVo - ��������� 
	* @author Ȳ����
	* ������� : 2019.09.15
	*/
	@Override
	public UserVo getUserDetail(String mbNo) {
		
		return mngDao.selectUserDetail(mbNo);
	}

	/**
	* ����� ���ο� ��ȸ service
	* 
	* @param  
	* @return int - ���ο� �� 
	* @author Ȳ����
	* ������� : 2019.09.16
	*/
	@Override
	public int getMngUserListCnt() {
		return mngDao.selectMngUserListCnt();
	}


}
