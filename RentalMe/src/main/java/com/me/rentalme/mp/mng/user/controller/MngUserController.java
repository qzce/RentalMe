package com.me.rentalme.mp.mng.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
* ����������(������) - ����ڰ���
* 
* @author Ȳ����
* @version ver1.0
* @see 
* ������� : 2019.08.14
*/
@Controller
@RequestMapping("/mp/mng")
public class MngUserController {
	
	Logger log = LoggerFactory.getLogger(getClass());
	
	/**
	* ����� ����Ʈ
	* 
	* @param  
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ModelAndView getUserList() {
		log.debug("����� ����Ʈ ��Ʈ�ѷ�");
		
		//����� ����Ʈ ���� �ۼ�
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mp/manager/mngUserList");
		return mav;
	}

	/**
	* ����� ������
	* 
	* @param  String memNo - ȸ����ȣ
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/act/{memNo}", method = RequestMethod.GET)
	public ModelAndView getUserDetail(@PathVariable("memNo") String memNo) {
		log.debug("����� ������ ��Ʈ�ѷ�");
		
		//����� ������ ���� �ۼ�
		
		
		ModelAndView mav = new ModelAndView("mp/manager/mngUserDetail");
		return mav;
	}

}
