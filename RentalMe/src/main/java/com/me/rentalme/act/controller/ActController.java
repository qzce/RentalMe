package com.me.rentalme.act.controller;

import java.sql.SQLException;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.me.rentalme.act.service.ActService;



/**
* �̺�Ʈ ��� ��Ʈ�ѷ�
* 
* @author ������
* @version ver1.0
* @see 
* ������� : 2019.09.04
*/
@Controller
@RequestMapping("/act")
public class ActController {
	Logger log = LoggerFactory.getLogger(getClass());
	
	@Inject
	ActService actService;
	
	
	/**
	* �̺�Ʈ ��� ����Ʈ
	* 
	* @param  None
	* @return ModelAndView 
	* @author ������
	* @exception 
	*/
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView getActList() throws SQLException{
		
		
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("alist", actService.actList());
		mav.addObject("alist2",actService.actEndList());
				
		mav.setViewName("act/actList");
		return mav;
	}
	
	/**
	* �̺�Ʈ ��� �󼼺���
	* 
	* @param  None
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value="/{idx}", method=RequestMethod.GET)
	public ModelAndView getActDetail(@PathVariable int idx) {
		
		
		ModelAndView mav = new ModelAndView();
		
		
		mav.setViewName("act/actDetail");
		return mav;
	}
	
	/**
	* �̺�Ʈ ��� �󼼼���
	* 
	* @param  None
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value="/gds/{idx}", method=RequestMethod.GET)
	public ModelAndView getDiscript(@PathVariable int idx) {
		
		
		ModelAndView mav = new ModelAndView("act/actGdsDetail");
		return mav;
	}
	
	
	/**
	* �̺�Ʈ ��� ������� - ��Ʈ�ѷ� ���� ��� ����
	* 
	* @param  None
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	
	
}
