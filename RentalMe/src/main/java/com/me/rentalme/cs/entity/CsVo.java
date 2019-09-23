package com.me.rentalme.cs.entity;

import java.sql.Date;

public class CsVo {

	private String faqNo;  //faq �Խ��� ��ȣ
	private String noticNo; //notic �Խ��� ��ȣ
	private String csGbCd; //�Խ��� �з� ��ȣ
	private String csClassGbCd;  //faq���� ��ȣ
	private String sub;    //����
	private String content;//����
	private String chgId;  
	private Date cghDt;
	private String regId;  //�ۼ����̵�
	private Date regDt;	   //��ϳ�¥
	
	private String pquestNo; //1��1 �Խñ� ��ȣ
	private String pquestDt; //1��1 �������
	private String mbNo;	 //1��1 ȸ����ȣ
	private String questStsCd; //1��1 ���ó���ڵ�
	
	private int startListNum;   //�Խ��� ���۹�ȣ
	private int listSize;		//��ϰ���
	private int cnt;			//�� ��ü ī��Ʈ
	
	private String pquestReplyNo;   //��۹�ȣ
	private String pquestReplyDate; //�������
	private String replyContent;
	private String replySub;
	private String replyChgId;  
	private Date replyCghDt;
	private String replyRegId;  //�ۼ����̵�
	private Date replyRegDt;	   //��ϳ�¥
	
	public String getFaqNo() {
		return faqNo;
	}
	public void setFaqNo(String faqNo) {
		this.faqNo = faqNo;
	}
	public String getNoticNo() {
		return noticNo;
	}
	public void setNoticNo(String noticNo) {
		this.noticNo = noticNo;
	}
	public String getCsGbCd() {
		return csGbCd;
	}
	public void setCsGbCd(String csGbCd) {
		this.csGbCd = csGbCd;
	}
	public String getCsClassGbCd() {
		return csClassGbCd;
	}
	public void setCsClassGbCd(String csClassGbCd) {
		this.csClassGbCd = csClassGbCd;
	}
	public String getSub() {
		return sub;
	}
	public void setSub(String sub) {
		this.sub = sub;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
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
	public String getPquestNo() {
		return pquestNo;
	}
	public void setPquestNo(String pquestNo) {
		this.pquestNo = pquestNo;
	}
	public String getPquestDt() {
		return pquestDt;
	}
	public void setPquestDt(String pquestDt) {
		this.pquestDt = pquestDt;
	}
	public String getMbNo() {
		return mbNo;
	}
	public void setMbNo(String mbNo) {
		this.mbNo = mbNo;
	}
	public String getQuestStsCd() {
		return questStsCd;
	}
	public void setQuestStsCd(String questStsCd) {
		this.questStsCd = questStsCd;
	}
	public int getStartListNum() {
		return startListNum;
	}
	public void setStartListNum(int startListNum) {
		this.startListNum = startListNum;
	}
	public int getListSize() {
		return listSize;
	}
	public void setListSize(int listSize) {
		this.listSize = listSize;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public String getPquestReplyNo() {
		return pquestReplyNo;
	}
	public void setPquestReplyNo(String pquestReplyNo) {
		this.pquestReplyNo = pquestReplyNo;
	}
	public String getPquestReplyDate() {
		return pquestReplyDate;
	}
	public void setPquestReplyDate(String pquestReplyDate) {
		this.pquestReplyDate = pquestReplyDate;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public String getReplySub() {
		return replySub;
	}
	public void setReplySub(String replySub) {
		this.replySub = replySub;
	}
	public String getReplyChgId() {
		return replyChgId;
	}
	public void setReplyChgId(String replyChgId) {
		this.replyChgId = replyChgId;
	}
	public Date getReplyCghDt() {
		return replyCghDt;
	}
	public void setReplyCghDt(Date replyCghDt) {
		this.replyCghDt = replyCghDt;
	}
	public String getReplyRegId() {
		return replyRegId;
	}
	public void setReplyRegId(String replyRegId) {
		this.replyRegId = replyRegId;
	}
	public Date getReplyRegDt() {
		return replyRegDt;
	}
	public void setReplyRegDt(Date replyRegDt) {
		this.replyRegDt = replyRegDt;
	}
	@Override
	public String toString() {
		return "CsVo [faqNo=" + faqNo + ", noticNo=" + noticNo + ", csGbCd=" + csGbCd + ", csClassGbCd=" + csClassGbCd
				+ ", sub=" + sub + ", content=" + content + ", chgId=" + chgId + ", cghDt=" + cghDt + ", regId=" + regId
				+ ", regDt=" + regDt + ", pquestNo=" + pquestNo + ", pquestDt=" + pquestDt + ", mbNo=" + mbNo
				+ ", questStsCd=" + questStsCd + ", startListNum=" + startListNum + ", listSize=" + listSize + ", cnt="
				+ cnt + ", pquestReplyNo=" + pquestReplyNo + ", pquestReplyDate=" + pquestReplyDate + ", replyContent="
				+ replyContent + ", replySub=" + replySub + ", replyChgId=" + replyChgId + ", replyCghDt=" + replyCghDt
				+ ", replyRegId=" + replyRegId + ", replyRegDt=" + replyRegDt + "]";
	}
	
	
	
	
	
}
