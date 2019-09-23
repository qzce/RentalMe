package com.me.rentalme.common;

/**
* ����¡ ���� Ŭ����
* 
* @author Ȳ����
* @version ver1.0
* ������� : 2019.09.06
*/
public class Paging {

	private int 	listSize 		= 10; 		//���   ����
	private int 	rangeSize 		= 10;		//������ ����
	private int 	page;						//����   ������
	private int 	range;						//����   ����������
	private int 	totalListCnt;				//�Խù� �Ѱ���
	private int 	pageCnt;					//��ü   ��������
	private int 	startPage;					//����   ������
	private int 	startListNum;				//�Խ��� ���۹�ȣ
	private int 	endPage;					//��	 ������
	private boolean prev;						//����   ��ư ��
	private boolean next;						//����   ��ư ��
	
	/*getter setter*/
	public int getListSize() {
		return listSize;
	}
	public void setListSize(int listSize) {
		this.listSize = listSize;
	}
	public int getRangeSize() {
		return rangeSize;
	}
	public void setRangeSize(int rangeSize) {
		this.rangeSize = rangeSize;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRange() {
		return range;
	}
	public void setRange(int range) {
		this.range = range;
	}
	public int getTotalListCnt() {
		return totalListCnt;
	}
	public void setTotalListCnt(int totalListCnt) {
		this.totalListCnt = totalListCnt;
	}
	public int getPageCnt() {
		return pageCnt;
	}
	public void setPageCnt(int pageCnt) {
		this.pageCnt = pageCnt;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getstartListNum() {
		return startListNum;
	}
	public void setstartListNum(int startListNum) {
		this.startListNum = startListNum;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	
	/**
	* ������ ���� 
	* 
	* @param  int page  - ���������� (������ �⺻�� : 1) 
	* @param  int range - ������� (������ �⺻�� : 1) 
	* @param  int totalListCnt - �Խù� �Ѱ���
	* @return 
	* @author Ȳ����
	* ������� : 2019.09.06
	*/
	public void pageInfo(int page, int range, int totalListCnt) {
		this.page 			= page;				//����������
		this.range 			= range;			//��������������
		this.totalListCnt 	= totalListCnt;		//�Խù��Ѱ���
		
		//��ü������ ��
		this.pageCnt = (int)Math.ceil((double)totalListCnt/listSize);
		
		//���� ������(�� ������ ������ ���� ��ȣ) - 1,6,11,...
		this.startPage = (range-1)*rangeSize+1;
		
		//������ ������ - 5,10,15,...
		this.endPage = range * rangeSize;
		
		//�Խ��� ���۹�ȣ(mysql limit�� ����ϱ� ���� ����)
		this.startListNum = (page - 1) * listSize;
		
		//���� ��ư ����
		this.prev = range  == 1 ? false : true;
		
		//���� ��ư ����
		this.next = endPage > pageCnt ? false : true;
		
		if(this.endPage > this.pageCnt) {
			this.endPage = this.pageCnt;
			this.next = false;
		}
	}
	
	
	
	
	

	
}
