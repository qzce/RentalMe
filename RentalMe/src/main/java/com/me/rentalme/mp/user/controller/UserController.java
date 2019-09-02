package com.me.rentalme.mp.user.controller;

import java.sql.SQLException;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.me.rentalme.cs.entity.CsVo;
import com.me.rentalme.model.entity.CallVo;
import com.me.rentalme.model.entity.UserVo;
import com.me.rentalme.mp.user.service.MpUserService;

/**
* ���������� ��Ʈ�ѷ�
* 
* @author ������
* @version ver1.0
* @see 
* ������� : 2019.08.14
*/
@Controller
@RequestMapping("/mp")
public class UserController {
	
	Logger log = LoggerFactory.getLogger(getClass());
	
	@Inject
	MpUserService mpUserService;
	
	/**
	 * @throws SQLException 
	* �ֹ�����
	* 
	* @param  
	* @return ModelAndView 
	* @author ������
	* @exception 
	*/
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getOrderList(HttpSession session) throws SQLException {
		log.debug("�ֹ����� ����Ʈ ��Ʈ�ѷ�...");
		
		//���ǿ��� mbno�� �ҷ��ͼ� �̸� ��������
		String mbNo = (String) session.getAttribute("loginMbNo");
		ModelAndView mav = new ModelAndView();
		mav.addObject("alist",mpUserService.ordList(mbNo));
		mav.addObject("userVo",mpUserService.getName(mbNo));
		mav.setViewName("mp/user/userOrdList");
		
		return mav;
	}
	
	/**
	 * @throws SQLException 
	* �ֹ�����> �ı���
	* 
	* @param  
	* @return ModelAndView 
	* @author ������
	* @exception 
	*/
	@RequestMapping(value = "/review", method = RequestMethod.POST)
	public ModelAndView addReview(CallVo callVo) throws SQLException {
		log.debug("�ı��� ��Ʈ�ѷ�...");
		
		mpUserService.addReview(callVo);
		
		

		ModelAndView mav = new ModelAndView("redirect:/mp/");
		
		return mav;
	}
	
	
	/**
	 * @throws SQLException 
	* ��ٱ���
	* 
	* @param  
	* @return ModelAndView 
	* @author ������
	* @exception 
	*/
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public ModelAndView getCartList(HttpSession session) throws SQLException {
		log.debug("��ٱ��� ��Ʈ�ѷ�...");
		
		//���ǿ��� mbno�� �ҷ��ͼ� �̸� ��������
		String mbNo = (String) session.getAttribute("loginMbNo");
		ModelAndView mav = new ModelAndView();
		mav.addObject("userVo",mpUserService.getName(mbNo));
		
		
		mav.addObject("alist",mpUserService.cartList(mbNo));
		mav.setViewName("mp/user/userCartList");
		return mav;
	}	
	
	/**
	 * @throws SQLException 
	* ���� ��ǰ
	* 
	* @param  
	* @return ModelAndView 
	* @author ������
	* @exception 
	*/
	@RequestMapping(value = "/wish", method = RequestMethod.GET)
	public ModelAndView getWishList(Model model,HttpSession session) throws SQLException {
		//log.debug("���ѻ�ǰ ��Ʈ�ѷ�...");
		
		//���ǿ��� mbno�� �ҷ��ͼ� �̸� ��������
		String mbNo = (String) session.getAttribute("loginMbNo");
		ModelAndView mav = new ModelAndView();
		mav.addObject("userVo",mpUserService.getName(mbNo));
		
		mav.addObject("alist", mpUserService.wishList());
		mav.setViewName("mp/user/userWishList");
		return mav;
	}
	
	/**
	 * @throws SQLException 
	* ���� ��ǰ ���� (�ʹ� �����......����)
	* 
	* @param  
	* @return ModelAndView 
	* @author ������
	* @exception 
	*/
//	@RequestMapping(value = "/wish/delete", method = RequestMethod.POST)
//	public int deleTeWish(HttpSession session, @RequestParam(value="checkRow[]") List<String> chArr, CallVo callVo) throws Exception{
//		
//		log.debug("delete wish");
//		
//		int result=0;
//		String usedGdsNo = "";
//		
//		for(String i : chArr) {
//			callVo.setUsedGdsNo(usedGdsNo);
//			mpUserService.deleteWish(callVo);
//		}
//		
//		result=1;
//		return result;
//	}
	
//	@RequestMapping(value = "/wish/delete", method = RequestMethod.POST)
//	public String deleteWish(@PathVariable("used")) {
//		
//		return null;
//		
//	}
//	
	/**
	 * @throws SQLException 
	* ��ġ��
	* 
	* @param  
	* @return ModelAndView 
	* @author ������
	* @exception 
	*/
	@RequestMapping(value = "/deposit", method = RequestMethod.GET)
	public ModelAndView getDeposit(CallVo callVo, HttpSession session) throws SQLException {
		log.debug("��ġ�� ��Ʈ�ѷ�...");
	
		ModelAndView mav = new ModelAndView();
		String mbNo = (String) session.getAttribute("loginMbNo");
		mav.addObject("userVo",mpUserService.getName(mbNo));
		
		
		//���� ��ġ�ݱݾ����� update
		mpUserService.updateDeposit();
		
		mav.addObject("alist", mpUserService.depositList());
		mav.addObject("callVo",mpUserService.userInfoList());
		
		mav.setViewName("mp/user/userDeposit");
		return mav;
		
	}	
	@RequestMapping(value = "/deposit", method = RequestMethod.POST)
	public ModelAndView insertDeposit(CallVo callVo) throws SQLException {
		log.debug("��ġ�� ���� ��Ʈ�ѷ�...");
	
		mpUserService.insertCharge(callVo);
		
		
		ModelAndView mav = new ModelAndView("redirect:/mp/deposit");
		return mav;
	}	
	
	/**
	 * @throws SQLException 
	* �� ���� ���� ��
	* 
	* @param  
	* @return String 
	* @author ������
	* @exception 
	*/
	@RequestMapping(value = "/updInfo", method = RequestMethod.GET)
	public ModelAndView modifyInfo(UserVo userVo, HttpSession session) throws SQLException {
		log.debug("�� ���� ���� �� ��Ʈ�ѷ�...");
		
		//���ǿ� ����Ǿ��ִ� ȸ����ȣ�� ������ ����
		String mbNo= (String) session.getAttribute("loginMbNo");
		
		
		
		ModelAndView mav=new ModelAndView();
		
		mav.addObject("userVo",mpUserService.userInfo(mbNo));
		
		
		
		
		
		
		mav.setViewName("mp/user/userUpdInfo");
		
		return mav;
	}

	
	/**
	 * @throws SQLException 
	* �� ���� ����
	* 
	* @param  UserVo
	* @return String 
	* @author ������
	* @exception 
	*/
	@RequestMapping(value = "/updInfo", method = RequestMethod.POST)
	public String modifyInfo2(UserVo userVo,HttpSession session ) throws SQLException {
		log.debug("�� ���� ���� ��Ʈ�ѷ�...");
		
		//���ǿ� ����Ǿ��ִ� ȸ����ȣ�� ������ ����
		String mbNo= (String) session.getAttribute("loginMbNo");
		System.out.println(mbNo);
		
		mpUserService.myinfo(mbNo,userVo);
		//�̸� ��Ͻ� ���ǿ� �̸� �����ϱ�
		session.setAttribute("loginUserNM", userVo.getUserNM());
		
		
		
		return "redirect:/mp/updInfo";
	}
	/**
	 * @throws SQLException 
	* ��ų���
	* 
	* @param  
	* @return ModelAndView 
	* @author ������
	* @exception 
	*/
	@RequestMapping(value = "/auctList", method = RequestMethod.GET)
	public ModelAndView getAuctList(HttpSession session) throws SQLException {
		log.debug("��ų��� ���� ��Ʈ�ѷ�...");
		
		//���ǿ��� mbno�� �ҷ��ͼ� �̸� ��������
		String mbNo = (String) session.getAttribute("loginMbNo");
		ModelAndView mav = new ModelAndView();
		mav.addObject("userVo",mpUserService.getName(mbNo));
		
		
		mav.addObject("alist",mpUserService.AuctList(mbNo));
		
		mav.setViewName("mp/user/userAuctList");
		return mav;
	}
	
	/**
	 * @throws SQLException 
	* �� ���� ����
	* 
	* @param  
	* @return ModelAndView 
	* @author ���μ�
	* @exception 
	*/
	@RequestMapping(value = "/mp/quest", method = RequestMethod.GET)
	public ModelAndView getQuestList(CsVo csVo,HttpSession session) throws SQLException {
		log.debug("�� ���� ���� ��Ʈ�ѷ�...");
		
		ModelAndView mav = new ModelAndView();
		mpUserService.myList(csVo, session);
		
		mav.addObject("mylist", mpUserService.myList(csVo, session));
		
		mav.setViewName("mp/user/userQuestList");
		return mav;
	}
	
	/**
	 * @throws SQLException 
	* �� ���� ��
	* 
	* @param  
	* @return ModelAndView 
	* @author ���μ�
	* @exception 
	*/
	@RequestMapping(value="/mp/questDetail")
	public ModelAndView myQuestDetail(HttpSession session,CsVo csVo) throws SQLException{
		String user=(String)session.getAttribute("loginUserId");
		ModelAndView mav=new ModelAndView();
		mav.addObject("bean",mpUserService.myInqDetail(csVo));
		mav.addObject("id", user);
		mav.setViewName("mp/user/userQuestDetail");
		return mav;
	}
	
	/**
	 * @throws SQLException 
	* �� ���� ����
	* 
	* @param  
	* @return ModelAndView 
	* @author ���μ�
	* @exception 
	*/
	@RequestMapping(value="/mp/QuestDelete")
	public ModelAndView myQuestDe(@RequestParam("pquestNo") String pquestNo, @RequestParam("mbNo") String mbNo,HttpSession session) throws SQLException{
		
		CsVo csVo=new CsVo();
		csVo.setMbNo(mbNo);
		csVo.setPquestNo(pquestNo);
		ModelAndView mav=new ModelAndView();
		mpUserService.myQuestDel(csVo);
		mav.setViewName("redirect:/mp//mp/quest");
		return mav;
	}
	/**
	* ���� �߰� ����
	* 
	* @param  
	* @return ModelAndView 
	* @author ������
	* @exception 
	*/
	@RequestMapping(value = "/used", method = RequestMethod.GET)
	public ModelAndView getUsedList() {
		log.debug("���� �߰� ���� ��Ʈ�ѷ�...");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mp/user/userMyUsedList");
		return mav;
	}
	
	/**
	* �ŷ�����
	* 
	* @param  
	* @return ModelAndView 
	* @author ������
	* @exception 
	*/
	@RequestMapping(value = "/act", method = RequestMethod.GET)
	public ModelAndView getActList() {
		log.debug("�� Ȱ�� ���� ��Ʈ�ѷ�...");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mp/user/userActList");
		return mav;
	}

}
