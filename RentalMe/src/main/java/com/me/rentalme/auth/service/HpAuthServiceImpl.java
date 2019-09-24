package com.me.rentalme.auth.service;


import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;


/**
* ȸ������ �ڵ��� ����
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
				
		//coolsms���� ���� apikey ����
		String 	apiKey 		= "NCSKEDEQPFGCT67L";						//git�� �ö󰥽� apiŰ �����Ǹ� �ȵǹǷ� ����(����ڿ��� ����)
		String 	apiSecret 	= "GZH4QB14H8QD9QAGIJE6DB16L6HVQTDD";		//git�� �ö󰥽� secretŰ �����Ǹ� �ȵǹǷ� ����(����ڿ��� ����)
		Message coolsms 	= new Message(apiKey, apiSecret);
		
		String result = "";
		String msg = "";
		
		Map<String, String> params = new HashMap<String, String>();
	    params.put("to", hp);									//���Ź�ȣ �Է� (�޸�[,]�� ���е� ���Ź�ȣ �Է°���)
	    params.put("from", "01025550359");						//����� �߽Ź�ȣ�� �ش��(�ٸ���ȣ ��������� �ȵ�!)
	    params.put("type", "SMS");								//�ܹ��޽���(�幮[2000��] : LMS)
	    params.put("text", "��Ż�� ȸ������ �����ڵ� : "+key);	//���۵� ���ڳ���
//	    params.put("app_version", "test app 1.2"); 				// application name and version		
		
    	//���������� �޴��� �����ڵ� �߼�
		try {
			JSONObject 	json = coolsms.send((HashMap<String, String>) params);
			
			
			params.put("successCnt", String.valueOf(json.get("success_count")));
			params.put("errCnt", String.valueOf(json.get("error_count")));
	    	
	    	//�ڵ��� ��������
	    	if(params.get("successCnt").equals("1") && params.get("errCnt").equals("0")) {
	    		result = key;
	    	}else {
	    		key = "err";
	    		result = key;
	    	}
			
		} catch (CoolsmsException e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
}
