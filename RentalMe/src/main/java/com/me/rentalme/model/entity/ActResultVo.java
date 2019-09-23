package com.me.rentalme.model.entity;

import java.sql.Date;

public class ActResultVo {
	private String gdsCd;					//��ǰ�ڵ�
	private String actSeq;					//����Ϸù�ȣ
	private String mbNo;					//ȸ����ȣ
	private int bidPrice;					//��������
	private String bidTime;					//�����ð�
	private String actBidStsCd;				//��ų��������ڵ�
	private String userId;					//�������̵�
	private String gdsStPrice;				//��� �ʱⰪ
	
	private String gdsNm;					// ��ǰ��
	private String userNm;					// ����ڸ�
	private String odrNo;					// �ֹ���ȣ
	private String payGbCd;					// �ֹ������ڵ�
	private String odrStsGbCd;				// �ֹ����±����ڵ�
	
	
	public String getGdsCd() {
		return gdsCd;
	}
	public void setGdsCd(String gdsCd) {
		this.gdsCd = gdsCd;
	}
	
	public String getActSeq() {
		return actSeq;
	}
	public void setActSeq(String actSeq) {
		this.actSeq = actSeq;
	}
	public String getMbNo() {
		return mbNo;
	}
	public void setMbNo(String mbNo) {
		this.mbNo = mbNo;
	}
	public int getBidPrice() {
		return bidPrice;
	}
	public void setBidPrice(int bidPrice) {
		this.bidPrice = bidPrice;
	}
	public String getBidTime() {
		return bidTime;
	}
	public void setBidTime(String bidTime) {
		this.bidTime = bidTime;
	}
	public String getActBidStsCd() {
		return actBidStsCd;
	}
	public void setActBidStsCd(String actBidStsCd) {
		this.actBidStsCd = actBidStsCd;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "ActResultVo [gdsCd=" + gdsCd + ", mbNo=" + mbNo + ", bidPrice=" + bidPrice + ", bidTime=" + bidTime
				+ ", actBidStsCd=" + actBidStsCd + ", userId=" + userId + "]";
	}
	public String getGdsNm() {
		return gdsNm;
	}
	public void setGdsNm(String gdsNm) {
		this.gdsNm = gdsNm;
	}
	public String getUserNm() {
		return userNm;
	}
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	public String getOdrNo() {
		return odrNo;
	}
	public void setOdrNo(String odrNo) {
		this.odrNo = odrNo;
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
	public String getGdsStPrice() {
		return gdsStPrice;
	}
	public void setGdsStPrice(String gdsStPrice) {
		this.gdsStPrice = gdsStPrice;
	}
	
	
}
