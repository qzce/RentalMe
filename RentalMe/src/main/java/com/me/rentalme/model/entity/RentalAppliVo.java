package com.me.rentalme.model.entity;

import java.sql.Date;

public class RentalAppliVo {
	
	private String gdsCd        ;		// ��ǰ�ڵ�
	private String gdsLclassCd  ;		// ��ǰ��з��ڵ�
	private String gdsMclassCd  ;		// ��ǰ�ߺз��ڵ�
	private String gdsSclassCd  ;		// ��ǰ�Һз��ڵ�
	private String gdsNm        ;		// ��ǰ��
	private String brandNm      ;		// �귣���
	private String modelNm      ;		// �𵨸�
	private String gdsGbCd      ;		// ��ǰ�����ڵ�
	private String gdsStsCd     ;		// ��ǰ�����ڵ�
	private String delYn        ;		// ��������
	
	private String gdsLclassNm  ; 		// ��ǰ�Һз���
	private String gdsMclassNm  ; 		// ��ǰ�Һз���
	private String gdsSclassNm  ; 		// ��ǰ�Һз���
	
	private String gubunCd		;		// ��ü�޴������ڵ�(10�� ���� ��ü�޴�)
	
	private int priceMin		;		// �޴� ���ݴ� �ּҰ�
	private int priceMax		;		// �޴� ���ݴ� �ּҰ�
	
	private int cnt				;		// ī��Ʈ
	private int totGrdSum		;		// ��Ż����հ�
	private double totGrdAvg	;		// ��Ż������
	private String img1			;		// �̹������1
	
	private int gdsPrice		;		// ��ǰ����
	
	private String sortGbCd		;		// ���ı����ڵ�
	
	private Date regDt			;		// �������
	
	public String getGdsCd() {
		return gdsCd;
	}
	public void setGdsCd(String gdsCd) {
		this.gdsCd = gdsCd;
	}
	public String getGdsLclassCd() {
		return gdsLclassCd;
	}
	public void setGdsLclassCd(String gdsLclassCd) {
		this.gdsLclassCd = gdsLclassCd;
	}
	public String getGdsMclassCd() {
		return gdsMclassCd;
	}
	public void setGdsMclassCd(String gdsMclassCd) {
		this.gdsMclassCd = gdsMclassCd;
	}
	public String getGdsSclassCd() {
		return gdsSclassCd;
	}
	public void setGdsSclassCd(String gdsSclassCd) {
		this.gdsSclassCd = gdsSclassCd;
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
	public String getGdsLclassNm() {
		return gdsLclassNm;
	}
	public void setGdsLclassNm(String gdsLclassNm) {
		this.gdsLclassNm = gdsLclassNm;
	}
	public String getGdsMclassNm() {
		return gdsMclassNm;
	}
	public void setGdsMclassNm(String gdsMclassNm) {
		this.gdsMclassNm = gdsMclassNm;
	}
	public String getGdsSclassNm() {
		return gdsSclassNm;
	}
	public void setGdsSclassNm(String gdsSclassNm) {
		this.gdsSclassNm = gdsSclassNm;
	}
	public String getGubunCd() {
		return gubunCd;
	}
	public void setGubunCd(String gubunCd) {
		this.gubunCd = gubunCd;
	}
	public int getPriceMin() {
		return priceMin;
	}
	public void setPriceMin(int priceMin) {
		this.priceMin = priceMin;
	}
	public int getPriceMax() {
		return priceMax;
	}
	public void setPriceMax(int priceMax) {
		this.priceMax = priceMax;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getTotGrdSum() {
		return totGrdSum;
	}
	public void setTotGrdSum(int totGrdSum) {
		this.totGrdSum = totGrdSum;
	}
	public double getTotGrdAvg() {
		return totGrdAvg;
	}
	public void setTotGrdAvg(double totGrdAvg) {
		this.totGrdAvg = totGrdAvg;
	}
	public String getImg1() {
		return img1;
	}
	public void setImg1(String img1) {
		this.img1 = img1;
	}
	public int getGdsPrice() {
		return gdsPrice;
	}
	public void setGdsPrice(int gdsPrice) {
		this.gdsPrice = gdsPrice;
	}
	public Date getRegDt() {
		return regDt;
	}
	public void setRegDt(Date regDt) {
		this.regDt = regDt;
	}
	public String getSortGbCd() {
		return sortGbCd;
	}
	public void setSortGbCd(String sortGbCd) {
		this.sortGbCd = sortGbCd;
	}

	
}
