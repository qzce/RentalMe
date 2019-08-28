package com.me.rentalme.cs.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.me.rentalme.cs.entity.CsVo;

public interface CsDao {

	//faq ����Ʈ
	List<CsVo> faqSelectAll() throws SQLException;
	List<CsVo> faqselectAll(Map<String, Integer> map) throws SQLException;
	
	//���� ����Ʈ
	List<CsVo> noticeSelectAll() throws SQLException;
	List<CsVo> noticeselectAll(Map<String, Integer> map) throws SQLException;
	
	
	//faq ��
	CsVo csFaqDetail(Map<String,Object> map) throws SQLException;	
	
	//���� ��
	CsVo csNoticeDetail(Map<String,Object> map) throws SQLException;
	
	int seqNocInsert() throws SQLException;
	int seqFaqInsert() throws SQLException;
	
	int insertOne(CsVo csVo) throws SQLException;
	int updateOne(CsVo bean) throws SQLException;
	int noticDel(int num) throws SQLException;
	
}
