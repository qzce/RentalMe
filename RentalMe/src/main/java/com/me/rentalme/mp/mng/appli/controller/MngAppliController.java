package com.me.rentalme.mp.mng.appli.controller;

import java.sql.SQLException;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
* ����������(������) ����Ʈ ��Ʈ�ѷ�
* 
* @author Ȳ����
* @version ver1.0 
* ������� : 2019.08.14
*/
@Controller
@RequestMapping("/mp")
public class MngAppliController {
	@Inject
	com.me.rentalme.mp.mng.service.MngService MngService;
	
	Logger log = LoggerFactory.getLogger(getClass());

	
	/**
	 * @throws SQLException 
	* ����������(������) - ���� ����Ʈ
	* 
	* @param  
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/mng/goodsList",method = RequestMethod.GET)
	public ModelAndView getMainList() throws SQLException {
		log.debug("����������(������) ���� ��Ʈ�ѷ�");
	
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("rlist", MngService.selectGoodsList());
		mav.setViewName("mp/manager/mngMainList");
		return mav;
	}
	
	/**
	* ����������(������) - �������� ����Ʈ
	* 
	* @param  
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/mng/Appli/lg", method = RequestMethod.GET)
	public ModelAndView getLgList() {
		log.debug("�������� ����Ʈ ��Ʈ�ѷ�");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mp/manager/mngAppliLgList");
		return mav;
	}
	
	/**
	* ����������(������) - �������� ����Ʈ
	* 
	* @param  
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/mng/Appli/sm", method = RequestMethod.GET)
	public ModelAndView getSmList() {
		log.debug("�������� ����Ʈ ��Ʈ�ѷ�");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mp/manager/mngAppliSmList");
		return mav;
	}
	
	/**
	*  ����������(������) - �ֹ��ǰ ����Ʈ
	* 
	* @param  
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/mng/Appli/kitc", method = RequestMethod.GET)
	public ModelAndView getKitcList() {
		log.debug("�ֹ� ����Ʈ ��Ʈ�ѷ�");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mp/manager/mngAppliKitcList");
		return mav;
	}
	
	/**
	*  ����������(������) - ���� ����Ʈ
	* 
	* @param  
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/mng/Appli/furn", method = RequestMethod.GET)
	public ModelAndView getFurnList() {
		log.debug("���� ����Ʈ ��Ʈ�ѷ�");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mp/manager/mngAppliFurnList");
		return mav;
	}
	
	/**
	*  ����������(������) - ��Ÿ ����Ʈ
	* 
	* @param  
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/mng/Appli/rest", method = RequestMethod.GET)
	public ModelAndView getRestList() {
		log.debug("��Ÿ ����Ʈ ��Ʈ�ѷ�");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mp/manager/mngAppliRestList");
		return mav;
	}
	
	/**
	*  ����������(������) - ��Ű�� ����Ʈ
	* 
	* @param  
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/mng/Appli/pkg", method = RequestMethod.GET)
	public ModelAndView getPkgList() {
		log.debug("��Ű�� ����Ʈ ��Ʈ�ѷ�");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mp/manager/mngAppliPkgList");
		return mav;
	}

	
}
