package com.me.rentalme.cs.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.me.rentalme.cs.dao.CsDao;
import com.me.rentalme.cs.entity.CsVo;
import com.me.rentalme.model.entity.UserVo;


@Service
public class CsServiceImpl implements CsService {

	@Inject
	CsDao csDao;
	
	HashMap<String, Object> map;
	
	//faq�Խñ� ����Ʈ
	@Override
	public List<CsVo> csFaqList() throws SQLException {
		
		return csDao.faqSelectAll();
	}
	
	//�����Խñ� ����Ʈ
	@Override
	public List<CsVo> csNoticeList() throws SQLException {
		return csDao.noticeSelectAll();
	}

	
	//faq�Խñ� ��
	@Override
	public CsVo csFaqDetail(CsVo csVo) throws SQLException {
		System.out.println("serviceImpl faq deta"+csVo.getFaqNo());
		return csDao.csFaqDetail(csVo);
	}
	//�����Խñ� ��
	@Override
	public CsVo csNoticeDetail(CsVo csVo) throws SQLException {
		System.out.println("notice �� mapping");

		System.out.println("notice �� mapping end");
		return csDao.csNoticeDetail(csVo);
	}
	
	//�Խñ� ���
	@Override
	public int addfaq(CsVo csVo) throws SQLException {
		return csDao.insertOne(csVo);
		
	}
	
	
	//�Խù� ����
	@Override
	public int csUpdateOne(CsVo csVo) throws SQLException {
		
		System.out.println("service"+csVo.getCsGbCd());
		return csDao.updateOne(csVo);
	}
	
	
	//�����Խù� ����
	@Override
	public int noticDel(String num) throws SQLException {
		
		return csDao.noticDel(num);
	}
	
	//faq�Խù� ����
	@Override
	public int faqDel(String num) throws SQLException {
		// TODO Auto-generated method stub
		return csDao.faqDel(num);
	}


	@Override
	public int seqNocUp() throws SQLException {
		//�������� �Խñ� ������
		return csDao.seqNocInsert();
	}
	@Override
	public int seqFaqUp() throws SQLException {
		//faq�Խñ� ������
		return csDao.seqFaqInsert();
	}
	@Override
	public int seqInqUp() throws SQLException {
		//Inquiry �Խñ� ������
		System.out.println("service inq ������...");
		return csDao.seqInqInsert();
	}

	//1:1����
	@Override
	public int inquiryAdd() throws SQLException {
	
		return 1;
	}

	//����
	@Override
	public List<CsVo> csInqList() throws SQLException {
		
		return csDao.inqSelectAll();
	}

	@Override
	public int inqAnswer(String num) throws SQLException {
		// TODO Auto-generated method stub
		return csDao.inqAnswer(num);
	}


}
