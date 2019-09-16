package com.me.rentalme.common;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class SessionListener implements HttpSessionBindingListener {
	
	//�̱��� ��ü�� ���� ����
	private static SessionListener sessionListener = null;

	//�α����� �����ڸ� ������ hashTable
	private static Hashtable<HttpSession, String> loginUsers = new Hashtable<HttpSession, String>();
	
    // �̱��� ó��
    public static synchronized SessionListener getInstance() {
        if(sessionListener == null) {
            sessionListener = new SessionListener();
        }
        return sessionListener;
    }


    // ������ ����� ȣ�� (�ؽ����̺� ������ ����)
    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        // TODO Auto-generated method stub
        loginUsers.put(event.getSession(), event.getName());
        System.out.println(event.getName() + " �α��� �Ϸ�");
        System.out.println("���� ������ �� : " +  getUserCount());
    }

    // ������ �������� ȣ��
    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        // TODO Auto-generated method stub
        loginUsers.remove(event.getSession());
        System.out.println(event.getName() + " �α׾ƿ� �Ϸ�");
        System.out.println("���� ������ �� : " +  getUserCount());
    }
    
    // �Է¹��� ���̵� �ؽ����̺��� ����
    public void removeSession(String userId) {
        Enumeration<HttpSession> e = loginUsers.keys();
        HttpSession session = null;
        while(e.hasMoreElements()){
            session = e.nextElement();
            if(loginUsers.get(session).equals(userId)){

                session.invalidate();
            }
       }
    }

   /*
    * �ش� ���̵��� ���� ����� �������ؼ� 
    * �̹� ������� ���̵������� Ȯ���Ѵ�.
    */
   public boolean isUsing(String userId){
       boolean flag = loginUsers.containsValue(userId);
       
       if(flag) {
    	   System.out.println("�����");    	   
       }else {
    	   System.out.println("�̻����");
       }
       return flag;
   }
    
   
   /*
    * �α����� �Ϸ��� ������� ���̵� ���ǿ� �����ϴ� �޼ҵ�
    */
   public void setSession(HttpSession session, String userId){
       //�̼����� Session Binding�̺�Ʈ�� �Ͼ�� ����
       //name������ userId, value������ �ڱ��ڽ�(HttpSessionBindingListener�� �����ϴ� Object)
       session.setAttribute(userId, this);//login�� �ڱ��ڽ��� ����ִ´�.
   }
    
    
   /*
     * �Է¹��� ����Object�� ���̵� �����Ѵ�.
     * @param session : ������ ������� session Object
     * @return String : ������ ���̵�
    */
   public String getUserID(HttpSession session){
       return (String)loginUsers.get(session);
   }
    
    
   /*
    * ���� ������ �� ����� ��
    * @return int  ���� ������ ��
    */
   public int getUserCount(){
       int size = loginUsers.size();
       
       System.out.println("�� ����� �� : "+ size);
       
       return size;
   }
    
    
   /*
    * ���� �������� ��� ����� ���̵� ���
    * @return void
    */
   public void printloginUsers(){
       Enumeration<HttpSession> e = loginUsers.keys();
       HttpSession session = null;
       System.out.println("===========================================");
       int i = 0;
       while(e.hasMoreElements()){
           session = e.nextElement();
           System.out.println((++i) + ". ������ : " +  loginUsers.get(session));
       }
       System.out.println("===========================================");
    }
    
   /*
    * ���� �������� ��� ����ڸ���Ʈ�� ����
    * @return list
    */
   public Collection getUsers(){
       Collection collection = loginUsers.values();
       return collection;
   }


	
	
}
