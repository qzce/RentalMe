package com.me.rentalme.model.entity;

public class CallVo {
	private String usedGdsNo;		//�߰� ��ǰ ��ȣ
	private String mbNo;			//ȸ����ȣ
	private String callStsCd;		//����� �ڵ�
	private String chgId;			//���� ���̵�
	private String chgDt;			//���� ��¥
	private String regId;			//��� ���̵�
	private String regDt;			//��� ��¥
	private String modelNm;			//�𵨸�
	private String brandNm;			//�귣���
	private String usedGdsPrice;	//�߰� ��ǰ ����
	private String odrNo;			//�ֹ� ��ȣ
	private String odrDt;			//�ֹ� ����
	private String gdsPrice;		//��Ż ��ǰ ����
	private int odrQty;				//�ֹ�����
	private int odrAmt;				//�ֹ� �ݾ�
	private String agreeTerm;		//��� �Ⱓ
	private String odrStsGbCd;		//�ֹ� ���� ���� �ڵ�
	private String gdsNm;			//��ǰ��
	private String gdsCd;			//��ǰ �ڵ�
	private String userId;			//����� ���̵�
	private String content;			//�ı� ��� ����
	private String grade;			//�ı� ����
	private String sumPrice;		//��ٱ��� �� �ݾ�?
	private String depositSeq;		//��ġ�� �Ϸ� ��ȣ
	private String depositDt;		//��ġ�� ����
	private String chargeDeposit;	//���� ��ġ��
	private String useDeposit;		//��� ��ġ��
	private String refundDeposit;	//ȯ�� ��ġ��
	private String depositGbCd;		//��ġ�� ���� �ڵ� (1-����, 2-���, 3-ȯ��)
	private String remnDeposit;		//�ܿ� ��ġ��
	private String bidPrice;		//���� ����
	private String bidTime;			//���� �ð�
	private String RImg1; 			//��Ż �̹���
	private String UImg1; 			//�߰���� �̹���
	private String cnt; 			//ȸ���� �ش��ǰ�� �� �ı� ����
	private String cartSeq;			//��ٱ��� �Ϸù�ȣ
	private String userNm; 			//ȸ�� �̸�
	private String actBidStsCd;		//ȸ�� ��� ����
	private String gdsCdDetail;		//��Ż�ǰ �������ڵ�
	private String img1;			//��Ż�ǰ ��ǥ�̹���
	private String refund;			//ȯ�� ��û ��ġ�� �ݾ�
	private String gdsSclassCd;		//��ǰ �Һз� �ڵ�
	private String gdsMclassCd;		//��ǰ �ߺз� �ڵ�
	private String payGbCd;			// ��ǰ���������ڵ�
	private String gdsStPrice;		//��ǰ �ʱⰪ
	
	public CallVo() {
	}
	
	public CallVo(String usedGdsNo, String mbNo, String callStsCd, String chgId, String chgDt, String regId,
			String regDt, String modelNm, String brandNm, String usedGdsPrice, String odrNo, String odrDt,
			String gdsPrice, int odrQty, int odrAmt, String agreeTerm, String odrStsGbCd, String gdsNm, String gdsCd,
			String userId, String content, String grade, String sumPrice, String depositSeq, String depositDt,
			String chargeDeposit, String useDeposit, String refundDeposit, String depositGbCd, String remnDeposit,
			String bidPrice, String bidTime, String rImg1, String uImg1, String cnt, String cartSeq, String userNm,
			String actBidStsCd, String gdsCdDetail, String img1, String refund, String gdsSclassCd,
			String gdsMclassCd, String payGbCd) {
		super();
		this.usedGdsNo = usedGdsNo;
		this.mbNo = mbNo;
		this.callStsCd = callStsCd;
		this.chgId = chgId;
		this.chgDt = chgDt;
		this.regId = regId;
		this.regDt = regDt;
		this.modelNm = modelNm;
		this.brandNm = brandNm;
		this.usedGdsPrice = usedGdsPrice;
		this.odrNo = odrNo;
		this.odrDt = odrDt;
		this.gdsPrice = gdsPrice;
		this.odrQty = odrQty;
		this.odrAmt = odrAmt;
		this.agreeTerm = agreeTerm;
		this.odrStsGbCd = odrStsGbCd;
		this.gdsNm = gdsNm;
		this.gdsCd = gdsCd;
		this.userId = userId;
		this.content = content;
		this.grade = grade;
		this.sumPrice = sumPrice;
		this.depositSeq = depositSeq;
		this.depositDt = depositDt;
		this.chargeDeposit = chargeDeposit;
		this.useDeposit = useDeposit;
		this.refundDeposit = refundDeposit;
		this.depositGbCd = depositGbCd;
		this.remnDeposit = remnDeposit;
		this.bidPrice = bidPrice;
		this.bidTime = bidTime;
		RImg1 = rImg1;
		UImg1 = uImg1;
		this.cnt = cnt;
		this.cartSeq = cartSeq;
		this.userNm = userNm;
		this.actBidStsCd = actBidStsCd;
		this.gdsCdDetail = gdsCdDetail;
		this.img1 = img1;
		this.refund = refund;
		this.gdsSclassCd = gdsSclassCd;
		this.gdsMclassCd = gdsMclassCd;
	}
	public String getUsedGdsNo() {
		return usedGdsNo;
	}
	public void setUsedGdsNo(String usedGdsNo) {
		this.usedGdsNo = usedGdsNo;
	}
	public String getMbNo() {
		return mbNo;
	}
	public void setMbNo(String mbNo) {
		this.mbNo = mbNo;
	}
	public String getCallStsCd() {
		return callStsCd;
	}
	public void setCallStsCd(String callStsCd) {
		this.callStsCd = callStsCd;
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
	public String getModelNm() {
		return modelNm;
	}
	public void setModelNm(String modelNm) {
		this.modelNm = modelNm;
	}
	public String getBrandNm() {
		return brandNm;
	}
	public void setBrandNm(String brandNm) {
		this.brandNm = brandNm;
	}
	public String getUsedGdsPrice() {
		return usedGdsPrice;
	}
	public void setUsedGdsPrice(String usedGdsPrice) {
		this.usedGdsPrice = usedGdsPrice;
	}
	public String getOdrNo() {
		return odrNo;
	}
	public void setOdrNo(String odrNo) {
		this.odrNo = odrNo;
	}
	public String getOdrDt() {
		return odrDt;
	}
	public void setOdrDt(String odrDt) {
		this.odrDt = odrDt;
	}
	public String getGdsPrice() {
		return gdsPrice;
	}
	public void setGdsPrice(String gdsPrice) {
		this.gdsPrice = gdsPrice;
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
	public String getAgreeTerm() {
		return agreeTerm;
	}
	public void setAgreeTerm(String agreeTerm) {
		this.agreeTerm = agreeTerm;
	}
	public String getOdrStsGbCd() {
		return odrStsGbCd;
	}
	public void setOdrStsGbCd(String odrStsGbCd) {
		this.odrStsGbCd = odrStsGbCd;
	}
	public String getGdsNm() {
		return gdsNm;
	}
	public void setGdsNm(String gdsNm) {
		this.gdsNm = gdsNm;
	}
	public String getGdsCd() {
		return gdsCd;
	}
	public void setGdsCd(String gdsCd) {
		this.gdsCd = gdsCd;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getSumPrice() {
		return sumPrice;
	}
	public void setSumPrice(String sumPrice) {
		this.sumPrice = sumPrice;
	}
	public String getDepositSeq() {
		return depositSeq;
	}
	public void setDepositSeq(String depositSeq) {
		this.depositSeq = depositSeq;
	}
	public String getDepositDt() {
		return depositDt;
	}
	public void setDepositDt(String depositDt) {
		this.depositDt = depositDt;
	}
	public String getChargeDeposit() {
		return chargeDeposit;
	}
	public void setChargeDeposit(String chargeDeposit) {
		this.chargeDeposit = chargeDeposit;
	}
	public String getUseDeposit() {
		return useDeposit;
	}
	public void setUseDeposit(String useDeposit) {
		this.useDeposit = useDeposit;
	}
	public String getRefundDeposit() {
		return refundDeposit;
	}
	public void setRefundDeposit(String refundDeposit) {
		this.refundDeposit = refundDeposit;
	}
	public String getDepositGbCd() {
		return depositGbCd;
	}
	public void setDepositGbCd(String depositGbCd) {
		this.depositGbCd = depositGbCd;
	}
	public String getRemnDeposit() {
		return remnDeposit;
	}
	public void setRemnDeposit(String remnDeposit) {
		this.remnDeposit = remnDeposit;
	}
	public String getBidPrice() {
		return bidPrice;
	}
	public void setBidPrice(String bidPrice) {
		this.bidPrice = bidPrice;
	}
	public String getBidTime() {
		return bidTime;
	}
	public void setBidTime(String bidTime) {
		this.bidTime = bidTime;
	}
	public String getRImg1() {
		return RImg1;
	}
	public void setRImg1(String rImg1) {
		RImg1 = rImg1;
	}
	public String getUImg1() {
		return UImg1;
	}
	public void setUImg1(String uImg1) {
		UImg1 = uImg1;
	}
	public String getCnt() {
		return cnt;
	}
	public void setCnt(String cnt) {
		this.cnt = cnt;
	}
	public String getCartSeq() {
		return cartSeq;
	}
	public void setCartSeq(String cartSeq) {
		this.cartSeq = cartSeq;
	}
	public String getUserNm() {
		return userNm;
	}
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	public String getActBidStsCd() {
		return actBidStsCd;
	}
	public void setActBidStsCd(String actBidStsCd) {
		this.actBidStsCd = actBidStsCd;
	}
	public String getGdsCdDetail() {
		return gdsCdDetail;
	}
	public void setGdsCdDetail(String gdsCdDetail) {
		this.gdsCdDetail = gdsCdDetail;
	}
	public String getImg1() {
		return img1;
	}
	public void setImg1(String img1) {
		this.img1 = img1;
	}
	public String getRefund() {
		return refund;
	}
	public void setRefund(String refund) {
		this.refund = refund;
	}
	public String getGdsSclassCd() {
		return gdsSclassCd;
	}
	public void setGdsSclassCd(String gdsSclassCd) {
		this.gdsSclassCd = gdsSclassCd;
	}
	public String getGdsMclassCd() {
		return gdsMclassCd;
	}
	public void setGdsMclassCd(String gdsMclassCd) {
		this.gdsMclassCd = gdsMclassCd;
	}
	
	public String getGdsStPrice() {
		return gdsStPrice;
	}

	public void setGdsStPrice(String gdsStPrice) {
		this.gdsStPrice = gdsStPrice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((RImg1 == null) ? 0 : RImg1.hashCode());
		result = prime * result + ((UImg1 == null) ? 0 : UImg1.hashCode());
		result = prime * result + ((actBidStsCd == null) ? 0 : actBidStsCd.hashCode());
		result = prime * result + ((agreeTerm == null) ? 0 : agreeTerm.hashCode());
		result = prime * result + ((bidPrice == null) ? 0 : bidPrice.hashCode());
		result = prime * result + ((bidTime == null) ? 0 : bidTime.hashCode());
		result = prime * result + ((brandNm == null) ? 0 : brandNm.hashCode());
		result = prime * result + ((callStsCd == null) ? 0 : callStsCd.hashCode());
		result = prime * result + ((cartSeq == null) ? 0 : cartSeq.hashCode());
		result = prime * result + ((chargeDeposit == null) ? 0 : chargeDeposit.hashCode());
		result = prime * result + ((chgDt == null) ? 0 : chgDt.hashCode());
		result = prime * result + ((chgId == null) ? 0 : chgId.hashCode());
		result = prime * result + ((cnt == null) ? 0 : cnt.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((depositDt == null) ? 0 : depositDt.hashCode());
		result = prime * result + ((depositGbCd == null) ? 0 : depositGbCd.hashCode());
		result = prime * result + ((depositSeq == null) ? 0 : depositSeq.hashCode());
		result = prime * result + ((gdsCd == null) ? 0 : gdsCd.hashCode());
		result = prime * result + ((gdsCdDetail == null) ? 0 : gdsCdDetail.hashCode());
		result = prime * result + ((gdsMclassCd == null) ? 0 : gdsMclassCd.hashCode());
		result = prime * result + ((gdsNm == null) ? 0 : gdsNm.hashCode());
		result = prime * result + ((gdsPrice == null) ? 0 : gdsPrice.hashCode());
		result = prime * result + ((gdsSclassCd == null) ? 0 : gdsSclassCd.hashCode());
		result = prime * result + ((grade == null) ? 0 : grade.hashCode());
		result = prime * result + ((img1 == null) ? 0 : img1.hashCode());
		result = prime * result + ((mbNo == null) ? 0 : mbNo.hashCode());
		result = prime * result + ((modelNm == null) ? 0 : modelNm.hashCode());
		result = prime * result + odrAmt;
		result = prime * result + ((odrDt == null) ? 0 : odrDt.hashCode());
		result = prime * result + ((odrNo == null) ? 0 : odrNo.hashCode());
		result = prime * result + odrQty;
		result = prime * result + ((odrStsGbCd == null) ? 0 : odrStsGbCd.hashCode());
		result = prime * result + ((refund == null) ? 0 : refund.hashCode());
		result = prime * result + ((refundDeposit == null) ? 0 : refundDeposit.hashCode());
		result = prime * result + ((regDt == null) ? 0 : regDt.hashCode());
		result = prime * result + ((regId == null) ? 0 : regId.hashCode());
		result = prime * result + ((remnDeposit == null) ? 0 : remnDeposit.hashCode());
		result = prime * result + ((sumPrice == null) ? 0 : sumPrice.hashCode());
		result = prime * result + ((useDeposit == null) ? 0 : useDeposit.hashCode());
		result = prime * result + ((usedGdsNo == null) ? 0 : usedGdsNo.hashCode());
		result = prime * result + ((usedGdsPrice == null) ? 0 : usedGdsPrice.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((userNm == null) ? 0 : userNm.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CallVo other = (CallVo) obj;
		if (RImg1 == null) {
			if (other.RImg1 != null)
				return false;
		} else if (!RImg1.equals(other.RImg1))
			return false;
		if (UImg1 == null) {
			if (other.UImg1 != null)
				return false;
		} else if (!UImg1.equals(other.UImg1))
			return false;
		if (actBidStsCd == null) {
			if (other.actBidStsCd != null)
				return false;
		} else if (!actBidStsCd.equals(other.actBidStsCd))
			return false;
		if (agreeTerm == null) {
			if (other.agreeTerm != null)
				return false;
		} else if (!agreeTerm.equals(other.agreeTerm))
			return false;
		if (bidPrice == null) {
			if (other.bidPrice != null)
				return false;
		} else if (!bidPrice.equals(other.bidPrice))
			return false;
		if (bidTime == null) {
			if (other.bidTime != null)
				return false;
		} else if (!bidTime.equals(other.bidTime))
			return false;
		if (brandNm == null) {
			if (other.brandNm != null)
				return false;
		} else if (!brandNm.equals(other.brandNm))
			return false;
		if (callStsCd == null) {
			if (other.callStsCd != null)
				return false;
		} else if (!callStsCd.equals(other.callStsCd))
			return false;
		if (cartSeq == null) {
			if (other.cartSeq != null)
				return false;
		} else if (!cartSeq.equals(other.cartSeq))
			return false;
		if (chargeDeposit == null) {
			if (other.chargeDeposit != null)
				return false;
		} else if (!chargeDeposit.equals(other.chargeDeposit))
			return false;
		if (chgDt == null) {
			if (other.chgDt != null)
				return false;
		} else if (!chgDt.equals(other.chgDt))
			return false;
		if (chgId == null) {
			if (other.chgId != null)
				return false;
		} else if (!chgId.equals(other.chgId))
			return false;
		if (cnt == null) {
			if (other.cnt != null)
				return false;
		} else if (!cnt.equals(other.cnt))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (depositDt == null) {
			if (other.depositDt != null)
				return false;
		} else if (!depositDt.equals(other.depositDt))
			return false;
		if (depositGbCd == null) {
			if (other.depositGbCd != null)
				return false;
		} else if (!depositGbCd.equals(other.depositGbCd))
			return false;
		if (depositSeq == null) {
			if (other.depositSeq != null)
				return false;
		} else if (!depositSeq.equals(other.depositSeq))
			return false;
		if (gdsCd == null) {
			if (other.gdsCd != null)
				return false;
		} else if (!gdsCd.equals(other.gdsCd))
			return false;
		if (gdsCdDetail == null) {
			if (other.gdsCdDetail != null)
				return false;
		} else if (!gdsCdDetail.equals(other.gdsCdDetail))
			return false;
		if (gdsMclassCd == null) {
			if (other.gdsMclassCd != null)
				return false;
		} else if (!gdsMclassCd.equals(other.gdsMclassCd))
			return false;
		if (gdsNm == null) {
			if (other.gdsNm != null)
				return false;
		} else if (!gdsNm.equals(other.gdsNm))
			return false;
		if (gdsPrice == null) {
			if (other.gdsPrice != null)
				return false;
		} else if (!gdsPrice.equals(other.gdsPrice))
			return false;
		if (gdsSclassCd == null) {
			if (other.gdsSclassCd != null)
				return false;
		} else if (!gdsSclassCd.equals(other.gdsSclassCd))
			return false;
		if (grade == null) {
			if (other.grade != null)
				return false;
		} else if (!grade.equals(other.grade))
			return false;
		if (img1 == null) {
			if (other.img1 != null)
				return false;
		} else if (!img1.equals(other.img1))
			return false;
		if (mbNo == null) {
			if (other.mbNo != null)
				return false;
		} else if (!mbNo.equals(other.mbNo))
			return false;
		if (modelNm == null) {
			if (other.modelNm != null)
				return false;
		} else if (!modelNm.equals(other.modelNm))
			return false;
		if (odrAmt != other.odrAmt)
			return false;
		if (odrDt == null) {
			if (other.odrDt != null)
				return false;
		} else if (!odrDt.equals(other.odrDt))
			return false;
		if (odrNo == null) {
			if (other.odrNo != null)
				return false;
		} else if (!odrNo.equals(other.odrNo))
			return false;
		if (odrQty != other.odrQty)
			return false;
		if (odrStsGbCd == null) {
			if (other.odrStsGbCd != null)
				return false;
		} else if (!odrStsGbCd.equals(other.odrStsGbCd))
			return false;
		if (refund == null) {
			if (other.refund != null)
				return false;
		} else if (!refund.equals(other.refund))
			return false;
		if (refundDeposit == null) {
			if (other.refundDeposit != null)
				return false;
		} else if (!refundDeposit.equals(other.refundDeposit))
			return false;
		if (regDt == null) {
			if (other.regDt != null)
				return false;
		} else if (!regDt.equals(other.regDt))
			return false;
		if (regId == null) {
			if (other.regId != null)
				return false;
		} else if (!regId.equals(other.regId))
			return false;
		if (remnDeposit == null) {
			if (other.remnDeposit != null)
				return false;
		} else if (!remnDeposit.equals(other.remnDeposit))
			return false;
		if (sumPrice == null) {
			if (other.sumPrice != null)
				return false;
		} else if (!sumPrice.equals(other.sumPrice))
			return false;
		if (useDeposit == null) {
			if (other.useDeposit != null)
				return false;
		} else if (!useDeposit.equals(other.useDeposit))
			return false;
		if (usedGdsNo == null) {
			if (other.usedGdsNo != null)
				return false;
		} else if (!usedGdsNo.equals(other.usedGdsNo))
			return false;
		if (usedGdsPrice == null) {
			if (other.usedGdsPrice != null)
				return false;
		} else if (!usedGdsPrice.equals(other.usedGdsPrice))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userNm == null) {
			if (other.userNm != null)
				return false;
		} else if (!userNm.equals(other.userNm))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CallVo [usedGdsNo=" + usedGdsNo + ", mbNo=" + mbNo + ", callStsCd=" + callStsCd + ", chgId=" + chgId
				+ ", chgDt=" + chgDt + ", regId=" + regId + ", regDt=" + regDt + ", modelNm=" + modelNm + ", brandNm="
				+ brandNm + ", usedGdsPrice=" + usedGdsPrice + ", odrNo=" + odrNo + ", odrDt=" + odrDt + ", gdsPrice="
				+ gdsPrice + ", odrQty=" + odrQty + ", odrAmt=" + odrAmt + ", agreeTerm=" + agreeTerm + ", odrStsGbCd="
				+ odrStsGbCd + ", gdsNm=" + gdsNm + ", gdsCd=" + gdsCd + ", userId=" + userId + ", content=" + content
				+ ", grade=" + grade + ", sumPrice=" + sumPrice + ", depositSeq=" + depositSeq + ", depositDt="
				+ depositDt + ", chargeDeposit=" + chargeDeposit + ", useDeposit=" + useDeposit + ", refundDeposit="
				+ refundDeposit + ", depositGbCd=" + depositGbCd + ", remnDeposit=" + remnDeposit + ", bidPrice="
				+ bidPrice + ", bidTime=" + bidTime + ", RImg1=" + RImg1 + ", UImg1=" + UImg1 + ", cnt=" + cnt
				+ ", cartSeq=" + cartSeq + ", userNm=" + userNm + ", actBidStsCd=" + actBidStsCd + ", gdsCdDetail="
				+ gdsCdDetail + ", img1=" + img1 + ", refund=" + refund + ", gdsSclassCd=" + gdsSclassCd
				+ ", gdsMclassCd=" + gdsMclassCd + ", getUsedGdsNo()=" + getUsedGdsNo() + ", getMbNo()=" + getMbNo()
				+ ", getCallStsCd()=" + getCallStsCd() + ", getChgId()=" + getChgId() + ", getChgDt()=" + getChgDt()
				+ ", getRegId()=" + getRegId() + ", getRegDt()=" + getRegDt() + ", getModelNm()=" + getModelNm()
				+ ", getBrandNm()=" + getBrandNm() + ", getUsedGdsPrice()=" + getUsedGdsPrice() + ", getOdrNo()="
				+ getOdrNo() + ", getOdrDt()=" + getOdrDt() + ", getGdsPrice()=" + getGdsPrice() + ", getOdrQty()="
				+ getOdrQty() + ", getOdrAmt()=" + getOdrAmt() + ", getAgreeTerm()=" + getAgreeTerm()
				+ ", getOdrStsGbCd()=" + getOdrStsGbCd() + ", getGdsNm()=" + getGdsNm() + ", getGdsCd()=" + getGdsCd()
				+ ", getUserId()=" + getUserId() + ", getContent()=" + getContent() + ", getGrade()=" + getGrade()
				+ ", getSumPrice()=" + getSumPrice() + ", getDepositSeq()=" + getDepositSeq() + ", getDepositDt()="
				+ getDepositDt() + ", getChargeDeposit()=" + getChargeDeposit() + ", getUseDeposit()=" + getUseDeposit()
				+ ", getRefundDeposit()=" + getRefundDeposit() + ", getDepositGbCd()=" + getDepositGbCd()
				+ ", getRemnDeposit()=" + getRemnDeposit() + ", getBidPrice()=" + getBidPrice() + ", getBidTime()="
				+ getBidTime() + ", getRImg1()=" + getRImg1() + ", getUImg1()=" + getUImg1() + ", getCnt()=" + getCnt()
				+ ", getCartSeq()=" + getCartSeq() + ", getUserNm()=" + getUserNm() + ", getActBidStsCd()="
				+ getActBidStsCd() + ", getGdsCdDetail()=" + getGdsCdDetail() + ", getImg1()=" + getImg1()
				+ ", getRefund()=" + getRefund() + ", getGdsSclassCd()=" + getGdsSclassCd() + ", getGdsMclassCd()="
				+ getGdsMclassCd() + ", hashCode()=" + hashCode() + ", getClass()=" + getClass() + ", toString()="
				+ super.toString() + "]";
	}
	public String getPayGbCd() {
		return payGbCd;
	}
	public void setPayGbCd(String payGbCd) {
		this.payGbCd = payGbCd;
	}
}
