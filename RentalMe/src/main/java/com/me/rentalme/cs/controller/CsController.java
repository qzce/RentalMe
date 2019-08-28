package com.me.rentalme.cs.controller;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.me.rentalme.cs.service.CsService;


/**
* ������ ��Ʈ�ѷ�
* 
* @author Ȳ����
* @version ver1.0
* @see 
* ������� : 2019.08.18
*/
@Controller
@RequestMapping("/cs")
public class CsController {
	
	@Inject
	CsService csService; 
	
	/**
	 * @throws SQLException 
	* ������ ����Ʈ 
	* 
	* @param  None
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	
	//1:1����
	@RequestMapping(value="/csInquiry")
	public String inquery(Model model) throws SQLException {
		System.out.println("����");
		return "cs/csInquiry";
		
	}
/////////////////////////////////////////////////////////////////////////////	
	//�����Խ���
	@RequestMapping(value = "/csNotice", method = RequestMethod.GET)
	public ModelAndView home() throws SQLException {
		System.out.println("mapping..");
		ModelAndView mav=new ModelAndView();
		mav.addObject("alist", csService.csNoticeList());
		mav.setViewName("cs/csNotice");
		return mav;
	}
	
	//faq�Խ���
	@RequestMapping(value="/csFAQ")
	public ModelAndView csfaq(Model model) throws SQLException {
		System.out.println("���ֹ�������");
		ModelAndView mav=new ModelAndView();
		mav.addObject("blist", csService.csFaqList());
		mav.setViewName("cs/csFAQ");
		return mav;
	}
/////////////////////////////////////////////////////////////////////////////		
	//notice�󼼰Խ���
	@RequestMapping(value="/csNoticeDetail",method=RequestMethod.GET)
	public String csNoticeDetail(@RequestParam("noticNo") String noticNo, @RequestParam("csGbCd") String  csGbCd ,Model model) throws Exception{
		
		System.out.println("detail..start");
		model.addAttribute("adetail", csService.csNoticeDetail(noticNo,csGbCd));
		System.out.println("detail...end");
		return "cs/csNoticeDetail";
		
	}
	
	//faq�󼼰Խ���
	@RequestMapping(value="/csFaqDetail",method=RequestMethod.GET)
	public String csFaqDetail(@RequestParam("csGbCd") String csGbCd, @RequestParam("faqNo") String  faqNo,@RequestParam("csClassGbCd")String csClassGbCd,Model model) throws Exception{
		
		System.out.println("detail..start");
		model.addAttribute("bdetail", csService.csFaqDetail(csGbCd,faqNo, csClassGbCd));
		System.out.println("detail...end");
		return "cs/csFaqDetail";
		
	}
	
/////////////////////////////////////////////////////////////////////////////		
	/**
	* ������ - ���� ��� �� 
	* 
	* @param  None
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	
	  @RequestMapping(value = "/csQuestAdd", method = RequestMethod.GET) 
	  public String getCsQuestForm() {
		  return "cs/csQuestAdd"; 
	  }
	 
	/**
	* ������ - ���� ��� 
	* 
	* @param  
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/csQuest", method = RequestMethod.POST)
	public ModelAndView setCsQuestAdd() {
		
		ModelAndView mav = new ModelAndView("cs/csList");
		return mav;
	}
}
