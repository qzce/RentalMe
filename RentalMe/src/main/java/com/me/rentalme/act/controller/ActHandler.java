package com.me.rentalme.act.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
//	List<WebSocketSession> list=new ArrayList<WebSocketSession>();
	static int cnt;
	static int totalPrice;
	Map<String,WebSocketSession> map=new HashMap<String,WebSocketSession>();
	List<String> enterList = new ArrayList<String>();
//	Map<String,String> users=new HashMap<String,String>();
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("Connect...");
		boolean same=true;
		cnt++;
		map.put(session.getId(), session);
		System.out.println(session.getId()+">websocket>"+session.getAttributes().get("loginUserId"));
		for(int i=enterList.size()-1; i>=0; i--) {
			if(enterList.get(i).equals((String)session.getAttributes().get("loginUserId"))) {
				System.out.println("�������");
				cnt--;
				same=false;
				break;
			}
		}
		if(same) {
			enterList.add((String)session.getAttributes().get("loginUserId"));
		}
		System.out.println(enterList.toString());
		
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println("Close...");
		for(int i=0;i<enterList.size(); i++) {
			if(enterList.get(i).equals((String)session.getAttributes().get("loginUserId"))) {
				System.out.println("����");
				enterList.remove(i);
				cnt--;
				break;
			}
		}
		map.remove(session.getId());
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		// Ŭ���̾�Ʈ�� ����
		System.out.println("�޽���"+message.getPayload());
		
		//gson�� �߰������� ������ jaxon���� ���
		//json -> map 
		ObjectMapper mapper = new ObjectMapper();
		String json = message.getPayload();
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map = mapper.readValue(json, new TypeReference<Map<String, String>>(){});
			
			System.out.println("json �Ľ� : "+ map);
			System.out.println("cnt = "+ map.get("cnt"));
			
			//�̷��� ���ϸ� websocket ���� (String���� ���� �� ���ڷ� ���� �� �ٽ� String���� ����)
//			String cnt = (String)map.get("cnt");			
//			int val = Integer.parseInt(cnt);
//			val++;
//			cnt = String.valueOf(val);
			
			int val=Integer.parseInt((String) map.get("price"));
			totalPrice=totalPrice+val;
			
			//����� cnt���� map�� �ִ´�.
			map.put("price", totalPrice);
			map.put("cnt", cnt);
			
			//map -> json
			json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(map);
			//System.out.println("json�� : "+json);
			Map<String,String> serverMsg=new HashMap<String,String>();
			serverMsg.put("type", "smsg");
			serverMsg.put("text", "10000��anybody");
			serverMsg.put("id", "admin");
			serverMsg.put("price", "");
			serverMsg.put("cnt", "");
			
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
		
	}
	
	
	
//  ����	
//	public void timeThread(WebSocketSession session) {
//		Timer m_timer = new Timer();
//		TimerTask m_task = new TimerTask() {
//
//			@Override
//			public void run() {
//			}
//		};
//		m_timer.schedule(m_task, 3000);
//	}
	
}
