package com.me.rentalme.act.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeMap;

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
	Map<String,Map<String, Integer>> premap=new HashMap<String, Map<String, Integer>>();//������ ��� ���� ���̵�, �ð�,���� ����
	Map<String,Integer> pricemap=new LinkedHashMap<String, Integer>();			//���̵� ���� ����
	List<Object> prebidList=new ArrayList<Object>();									//���� �������� ������ ���
	List<Object> bidList=new ArrayList<Object>();										//���� �������� ������ ���
	SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	String list;
	int totalprice;							//������
	boolean interup=true;					//�߰��� ������ �����带 ����
	int currentCnt;							//���� �������� �����
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
				currentCnt=0;
				prebidList=bidList;
				System.out.println("��������Ʈ:"+prebidList);
				bidList=new ArrayList<Object>();
				totalprice=totalprice+Integer.parseInt(String.valueOf(mapping.get("text")));
				mapping.put("text", totalprice);
			}else if(String.valueOf(mapping.get("type")).equals("bid")) {
				currentCnt++;
				bidList.add(session.getAttributes().get("loginUserId"));
				Map<String, Integer> inmap=new HashMap<String, Integer>();				//�ʿ� �� ��
				inmap.put(dayTime.format(new Date(System.currentTimeMillis())), totalprice);		//���� �ð��� ������ �ִ´�
				premap.put(String.valueOf(session.getAttributes().get("loginUserId")), inmap);

				interup=false;
			}else if(String.valueOf(mapping.get("type")).equals("enter")) {
				mapping.put("text",bidList);
				mapping.put("price",totalprice);
			}else if(String.valueOf(mapping.get("type")).equals("countDown")) {
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
		System.out.println("premap:"+ premap.toString());
		
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////
//	//���� ���� �޾Ƽ� ���ݺ��� �з����� ����Ʈ�� �ֱ�
//	public List<Map<String,Map<String, Integer>>> priceSet(Map<String,Map<String, Integer>> premap){
//		List<Map<String,Map<String, Integer>>> priceSetList = new ArrayList<Map<String,Map<String,Integer>>>();
//		Map<String,Integer> idpriMap=idpriceMap(premap);
//		idpriMap= funcAsc2(idpriMap);
//		
//		return priceSetList;
//	}
	
	
	public Map<String,String> idtimeMap(Map<String,Map<String, Integer>> premap) {					//�ʾȿ� �ʻ̾� ���̵�,�ð� �ʸ����
		Iterator<String> preMapIter = premap.keySet().iterator();
        Map<String,String> othermap=new HashMap<String,String>();
        Map<String,Integer> trashmap=new HashMap<String,Integer>();
        
        while(preMapIter.hasNext()) {
 
            String key = preMapIter.next();
            trashmap = premap.get(key);
            Iterator<String> trashiter = trashmap.keySet().iterator();
            while(trashiter.hasNext()) {
            	String key2 = trashiter.next();
            	othermap.put(key, key2);
            }
        }
        return othermap;
	}
	public Map<String,Integer> idpriceMap(Map<String,Map<String, Integer>> premap) {					//�ʾȿ� �ʻ̾� ���̵�,���� �ʸ����
		Iterator<String> preMapIter = premap.keySet().iterator();
        Map<String,Integer> othermap=new HashMap<String,Integer>();
        Map<String,Integer> trashmap=new HashMap<String,Integer>();
        
        while(preMapIter.hasNext()) {
 
            String key = preMapIter.next();
            trashmap = premap.get(key);
            Iterator<String> trashiter = trashmap.keySet().iterator();
            while(trashiter.hasNext()) {
            	String key2 = trashiter.next();
            	int price = trashmap.get(key2);
            	othermap.put(key, price);
            }
        }
        return othermap;
	}
	
	public Map<String,String> funcAsc(Map<String,String> map) {			//���̵� �ð�
		Map<String,String> ascMap=new LinkedHashMap<String, String>();
		List<String> keySetList = new ArrayList<String>(map.keySet());
		 Collections.sort(keySetList, (o1, o2) -> (map.get(o1).compareTo(map.get(o2))));		//�������� ����
		 for(String key : keySetList) {
			 ascMap.put(key, map.get(key));
	     }
		 return ascMap;
	}
	
	public Map<String,Integer> funcAsc2(Map<String,Integer> map) {			//���̵� ���� ��������
		List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
        
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int comparision = (o1.getValue() - o2.getValue()) * -1;
                return comparision == 0 ? o1.getKey().compareTo(o2.getKey()) : comparision;
            }
        });
        
        // ���������� ���� LinkedHashMap�� ���
        Map<String, Integer> sortedMap = new LinkedHashMap<>(); 
        for(Iterator<Map.Entry<String, Integer>> iter = list.iterator(); iter.hasNext();){
            Map.Entry<String, Integer> entry = iter.next();
            sortedMap.put(entry.getKey(), entry.getValue());
        }
		 return sortedMap;
	}
	
	public Map<String,Map<String, Integer>> changeMap(Map<String,String> map, Map<String,Map<String, Integer>> premap){
		Map<String,Map<String, Integer>> lastMap=new LinkedHashMap<String, Map<String,Integer>>();
		Set<String> set = map.keySet();
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()){
		  String key = (String)iterator.next();
		  lastMap.put(key, premap.get(key));
		}
		
		return lastMap;
	}
		
	public void timeThread() {
		Timer m_timer = new Timer();
		TimerTask m_task = new TimerTask() {
			int count=5;
			TextMessage msg;
			@Override
			public void run() {
				if(interup) {
					if(count>0) {
						msg = new TextMessage(count+"");
						System.out.println("����ī��Ʈ:"+currentCnt);
						Set<String> keys=map.keySet();
						Iterator<String> ite=keys.iterator();
						while(ite.hasNext()) {
							try {
								map.get(ite.next()).sendMessage(msg);
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}else if(count==0){
						String endMsg=null;
						
						if(currentCnt==0) {
							endMsg="{\"type\":\"endMsg\",\"text\":\""+prebidList.get(0)+"\",\"id\":\"admin\",\"cnt\":0}";
						}else {
							endMsg="{\"type\":\"endMsg\",\"text\":\""+bidList.get(0)+"\",\"id\":\"admin\",\"cnt\":0}";
						}
						ObjectMapper mapper = new ObjectMapper();
						Map<String, Object> mapping = new HashMap<String, Object>();
						try {
							mapping = mapper.readValue(endMsg, new TypeReference<Map<String, String>>(){});
							endMsg = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(mapping);
						} catch (IOException e) {
							e.printStackTrace();
						}
						msg= new TextMessage(endMsg);
						Set<String> keys=map.keySet();
						Iterator<String> ite=keys.iterator();
						while(ite.hasNext()) {
							try {
								map.get(ite.next()).sendMessage(msg);
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}else if(count==-1){
						String bidResult=null;
						
						ObjectMapper mapper = new ObjectMapper();
						Map<String, Object> mapping = new HashMap<String, Object>();
						try {
							String chbidR=mapper.writeValueAsString(premap).replaceAll("\"", "�ٲ�");
							bidResult="{\"type\":\"bidResult\",\"text\":\""+chbidR+"\",\"id\":\"admin\",\"cnt\":0}";
							mapping = mapper.readValue(bidResult, new TypeReference<Map<String, String>>(){});
							bidResult = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(mapping);
						} catch (IOException e) {
							e.printStackTrace();
						}
						msg= new TextMessage(bidResult);
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
						System.out.println("��...");
						m_timer.cancel();
					}
				}else {
					System.out.println("��...");
					m_timer.cancel();
				}
				count--;
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

