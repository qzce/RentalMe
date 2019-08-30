package com.me.rentalme.cs.service;


import java.sql.SQLException;
import java.util.List;

import com.me.rentalme.cs.dao.CsDao;
import com.me.rentalme.cs.entity.CsVo;

public interface CsService {
	
	List<CsVo> csFaqList() throws SQLException;    //faq����Ʈ������
	List<CsVo> csNoticeList() throws SQLException;	//���� ����Ʈ������

	CsVo csFaqDetail(CsVo csVo) throws SQLException;  //faq ��������
	CsVo csNoticeDetail(CsVo csVo) throws SQLException;					//���� ��������

	int csUpdateOne(CsVo csVo) throws SQLException;
	int noticDel(String num) throws SQLException;
	int faqDel(String num) throws SQLException;
	
	int seqNocUp() throws SQLException;
	int seqFaqUp() throws SQLException;
	
	int addfaq(CsVo csVo) throws SQLException;
	
	
}
