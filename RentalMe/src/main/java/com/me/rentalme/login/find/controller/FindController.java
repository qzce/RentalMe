package com.me.rentalme.login.find.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.me.rentalme.login.find.service.LoginFindService;
import com.me.rentalme.model.entity.UserVo;

/**
* ���̵�, ��й�ȣ ã�� ��Ʈ�ѷ�
* 
* @author Ȳ����
* @version ver1.0
* @see 
* ������� : 2019.08.14
*/
@Controller
public class FindController {
	
	Logger log = LoggerFactory.getLogger(getClass());
	
	@Inject
	LoginFindService loginFindService; 
	
	/**
	* ��ϵ� �̸��Ϸ� ���̵� ã��
	* 
	* @param  String email : �̸����ּ�
	* @return String 
	* @author Ȳ����
	* @exception
	* ������� : 2019-08-14 
	*/
	
	@RequestMapping(value = "/emailFindId", method = RequestMethod.GET)
	public @ResponseBody List<UserVo> findEmailId(@RequestParam("email") String email, Model model) {
		log.debug("��ϵ� �̸��Ϸ� ���̵� ã�� ��Ʈ�ѷ� ...");
		
		
		//����� �̸��Ϸ� ����� ������ ������´�.
		List<UserVo> infoList = loginFindService.getId(email);

		return infoList;
		
	}
	
	/**
	* ��й�ȣ ã�� ������ üũ
	* 
	* @param  UserVo
	* @return String 
	* @author Ȳ����
	* @exception
	* ������� : 2019-09-04 
	*/
	@RequestMapping(value = "/pwFind", method = RequestMethod.GET)
	public ModelAndView findEmailPw(@ModelAttribute UserVo userVo) {
		log.debug("��ϵ� �̸��Ϸ� ��й�ȣ ã�� ��Ʈ�ѷ�");
		
		//�޾ƿ� �����Ͱ� �´��� üũ
		String str = loginFindService.checkData(userVo);
		
		ModelAndView mav = new ModelAndView("login/login");
		
		if(str.equals("not empty")) {
			mav.addObject("pwMsg", "notEmpty");
			mav.addObject("pwEmail", userVo.getEmail());
			mav.addObject("pwId", userVo.getUserId());
		}else if(str.equals("empty")) {
			mav.addObject("pwMsg", "empty");
		}
		
		return mav;
	}
	
	/**
	* ��й�ȣ ����
	* 
	* @param  String userPw	- ��й�ȣ
	* @return String 
	* @author Ȳ����
	* @exception
	* ������� : 2019-08-14 
	*/
	@RequestMapping(value = "/changePw", method = RequestMethod.POST)
	public String modifyChgPw(@ModelAttribute UserVo userVo) {
		log.debug("��й�ȣ ���� ��Ʈ�ѷ�...");
		
		loginFindService.modifyPw(userVo);
		
		return "redirect:/login";
	}
	
}
