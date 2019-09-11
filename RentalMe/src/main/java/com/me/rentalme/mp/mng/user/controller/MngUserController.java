package com.me.rentalme.mp.mng.user.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.me.rentalme.model.entity.UserVo;
import com.me.rentalme.mp.mng.service.MngService;
import com.me.rentalme.mp.user.service.MpUserService;

/**
* ����������(������) - ����ڰ���
* 
* @author Ȳ����
* @version ver1.0
* @see 
* ������� : 2019.08.14
* �������� : 2019.09.11
*/
@Controller
@RequestMapping("/mp/mng")
public class MngUserController {
	
	Logger log = LoggerFactory.getLogger(getClass());
	
	@Inject
	MngService mngService; 
	
	/**
	* ����� ����Ʈ
	* 
	* @param  None
	* @return ModelAndView 
	* @author Ȳ����
	* ������� : 2019.09.11
	*/
	@RequestMapping(value = "/userList", method = RequestMethod.GET)
	public ModelAndView getUserList() {
		log.debug("����� ����Ʈ ��Ʈ�ѷ�");
		
		//����� ����Ʈ ���� �ۼ�
		List<UserVo> userInfo =  mngService.getUserInfo();
		
		ModelAndView mav = new ModelAndView("mp/manager/mngUserList");
		mav.addObject("userInfo", userInfo);
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
