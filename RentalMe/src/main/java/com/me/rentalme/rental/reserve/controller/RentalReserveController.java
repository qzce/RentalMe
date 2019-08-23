package com.me.rentalme.rental.reserve.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.me.rentalme.model.entity.UserVo;

/**
* ��Ż������ - ��㿹��
* 
* @author Ȳ����
* @version ver1.0
* @see 
* ������� : 2019.08.18
*/
@Controller
@RequestMapping("/rental/reserve")
public class RentalReserveController {
	
	/**
	* ����������Ż ��㿹�� ��
	* 
	* @param  String lg
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/{lg}", method = RequestMethod.GET)
	public ModelAndView getReserveLg(@PathVariable String lg) {
		
		
		ModelAndView mav = new ModelAndView("rental/rentalReserve");
		return mav;
	}

	/**
	* ����������Ż ��㿹��
	* 
	* @param  UserVo bean
	* @param  String lg
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/{lg}", method = RequestMethod.POST)
	public ModelAndView setReserveLg(@PathVariable UserVo bean, @PathVariable String lg) {
		
		
		ModelAndView mav = new ModelAndView("rental/rentalAppliLgList");
		return mav;
	}
	
	/**
	* ����������Ż ��㿹�� ��
	* 
	* @param  String sm
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/{sm}", method = RequestMethod.GET)
	public ModelAndView setReserveSm(@PathVariable String sm) {
		
		
		ModelAndView mav = new ModelAndView("rental/rentalReserve");
		return mav;
	}
	
	/**
	* ����������Ż ��㿹��
	* 
	* @param  UserVo bean
	* @param  String sm
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/{sm}", method = RequestMethod.POST)
	public ModelAndView setReserveSm(@PathVariable UserVo bean, @PathVariable String sm) {
		
		
		ModelAndView mav = new ModelAndView("rental/rentalAppliSmList");
		return mav;
	}
	
	/**
	* �ֹ氡����Ż ��㿹�� ��
	* 
	* @param  String kitc
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/{kitc}", method = RequestMethod.GET)
	public ModelAndView getReserveKitc(@PathVariable String kitc) {
		
		
		ModelAndView mav = new ModelAndView("rental/rentalReserve");
		return mav;
	}
	
	/**
	* �ֹ氡����Ż ��㿹��
	* 
	* @param  UserVo bean
	* @param  String kitc
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/{kitc}", method = RequestMethod.POST)
	public ModelAndView setReserveKitc(@PathVariable UserVo bean, @PathVariable String kitc) {
		
		
		ModelAndView mav = new ModelAndView("rental/rentalAppliKitcList");
		return mav;
	}
	
	/**
	* ������Ż ��㿹�� ��
	* 
	* @param  String furn
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/{furn}", method = RequestMethod.GET)
	public ModelAndView getReserveFurn(@PathVariable String furn) {
		
		
		ModelAndView mav = new ModelAndView("rental/rentalReserve");
		return mav;
	}
	
	/**
	* ������Ż ��㿹��
	* 
	* @param  UserVo bean
	* @param  String furn
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/{furn}", method = RequestMethod.POST)
	public ModelAndView setReserveFurn(@PathVariable UserVo bean, @PathVariable String furn) {
		
		
		ModelAndView mav = new ModelAndView("rental/rentalAppliFurnList");
		return mav;
	}
	
	/**
	* ��Ÿ��Ż ��㿹�� ��
	* 
	* @param  String rest
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/{rest}", method = RequestMethod.GET)
	public ModelAndView getReserveRest(@PathVariable String rest) {
		
		
		ModelAndView mav = new ModelAndView("rental/rentalReserve");
		return mav;
	}
	
	/**
	* ��Ÿ��Ż ��㿹��
	* 
	* @param  UserVo bean
	* @param  String lg
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/{rest}", method = RequestMethod.POST)
	public ModelAndView setReserveRest(@PathVariable UserVo bean, @PathVariable String rest) {
		
		
		ModelAndView mav = new ModelAndView("rental/rentalAppliRestList");
		return mav;
	}
	
	/**
	* ��Ű����Ż ��㿹�� ��
	* 
	* @param  String pkg
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/{pkg}", method = RequestMethod.GET)
	public ModelAndView getReservePkg(@PathVariable String pkg) {
		
		
		ModelAndView mav = new ModelAndView("rental/rentalReserve");
		return mav;
	}
	
	/**
	* �ֹ氡����Ż ��㿹��
	* 
	* @param  UserVo bean
	* @param  String lg
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/{pkg}", method = RequestMethod.POST)
	public ModelAndView setReservePkg(@PathVariable UserVo bean, @PathVariable String pkg) {
		
		
		ModelAndView mav = new ModelAndView("rental/rentalAppliPkgList");
		return mav;
	}
}
