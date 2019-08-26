package com.me.rentalme.cs.controller;

import java.sql.SQLException;

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
	@RequestMapping(value="/csInquiry")
	public String inquery(Model model) throws SQLException {
		System.out.println("����");
		csService.getList(model);
		return "cs/csInquiry";
		
	}
	@RequestMapping(value = "/csNotice", method = RequestMethod.GET)
	public String home(Model model) throws SQLException {
		System.out.println("mapping..");
		csService.getList(model);
		return "cs/csNotice";
	}
	@RequestMapping(value="/csFAQ")
	public String csfaq(Model model) throws SQLException {
		System.out.println("���ֹ�������");
		csService.getList(model);
		return "cs/csFAQ";
	}
	/*
	 * @RequestMapping(value="/csFAQ") public String csbtn(@RequestParam int num,
	 * Model model) throws SQLException{ csService.selectListOne(model,num); return
	 * "cs/csFAQ"; }
	 */
	
	
	
	@RequestMapping(value="/csDetail", method=RequestMethod.GET)
	public ModelAndView csdetail() throws Exception{
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("cs/csDetail");
		return mav;
	}
	
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
