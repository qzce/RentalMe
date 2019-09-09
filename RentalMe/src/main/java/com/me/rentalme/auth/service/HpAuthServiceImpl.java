package com.me.rentalme.auth.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;


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
				
		//coolsms���� ���� apikey ����
		String apiKey = "";			//git�� �ö󰥽� apiŰ �����Ǹ� �ȵǹǷ� ����(����ڿ��� ����)
		String apiSecret = "";		//git�� �ö󰥽� secretŰ �����Ǹ� �ȵǹǷ� ����(����ڿ��� ����)
		Message coolsms = new Message(apiKey, apiSecret);
		
		HashMap<String, String> params = new HashMap<String, String>();
	    params.put("to", hp);									//���Ź�ȣ �Է� (�޸�[,]�� ���е� ���Ź�ȣ �Է°���)
	    params.put("from", "");									//coolsms���� ����� �߽Ź�ȣ�� �ش��(�ٸ���ȣ ��������� �ȵ�!)
	    params.put("type", "SMS");								//�ܹ��޽���(�幮[2000��] : LMS)
	    params.put("text", "��Ż�� ȸ������ �����ڵ� : "+key);	//���۵� ���ڳ���
//	    params.put("app_version", "test app 1.2"); 				// application name and version		
		
	    try {
	    	//���������� �޴��� �����ڵ� �߼�
	        JSONObject json = (JSONObject) coolsms.send(params);
;
	        System.out.println(json.toString());
	    	
	    	//json -> map
	    	ObjectMapper mapper = new ObjectMapper();
	    	   	
	    	Map<String, Object> map = new HashMap<String, Object>();
//	    	map = mapper.readValues(json, new TypeReference<Map<String, Object>>(){});
	    	
	    	System.out.println(map.toString());
	    	
	    } 
//	    catch (JsonGenerationException e){ 
//	    	e.printStackTrace(); 
//	    } catch (JsonMappingException e) { 
//	    	e.printStackTrace(); 
//	    } catch (IOException e) {
//	    	e.printStackTrace(); 
//	    } 
	    catch (CoolsmsException e) {
	        System.out.println(e.getMessage());
	        System.out.println(e.getCode());
	      }		
		
		return key;
	}

}
