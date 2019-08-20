package com.me.rentalme.mp.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.me.rentalme.model.entity.UserVo;

/**
* ���������� ��Ʈ�ѷ�
* 
* @author Ȳ����
* @version ver1.0
* @see 
* ������� : 2019.08.14
*/
@Controller
public class UserController {
	
	Logger log = LoggerFactory.getLogger(getClass());
	
	/**
	* �ֹ�����
	* 
	* @param  
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/mp/", method = RequestMethod.GET)
	public ModelAndView getOrderList() {
		log.debug("�ֹ����� ����Ʈ ��Ʈ�ѷ�...");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mp/user/userOrdList");
		
		return mav;
	}
	
	/**
	* ��ٱ���
	* 
	* @param  
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/mp/cart", method = RequestMethod.GET)
	public ModelAndView getCartList() {
		log.debug("��ٱ��� ��Ʈ�ѷ�...");
		
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mp/user/userCartList");
		return mav;
	}	
	
	/**
	* ���� ��ǰ
	* 
	* @param  
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/mp/wish", method = RequestMethod.GET)
	public ModelAndView getWishList() {
		log.debug("���ѻ�ǰ ��Ʈ�ѷ�...");
	
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mp/user/userWishList");
		return mav;
	}
	
	/**
	* ��ġ��
	* 
	* @param  
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/mp/deposit", method = RequestMethod.GET)
	public ModelAndView getDeposit() {
		log.debug("��ġ�� ��Ʈ�ѷ�...");
	
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mp/user/userDeposit");
		return mav;
	}	
	
	/**
	* �� ���� ���� ��
	* 
	* @param  
	* @return String 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/mp/updInfo", method = RequestMethod.GET)
	public String modifyInfo() {
		log.debug("�� ���� ���� �� ��Ʈ�ѷ�...");
	
		return "mp/user/userUpdInfo";
	}
	
	/**
	* �� ���� ����
	* 
	* @param  UserVo
	* @return String 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/mp/updInfo", method = RequestMethod.PUT)
	public String modifyInfo(UserVo bean) {
		log.debug("�� ���� ���� ��Ʈ�ѷ�...");
	
		return "mp/user/userUpdInfo";
	}
	
	/**
	* �� ���� ����
	* 
	* @param  
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/mp/quest", method = RequestMethod.GET)
	public ModelAndView getQuestList() {
		log.debug("�� ���� ���� ��Ʈ�ѷ�...");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mp/user/userQuestList");
		return mav;
	}
	
	/**
	* ���� �߰� ����
	* 
	* @param  
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/mp/used", method = RequestMethod.GET)
	public ModelAndView getUsedList() {
		log.debug("���� �߰� ���� ��Ʈ�ѷ�...");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mp/user/userMyUsedList");
		return mav;
	}
	
	/**
	* �ŷ�����
	* 
	* @param  
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/mp/act", method = RequestMethod.GET)
	public ModelAndView getActList() {
		log.debug("�� ���� ���� ��Ʈ�ѷ�...");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mp/user/userActList");
		return mav;
	}

}
