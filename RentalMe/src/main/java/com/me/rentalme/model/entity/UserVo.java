package com.me.rentalme.model.entity;

import java.sql.Date;

public class UserVo {
	private String 	userId;			// ���̵�
	private String	mbNo;			// ȸ����ȣ
	private String	userNM;			// �̸�
	private String	birthDay;		// �������
	private String	genderGbCd;		// ���������ڵ�(1:����, 2:����)
	private String	hp;				// �޴���ȭ
	private String	hpYn;			// �޴���ȭ ���ſ���
	private String  hpKey;			// �޴��� ����� Ű
	private String 	email;			// �̸���
	private String	emailYn;		// �̸��� ���ſ���
	private String	emailKey;		// �̸��� ����� Ű (���� �� : ���� ������ Ű���� �Է�, ���� �� Y �Է�)
	private String  addr;			// �ּ�
	private String  addrDetail;		// ���ּ�
	private String  zipCode;		// �����ȣ
	private String	userPw;			// ��й�ȣ
	private String  pwFailCnt;		// ��й�ȣ ����Ƚ��
	private Date	pwAdjDt;		// ��й�ȣ	��������
	private String	levelGbCd;		// ���������ڵ�(1:�Ϲ�, 2:������)
	private String  joinDt;			// ��������
	private String  userStsCd;		// ����ڻ����ڵ�(1:����, 2:�޸�, 3:����)
	private String  chgId;			// ������̵�
	private Date  	chgDt;			// ��������	
	private String  regId;			// ��Ͼ��̵�
	private Date	regDt;			// �������
	private String  sessionKey;		// ����Ű (��Ⱚ ����)
	private Date	sessionDt;		// ��������
	private boolean useLogin;		// �ڵ��α��� ����
	private String  loginStsCd;		// �α��� ���� �� (1 : �α���, 2 : �α׿���)
	private String  browserStsCd;	// ������ ���� �� (1:IE, 2:Opera, 3:FireFox, 4: Chrome, 5:Safari)
	
	
	public UserVo() {

	}


	public UserVo(String userId, String mbNo, String userNM, String birthDay, String genderGbCd, String hp, String hpYn,
			String hpKey, String email, String emailYn, String emailKey, String addr, String addrDetail, String zipCode,
			String userPw, String pwFailCnt, Date pwAdjDt, String levelGbCd, String joinDt, String userStsCd,
			String chgId, Date chgDt, String regId, Date regDt, String sessionKey, Date sessionDt, boolean useLogin,
			String loginStsCd, String browserStsCd) {
		super();
		this.userId = userId;
		this.mbNo = mbNo;
		this.userNM = userNM;
		this.birthDay = birthDay;
		this.genderGbCd = genderGbCd;
		this.hp = hp;
		this.hpYn = hpYn;
		this.hpKey = hpKey;
		this.email = email;
		this.emailYn = emailYn;
		this.emailKey = emailKey;
		this.addr = addr;
		this.addrDetail = addrDetail;
		this.zipCode = zipCode;
		this.userPw = userPw;
		this.pwFailCnt = pwFailCnt;
		this.pwAdjDt = pwAdjDt;
		this.levelGbCd = levelGbCd;
		this.joinDt = joinDt;
		this.userStsCd = userStsCd;
		this.chgId = chgId;
		this.chgDt = chgDt;
		this.regId = regId;
		this.regDt = regDt;
		this.sessionKey = sessionKey;
		this.sessionDt = sessionDt;
		this.useLogin = useLogin;
		this.loginStsCd = loginStsCd;
		this.browserStsCd = browserStsCd;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getMbNo() {
		return mbNo;
	}


	public void setMbNo(String mbNo) {
		this.mbNo = mbNo;
	}


	public String getUserNM() {
		return userNM;
	}


	public void setUserNM(String userNM) {
		this.userNM = userNM;
	}


	public String getBirthDay() {
		return birthDay;
	}


	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}


	public String getGenderGbCd() {
		return genderGbCd;
	}


	public void setGenderGbCd(String genderGbCd) {
		this.genderGbCd = genderGbCd;
	}


	public String getHp() {
		return hp;
	}


	public void setHp(String hp) {
		this.hp = hp;
	}


	public String getHpYn() {
		return hpYn;
	}


	public void setHpYn(String hpYn) {
		this.hpYn = hpYn;
	}


	public String getHpKey() {
		return hpKey;
	}


	public void setHpKey(String hpKey) {
		this.hpKey = hpKey;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getEmailYn() {
		return emailYn;
	}


	public void setEmailYn(String emailYn) {
		this.emailYn = emailYn;
	}


	public String getEmailKey() {
		return emailKey;
	}


	public void setEmailKey(String emailKey) {
		this.emailKey = emailKey;
	}


	public String getAddr() {
		return addr;
	}


	public void setAddr(String addr) {
		this.addr = addr;
	}


	public String getAddrDetail() {
		return addrDetail;
	}


	public void setAddrDetail(String addrDetail) {
		this.addrDetail = addrDetail;
	}


	public String getZipCode() {
		return zipCode;
	}


	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}


	public String getUserPw() {
		return userPw;
	}


	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}


	public String getPwFailCnt() {
		return pwFailCnt;
	}


	public void setPwFailCnt(String pwFailCnt) {
		this.pwFailCnt = pwFailCnt;
	}


	public Date getPwAdjDt() {
		return pwAdjDt;
	}


	public void setPwAdjDt(Date pwAdjDt) {
		this.pwAdjDt = pwAdjDt;
	}


	public String getLevelGbCd() {
		return levelGbCd;
	}


	public void setLevelGbCd(String levelGbCd) {
		this.levelGbCd = levelGbCd;
	}


	public String getJoinDt() {
		return joinDt;
	}


	public void setJoinDt(String joinDt) {
		this.joinDt = joinDt;
	}


	public String getUserStsCd() {
		return userStsCd;
	}


	public void setUserStsCd(String userStsCd) {
		this.userStsCd = userStsCd;
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


	public String getSessionKey() {
		return sessionKey;
	}


	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}


	public Date getSessionDt() {
		return sessionDt;
	}


	public void setSessionDt(Date sessionDt) {
		this.sessionDt = sessionDt;
	}


	public boolean isUseLogin() {
		return useLogin;
	}


	public void setUseLogin(boolean useLogin) {
		this.useLogin = useLogin;
	}


	public String getLoginStsCd() {
		return loginStsCd;
	}


	public void setLoginStsCd(String loginStsCd) {
		this.loginStsCd = loginStsCd;
	}


	public String getBrowserStsCd() {
		return browserStsCd;
	}


	public void setBrowserStsCd(String browserStsCd) {
		this.browserStsCd = browserStsCd;
	}


	@Override
	public String toString() {
		return "UserVo [userId=" + userId + ", mbNo=" + mbNo + ", userNM=" + userNM + ", birthDay=" + birthDay
				+ ", genderGbCd=" + genderGbCd + ", hp=" + hp + ", hpYn=" + hpYn + ", hpKey=" + hpKey + ", email="
				+ email + ", emailYn=" + emailYn + ", emailKey=" + emailKey + ", addr=" + addr + ", addrDetail="
				+ addrDetail + ", zipCode=" + zipCode + ", userPw=" + userPw + ", pwFailCnt=" + pwFailCnt + ", pwAdjDt="
				+ pwAdjDt + ", levelGbCd=" + levelGbCd + ", joinDt=" + joinDt + ", userStsCd=" + userStsCd + ", chgId="
				+ chgId + ", chgDt=" + chgDt + ", regId=" + regId + ", regDt=" + regDt + ", sessionKey=" + sessionKey
				+ ", sessionDt=" + sessionDt + ", useLogin=" + useLogin + ", loginStsCd=" + loginStsCd
				+ ", browserStsCd=" + browserStsCd + "]";
	}


	

}
