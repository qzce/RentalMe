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
	* ��ϵ� �ڵ������� ���̵� ã��
	* 
	* @param  String hp : �ڵ����ּ�
	* @return List 
	* @author Ȳ����
	* @exception
	* ������� : 2019-09-09 
	*/
	
	@RequestMapping(value = "/hpFindId", method = RequestMethod.POST)
	public @ResponseBody List<UserVo> findHpId(@RequestParam("hp") String hp) {
		log.debug("��ϵ� �ڵ������� ���̵� ã�� ��Ʈ�ѷ� ...");
		
		//���ŵ��� ���θ� üũ�Ѵ�.
		List<UserVo> infoList = loginFindService.checkHpYn(hp);
		
		for(UserVo info : infoList) {
			System.out.println("����� ���̵� : "+info.getUserId());
			System.out.println("����� �������� : "+info.getJoinDt());
		}

		return infoList;
	}
	
	/**
	 * ��ϵ� �̸��Ϸ� ���̵� ã��
	 * 
	 * @param  String email : �̸����ּ�
	 * @return List 
	 * @author Ȳ����
	 * @exception
	 * ������� : 2019-08-14 
	 */
	
	@RequestMapping(value = "/emailFindId", method = RequestMethod.GET)
	public @ResponseBody List<UserVo> findEmailId(@RequestParam("email") String email) {
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
	* �������� : 2019-09-27
	*/
	@RequestMapping(value = "/pwFind", method = RequestMethod.POST)
	public ModelAndView findEmailPw(@ModelAttribute UserVo userVo) {
		log.debug("��ϵ� �̸��Ϸ� ��й�ȣ ã�� ��Ʈ�ѷ�");
		
		
		//�޾ƿ� �����Ͱ� �´��� üũ
		String str = loginFindService.checkData(userVo);
		
		ModelAndView mav = new ModelAndView("login/login");
		
		if(str.equals("not empty")) {							//�̸��Ϸ� ��й�ȣ ã���� ���
						
			mav.addObject("pwMsg", "notEmpty");
			if(userVo.getEmail() != null) {
				mav.addObject("pwEmail", userVo.getEmail());
			}
			
			if(userVo.getHp() != null) {						//�ڵ������� ��й�ȣ ã���� ���
				mav.addObject("pwHp", userVo.getHp());
			}
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
