package com.me.rentalme.mp.mng.decl.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
* �Ű����� ��Ʈ�ѷ�
* 
* @author Ȳ����
* @version ver1.0
* @see 
* ������� : 2019.08.14
*/
@Controller
public class MngDeclController {
	
	Logger log = LoggerFactory.getLogger(getClass());

	/**
	* �Ű����� ����Ʈ
	* 
	* @param  
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/mp/mng/decl", method = RequestMethod.GET)
	public ModelAndView getDeclList() {
		log.debug("�Ű����� ����Ʈ ��Ʈ�ѷ�...");
	
		ModelAndView mav = new ModelAndView("/mp/manager/mngDeclList");
		return mav;
	}
}
