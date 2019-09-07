package com.me.rentalme.auth.service;

import java.util.HashMap;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

//import net.nurigo.java_sdk.api.Message;


/**
* �ڵ��� ����
* 
* @author Ȳ����
* @version ver1.0
* @see 
* ������� : 2019.09.05
*/
@Service
public class HpAuthServiceImpl implements HpAuthService {
	
	@Inject
	MailAuthService mailAuthService;

	/**
	* �ڵ��� ���� ��ȣ�� ������.
	* 
	* @param  String hp - �Է��� �ڵ��� ��ȣ
	* @return void 
	* @author Ȳ����
	* 
	*/
	@Override
	public String sendHp(String hp) {
		//�����ڵ� ����
		String key = mailAuthService.getKey(false, 6);
		
		//System.out.println("������ ����Ű : "+key);
		
		//coolsms���� ���� apikey ����
		String apiKey = "";			//git�� �ö󰥽� apiŰ �����Ǹ� �ȵǹǷ� ����(����ڿ��� ����)
		String apiSecret = "";		//git�� �ö󰥽� secretŰ �����Ǹ� �ȵǹǷ� ����(����ڿ��� ����)
		//Message coolsms = new Message(apiKey, apiSecret);
		
		HashMap<String, String> params = new HashMap<String, String>();
	    params.put("to", hp);									//���Ź�ȣ �Է� (�޸�[,]�� ���е� ���Ź�ȣ �Է°���)
	    params.put("from", "");									//coolsms���� ����� �߽Ź�ȣ�� �ش��(�ٸ���ȣ ��������� �ȵ�!)
	    params.put("type", "SMS");								//�ܹ��޽���(�幮[2000��] : LMS)
	    params.put("text", "��Ż�� ȸ������ �����ڵ� : "+key);	//���۵� ���ڳ���
//	    params.put("app_version", "test app 1.2"); 				// application name and version		
		
	    try {
	    	//���������� �޴��� �����ڵ� �߼�
	        //JSONObject json = (JSONObject) coolsms.send(params);
	        //System.out.println(json.toString());
	    	
	    	String jsonStr = "{ "+"group_id"+" : "+"1000"+", "+"success_count"+" : 1, "+"error_count"+" : 0 }";
	    	
	    	System.out.println(jsonStr);
	    	

	        
	        
	        
	        
	      } catch (Exception e) {
//	        System.out.println(e.getMessage());
//	        System.out.println(e.getCode());
	      }		
		
		return key;
	}

}
