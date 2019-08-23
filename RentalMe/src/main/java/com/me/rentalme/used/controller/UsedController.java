package com.me.rentalme.used.controller;

import java.sql.SQLException;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.me.rentalme.model.entity.UsedVo;
import com.me.rentalme.used.service.UsedService;


/**
* �߰�ŷ� ��Ʈ�ѷ�
* 
* @author Ȳ����
* @version ver1.0
* @see 
* ������� : 2019.08.18
*/
@Controller
@RequestMapping("/used")
public class UsedController {

	Logger log = LoggerFactory.getLogger(getClass());
	
	@Inject
	UsedService usedService;
	/**
	 * @throws SQLException 
	* �߰�ŷ� ����Ʈ
	* 
	* @param  None
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getUsedList(Model model) throws SQLException {
		
		log.debug("�߰�ŷ� ��Ʈ�ѷ�");
		UsedVo bean=new UsedVo();
		bean.setMODEL_NM("");
		bean.setGDS_MCLASS_CD("10");
		model.addAttribute("alist1", usedService.oneList(bean));
		bean.setGDS_MCLASS_CD("20");
		model.addAttribute("alist2", usedService.oneList(bean));
		bean.setGDS_MCLASS_CD("30");
		model.addAttribute("alist3", usedService.oneList(bean));
		bean.setGDS_MCLASS_CD("40");
		model.addAttribute("alist4", usedService.oneList(bean));
		bean.setGDS_MCLASS_CD("50");
		model.addAttribute("alist5", usedService.oneList(bean));
		
		return "used/usedList";
	}
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String getUsedListNM(Model model,@RequestParam("MODEL_NM") String MODEL_NM) throws SQLException {
		
		log.debug("�߰�ŷ� ��Ʈ�ѷ�");
		UsedVo bean=new UsedVo();
		if(MODEL_NM==null) {
			MODEL_NM="";
		}
		bean.setMODEL_NM(MODEL_NM);
		bean.setGDS_MCLASS_CD("10");
		model.addAttribute("alist1", usedService.oneList(bean));
		bean.setGDS_MCLASS_CD("20");
		model.addAttribute("alist2", usedService.oneList(bean));
		bean.setGDS_MCLASS_CD("30");
		model.addAttribute("alist3", usedService.oneList(bean));
		bean.setGDS_MCLASS_CD("40");
		model.addAttribute("alist4", usedService.oneList(bean));
		bean.setGDS_MCLASS_CD("50");
		model.addAttribute("alist5", usedService.oneList(bean));
		
		return "used/usedList";
	}

	/**
	* �߰�ŷ� �󼼺���
	* 
	* @param  int idx
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/detail/{idx}", method = RequestMethod.GET)
	public ModelAndView getUsedDetail(@PathVariable("idx") int idx) {
		
		
		ModelAndView mav = new ModelAndView("used/usedDetail");
		return mav;
	}
	
	/**
	* ���� �߰���� ����Ʈ
	* 
	* @param  None
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/store", method = RequestMethod.GET)
	public ModelAndView getUsedMyStroe() {
		
		
		ModelAndView mav = new ModelAndView("used/usedMyStore");
		return mav;
	}
	
	/**
	* �߰�ŷ� ��ǰ��� ��
	* 
	* @param  None
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/mng", method = RequestMethod.GET)
	public ModelAndView getUsedPrd() {
		
		
		ModelAndView mav = new ModelAndView("used/usedMng");
		return mav;
	}
	
	/**
	 * @throws SQLException 
	* �߰�ŷ� ��ǰ��� 
	* 
	* @param  None
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/mng", method = RequestMethod.POST)
	public ModelAndView addUsedPrd(UsedVo bean) throws SQLException {
		
		// ������ 1����
		usedService.seqUp();
		usedService.addUsed(bean);
		
		ModelAndView mav = new ModelAndView("used/usedMyStore");
		return mav;
	}
	
	/**
	 * �߰�ŷ� ��ǰ����
	 * 
	 * @param  None
	 * @return ModelAndView 
	 * @author Ȳ����
	 * @exception 
	 */
	@RequestMapping(value = "/mng", method = RequestMethod.PUT)
	public ModelAndView modifyUsedPrd() {
		
		
		ModelAndView mav = new ModelAndView("used/usedMyStore");
		return mav;
	}

}
