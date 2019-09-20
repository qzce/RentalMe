package com.me.rentalme;


import java.sql.SQLException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.me.rentalme.service.RentalMeService;

@Controller
public class HomeController {
	String uploadDir="C:\\Users\\speed\\git\\RentalMe\\RentalMe\\src\\main\\webapp\\imgs\\";
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	RentalMeService rentalmeService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) throws SQLException {
		
		model.addAttribute("alist", rentalmeService.list());
		return "home";
	}
	
	
	/**
	 * ����
	 * 
	 * 
	 * @param  
	 * @return ModelAndView 
	 * @author ������
	 * @exception 
	 */
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public ModelAndView getOrdList(Model model) throws SQLException {
		logger.debug("main");
		
		ModelAndView mav= new ModelAndView();
		
		//�ǽð� �ֹ� ����Ʈ
		mav.addObject("ordlist",rentalmeService.ordList());
		
		//����Ʈ ������ ����Ʈ
		mav.addObject("bestitem",rentalmeService.bestList());
		//���ο� ������ ����Ʈ
		mav.addObject("newitem",rentalmeService.newList());
		
		
		//�������� ����Ʈ
		mav.addObject("cs",rentalmeService.csList());
		
	
		
		mav.setViewName("rental/rentalMain");
		
		return mav;
	}
	
	/**
	 * ����Ʈ ��ǰ ���������� �̵�
	 * 
	 * @param  
	 * @return ModelAndView 
	 * @author ������
	 * @exception 
	 */
	/*
	 * @RequestMapping(value = "/rentalme/appli/${menu}/detail/${best.gdsCd} ",
	 * method = RequestMethod.GET) public ModelAndView
	 * getbestDetail(@PathVariable("menu") String
	 * gdsSclassCd, @PathVariable("gdsCd") String gdsCd, Model model) throws
	 * SQLException { logger.debug("main");
	 * 
	 * ModelAndView mav= new ModelAndView();
	 * mav.addObject("ordlist",rentalmeService.ordList());
	 * mav.addObject("bestitem",rentalmeService.bestList());
	 * 
	 * mav.setViewName("rental/rentalMain");
	 * 
	 * return mav; }
	 */
	
	
}
