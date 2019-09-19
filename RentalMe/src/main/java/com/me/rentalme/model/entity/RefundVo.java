package com.me.rentalme.model.entity;

public class RefundVo {
	private String userNm;				//ȸ���̸�
	private String mbNo;				//ȸ����ȣ
	private String depositRefundSeq;	//��ġ��ȯ���Ϸù�ȣ
	private String depositRefundDt;		//��ġ��ȯ������
	private int refundDeposit;			//ȯ�ҿ�ġ�ݾ�
	private String depositRefundGbCd;	//��ġ��ȯ�ұ����ڵ�
	private String chgId;				//���� ���̵�
	private String chgDt;				//���� ��¥
	private String regId;				//��� ���̵�
	private String regDt;				//��� ��¥
	
	public RefundVo() {
	}

	public String getUserNm() {
		return userNm;
	}

	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}

	public String getMbNo() {
		return mbNo;
	}

	public void setMbNo(String mbNo) {
		this.mbNo = mbNo;
	}

	public String getDepositRefundSeq() {
		return depositRefundSeq;
	}

	public void setDepositRefundSeq(String depositRefundSeq) {
		this.depositRefundSeq = depositRefundSeq;
	}

	public String getDepositRefundDt() {
		return depositRefundDt;
	}

	public void setDepositRefundDt(String depositRefundDt) {
		this.depositRefundDt = depositRefundDt;
	}

	public int getRefundDeposit() {
		return refundDeposit;
	}

	public void setRefundDeposit(int refundDeposit) {
		this.refundDeposit = refundDeposit;
	}

	public String getDepositRefundGbCd() {
		return depositRefundGbCd;
	}

	public void setDepositRefundGbCd(String depositRefundGbCd) {
		this.depositRefundGbCd = depositRefundGbCd;
	}

	public String getChgId() {
		return chgId;
	}

	public void setChgId(String chgId) {
		this.chgId = chgId;
	}

	public String getChgDt() {
		return chgDt;
	}

	public void setChgDt(String chgDt) {
		this.chgDt = chgDt;
	}

	public String getRegId() {
		return regId;
	}

	public void setRegId(String regId) {
		this.regId = regId;
	}

	public String getRegDt() {
		return regDt;
	}

	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}

	@Override
	public String toString() {
		return "RefundVo [userNm=" + userNm + ", mbNo=" + mbNo + ", depositRefundSeq=" + depositRefundSeq
				+ ", depositRefundDt=" + depositRefundDt + ", refundDeposit=" + refundDeposit + ", depositRefundGbCd="
				+ depositRefundGbCd + ", chgId=" + chgId + ", chgDt=" + chgDt + ", regId=" + regId + ", regDt=" + regDt
				+ "]";
	}
	
}
