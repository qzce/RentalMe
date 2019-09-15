package com.me.rentalme.mp.mng.user.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.me.rentalme.common.Paging;
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
	
	String path= "/mp/mng";
	
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
	public ModelAndView getUserList(@RequestParam(required = false, defaultValue = "1")int page, @RequestParam(required = false, defaultValue = "1")int range) {
		log.debug("����� ����Ʈ ��Ʈ�ѷ�");
		
		
		int totalUserCnt = mngService.getMngUserListCnt(); 
				
		Paging mngUserPage = new Paging();
		
		mngUserPage.pageInfo(page, range, totalUserCnt);
		
		
		//����� ����Ʈ ����
		List<UserVo> userInfo =  mngService.getUserInfo(mngUserPage);
		
		ModelAndView mav = new ModelAndView("mp/manager/mngUserList");
		mav.addObject("path", path+"/userList");
		mav.addObject("paging", mngUserPage);
		mav.addObject("userInfo", userInfo);
		return mav;
	}

	/**
	* ����� ������
	* 
	* @param  String mbNo - ȸ����ȣ
	* @return UserVo 
	* @author Ȳ����
	* ������� : 2019-09-15
	*/
	@RequestMapping(value = "UserDetail", method = RequestMethod.POST)
	public @ResponseBody UserVo getUserDetail(@RequestParam String mbNo) {
		log.debug("����� ������ ��Ʈ�ѷ�");
		
		//����� ������ ���� �ۼ�
		UserVo userVo = mngService.getUserDetail(mbNo);
		
				
		return userVo;
	}
	
	/**
	* ����� Ż���ϱ�
	* (�̽����� : id�� primarykey�� ��� �ֱ� ������ ''�� ������Ʈ �� Ű�ߺ� ������ ��)
	* @param  String mbNo - ȸ����ȣ
	* @return String  
	* @author Ȳ����
	* ������� : 2019-09-15
	* 
	*/	
	@RequestMapping(value="/userLeave", method = RequestMethod.POST)
	public @ResponseBody String removeUserLeave(@RequestParam String mbNo) {
		log.debug("����� Ż���ϱ�");
		
		//����� Ż���ϱ�
		String msg = mngService.delUserInfo(mbNo);
		
		return msg;
	}

}
