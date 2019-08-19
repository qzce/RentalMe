package com.me.rentalme.mp.mng.rental.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
* ����������(������) ��� ��Ʈ�ѷ�
* 
* @author Ȳ����
* @version ver1.0 
* ������� : 2019.08.14
*/
@Controller
@RequestMapping("/mp")
public class MngRentalController {

	Logger log = LoggerFactory.getLogger(getClass());
	
	/**
	* ����������(������) - ��ǰ��� ��
	* 
	* @param  
	* @return String 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/mng/", method = RequestMethod.GET)
	public String getPrdRegisterForm() {
		log.debug("����������(������) ��ǰ ��� �� ��Ʈ�ѷ�");
		
		return "mp/manager/mngRentalAdd";
	}
	
	/**
	* ����������(������) - ��ǰ��� 
	* 
	* @param  String prdDiv - �ߺз�
	* @return ModelAndView
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/mng/rental/{prdDiv}", method = RequestMethod.POST)
	public ModelAndView getRentalList(@PathVariable String prdDiv) {
		log.debug("����������(������) ��ǰ ��� ��Ʈ�ѷ�");
		
		//���� ���
		if(prdDiv.equals("lg")) {
			//�������� ��� ���� �ۼ�
		}else if(prdDiv.equals("sm")) {
			//�������� ��� ���� �ۼ�
		}else if(prdDiv.equals("kitc")) {
			//�ֹ��ǰ ��� ���� �ۼ�
		}else if(prdDiv.equals("furn")) {
			//���� ��� ���� �ۼ�
		}else if(prdDiv.equals("rest")) {
			//��Ÿ ��� ���� �ۼ�
		}else if(prdDiv.equals("pkg")) {
			//��Ű�� ��� ���� �ۼ�
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mp/manager/mngMainList");
		return mav;
	}
}
