package com.me.rentalme.model.entity;

import java.sql.Date;

public class MngOrdDetailVo {
	private String odrNo;				//�ֹ���ȣ
	private String odrSeq;				//�ֹ��Ϸù�ȣ
	private String odrDt;				//�ֹ�����
	private String gdsCd;				//��ǰ�ڵ�
	private int gdsPrice;				//��ǰ����
	private int gdsDisPrice;			//��ǰ���ΰ���
	private String gdsDisStsCd;			//��ǰ���α����ڵ�
	private int odrQty;					//�ֹ�����
	private int odrAmt;					//�ֹ��ݾ�
	private String agreeTem;			//���Ⱓ
	private String chgId;				//������̵�
	private Date chgDt;					//��������
	private String regId;				//��Ͼ��̵�
	private Date regDt;					//�������
	private String gdsNm;				//��ǰ�̸�
	
	public String getOdrNo() {
		return odrNo;
	}
	public void setOdrNo(String odrNo) {
		this.odrNo = odrNo;
	}
	public String getOdrSeq() {
		return odrSeq;
	}
	public void setOdrSeq(String odrSeq) {
		this.odrSeq = odrSeq;
	}
	public String getOdrDt() {
		return odrDt;
	}
	public void setOdrDt(String odrDt) {
		this.odrDt = odrDt;
	}
	public String getGdsCd() {
		return gdsCd;
	}
	public void setGdsCd(String gdsCd) {
		this.gdsCd = gdsCd;
	}
	public int getGdsPrice() {
		return gdsPrice;
	}
	public void setGdsPrice(int gdsPrice) {
		this.gdsPrice = gdsPrice;
	}
	public int getGdsDisPrice() {
		return gdsDisPrice;
	}
	public void setGdsDisPrice(int gdsDisPrice) {
		this.gdsDisPrice = gdsDisPrice;
	}
	public String getGdsDisStsCd() {
		return gdsDisStsCd;
	}
	public void setGdsDisStsCd(String gdsDisStsCd) {
		this.gdsDisStsCd = gdsDisStsCd;
	}
	public int getOdrQty() {
		return odrQty;
	}
	public void setOdrQty(int odrQty) {
		this.odrQty = odrQty;
	}
	public int getOdrAmt() {
		return odrAmt;
	}
	public void setOdrAmt(int odrAmt) {
		this.odrAmt = odrAmt;
	}
	public String getAgreeTem() {
		return agreeTem;
	}
	public void setAgreeTem(String agreeTem) {
		this.agreeTem = agreeTem;
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
	public String getGdsNm() {
		return gdsNm;
	}
	public void setGdsNm(String gdsNm) {
		this.gdsNm = gdsNm;
	}
	
	
}
