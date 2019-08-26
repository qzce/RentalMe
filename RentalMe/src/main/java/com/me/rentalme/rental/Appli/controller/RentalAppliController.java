package com.me.rentalme.rental.Appli.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.me.rentalme.model.entity.RentalAppliVo;
import com.me.rentalme.rental.Appli.service.RentalAppliService;


/**
* ��Ż������ - ����Ʈ, �󼼺���
* 
* @author Ȳ����
* @version ver1.0
* @see 
* ������� : 2019.08.17
*/
@Controller
@RequestMapping("/rental/Appli")
public class RentalAppliController {

	Logger log = LoggerFactory.getLogger(getClass());
	
	@Inject
	RentalAppliService rentalAppliService; 
	
	/**
	* ����������Ż ����Ʈ
	* 
	* @param  
	* @return String 
	* @author Ȳ�¿�
	* @exception 
	*/
	
	@RequestMapping(value = "/lg/{menu}", method = RequestMethod.GET)
	public String getLgList(@PathVariable("menu") String gdsSclassCd, RentalAppliVo rentalAppliVo, Model model) {
		rentalAppliVo.setGdsSclassCd(gdsSclassCd);
		List<RentalAppliVo> path = rentalAppliService.rentalPath(rentalAppliVo);	//	PATH ���
		List<RentalAppliVo> list1 = rentalAppliService.rentalList1(rentalAppliVo);	//	�Ҹ޴��� ����Ʈ
		List<RentalAppliVo> list2 = rentalAppliService.rentalList2(rentalAppliVo);	//	�ɼ� �귣��� ����Ʈ
		
		model.addAttribute("path", path);
		model.addAttribute("list1", list1);
		model.addAttribute("list2", list2);
		return "rental/rentalAppliLgList";
	}
	
	/**
	 * ����������Ż �󼼺���
	 * 
	 * @param  int idx
	 * @return ModelAndView 
	 * @author Ȳ����
	 * @exception 
	 */
	/*
	@RequestMapping(value = "/lg/{idx}", method = RequestMethod.GET)
	public ModelAndView getLgDeatail(@PathVariable("idx") int idx) {
		log.debug("����������Ż �󼼺��� ��Ʈ�ѷ�...");
		
		ModelAndView mav = new ModelAndView("rental/rentalDetail");
		return mav;
	}
	*/
	
	/**
	 * ����������Ż ����Ʈ
	 * 
	 * @param  
	 * @return ModelAndView 
	 * @author Ȳ����
	 * @exception 
	 */
	@RequestMapping(value = "/sm", method = RequestMethod.GET)
	public ModelAndView getSmList() {
		log.debug("����������Ż ����Ʈ ��Ʈ�ѷ�...");
		
		ModelAndView mav = new ModelAndView("rental/rentalAppliSmList");
		return mav;
	}	
	
	/**
	 * ����������Ż �󼼺���
	 * 
	 * @param  int idx
	 * @return ModelAndView 
	 * @author Ȳ����
	 * @exception 
	 */
	@RequestMapping(value = "/sm/{idx}", method = RequestMethod.GET)
	public ModelAndView getSmDeatail(@PathVariable("idx") int idx) {
		log.debug("����������Ż �󼼺��� ��Ʈ�ѷ�...");
		
		ModelAndView mav = new ModelAndView("rental/rentalDetail");
		return mav;
	}	
	
	/**
	* �ֹ氡�� ����Ʈ
	* 
	* @param  
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/kitc", method = RequestMethod.GET)
	public ModelAndView getKitcList() {
		log.debug("�ֹ氡����Ż ����Ʈ ��Ʈ�ѷ�...");
		
		ModelAndView mav = new ModelAndView("rental/rentalAppliKitcList");
		return mav;
	}	
	
	/**
	 * �ֹ氡�� �󼼺���
	 * 
	 * @param  int idx
	 * @return ModelAndView 
	 * @author Ȳ����
	 * @exception 
	 */
	@RequestMapping(value = "/kitc/{idx}", method = RequestMethod.GET)
	public ModelAndView getKitcDeatail(@PathVariable("idx") int idx) {
		log.debug("�ֹ氡����Ż �󼼺��� ��Ʈ�ѷ�...");
		
		ModelAndView mav = new ModelAndView("rental/rentalDetail");
		return mav;
	}
	
	/**
	* ������Ż ����Ʈ
	* 
	* @param  
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/furn", method = RequestMethod.GET)
	public ModelAndView getFurnList() {
		log.debug("������Ż ����Ʈ ��Ʈ�ѷ�...");
		
		ModelAndView mav = new ModelAndView("rental/rentalAppliFurnList");
		return mav;
	}	
	
	/**
	 * ������Ż �󼼺���
	 * 
	 * @param  int idx
	 * @return ModelAndView 
	 * @author Ȳ����
	 * @exception 
	 */
	@RequestMapping(value = "/furn/{idx}", method = RequestMethod.GET)
	public ModelAndView getFurnDeatail(@PathVariable("idx") int idx) {
		log.debug("������Ż �󼼺��� ��Ʈ�ѷ�...");
		
		ModelAndView mav = new ModelAndView("rental/rentalDetail");
		return mav;
	}
	
	/**
	* ��Ÿ��Ż ����Ʈ
	* 
	* @param  
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/rest", method = RequestMethod.GET)
	public ModelAndView getRestList() {
		log.debug("��Ÿ��Ż ����Ʈ ��Ʈ�ѷ�...");
		
		ModelAndView mav = new ModelAndView("rental/rentalAppliRestList");
		return mav;
	}	
	
	/**
	 * ��Ÿ��Ż �󼼺���
	 * 
	 * @param  int idx
	 * @return ModelAndView 
	 * @author Ȳ����
	 * @exception 
	 */
	@RequestMapping(value = "/rest/{idx}", method = RequestMethod.GET)
	public ModelAndView getRestDeatail(@PathVariable("idx") int idx) {
		log.debug("��Ÿ��Ż �󼼺��� ��Ʈ�ѷ�...");
		
		ModelAndView mav = new ModelAndView("rental/rentalDetail");
		return mav;
	}
	
	/**
	* ��Ű����Ż ����Ʈ
	* 
	* @param  
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/pkg", method = RequestMethod.GET)
	public ModelAndView getPkgList() {
		log.debug("��Ű����Ż ����Ʈ ��Ʈ�ѷ�...");
		
		ModelAndView mav = new ModelAndView("rental/rentalAppliPkgList");
		return mav;
	}	
	
	/**
	 * ��Ű����Ż �󼼺���
	 * 
	 * @param  int idx
	 * @return ModelAndView 
	 * @author Ȳ����
	 * @exception 
	 */
	@RequestMapping(value = "/pkg/{idx}", method = RequestMethod.GET)
	public ModelAndView getPkgDeatail(@PathVariable("idx") int idx) {
		log.debug("��Ű����Ż �󼼺��� ��Ʈ�ѷ�...");
		
		ModelAndView mav = new ModelAndView("rental/rentalDetail");
		return mav;
	}
	
	
}
