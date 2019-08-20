package com.me.rentalme.mp.mng.act.cotroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.me.rentalme.model.entity.ProductVo;


/**
* ����������(������) - �̺�Ʈ ��� ��Ʈ�ѷ�
* 
* @author Ȳ����
* @version ver1.0
* @see 
* ������� : 2019.08.14
*/
@Controller
@RequestMapping("/mp/mng")
public class MngActController {
	
	Logger log = LoggerFactory.getLogger(getClass());
	
	/**
	* �̺�Ʈ ��� 
	* 
	* @param  String code - c : �̺�Ʈ ��� ��� ��, R : �̺�Ʈ ��� ����Ʈ
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/act", method = RequestMethod.GET)
	public ModelAndView getAct(String code) {
		log.debug("�̺�Ʈ ��� ��Ʈ�ѷ�");
		
		ModelAndView mav = new ModelAndView();
		if(code.equals("R")) {
			//R : �̺�Ʈ ��� ����Ʈ ���� �ۼ�
			
		}else if(code.equals("C")) {
			//C : �̺�Ʈ ��� ��� ��
			return new ModelAndView("/mp/manager/mngActAdd");
		}
		mav.setViewName("/mp/manager/mngActList");
		return mav;
	}

	/**
	* �̺�Ʈ ��� ��� 
	* 
	* @param  ProductVo - ��ǰ
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/act", method = RequestMethod.POST)
	public ModelAndView addAct(ProductVo bean) {
		log.debug("�̺�Ʈ ��� ��� ��Ʈ�ѷ�");
		
		//�̺�Ʈ ��� ���� �ۼ�
		
		ModelAndView mav = new ModelAndView("redirect:/mp/mng/act");
		return mav;
	}

}
