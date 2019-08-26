package com.me.rentalme.auth.service;

import javax.servlet.http.HttpServletRequest;

public interface MailAuthService {
	//���� ����
	public String init(); 	
	
	//���� ����� �޼��带 �̿��ؼ� Ű ����
	public String getKey(boolean lowerCheck, int size); 
	
	// ȸ������ �̸��� (����Ű �߼�)
	public void mailSendWithUserKey(String email, String userId, HttpServletRequest req);

	//����Ȯ�� �޼���(Y������ ������Ʈ)
	public int updateEamilConfirm(String userId, String emailKey);

}
