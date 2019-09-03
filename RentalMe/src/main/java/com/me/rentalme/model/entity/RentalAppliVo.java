package com.me.rentalme.model.entity;

import java.sql.Date;
import java.util.List;

public class RentalAppliVo {
	
	private String gdsCd        ;		// 상품코드
	private String gdsLclassCd  ;		// 상품대분류코드
	private String gdsMclassCd  ;		// 상품중분류코드
	private String gdsSclassCd  ;		// 상품소분류코드
	private String gdsNm        ;		// 상품명
	private String brandNm      ;		// 브랜드명
	private String modelNm      ;		// 모델명
	private String gdsGbCd      ;		// 상품구분코드
	private String gdsGbNm		;		// 상품구분명
	private String gdsStsCd     ;		// 상품상태코드
	private String delYn        ;		// 삭제여부
	private String gdsLclassNm  ; 		// 상품소분류명
	private String gdsMclassNm  ; 		// 상품소분류명
	private String gdsSclassNm  ; 		// 상품소분류명
	private String gubunCd		;		// 전체메뉴구분코드(10의 단위 전체메뉴)
	private int cnt				;		// 카운트
	private int totGrdSum		;		// 토탈등급합계
	private double totGrdAvg	;		// 토탈등급평균
	private String img1			;		// 이미지경로1
	private int gdsPrice		;		// 상품가격
	private String sortGbCd		;		// 정렬구분코드
	private Date regDt			;		// 등록일자
	
	/* RequestParm session 사용 변수 */
	private String sts               ;
	private String search            ;
	private String searchPriceSt     ;
	private String searchPriceEd     ;
	private String sort              ;
	private List<String> brandNm2	 ;
	
	/* 디테일 */
	private String agreeTerm    ;		// 계약기간
	private String deliverCost  ;		// 배송비용
	private String instalCost   ;		// 설치비용 
	private String asCondition  ;		// AS조건 
	
	
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
