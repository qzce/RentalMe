package com.me.rentalme.auth.service;

import java.util.Random;

import javax.inject.Inject;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.me.rentalme.join.model.JoinDao;


/**
* �������� ����
* 
* @author Ȳ����
* @version ver1.0
* @see 
* ������� : 2019.08.21
*/
@Service
public class MailAuthServiceImpl implements MailAuthService {
	
	@Inject
	private JavaMailSender mailSender;

	@Inject
	private JoinDao joinDao;
	
	// ������ �̿��� Ű ����
	private boolean lowerCheck;
	private int size;

	/**
	* �̸��� ���� ���� �޼��� 
	* 
	* @param  none
	* @return String sb.toString() 
	* @author Ȳ����
	* @exception none
	*/
	@Override
	public String init() {
		Random ran = new Random();
		StringBuffer sb = new StringBuffer();
		int num = 0;
		
		do {
			num = ran.nextInt(75) + 48;
			if ((num >= 48 && num <= 57) || (num >= 65 && num <= 90) || (num >= 97 && num <= 122)) {
				sb.append((char) num);
			} else {
				continue;
			}
		}while(sb.length() < size);
		
		if(lowerCheck) {
			return sb.toString().toLowerCase();
		}
		return sb.toString();
		
	}

	/**
	* ������ �̿��� Ű ����
	* 
	* @param  boolean lowerCheck
	* @param  int size
	* @return String init()
	* @author Ȳ����
	* @exception none
	*/
	@Override
	public String getKey(boolean lowerCheck, int size) {
		this.lowerCheck = lowerCheck;
		this.size = size;
		return init();
	}

	/**
	* ȸ������ �߼� �̸���(����Ű �߼�)
	* 
	* @param  String email	- ������ �����ּ�
	* @param  String userId	- ���Ծ��̵�
	* @param  HttpServletRequest req - ��θ� ��
	* @return 
	* @author Ȳ����
	* @exception none
	*/
	@Override
	public void mailSendWithUserKey(String email, String userId, HttpServletRequest req){

		String key = getKey(false, 20);
		joinDao.getKey(userId, key); 
		MimeMessage mail = mailSender.createMimeMessage();
		String htmlStr = "<h2>�ȳ��ϼ���. RentalMe �������Դϴ�.</h2><br/><br/>";
		htmlStr+="<h3>"+userId+"��</h3><p>�����ϱ� ��ư�� �����ø� �α����� �Ͻ� �� �ֽ��ϴ�. : ";
		htmlStr+="<a href='http://localhost:8080"+req.getContextPath()+"/join/key_alter?userId="+userId+"&emailKey="+key+"'>�����ϱ�</a></p>";
		htmlStr+="(Ȥ�� �߸� ���޵� �����̶�� �� �̸����� �����Ͻñ� �ٶ��ϴ�.)";
		
		try {
			mail.setSubject("[��������] RentalMe �߰�ŷ� ȸ������ �������� �Դϴ�.", "utf-8");
			mail.setText(htmlStr, "utf-8", "html");
			mail.addRecipient(RecipientType.TO, new InternetAddress(email));
			mailSender.send(mail);
		}catch(MessagingException e) {
			e.printStackTrace();
		}
		 
	}

	@Override
	public int updateEamilConfirm(String userId, String emailKey) {
		int result = 0;
		
		result = joinDao.updEmailKey(userId, emailKey);
		return result;
	}


}
