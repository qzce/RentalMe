package com.me.rentalme.rental.pay.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
* ��Ż������ - �����ϱ�
* [������Ʈ, īī������] - ���� �߰� ���� ����
* 
* @author Ȳ����
* @version ver1.0
* @see 
* ������� : 2019.08.18
*/
@Controller
@RequestMapping("/rental/pay")
public class RentalPayController {
	
	Logger log = LoggerFactory.getLogger(getClass());
	
	/**
	* īī������ ����
	* 
	* @param  
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/kakaoPay", method = RequestMethod.POST)
	public ModelAndView kakaoPay() {
		log.debug("īī������ ��Ʈ�ѷ�...");
		
		ModelAndView mav = new ModelAndView("rental/rentalAppliLgList");
		return mav;
	}	
	
}
