package com.me.rentalme.mp.mng.controller;

import java.sql.SQLException;
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

import com.me.rentalme.mp.mng.service.MngService;

@Controller
@RequestMapping("/mp/mng/cart")
public class MngReturnController {
	
	Logger log = LoggerFactory.getLogger(getClass());
	
	@Inject
	MngService mngService;
	
	
	/**
	 * @throws SQLException 
	* ��ǰ����
	* 
	* @param  
	* @return String 
	* @author ����ȯ
	* @exception 
	*/
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getMngReturnList(Model model) throws SQLException {
		model.addAttribute("sub", "��ǰ");
		model.addAttribute("alist", mngService.selectReturn());
		
		return "mp/manager/mngOrdList";
	}
	
	/**
	 * @throws SQLException 
	 * ��ǰȮ������ �ٲٱ�
	 * 
	 * @param  
	 * @return String 
	 * @author ����ȯ
	 * @exception 
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String getMngReturnStsUdt(@RequestParam(value = "odrNo") String odrNo) throws SQLException {
		String[] array;
		array=odrNo.split(",");
		
		for(int i=0; i<array.length; i++) {
			mngService.updateStsRtn(array[i]);
		}
		
		return "redirect:/mp/mng/cart";
	}

}
