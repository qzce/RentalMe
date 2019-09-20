package com.me.rentalme.mp.mng.appli.controller;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.me.rentalme.common.Paging;
import com.me.rentalme.model.entity.RentalAppliVo;

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
	
	String pagingPath="/mp";
	
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
	public ModelAndView getMainList(Model model,
			@RequestParam(required = false, defaultValue = "1")int page, @RequestParam(required = false, defaultValue = "1")int range) throws SQLException {
		
		log.debug("����������(������) ���� ��Ʈ�ѷ�");
	 
		pagingPath="/mp";
		pagingPath+="/mng/goodsList";
		
		int listCnt=MngService.goodsListCnt();
		System.out.println("�÷���"+listCnt);
		
		Paging apliPaging=new Paging();
		
		apliPaging.pageInfo(page, range, listCnt);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("rlist", MngService.selectGoodsList(apliPaging));
		model.addAttribute("pathPaging",pagingPath);
		model.addAttribute("paging", apliPaging);
		mav.setViewName("mp/manager/mngMainList");
		return mav;
	}
	
	
	
	/**
	 * @throws SQLException 
	* ����������(������) - �������� ����Ʈ
	* 
	* @param  
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/mng/Appli/lg", method = RequestMethod.GET)
	public ModelAndView getLgList(Model model,
			@RequestParam(required = false, defaultValue = "1")int page, @RequestParam(required = false, defaultValue = "1")int range) throws SQLException {
		log.debug("�������� ����Ʈ ��Ʈ�ѷ�");
		
		pagingPath="/mp";
		pagingPath+="/mng/Appli/lg";
		int listCnt=MngService.lGoodsListCnt();
		Paging apliPaging=new Paging();
		apliPaging.pageInfo(page, range, listCnt);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("rlist", MngService.lGoodsList(apliPaging));
		model.addAttribute("pathPaging",pagingPath);
		model.addAttribute("paging", apliPaging);
		mav.setViewName("mp/manager/mngAppliLgList");
		return mav;
	}
	
	/**
	 * @throws SQLException 
	* ����������(������) - �������� ����Ʈ
	* 
	* @param  
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/mng/Appli/sm", method = RequestMethod.GET)
	public ModelAndView getSmList(Model model,
			@RequestParam(required = false, defaultValue = "1")int page, @RequestParam(required = false, defaultValue = "1")int range) throws SQLException {
		log.debug("�������� ����Ʈ ��Ʈ�ѷ�");
		
		pagingPath="/mp";
		pagingPath+="/mng/Appli/sm";
		int listCnt=MngService.sGoodsListCnt();
		System.out.println("�������� �÷� ��"+listCnt);
		Paging apliPaging=new Paging();
		apliPaging.pageInfo(page, range, listCnt);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("rlist", MngService.sGoodsList(apliPaging));
		model.addAttribute("pathPaging",pagingPath);
		model.addAttribute("paging", apliPaging);
		mav.setViewName("mp/manager/mngAppliSmList");
		return mav;
	}
	
	/**
	 * @throws SQLException 
	*  ����������(������) - �ֹ��ǰ ����Ʈ
	* 
	* @param  
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/mng/Appli/kitc", method = RequestMethod.GET)
	public ModelAndView getKitcList(Model model,
			@RequestParam(required = false, defaultValue = "1")int page, @RequestParam(required = false, defaultValue = "1")int range) throws SQLException {
		log.debug("�ֹ� ����Ʈ ��Ʈ�ѷ�");
		pagingPath="/mp";
		pagingPath+="/mng/Appli/kitc";
		int listCnt=MngService.kGoodsListCnt();
		System.out.println("�ֹ氡�� �÷� ��"+listCnt);
		Paging apliPaging=new Paging();
		apliPaging.pageInfo(page, range, listCnt);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("rlist", MngService.kGoodsList(apliPaging));
		model.addAttribute("pathPaging",pagingPath);
		model.addAttribute("paging", apliPaging);
		
		mav.setViewName("mp/manager/mngAppliKitcList");
		return mav;
	}
	
	/**
	 * @throws SQLException 
	*  ����������(������) - ���� ����Ʈ
	* 
	* @param  
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/mng/Appli/furn", method = RequestMethod.GET)
	public ModelAndView getFurnList(Model model,
			@RequestParam(required = false, defaultValue = "1")int page, @RequestParam(required = false, defaultValue = "1")int range) throws SQLException {
		log.debug("���� ����Ʈ ��Ʈ�ѷ�");
		
		
		pagingPath="/mp";
		pagingPath+="/mng/Appli/furn";
		int listCnt=MngService.fGoodsListCnt();
		System.out.println("���� �÷� ��"+listCnt);
		Paging apliPaging=new Paging();
		apliPaging.pageInfo(page, range, listCnt);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("rlist", MngService.fGoodsList(apliPaging));
		model.addAttribute("pathPaging",pagingPath);
		model.addAttribute("paging", apliPaging);
		
		mav.setViewName("mp/manager/mngAppliFurnList");
		return mav;
	}
	
	/**
	 * @throws SQLException 
	*  ����������(������) - ��Ÿ ����Ʈ
	* 
	* @param  
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/mng/Appli/rest", method = RequestMethod.GET)
	public ModelAndView getRestList(Model model,
			@RequestParam(required = false, defaultValue = "1")int page, @RequestParam(required = false, defaultValue = "1")int range) throws SQLException {
		log.debug("��Ÿ ����Ʈ ��Ʈ�ѷ�");


		pagingPath="/mp";
		pagingPath+="/mng/Appli/rest";
		int listCnt=MngService.otherGoodsListCnt();
		System.out.println("��Ÿ���� �÷� ��"+listCnt);
		Paging apliPaging=new Paging();
		apliPaging.pageInfo(page, range, listCnt);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("rlist", MngService.otherGoodsList(apliPaging));
		model.addAttribute("pathPaging",pagingPath);
		model.addAttribute("paging", apliPaging);
		
		mav.setViewName("mp/manager/mngAppliRestList");
		return mav;
	}
	
	/**
	 * @throws SQLException 
	*  ����������(������) - ��Ű�� ����Ʈ
	* 
	* @param  
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/mng/Appli/pkg", method = RequestMethod.GET)
	public ModelAndView getPkgList(Model model,
			@RequestParam(required = false, defaultValue = "1")int page, @RequestParam(required = false, defaultValue = "1")int range) throws SQLException {
		log.debug("��Ű�� ����Ʈ ��Ʈ�ѷ�");
		

		pagingPath="/mp";
		pagingPath+="/mng/Appli/pkg";
		int listCnt=MngService.pacGoodsListCnt();
		System.out.println("��Ű������ �÷� ��"+listCnt);
		Paging apliPaging=new Paging();
		apliPaging.pageInfo(page, range, listCnt);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("rlist", MngService.pacGoodsList(apliPaging));
		model.addAttribute("pathPaging",pagingPath);
		model.addAttribute("paging", apliPaging);
		
		mav.setViewName("mp/manager/mngAppliPkgList");
		return mav;
	}
	
	//��Ż��ǰ ���û���
		@RequestMapping(value = "/mng/deleteAppliList", method = RequestMethod.POST)
		public ModelAndView deleteCart(@RequestParam(value = "chbox[]") List<String> chArr
				,RentalAppliVo rentalAppliVo) throws SQLException {
		
			System.out.println("��Ż�ǰ ���� ��Ʈ�ѷ�");
			
			ModelAndView mav=new ModelAndView();

			for (String gdsCd : chArr) {
				rentalAppliVo.setGdsCd(gdsCd);
				
				MngService.deleteAppli(gdsCd);
			}

			mav.setViewName("/mp/manager/mngMainList");
			return mav;
		}

	
}
