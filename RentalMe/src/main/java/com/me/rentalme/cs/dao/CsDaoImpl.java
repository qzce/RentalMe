package com.me.rentalme.cs.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.me.rentalme.common.Paging;
import com.me.rentalme.cs.entity.CsVo;
import com.me.rentalme.cs.paging.Search;
import com.me.rentalme.model.entity.UserVo;


@Repository
public class CsDaoImpl implements CsDao {

	@Inject
	SqlSession sqlSession; 
	
	@Override
	public List<CsVo> faqSelectAll() throws SQLException {
		
		
		return sqlSession.selectList("csCenter.faqSelectAll");
	}
	
	@Override
	public List<CsVo> faqSelectAll(Search search, Paging paging) throws SQLException {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		String keyword = "";
		String searchType = "";
		
		if(search.getKeyword() != null) {
			keyword = search.getKeyword();
		}
		
		if(search.getSearchType() != null) {
			searchType = search.getSearchType();
		}
		
		int startListNum = 0;
		int listSize = 0;
		
		if(paging.getstartListNum() != 0) {
			startListNum = paging.getstartListNum();
		}
		
		if(paging.getListSize() != 0) {
			listSize = paging.getListSize();
		}
		
		System.out.println("������ ���� ��ȣ : "+listSize + ", ������ ������ : "+ listSize);

		map.put("keyword", keyword);
		map.put("searchType", searchType);
		map.put("startListNum", startListNum);
		map.put("listSize", listSize);
		
		
		return sqlSession.selectList("csCenter.faqSelectAll", map);
	}

	
	//����, faq �Խñ� ���
	@Override
	public int insertOne(CsVo csVo) throws SQLException {
	
		System.out.println("mapping..");
		System.out.println("getcsGbCd:"+csVo.getCsGbCd());
		if(csVo.getCsGbCd().equals("10")){
			System.out.println(csVo.getCsGbCd());
			return sqlSession.insert("csCenter.csInsertNocOne",csVo);
		}else if(csVo.getCsGbCd().equals("20")){
			System.out.println(csVo.getCsGbCd());
			System.out.println(csVo.getCsClassGbCd());
			return sqlSession.insert("csCenter.csInsertFaqOne",csVo);
		}else if(csVo.getCsGbCd().equals("30")){
			System.out.println(csVo.getCsGbCd());
			System.out.println(csVo.getCsClassGbCd());
			return sqlSession.insert("csCenter.csInsertInqOne", csVo);
		}else {
			
			System.out.println(csVo.getCsGbCd()+2);
		}
		return 0;
	}
	
	//1��1���� �Խñ� ���
	

	@Override
	public CsVo csFaqDetail(CsVo csVo) throws SQLException {
		System.out.println("dao.csFaqDetail..."+csVo.getFaqNo());
		System.out.println("dao.csFaqDetail..."+csVo.getCsGbCd());
		System.out.println("dao.csFaqDetail..."+csVo.getCsClassGbCd());
		return sqlSession.selectOne("csCenter.csFaqDetail", csVo);
	}

	@Override
	public int updateOne(CsVo csVo) throws SQLException {
		System.out.println("�ҷ��´�"+csVo.getCsGbCd());
		System.out.println("??");
		if(csVo.getCsGbCd().equals("10")){
			System.out.println("notice��������");
			return sqlSession.update("csCenter.csNoticeUpdate", csVo);
		}
		else if(csVo.getCsGbCd().equals("20")){
			System.out.println("faq��������");
			return sqlSession.update("csCenter.csFaqUpdate", csVo);
		}
		return 0;
	}


	@Override
	public List<CsVo> faqselectAll(Map<String, Integer> map) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<CsVo> noticeSelectAll() throws SQLException {
		return sqlSession.selectList("csCenter.noticeSelectAll");
	}
	
	@Override
	public List<CsVo> noticeSelectAll(Paging csPaging) throws SQLException {
		return sqlSession.selectList("csCenter.noticeSelectAll", csPaging);
	}


	@Override
	public List<CsVo> inqSelectAll() throws SQLException {
		return sqlSession.selectList("csCenter.inqSelectAll");
	}

	@Override
	public List<CsVo> noticeselectAll(Map<String, Integer> map) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public CsVo csNoticeDetail(CsVo csVo) throws SQLException {
		return sqlSession.selectOne("csCenter.csNoticeDetail", csVo);
	}



	//notice������
	@Override
	public int seqNocInsert() throws SQLException {
		return sqlSession.insert("csCenter.seqNocInsert");
	}
	
	// faq������
	@Override
	public int seqFaqInsert() throws SQLException {
		return sqlSession.insert("csCenter.seqFaqInsert");
	}
	
	//Inq������
	@Override
	public int seqInqInsert() throws SQLException {
		System.out.println("inq������ ����");
		return sqlSession.insert("csCenter.seqInqInsert");
	}



	@Override
	public int noticDel(String num) throws SQLException {
		
		return sqlSession.delete("csCenter.csNoticeDelete", num);
	}



	@Override
	public int faqDel(String num) throws SQLException {
		
		return sqlSession.delete("csCenter.csFaqDelete", num);
	}


	@Override
	public int inqAnswer(String num) throws SQLException {
		
		String pquestNo=num;
		return sqlSession.update("csCenter.inqAnswer", pquestNo);
	}


	//�Խñ� ����
	@Override
	public int faqListCnt(Search search) throws SQLException {
		System.out.println("faq����¡ dao");
		int cnt=0;
		cnt=sqlSession.selectOne("csCenter.csFaqListCnt",search);
		System.out.println("faq����:"+cnt);
		return cnt;
	}
	
	@Override
	public int noticListCnt() throws SQLException {
		System.out.println("notic����¡ dao");
		int cnt=0;
		cnt=sqlSession.selectOne("csCenter.csNoticListCnt");
		System.out.println("notic����:"+cnt);
		return cnt;
	}


	@Override
	public int inquiryListCnt() throws SQLException {
		
		System.out.println("inq����¡ dao");
		int cnt=0;
		cnt=sqlSession.selectOne("csCenter.csInquiryListCnt");
		System.out.println("inq����:"+cnt);
		return cnt;
	}


	@Override
	public int faqListCnt22(String csClassGbCd) {
		int cnt=0;
		cnt=sqlSession.selectOne("csCenter.csFaqTapListCnt",csClassGbCd);
		System.out.println("��..."+cnt);
		return cnt;
	}


	@Override
	public List<CsVo> csFaqHeadList(Paging paging,String tapName) throws SQLException {
		int startListNum=paging.getstartListNum();
		int listSize=paging.getListSize();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("startListNum", startListNum);
		map.put("listSize", listSize);
		map.put("tapName", tapName);
		
		return sqlSession.selectList("csCenter.csFaqHeadList", map);
	}


	@Override
	public UserVo userLevel(String userLevel) {
		return sqlSession.selectOne("csCenter.userLevel",userLevel);
	}


	@Override
	public int insertReply(CsVo csVo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("csCenter.insertReply", csVo);
	}


	@Override
	public CsVo selectReply(String pquestNo) {
		System.out.println("dao ���"+pquestNo);
		return sqlSession.selectOne("csCenter.selectReply", pquestNo);
	}
	
	








}