package com.me.rentalme.model.entity;

import java.sql.Date;

public class ActVo {
	
	private String gdsCd; //��ǰ�ڵ�
	private int gdsStPrice; //��ǰ ���۰���
	private int unitPrice;	//������������
	private Date actStTime;	//��Ž��۽ð�
	private Date actEdTime;	//�������ð�
	private Date actReTime; //��ų����ð�
	private String content; //����
	private String gdsCdDetail;  //��ǰ�ڵ� ��
	private String currentPresent; //���� ��Ű�
	private String GdsLclassCd; //��ǰ��з��ڵ�
	private String GdsMclassCd; //��ǰ�ߺз��ڵ�
	private String GdsSclassCd; //��ǰ�Һз��ڵ�
	private String gdsNm;    //��ǰ��
	private String brandNm;	 //�귣���
	private String modelNm;	 //�𵨸�
	private String gdsGbCd;	 //��ǰ�����ڵ�
	private String gdsStsCd; //��ǰ�����ڵ�
	private String delYn;	 //��������
	private String img1;     // �̹���1
	private String img2;     // �̹���2
	private String img3;     // �̹���3
	private String img4;     // �̹���4
	private String chgId;  
	private Date cghDt;
	private String regId;  //�ۼ����̵�
	private Date regDt;	   //��ϳ�¥
	
	
	
	
	public String getChgId() {
		return chgId;
	}
	public void setChgId(String chgId) {
		this.chgId = chgId;
	}
	public Date getCghDt() {
		return cghDt;
	}
	public void setCghDt(Date cghDt) {
		this.cghDt = cghDt;
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
	public String getGdsCd() {
		return gdsCd;
	}
	public void setGdsCd(String gdsCd) {
		this.gdsCd = gdsCd;
	}
	public int getGdsStPrice() {
		return gdsStPrice;
	}
	public void setGdsStPrice(int gdsStPrice) {
		this.gdsStPrice = gdsStPrice;
	}
	public int getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Date getActStTime() {
		return actStTime;
	}
	public void setActStTime(Date actStTime) {
		this.actStTime = actStTime;
	}
	public Date getActEdTime() {
		return actEdTime;
	}
	public void setActEdTime(Date actEdTime) {
		this.actEdTime = actEdTime;
	}
	public Date getActReTime() {
		return actReTime;
	}
	public void setActReTime(Date actReTime) {
		this.actReTime = actReTime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getGdsCdDetail() {
		return gdsCdDetail;
	}
	public void setGdsCdDetail(String gdsCdDetail) {
		this.gdsCdDetail = gdsCdDetail;
	}
	public String getCurrentPresent() {
		return currentPresent;
	}
	public void setCurrentPresent(String currentPresent) {
		this.currentPresent = currentPresent;
	}
	public String getGdsLclassCd() {
		return GdsLclassCd;
	}
	public void setGdsLclassCd(String gdsLclassCd) {
		GdsLclassCd = gdsLclassCd;
	}
	public String getGdsMclassCd() {
		return GdsMclassCd;
	}
	public void setGdsMclassCd(String gdsMclassCd) {
		GdsMclassCd = gdsMclassCd;
	}
	public String getGdsSclassCd() {
		return GdsSclassCd;
	}
	public void setGdsSclassCd(String gdsSclassCd) {
		GdsSclassCd = gdsSclassCd;
	}
	public String getGdsNm() {
		return gdsNm;
	}
	public void setGdsNm(String gdsNm) {
		this.gdsNm = gdsNm;
	}
	public String getBrandNm() {
		return brandNm;
	}
	public void setBrandNm(String brandNm) {
		this.brandNm = brandNm;
	}
	public String getModelNm() {
		return modelNm;
	}
	public void setModelNm(String modelNm) {
		this.modelNm = modelNm;
	}
	public String getGdsGbCd() {
		return gdsGbCd;
	}
	public void setGdsGbCd(String gdsGbCd) {
		this.gdsGbCd = gdsGbCd;
	}
	public String getGdsStsCd() {
		return gdsStsCd;
	}
	public void setGdsStsCd(String gdsStsCd) {
		this.gdsStsCd = gdsStsCd;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	public String getImg1() {
		return img1;
	}
	public void setImg1(String img1) {
		this.img1 = img1;
	}
	public String getImg2() {
		return img2;
	}
	public void setImg2(String img2) {
		this.img2 = img2;
	}
	public String getImg3() {
		return img3;
	}
	public void setImg3(String img3) {
		this.img3 = img3;
	}
	public String getImg4() {
		return img4;
	}
	public void setImg4(String img4) {
		this.img4 = img4;
	}
	@Override
	public String toString() {
		return "ActVo [gdsCd=" + gdsCd + ", gdsStPrice=" + gdsStPrice + ", unitPrice=" + unitPrice + ", actStTime="
				+ actStTime + ", actEdTime=" + actEdTime + ", actReTime=" + actReTime + ", content=" + content
				+ ", gdsCdDetail=" + gdsCdDetail + ", currentPresent=" + currentPresent + ", GdsLclassCd=" + GdsLclassCd
				+ ", GdsMclassCd=" + GdsMclassCd + ", GdsSclassCd=" + GdsSclassCd + ", gdsNm=" + gdsNm + ", brandNm="
				+ brandNm + ", modelNm=" + modelNm + ", gdsGbCd=" + gdsGbCd + ", gdsStsCd=" + gdsStsCd + ", delYn="
				+ delYn + ", img1=" + img1 + ", img2=" + img2 + ", img3=" + img3 + ", img4=" + img4 + ", chgId=" + chgId
				+ ", cghDt=" + cghDt + ", regId=" + regId + ", regDt=" + regDt + "]";
	}
	
}
