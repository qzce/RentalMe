package com.me.rentalme.model.entity;

import java.sql.Date;

public class MngOrdVo {

	private String odrNo;				//�ֹ���ȣ
	private String mbNo;				//ȸ����ȣ
	private String odrDt;				//�ֹ�����
	private int totOdrAmt;				//��ü�ֹ��ݾ�
	private String odrGbCd;				//�ֹ������ڵ�
	private String payGbCd;				//���������ڵ�
	private String odrStsGbCd;			//�ֹ����±����ڵ�
	private String chgId;				//������̵�
	private Date chgDt;					//��������
	private String regId;				//��Ͼ��̵�
	private Date regDt;					//�������
	
	private String userNm;				// ����ڸ�
	
	public String getOdrNo() {
		return odrNo;
	}
	public void setOdrNo(String odrNo) {
		this.odrNo = odrNo;
	}
	public String getMbNo() {
		return mbNo;
	}
	public void setMbNo(String mbNo) {
		this.mbNo = mbNo;
	}
	public String getOdrDt() {
		return odrDt;
	}
	public void setOderDt(String odrDt) {
		this.odrDt = odrDt;
	}
	public int getTotOdrAmt() {
		return totOdrAmt;
	}
	public void setTotOdrAmt(int totOdrAmt) {
		this.totOdrAmt = totOdrAmt;
	}
	public String getOdrGbCd() {
		return odrGbCd;
	}
	public void setOdrGbCd(String odrGbCd) {
		this.odrGbCd = odrGbCd;
	}
	public String getPayGbCd() {
		return payGbCd;
	}
	public void setPayGbCd(String payGbCd) {
		this.payGbCd = payGbCd;
	}
	public String getOdrStsGbCd() {
		return odrStsGbCd;
	}
	public void setOdrStsGbCd(String odrStsGbCd) {
		this.odrStsGbCd = odrStsGbCd;
	}
	public String getChgId() {
		return chgId;
	}
	public void setChgId(String chgId) {
		this.chgId = chgId;
	}
	public Date getChgDt() {
		return chgDt;
	}
	public void setChgDt(Date chgDt) {
		this.chgDt = chgDt;
	}
	public String getRegId() {
		return regId;
	}
	public void setRegId(String regId) {
		this.regId = regId;
	}
	public Date getRegDt() {
		return regDt;
	}
	public void setRegDt(Date regDt) {
		this.regDt = regDt;
	}
	public String getUserNm() {
		return userNm;
	}
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	
	
	
}
