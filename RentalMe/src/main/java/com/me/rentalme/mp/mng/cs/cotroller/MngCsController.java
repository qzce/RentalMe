package com.me.rentalme.mp.mng.cs.cotroller;

import java.sql.SQLException;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.me.rentalme.cs.entity.CsVo;
import com.me.rentalme.cs.service.CsService;
import com.me.rentalme.model.entity.ProductVo;


/**
* ������ ��Ʈ�ѷ� - ����/FAQ, 1:1����
* 
* @author Ȳ����
* @version ver1.0
* @see 
* ������� : 2019.08.14
*/
@Controller
@RequestMapping("/mp/mng")
public class MngCsController {

	@Inject
	CsService csService;
	
	Logger log = LoggerFactory.getLogger(getClass());
	
	/**
	 * @throws SQLException 
	* ����/FAQ 
	* 
	* @param  String code - c : ����/FAQ ��� ��, R : ����/FAQ ����Ʈ
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/csNoticeList", method = RequestMethod.GET)
	public ModelAndView getCsNotice() throws SQLException {
		log.debug("����/FAQ ��Ʈ�ѷ�");
		
		ModelAndView mav = new ModelAndView();
		
		System.out.println("mapping..");
		mav.addObject("alist", csService.csNoticeList());
		
		mav.setViewName("/mp/manager/mngCsList");
		return mav;
	}
	
	@RequestMapping(value = "/csFaqList", method = RequestMethod.GET)
	public ModelAndView getCsFaq() throws SQLException {
		log.debug("����/FAQ ��Ʈ�ѷ�");
		
		ModelAndView mav = new ModelAndView();
		
		System.out.println("mapping..");
		mav.addObject("blist", csService.csFaqList());
		
		mav.setViewName("/mp/manager/mngCsFaqList");
		return mav;
	}
	

	/**
	 * @throws SQLException 
	*  ����/FAQ ���
	* 
	* @param  ProductVo - ��ǰ
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/csNoticeAdd", method = RequestMethod.POST)
	public ModelAndView addCs(CsVo csVo) throws SQLException {
		log.debug("����/FAQ ��� ��Ʈ�ѷ�");
		//����/FAQ ��� ���� �ۼ�
		
		if(csVo.getCsGbCd().equals("10")) {
			csService.seqNocUp();
		}
		if(csVo.getCsGbCd().equals("20")) {
			csService.seqFaqUp();
		}
		csService.addfaq(csVo);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/mp/mng/csNoticeList");
		return mav;
	}
	
	@RequestMapping(value = "/csAdd")
	public ModelAndView addCs() {
		log.debug("����/FAQ ��� ��Ʈ�ѷ�");
		//����/FAQ ��� ���� �ۼ�
		
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/mp/manager/mngCsAdd");
		return mav;
	}
	
	@RequestMapping(value="/noticeDelete", method=RequestMethod.POST)
	public ModelAndView listdel(@RequestParam("num") int num) throws SQLException {
		
		csService.noticDel(num);
		System.out.println(num);
		ModelAndView  mav=new ModelAndView("redirect:/mp/mng/csNoticeList");
		return mav;
	}
	
	/**
	* 1:1 ����
	* 
	* @param  String code - c : 1:1���� ��� ��, R : 1:1���� ����Ʈ
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/csQuest", method = RequestMethod.GET)
	public ModelAndView getCsQuest(String code) {
		log.debug("1:1���� ����Ʈ ��Ʈ�ѷ�");
		
		ModelAndView mav = new ModelAndView();
		if(code.equals("R")) {
			//R : 1:1���� ����Ʈ ���� �ۼ�
			
		}else if(code.equals("C")) {
			//C : 1:1���� ��� ��
			return new ModelAndView("/mp/manager/mngCsQuestAdd");
		}
		mav.setViewName("/mp/manager/mngCsQuestList");
		return mav;
	}

	/**
	* 1:1 ���� ���  
	* 
	* @param  ProductVo - ��ǰ
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/csQuest", method = RequestMethod.POST)
	public ModelAndView addCsQuest(ProductVo bean) {
		log.debug("1:1���� ��� ��Ʈ�ѷ�");
		
		//1:1���� ��� ���� �ۼ�
		
		ModelAndView mav = new ModelAndView("redirect:/mp/mng/csQuest");
		return mav;
	}
	
}
