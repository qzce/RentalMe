package com.me.rentalme.mp.mng.user.controller;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.me.rentalme.common.Paging;
import com.me.rentalme.cs.entity.CsVo;
import com.me.rentalme.cs.service.CsService;
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
	
	@Inject
	CsService csService;
	
	@Inject
	MpUserService mpUserService;
	
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
		
		
		//����� ����Ʈ ����
		List<UserVo> userInfo =  mngService.getUserInfo();
		
		ModelAndView mav = new ModelAndView("mp/manager/mngUserList");
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
	 * @throws SQLException �� ���� ��
	 * 
	 * @param @return ModelAndView @author ���μ� @exception
	 */
	@RequestMapping(value = "/questDetail")
	public ModelAndView myQuestDetail(HttpSession session, CsVo csVo,@RequestParam("pquestNo") String pquestNo) throws SQLException {
		
		ModelAndView mav = new ModelAndView();
		String user = (String) session.getAttribute("loginUserId");
		String mbNo = (String) session.getAttribute("loginMbNo");
		UserVo userVo = csService.userLevel(mbNo);
		String userLevel = userVo.getLevelGbCd();
		System.out.println(userLevel);
		csVo.setPquestNo(pquestNo);
		
		csService.selectReply(csVo.getPquestNo());
		System.out.println("�����..."+csVo.getReplyContent());
		mav.addObject("levelGbCd",userLevel);
		mav.addObject("bean", mpUserService.myInqDetail(csVo));
		mav.addObject("reply", csService.selectReply(csVo.getPquestNo()));
		mav.addObject("id", user);
		mav.setViewName("mp/manager/mngQuestDetail");
		return mav;
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
