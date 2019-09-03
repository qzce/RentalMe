package com.me.rentalme.model.entity;

import java.sql.Date;
import java.util.List;

public class RentalAppliVo {
	
	private String gdsCd        ;		// ��ǰ�ڵ�
	private String gdsLclassCd  ;		// ��ǰ��з��ڵ�
	private String gdsMclassCd  ;		// ��ǰ�ߺз��ڵ�
	private String gdsSclassCd  ;		// ��ǰ�Һз��ڵ�
	private String gdsNm        ;		// ��ǰ��
	private String brandNm      ;		// �귣���
	private String modelNm      ;		// �𵨸�
	private String gdsGbCd      ;		// ��ǰ�����ڵ�
	private String gdsGbNm		;		// ��ǰ���и�
	private String gdsStsCd     ;		// ��ǰ�����ڵ�
	private String delYn        ;		// ��������
	private String gdsLclassNm  ; 		// ��ǰ�Һз���
	private String gdsMclassNm  ; 		// ��ǰ�Һз���
	private String gdsSclassNm  ; 		// ��ǰ�Һз���
	private String gubunCd		;		// ��ü�޴������ڵ�(10�� ���� ��ü�޴�)
	private int cnt				;		// ī��Ʈ
	private int totGrdSum		;		// ��Ż����հ�
	private double totGrdAvg	;		// ��Ż������
	private String img1			;		// �̹������1
	private int gdsPrice		;		// ��ǰ����
	private String sortGbCd		;		// ���ı����ڵ�
	private Date regDt			;		// �������
	
	/* RequestParm session ��� ���� */
	private String sts               ;
	private String search            ;
	private String searchPriceSt     ;
	private String searchPriceEd     ;
	private String sort              ;
	private List<String> brandNm2	 ;
	
	/* ������ */
	private String agreeTerm    ;		// ���Ⱓ
	private String deliverCost  ;		// ��ۺ��
	private String instalCost   ;		// ��ġ��� 
	private String asCondition  ;		// AS���� 
	
	
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
	public String getSts() {
		return sts;
	}
	public void setSts(String sts) {
		this.sts = sts;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getSearchPriceSt() {
		return searchPriceSt;
	}
	public void setSearchPriceSt(String searchPriceSt) {
		this.searchPriceSt = searchPriceSt;
	}
	public String getSearchPriceEd() {
		return searchPriceEd;
	}
	public void setSearchPriceEd(String searchPriceEd) {
		this.searchPriceEd = searchPriceEd;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public List<String> getBrandNm2() {
		return brandNm2;
	}
	public void setBrandNm2(List<String> brandNm2) {
		this.brandNm2 = brandNm2;
	}
	public String getGdsGbNm() {
		return gdsGbNm;
	}
	public void setGdsGbNm(String gdsGbNm) {
		this.gdsGbNm = gdsGbNm;
	}
	public String getAgreeTerm() {
		return agreeTerm;
	}
	public void setAgreeTerm(String agreeTerm) {
		this.agreeTerm = agreeTerm;
	}

	public String getAsCondition() {
		return asCondition;
	}
	public void setAsCondition(String asCondition) {
		this.asCondition = asCondition;
	}
	/**
	 * @return the deliverCost
	 */
	public String getDeliverCost() {
		return deliverCost;
	}
	/**
	 * @param deliverCost the deliverCost to set
	 */
	public void setDeliverCost(String deliverCost) {
		this.deliverCost = deliverCost;
	}
	/**
	 * @return the instalCost
	 */
	public String getInstalCost() {
		return instalCost;
	}
	/**
	 * @param instalCost the instalCost to set
	 */
	public void setInstalCost(String instalCost) {
		this.instalCost = instalCost;
	}

	
}
