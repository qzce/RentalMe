package com.me.rentalme.mp.mng.act.cotroller;

import java.sql.SQLException;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.me.rentalme.act.service.ActService;
import com.me.rentalme.model.entity.ActVo;
import com.me.rentalme.model.entity.ProductVo;


/**
* ����������(������) - �̺�Ʈ ��� ��Ʈ�ѷ�
* 
* @author Ȳ����
* @version ver1.0
* @see 
* ������� : 2019.08.14
*/
@Controller
@RequestMapping("/mp/mng")
public class MngActController {
	
	@Inject
	ActService actService;
	
	Logger log = LoggerFactory.getLogger(getClass());
	
	/**
	 * @throws SQLException 
	* �̺�Ʈ ��� 
	* 
	* @param  String code - c : �̺�Ʈ ��� ��� ��, R : �̺�Ʈ ��� ����Ʈ
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/actList", method = RequestMethod.GET)
	public ModelAndView getAct() throws SQLException{
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("actList", actService.listAct() );
		mav.setViewName("/mp/manager/mngActList");
		
		return mav;
	}
	/**
	* �̺�Ʈ ��� ��� 
	* 
	* @param  ProductVo - ��ǰ
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/actInsertPage")
	public ModelAndView addActPage() {
		log.debug("�̺�Ʈ ��� ��� ������ ��Ʈ�ѷ�");
		
	
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/mp/manager/mngActAdd");
		return mav;
	}
	/**
	* �̺�Ʈ ��� ��� 
	* 
	* @param  ProductVo - ��ǰ
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/actInsert", method = RequestMethod.POST)
	public ModelAndView addAct(ActVo actVo) {
		log.debug("�̺�Ʈ ��� ��� ��Ʈ�ѷ�");
		
	
		ModelAndView mav = new ModelAndView();
		mav.addObject("actInsert", actService);
		mav.setViewName("redirect:/mp/mng/actList");
		return mav;
	}
}
