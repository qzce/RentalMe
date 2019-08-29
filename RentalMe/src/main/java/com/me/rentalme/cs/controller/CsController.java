package com.me.rentalme.cs.controller;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.me.rentalme.cs.entity.CsVo;
import com.me.rentalme.cs.service.CsService;
import com.me.rentalme.model.entity.UserVo;


/**
* ������ ��Ʈ�ѷ�
* 
* @author Ȳ����
* @version ver1.0
* @see 
* ������� : 2019.08.18
*/
@Controller
@RequestMapping("/cs")
public class CsController {
	
	@Inject
	CsService csService; 
	
	/**
	 * @throws SQLException 
	* ������ ����Ʈ 
	* 
	* @param  None
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	
	//1:1���ǿ��� ������
	@RequestMapping(value="/csInquiry")
	public ModelAndView inquery(HttpSession session) throws SQLException {
		System.out.println("����");
		ModelAndView mav=new ModelAndView();
		
		String user=(String)session.getAttribute("loginUserId");
		System.out.println(user);
		
	
		mav.addObject("UserId",(String)session.getAttribute("loginUserId"));
		mav.setViewName("cs/csInquiry");
		return mav;
		
	}
	
	//1:1���� ��� �������̵�
	@RequestMapping(value="/csInquiryAddPage")
	public ModelAndView inquiryAddPage(HttpSession session) throws SQLException{
		
		ModelAndView mav=new ModelAndView();
		CsVo csVo=new CsVo();
		String user=(String)session.getAttribute("loginUserId");
		
		
		
		System.out.println("ȸ��id:"+user);
		System.out.println("�� ���� ȸ����ȣ:"+csVo.getMbNo());
		
		mav.addObject("id", user);
		mav.setViewName("cs/csQuestAdd");
		return mav;
	}
	
	//1:1���ǵ�� 
	@RequestMapping(value="/csInquiryAdd")
	public ModelAndView inquiryAdd(CsVo csVo,HttpSession session) throws SQLException{
		ModelAndView mav=new ModelAndView();
		
		if(csVo.getCsClassGbCd().equals("")) {
			System.out.println("����"+csVo.getCsClassGbCd());
			mav.setViewName("redirect:/cs/csInquiryAddPage");
			return mav;
		}
		if(csVo.getSub().equals("")) {
			System.out.println("����"+csVo.getCsClassGbCd());
			mav.setViewName("redirect:/cs/csInquiryAddPage");
			return mav;
		}
		if(csVo.getContent().equals("")) {
			System.out.println("����"+csVo.getCsClassGbCd());
			mav.setViewName("redirect:/cs/csInquiryAddPage");
			return mav;
		}
		String loginMbNo=(String)session.getAttribute("loginMbNo");
		csVo.setMbNo(loginMbNo);
		System.out.println("ȸ����ȣ ����³�"+csVo.getMbNo());
		System.out.println("�̻�..true??"+csVo.getCsGbCd().equals("30")); //true
		if(csVo.getCsGbCd().equals("30")) {
			csService.seqInqUp();
		}
		csService.addfaq(csVo);
		mav.setViewName("redirect:/mp/mp/quest");
		return mav;
	}
	
/////////////////////////////////////////////////////////////////////////////	
	//�����Խ���
	@RequestMapping(value = "/csNotice", method = RequestMethod.GET)
	public ModelAndView home() throws SQLException {
		System.out.println("mapping..");
		ModelAndView mav=new ModelAndView();
		mav.addObject("alist", csService.csNoticeList());
		mav.setViewName("cs/csNotice");
		return mav;
	}
	
	
	//faq�Խ���
	@RequestMapping(value="/csFAQ")
	public ModelAndView csfaq(Model model) throws SQLException {
		System.out.println("���ֹ�������");
		ModelAndView mav=new ModelAndView();
		mav.addObject("blist", csService.csFaqList());
		mav.setViewName("cs/csFAQ");
		return mav;
	}
/////////////////////////////////////////////////////////////////////////////		
	//notice�󼼰Խ���
	@RequestMapping(value="/csNoticeDetail",method=RequestMethod.GET)
	public ModelAndView csNoticeDetail(CsVo csVo) throws Exception{
		
		ModelAndView mav=new ModelAndView();
		System.out.println("detail..start");
		csService.csNoticeDetail(csVo);
		mav.addObject("adetail", csService.csNoticeDetail(csVo));
		
		System.out.println("detail...end");
		return mav;
		
	}
	
	//faq�󼼰Խ���
	@RequestMapping(value="/csFaqDetail",method=RequestMethod.GET)
	public ModelAndView csFaqDetail(CsVo csVo) throws Exception{
		
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("bdetail", csService.csFaqDetail(csVo));
		
		return mav;
	}
	
/////////////////////////////////////////////////////////////////////////////	

	/**
	* ������ - ���� ��� �� 
	* 
	* @param  None
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	
	  @RequestMapping(value = "/csQuestAdd", method = RequestMethod.GET) 
	  public String getCsQuestForm() {
		  return "cs/csQuestAdd"; 
	  }
	 
	/**
	* ������ - ���� ��� 
	* 
	* @param  
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/csQuest", method = RequestMethod.POST)
	public ModelAndView setCsQuestAdd() {
		
		ModelAndView mav = new ModelAndView("cs/csList");
		return mav;
	}
}
