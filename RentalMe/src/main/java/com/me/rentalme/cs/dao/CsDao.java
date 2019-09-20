package com.me.rentalme.cs.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.me.rentalme.common.Paging;
import com.me.rentalme.cs.entity.CsVo;
import com.me.rentalme.cs.paging.Search;

public interface CsDao {

	//faq ����Ʈ
	List<CsVo> faqSelectAll(Search search) throws SQLException;
	List<CsVo> faqselectAll(Map<String, Integer> map) throws SQLException;
	
	//���� ����Ʈ
	List<CsVo> noticeSelectAll(Paging paging) throws SQLException;
	List<CsVo> noticeselectAll(Map<String, Integer> map) throws SQLException;
	
	//���� ����Ʈ
	List<CsVo> inqSelectAll(Paging paging) throws SQLException;
	
	//�Խñ� �� ����
	int faqListCnt(Search search) throws SQLException;
	int noticListCnt() throws SQLException;
	int inquiryListCnt() throws SQLException;
	int faqListCnt22(String csClassGbCd);
	
	//faq ��
	CsVo csFaqDetail(CsVo csVo) throws SQLException;	
	
	//���� ��
	CsVo csNoticeDetail(CsVo csVo) throws SQLException;
	
	//�Խ��� ������
	int seqNocInsert() throws SQLException;
	int seqFaqInsert() throws SQLException;
	int seqInqInsert() throws SQLException;
	
	int insertOne(CsVo csVo) throws SQLException;
	
	
	int updateOne(CsVo csVo) throws SQLException;
	int noticDel(String num) throws SQLException;
	int faqDel(String num) throws SQLException;
	int inqAnswer(String num) throws SQLException;
	
	List<CsVo> csFaqHeadList(Paging paging,String tapName) throws SQLException;
}
