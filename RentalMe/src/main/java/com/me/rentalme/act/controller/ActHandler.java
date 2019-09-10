package com.me.rentalme.act.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
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
	Map<String,Integer> premap=new LinkedHashMap<String, Integer>();					//������ ��� ���� ����
	List<Object> bidList=new ArrayList<Object>();										//���� �������� ������ ���
//	String list;
	int totalprice;							//������
	boolean interup=true;					//�߰��� ������ �����带 ����
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
			//System.out.println("json�� : "+json);
			
			if(String.valueOf(mapping.get("type")).equals("adminMsg")) {
				bidList=new ArrayList<Object>();
				totalprice=totalprice+Integer.parseInt(String.valueOf(mapping.get("text")));
				mapping.put("text", totalprice);
			}else if(String.valueOf(mapping.get("type")).equals("bid")) {
				bidList.add(session.getAttributes().get("loginUserId"));
				premap.put(String.valueOf(session.getAttributes().get("loginUserId")), totalprice);
				
				interup=false;
			}else if(String.valueOf(mapping.get("type")).equals("enter")) {

			}else if(String.valueOf(mapping.get("type")).equals("countDown")) {
				System.out.println("ī��Ʈ ����");
				interup=true;
				timeThread();
			}
			json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(mapping);
			
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
				if(count>0&&interup) {
					msg = new TextMessage(count+"");
					count--;
				}else if(count==0&&interup){
					System.out.println("ù��°����Ʈ:"+bidList.get(0));
					String endMsg="{\"type\":\"endMsg\",\"text\":\""+bidList.get(0)+"\",\"id\":\"admin\",\"cnt\":0}";
					ObjectMapper mapper = new ObjectMapper();
					Map<String, Object> mapping = new HashMap<String, Object>();
					try {
						mapping = mapper.readValue(endMsg, new TypeReference<Map<String, String>>(){});
						endMsg = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(mapping);
					} catch (IOException e) {
						e.printStackTrace();
					}
					msg= new TextMessage(endMsg);
					count--;
				}else {
					System.out.println("��...");
					m_timer.cancel();
					count--;
				}
				
				if(count>=-1) {
					Set<String> keys=map.keySet();
					Iterator<String> ite=keys.iterator();
					while(ite.hasNext()) {
						try {
							map.get(ite.next()).sendMessage(msg);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		};
		m_timer.schedule(m_task, 1000, 1000);
	}
	
//	//������ ����ƽ �Լ��� ���� // �� �����ִ� �Լ�
//
//	public static List sortByValue(final Map map) {
//
//	        List<String> list = new ArrayList();
//	        list.addAll(map.keySet());
//	        
//	        Collections.sort(list,new Comparator() {
//	            
//	            public int compare(Object o1,Object o2) {
//	                Object v1 = map.get(o1);
//	                Object v2 = map.get(o2);
//
//
//	                return ((Comparable) v2).compareTo(v1);
//	            }
//	        });
//	        Collections.reverse(list); // �ּ��� ��������
//	        return list;
//	    }
	
}

