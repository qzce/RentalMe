package com.me.rentalme.mp.user.controller;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.me.rentalme.model.entity.CallVo;
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
	 * @throws SQLException 
	* �ֹ�����
	* 
	* @param  
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getOrderList() throws SQLException {
		log.debug("�ֹ����� ����Ʈ ��Ʈ�ѷ�...");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("alist",mpUserService.ordList());
		mav.setViewName("mp/user/userOrdList");
		
		return mav;
	}
	
	/**
	 * @throws SQLException 
	* ��ٱ���
	* 
	* @param  
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public ModelAndView getCartList() throws SQLException {
		log.debug("��ٱ��� ��Ʈ�ѷ�...");
		
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("alist",mpUserService.cartList());
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
		//log.debug("���ѻ�ǰ ��Ʈ�ѷ�...");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("alist", mpUserService.wishList());
		mav.setViewName("mp/user/userWishList");
		return mav;
	}
	
	/**
	 * @throws SQLException 
	* ���� ��ǰ ���� (�ʹ� �����......����)
	* 
	* @param  
	* @return ModelAndView 
	* @author ������
	* @exception 
	*/
//	@RequestMapping(value = "/wish/delete", method = RequestMethod.POST)
//	public int deleTeWish(HttpSession session, @RequestParam(value="checkRow[]") List<String> chArr, CallVo callVo) throws Exception{
//		
//		log.debug("delete wish");
//		
//		int result=0;
//		String usedGdsNo = "";
//		
//		for(String i : chArr) {
//			callVo.setUsedGdsNo(usedGdsNo);
//			mpUserService.deleteWish(callVo);
//		}
//		
//		result=1;
//		return result;
//	}
	
//	@RequestMapping(value = "/wish/delete", method = RequestMethod.POST)
//	public String deleteWish(@PathVariable("used")) {
//		
//		return null;
//		
//	}
//	
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
