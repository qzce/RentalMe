package com.me.rentalme.mp.user.controller;

import java.sql.SQLException;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.me.rentalme.model.entity.UserVo;
import com.me.rentalme.mp.user.service.MpUserService;
import com.me.rentalme.mp.user.service.MpUserServiceImpl;

/**
* ���������� ��Ʈ�ѷ�
* 
* @author Ȳ����
* @version ver1.0
* @see 
* ������� : 2019.08.14
*/
@Controller
@RequestMapping("/mp")
public class UserController {
	
	Logger log = LoggerFactory.getLogger(getClass());
	
	@Inject
	MpUserService mpUserService;
	
	/**
	* �ֹ�����
	* 
	* @param  
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/", method = RequestMethod.GET)
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
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public ModelAndView getCartList() {
		log.debug("��ٱ��� ��Ʈ�ѷ�...");
		
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mp/user/userCartList");
		return mav;
	}	
	
	/**
	 * @throws SQLException 
	* ���� ��ǰ
	* 
	* @param  
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/wish", method = RequestMethod.GET)
	public ModelAndView getWishList(Model model) throws SQLException {
		log.debug("���ѻ�ǰ ��Ʈ�ѷ�...");
		
		
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("alist", mpUserService.list());
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
	@RequestMapping(value = "/deposit", method = RequestMethod.GET)
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
	@RequestMapping(value = "/updInfo", method = RequestMethod.GET)
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
	@RequestMapping(value = "/updInfo", method = RequestMethod.PUT)
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
	@RequestMapping(value = "/used", method = RequestMethod.GET)
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
	@RequestMapping(value = "/act", method = RequestMethod.GET)
	public ModelAndView getActList() {
		log.debug("�� ���� ���� ��Ʈ�ѷ�...");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mp/user/userActList");
		return mav;
	}

}
