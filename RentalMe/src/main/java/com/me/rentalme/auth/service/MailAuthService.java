package com.me.rentalme.auth.service;

public interface MailAuthService {
	//���� ����
	public String init(); 	
	
	//���� ����� �޼��带 �̿��ؼ� Ű ����
	public String getKey(boolean lowerCheck, int size); 
	
	// ȸ������ �̸��� (����Ű �߼�) - (2019-08-27 : ȸ������ ��Ŀ��� �����ϴ� ������� �������� ���� ����)
	//public void mailSendWithUserKey(String email, String userId, HttpServletRequest req);

	//����Ȯ�� �޼���(Y������ ������Ʈ) - (2019-08-27 : ȸ������ ��Ŀ��� �����ϴ� ������� �������� ���� ����)
	//public int updateEamilConfirm(String userId, String emailKey);

	// �̸��� ����
	public String mailSendWithUserEmail(String email);

}
