package com.me.rentalme.mp.user.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.me.rentalme.cs.entity.CsVo;
import com.me.rentalme.model.entity.CallVo;
import com.me.rentalme.model.entity.UserVo;

@Repository
public class MpUserDaoImpl implements MpUserDao{

	Logger log = LoggerFactory.getLogger(getClass());
	
	@Inject
	SqlSession sqlSession;
	
	//�ֹ����� ����Ʈ
	@Override
	public List<CallVo> selectOrd(String mbNo) throws SQLException {
		return sqlSession.selectList("mpUser.selectOrd",mbNo);
	}
	
	//��ٱ��� ����Ʈ
	@Override
	public List<CallVo> selectCart(String mbNo) throws SQLException {
		return sqlSession.selectList("mpUser.selectCart",mbNo);
	}
	
	//��ٱ��� ���û���
	@Override
	public void deleteCart(String gdsCd, String mbNo, String cartSeq) throws SQLException {
		Map<String, String> map=new HashMap<String, String>();
		map.put("gdsCd", gdsCd);
		map.put("mbNo", mbNo);
		map.put("cartSeq", cartSeq);
		
		//System.out.println("gdsCd:"+gdsCd+" mbNo:"+mbNo+" cartSeq:"+cartSeq);
		
		sqlSession.delete("mpUser.deleteCart",map);
	}
	
	//���ѻ�ǰ ����Ʈ
	@Override
	public List<CallVo> selectWish(String mbNo) throws SQLException {
		//log.debug("����������(���ѻ�ǰ) Dao");
		
		return sqlSession.selectList("mpUser.selectWish",mbNo);
	}

	//���ѻ�ǰ ���û���
	@Override
	public void deleteWish(String usedGdsNo, String mbNo) throws SQLException {
		Map<String, String> map=new HashMap<String, String>();
		map.put("usedGdsNo", usedGdsNo);
		map.put("mbNo", mbNo);
		
		sqlSession.update("mpUser.deleteWish",map);
	}

	//�ı���
	@Override
	public int InsertReview(String gdsCd, String userId, String content,String grade, String mbNo) throws SQLException {
		Map<String, String> map=new HashMap<String, String>();
		map.put("gdsCd", gdsCd);
		map.put("userId", userId);
		map.put("content", content);
		map.put("grade", grade);
		map.put("mbNo", mbNo);
		
		log.debug("gdscd="+gdsCd+", userId="+userId+", content="+content+", grade="+grade+ " �ı� �Է� DaoImpl...");
		
		return sqlSession.insert("mpUser.insertReview",map);
	}

	//��ġ�� ��ȸ
	@Override
	public List<CallVo> selectDeposit(String mbNo) throws SQLException {
		
		return sqlSession.selectList("mpUser.selectDeposit",mbNo);
	}
	
	//��ġ�� ����
	@Override
	public int insertCharge(String userId, String depositGbCd, String chargeDeposit, String mbNo) throws SQLException {
		Map<String, String> map=new HashMap<String, String>();
		map.put("userId", userId);
		map.put("depositGbCd", depositGbCd);
		map.put("chargeDeposit", chargeDeposit);
		map.put("mbNo", mbNo);
		
		log.debug("userId="+userId+", depositGbCd="+depositGbCd+", chargeDeposit="+chargeDeposit+" ��ġ�� ���� �Է� DaoImpl...");
		
		return sqlSession.insert("mpUser.inserDeposit",map);
	}

	@Override

	public void updateDeposit(String chargeDeposit, String mbNo) throws SQLException {
		Map<String, String> map=new HashMap<String, String>();
		map.put("chargeDeposit", chargeDeposit);
		map.put("mbNo", mbNo);
		
		sqlSession.selectList("mpUser.updateDeposit",map);
		
	}

	public List<CsVo> myQuestList(CsVo csVo,HttpSession session) throws SQLException {
		Map<String, String> map=new HashMap<String, String>();
		String mbNo=(String)session.getAttribute("loginMbNo");
		System.out.println(mbNo+"dd");
		map.put("mbNo",mbNo);
		csVo.setMbNo(mbNo);
		System.out.println(csVo.getMbNo());
		System.out.println("sql��..");
		return sqlSession.selectList("csCenter.myQuestList",map);
	}

	@Override
	public CsVo myQuestDetail(CsVo csVo) throws SQLException {
		System.out.println("questDetail��..");
		
		return sqlSession.selectOne("csCenter.myQuestDetail", csVo);
	}

	@Override
	public int myQuestDel(CsVo csVo) throws SQLException {
		System.out.println("inq delete dao..");
		System.out.println("ȸ����ȣ:"+csVo.getMbNo());
		System.out.println("�Խù���ȣ:"+csVo.getPquestNo());
		
		return sqlSession.delete("csCenter.myQuestDel", csVo);
	}


	@Override
	public CallVo selectUserInfo(String mbNo) throws SQLException {
		return sqlSession.selectOne("mpUser.selectInfoUser",mbNo);
	}

	@Override
	public UserVo selectMyInfo(String mbNo)  {
		log.debug("mbno:"+mbNo);
		return sqlSession.selectOne("mpUser.selectMyInfo",mbNo);
	}

	@Override
	public UserVo updateMyInfo(String mbNo,String userNm, String addr, String addrDetail) {
		log.debug("mbno:"+mbNo);
		
		Map<String, String> map=new HashMap<String, String>();
		map.put("mbNo",mbNo);
		map.put("userNm",userNm);
		map.put("addr",addr);
		map.put("addrDetail",addrDetail);
		
		System.out.println("userNm="+userNm+", addr="+addr+", addrDetail="+addrDetail+" �� ���� ������Ʈ DaoImpl...");
		return sqlSession.selectOne("mpUser.updateMyinfo",map);
	}

	@Override
	public UserVo getName(String mbNo) {
		
		return sqlSession.selectOne("mpUser.checkName",mbNo);
	}

	@Override
	public List<CallVo> selectAuct(String mbNo) throws SQLException {
		return sqlSession.selectList("mpUser.selectAuct",mbNo);
	}


}
