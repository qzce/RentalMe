package com.me.rentalme.act.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ActHandler extends TextWebSocketHandler{
	//ä�ü���
	Map<String,WebSocketSession> map=new HashMap<String,WebSocketSession>();			//���Ͽ� ����� client
	List<Object> bidList=new ArrayList<Object>();										//���� �������� ������ ���
	String list;
	boolean interup=true;
///////////////////////////////////////////////////////////////////////////////////////////////////////////
	//������ �������� �� �̺�Ʈ
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("Connect...");
		map.put(session.getId(), session);
		System.out.println(session.getId()+">websocket>"+session.getAttributes().get("loginUserId"));
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////
	//������ �������� �� �̺�Ʈ
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println("Close...");
		map.remove(session.getId());
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////
	//������ �޽����� ������ �� �̺�Ʈ
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		// Ŭ���̾�Ʈ�� ����
		System.out.println("�޽���"+message.getPayload());
		
		//gson�� �߰������� ������ jaxon���� ���
		//json -> map 
		ObjectMapper mapper = new ObjectMapper();
		String json = message.getPayload();
		try {
			Map<String, Object> mapping = new HashMap<String, Object>();
			mapping = mapper.readValue(json, new TypeReference<Map<String, String>>(){});
			
			//���� ���Ͽ� ����� �ο� ���� cnt�� �ִ´�.
			mapping.put("cnt", this.map.size());
			System.out.println("���� �� �޽����� ������?:"+mapping.get("id"));
			//map -> json
			json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(mapping);
			//System.out.println("json�� : "+json);
			
			System.out.println(mapping.get("type"));
			if(String.valueOf(mapping.get("type")).equals("adminMsg")) {
				bidList=new ArrayList<Object>();
			}else if(String.valueOf(mapping.get("type")).equals("bid")) {
				bidList.add(session.getAttributes().get("loginUserId"));
				interup=false;
			}else if(String.valueOf(mapping.get("type")).equals("enter")) {
				
//				Map<String,Object> listAll=new HashMap<String,Object>();
//				listAll.put("type", "bidlist");
//				listAll.put("text", bidList);
//				listAll.put("id", session.getAttributes().get("loginUserId"));
//				listAll.put("cnt", "");
//				
//				list=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(listAll);
//				
//				TextMessage msg=new TextMessage(list);
//				Set<String> keys=map.keySet();
//				Iterator<String> ite=keys.iterator();
//				while(ite.hasNext()) {
//					map.get(ite.next()).sendMessage(msg);
//				}
			}else if(String.valueOf(mapping.get("type")).equals("countDown")) {
				System.out.println("ī��Ʈ ����");
				interup=true;
				timeThread();
			}
			
		} catch (JsonGenerationException e) { 
			e.printStackTrace(); 
		} catch (JsonMappingException e) {
			e.printStackTrace(); 
		} catch (IOException e) { 
			e.printStackTrace(); 
		}
		
		//����� json���� �־��ش�.
		TextMessage msg= new TextMessage(json);
		Set<String> keys=map.keySet();
		Iterator<String> ite=keys.iterator();
		while(ite.hasNext()) {
			map.get(ite.next()).sendMessage(msg);
		}
		
		System.out.println("bidList:"+ bidList.toString());
	}
		
	public void timeThread() {
		Timer m_timer = new Timer();
		TimerTask m_task = new TimerTask() {
			int count=5;
			TextMessage msg;
			@Override
			public void run() {
				msg = new TextMessage(count+"");
				if(count>=0&&interup) {
					count--;
					Set<String> keys=map.keySet();
					Iterator<String> ite=keys.iterator();
					while(ite.hasNext()) {
						try {
							map.get(ite.next()).sendMessage(msg);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}else {
					m_timer.cancel();
				}
			}
		};
		m_timer.schedule(m_task, 1000, 1000);
	}
}