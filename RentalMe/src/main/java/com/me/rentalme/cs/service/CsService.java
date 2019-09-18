package com.me.rentalme.cs.service;


import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import com.me.rentalme.common.Paging;
import com.me.rentalme.cs.dao.CsDao;
import com.me.rentalme.cs.entity.CsVo;
import com.me.rentalme.cs.paging.Search;
import com.me.rentalme.model.entity.UserVo;

public interface CsService {

	
	List<CsVo> csFaqList(Search search) throws SQLException;    //faq����Ʈ������
	List<CsVo> csNoticeList(Paging paging) throws SQLException;	//���� ����Ʈ������
	List<CsVo> csInqList(Paging paging) throws SQLException;	//���� ����Ʈ������
	
	CsVo csFaqDetail(CsVo csVo) throws SQLException;  //faq ��������
	CsVo csNoticeDetail(CsVo csVo) throws SQLException;	//���� ��������

	int csUpdateOne(CsVo csVo) throws SQLException;
	int noticDel(String num) throws SQLException;
	int faqDel(String num) throws SQLException;
	
	//����,Faq,���ǰԽ��� ������
	int seqNocUp() throws SQLException;
	int seqFaqUp() throws SQLException;
	int seqInqUp() throws SQLException;
	
	//1��1����
	int addfaq(CsVo csVo) throws SQLException;
	
	int inqAnswer(String num) throws SQLException;
	
	//�Խñ� �� ����
	int faqListCnt1(Search search) throws SQLException;
	int noticListCnt() throws SQLException;
	int inquiryListCnt() throws SQLException;
}
