package com.me.rentalme.mp.mng.cs.cotroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.me.rentalme.model.entity.ProductVo;


/**
* ������ ��Ʈ�ѷ� - ����/FAQ, 1:1����
* 
* @author Ȳ����
* @version ver1.0
* @see 
* ������� : 2019.08.14
*/
@Controller
@RequestMapping("/mp/mng")
public class MngCsController {

	Logger log = LoggerFactory.getLogger(getClass());
	
	/**
	* ����/FAQ 
	* 
	* @param  String code - c : ����/FAQ ��� ��, R : ����/FAQ ����Ʈ
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/cs", method = RequestMethod.GET)
	public ModelAndView getCs(String code) {
		log.debug("����/FAQ ��Ʈ�ѷ�");
		
		ModelAndView mav = new ModelAndView();
		if(code.equals("R")) {
			//R : ����/FAQ ����Ʈ ���� �ۼ�
			
		}else if(code.equals("C")) {
			//C : ����/FAQ ��� ��
			return new ModelAndView("/mp/manager/mngCsAdd");
		}
		mav.setViewName("/mp/manager/mngCsList");
		return mav;
	}

	/**
	*  ����/FAQ ���
	* 
	* @param  ProductVo - ��ǰ
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/cs", method = RequestMethod.POST)
	public ModelAndView addCs(ProductVo bean) {
		log.debug("����/FAQ ��� ��Ʈ�ѷ�");
		
		//����/FAQ ��� ���� �ۼ�
		
		ModelAndView mav = new ModelAndView("redirect:/mp/mng/cs");
		return mav;
	}
	
	/**
	* 1:1 ����
	* 
	* @param  String code - c : 1:1���� ��� ��, R : 1:1���� ����Ʈ
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/csQuest", method = RequestMethod.GET)
	public ModelAndView getCsQuest(String code) {
		log.debug("1:1���� ����Ʈ ��Ʈ�ѷ�");
		
		ModelAndView mav = new ModelAndView();
		if(code.equals("R")) {
			//R : 1:1���� ����Ʈ ���� �ۼ�
			
		}else if(code.equals("C")) {
			//C : 1:1���� ��� ��
			return new ModelAndView("/mp/manager/mngCsQuestAdd");
		}
		mav.setViewName("/mp/manager/mngCsQuestList");
		return mav;
	}

	/**
	* 1:1 ���� ���  
	* 
	* @param  ProductVo - ��ǰ
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/csQuest", method = RequestMethod.POST)
	public ModelAndView addCsQuest(ProductVo bean) {
		log.debug("1:1���� ��� ��Ʈ�ѷ�");
		
		//1:1���� ��� ���� �ۼ�
		
		ModelAndView mav = new ModelAndView("redirect:/mp/mng/csQuest");
		return mav;
	}
	
}
