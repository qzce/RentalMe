package com.me.rentalme.mp.user.controller;

import java.util.List;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.me.rentalme.common.Paging;
import com.me.rentalme.cs.entity.CsVo;
import com.me.rentalme.model.entity.CallVo;
import com.me.rentalme.model.entity.RentalAppliVo;
import com.me.rentalme.model.entity.UserVo;
import com.me.rentalme.mp.user.service.MpUserService;
import com.me.rentalme.rental.Appli.service.RentalAppliService;

/**
 * ���������� ��Ʈ�ѷ�
 * 
 * @author ������
 * @version ver1.0
 * @see ������� : 2019.08.14
 */
@Controller
@RequestMapping("/mp")
public class UserController {

	String pagingPath="/mp";
	Logger log = LoggerFactory.getLogger(getClass());

	@Inject
	MpUserService mpUserService;
	
	@Inject
	RentalAppliService rentalAppliService; 

	/**
	 * @throws SQLException �ֹ�����
	 * 
	 * @param @return ModelAndView @author ������ @exception
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getOrderList(HttpSession session) throws SQLException {
		log.debug("�ֹ����� ����Ʈ ��Ʈ�ѷ�...");

		// ���ǿ��� mbno�� �ҷ��ͼ� �̸� ��������
		String mbNo = (String) session.getAttribute("loginMbNo");
		ModelAndView mav = new ModelAndView();
		mav.addObject("alist", mpUserService.ordList(mbNo));
		mav.addObject("userVo", mpUserService.getName(mbNo));
		mav.setViewName("mp/user/userOrdList");

		return mav;
	}

	/**
	 * @throws SQLException �ֹ�����> �ı���
	 * 
	 * @param @return ModelAndView @author ������ @exception
	 */
	@RequestMapping(value = "/review", method = RequestMethod.POST)
	public ModelAndView addReview(CallVo callVo, HttpSession session) throws SQLException {
		log.debug("�ı��� ��Ʈ�ѷ�...");

		// ���ǿ��� mbno�� �ҷ��ͼ� �̸� ��������
		String mbNo = (String) session.getAttribute("loginMbNo");

		mpUserService.addReview(callVo, mbNo);

		ModelAndView mav = new ModelAndView("redirect:/mp/");

		return mav;
	}
	
	/**
	 * �ֹ�����> ���� or ��ǰ
	 * 
	 * @param  
	 * @return String 
	 * @author Ȳ�¿�
	 * @exception 
	 */
	@RequestMapping(value = "/decision", method = RequestMethod.POST) 
	public String modifyDecisionOdr(@RequestParam("crudGbCd")String crudGbCd, @RequestParam("odrGbCd")String odrGbCd, @RequestParam("odrNo")String odrNo,
			RentalAppliVo rentalAppliVo, Model model, HttpSession session ){
		
		rentalAppliVo.setCrudGbCd(crudGbCd);
		rentalAppliVo.setOdrGbCd(odrGbCd);
		rentalAppliVo.setOdrNo(odrNo);
		rentalAppliVo.setMbNo((String) session.getAttribute("loginMbNo"));
		
		int result1 = rentalAppliService.decisionOdr(rentalAppliVo);			// �ֹ��ڷ� ����
		model.addAttribute("rtnCd", Integer.toString(result1));
		return "redirect:/mp/";
	}
	
	/**
	 * @throws SQLException ��ٱ���
	 * 
	 * @param @return ModelAndView @author ������ @exception
	 */
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public ModelAndView getCartList(HttpSession session) throws SQLException {
		log.debug("��ٱ��� ��Ʈ�ѷ�...");

		// ���ǿ��� mbno�� �ҷ��ͼ� �̸� ��������
		String mbNo = (String) session.getAttribute("loginMbNo");
		ModelAndView mav = new ModelAndView();
		mav.addObject("sessionMbNo", mbNo);
		mav.addObject("userVo", mpUserService.getName(mbNo));

		mav.addObject("alist", mpUserService.cartList(mbNo));
		mav.setViewName("mp/user/userCartList");
		return mav;
	}

	/**
	 * @throws SQLException ��ٱ��� ���� ����
	 * 
	 * @param @return ModelAndView @author ������ @exception
	 */
	@RequestMapping(value = "/deleteCart", method = RequestMethod.POST)
	public ModelAndView deleteCart(HttpSession session, @RequestParam(value = "chbox[]") List<String> chArr,
			@RequestParam(value = "chseq[]") List<String> chSeq, CallVo callVo) throws SQLException {
		log.debug("��ٱ��� ���� ��Ʈ�ѷ�...");

		// ���ǿ��� mbno�� �ҷ��ͼ� �̸� ��������
		String mbNo = (String) session.getAttribute("loginMbNo");
		ModelAndView mav = new ModelAndView();

		for (String gdsCd : chArr) {
			callVo.setGdsCd(gdsCd);
			for (String cartSeq : chSeq) {
				mpUserService.deleteCart(gdsCd, mbNo, cartSeq);
			}
		}

		mav.setViewName("mp/user/userCartList");
		return mav;
	}
	
	/**
	 * ��ٱ��� �����ϱ�
	 * 
	 * @param  
	 * @return String 
	 * @author Ȳ�¿�
	 * @exception 
	 */
	@RequestMapping(value = "/cart/odr", method = RequestMethod.POST) 
	public String addCartOdr(@RequestParam("crudGbCd")String crudGbCd, @RequestParam("odrGbCd")String odrGbCd, @RequestParam("payGbCd")String payGbCd, 
			@RequestParam("mbNo")String mbNo, @RequestParam("totOdrAmt")int totOdrAmt,  @RequestParam("gdsCdArr[]")List<String> gdsCdArr,
			@RequestParam("cartSeqArr[]")List<String> cartSeqArr, @RequestParam("gdsPriceArr[]")List<Integer> gdsPriceArr, @RequestParam("odrQtyArr[]")List<Integer> odrQtyArr, 
			@RequestParam("agreeTermArr[]")List<String> agreeTermArr, RentalAppliVo rentalAppliVo, Model model, HttpSession session ){
		
			int result1 = rentalAppliService.cartOdr(rentalAppliVo);			// �ֹ��ڷ� ����
			int result2 = rentalAppliService.cartDetailOdr(rentalAppliVo, gdsCdArr, cartSeqArr, gdsPriceArr, odrQtyArr, agreeTermArr );		// �ֹ����ڷ� ����
			model.addAttribute("rtnCd", Integer.toString(result1));
			return "redirect:/mp/";
	}

	/**
	 * @throws SQLException ���� ��ǰ
	 * 
	 * @param @return ModelAndView @author ������ @exception
	 */
	@RequestMapping(value = "/wish", method = RequestMethod.GET)
	public ModelAndView getWishList(Model model, HttpSession session) throws SQLException {
		// log.debug("���ѻ�ǰ ��Ʈ�ѷ�...");

		// ���ǿ��� mbno�� �ҷ��ͼ� �̸� ��������
		String mbNo = (String) session.getAttribute("loginMbNo");
		ModelAndView mav = new ModelAndView();
		mav.addObject("userVo", mpUserService.getName(mbNo));

		mav.addObject("alist", mpUserService.wishList(mbNo));
		mav.setViewName("mp/user/userWishList");
		return mav;
	}

	/**
	 * @throws SQLException ���� ��ǰ ���� ����
	 * 
	 * @param @return ModelAndView @author ������ @exception
	 */
	@RequestMapping(value = "/deleteWish", method = RequestMethod.POST)
	public ModelAndView deleteWish(HttpSession session, @RequestParam(value = "chbox[]") List<String> chArr,
			CallVo callVo) throws SQLException {
		log.debug("���ѻ�ǰ ���� ��Ʈ�ѷ�...");

		// ���ǿ��� mbno�� �ҷ��ͼ� �̸� ��������
		String mbNo = (String) session.getAttribute("loginMbNo");
		ModelAndView mav = new ModelAndView();

		for (String usedGdsNo : chArr) {
			callVo.setUsedGdsNo(usedGdsNo);
			mpUserService.deleteWish(usedGdsNo, mbNo);
		}

		mav.setViewName("mp/user/userWishList");
		return mav;
	}

	/**
	 * @throws SQLException ��ġ��
	 * 
	 * @param @return ModelAndView @author ������ @exception
	 */
	@RequestMapping(value = "/deposit", method = RequestMethod.GET)
	public ModelAndView getDeposit(CallVo callVo, HttpSession session) throws SQLException {
		log.debug("��ġ�� ��Ʈ�ѷ�...");

		// ���ǿ��� mbno�� �ҷ��ͼ� �̸� ��������
		ModelAndView mav = new ModelAndView();
		String mbNo = (String) session.getAttribute("loginMbNo");
		mav.addObject("userVo", mpUserService.getName(mbNo));

		mav.addObject("alist", mpUserService.depositList(mbNo));
		mav.addObject("callVo", mpUserService.userInfoList(mbNo));

		mav.setViewName("mp/user/userDeposit");
		return mav;

	}

	/**
	 * @throws SQLException ��ġ�� ����
	 * 
	 * @param @return ModelAndView @author ������ @exception
	 */
	@RequestMapping(value = "/deposit", method = RequestMethod.POST)
	public ModelAndView insertDeposit(@RequestParam("chargeDeposit") String chargeDeposit, CallVo callVo,
			HttpSession session) throws SQLException {
		log.debug("��ġ�� ���� ��Ʈ�ѷ�...");

		// ���ǿ��� mbno�� �ҷ��ͼ� �̸� ��������
		String mbNo = (String) session.getAttribute("loginMbNo");
		ModelAndView mav = new ModelAndView();
		mav.addObject("userVo", mpUserService.getName(mbNo));

		mpUserService.insertCharge(callVo, mbNo);

		// ���� ��ġ�ݱݾ����� update
		mpUserService.updateDeposit(chargeDeposit, mbNo);

		mav.setViewName("redirect:/mp/deposit");
		return mav;
	}
	
	/**
	 * @throws SQLException ��ġ�� ����
	 * 
	 * @param @return ModelAndView @author ������ @exception
	 */
	@RequestMapping(value = "/deposit/refund", method = RequestMethod.POST)
	@ResponseBody
	public String refundtDeposit(@RequestParam String refund, HttpSession session) throws SQLException {
		log.debug("��ġ�� ȯ�� ��Ʈ�ѷ�...");
		

		// ���ǿ��� mbno�� �ҷ��ͼ� �̸� ��������
		String mbNo = (String) session.getAttribute("loginMbNo");
		ModelAndView mav = new ModelAndView();
		mav.addObject("userVo", mpUserService.getName(mbNo));
		
		//��ġ�� ȯ�� ��û �� �ߺ� ȯ�� ��û���� Ȯ���ϱ�
		String duplmsg = mpUserService.selectRefund(mbNo);
			if(duplmsg.equals("duplication")) {
				
				duplmsg="duplication";
				 
			}else {
				//�ߺ� ȯ�� ��û���� ������ ��û�� �Է��ϱ�
				mpUserService.refundCharge(refund,mbNo);
				duplmsg="not duplication";
				
			}


		return duplmsg;
	}

	/**
	 * @throws SQLException �� ���� ���� ��
	 * 
	 * @param @return String @author ������ @exception
	 */
	@RequestMapping(value = "/updInfo", method = RequestMethod.GET)
	public ModelAndView modifyInfo(UserVo userVo, HttpSession session) throws SQLException {
		log.debug("�� ���� ���� �� ��Ʈ�ѷ�...");

		// ���ǿ� ����Ǿ��ִ� ȸ����ȣ�� ������ ����
		String mbNo = (String) session.getAttribute("loginMbNo");

		ModelAndView mav = new ModelAndView();

		mav.addObject("userVo", mpUserService.userInfo(mbNo));

		mav.setViewName("mp/user/userUpdInfo");

		return mav;
	}
	
	/**
	 * @throws SQLException �� ���� ���� : ��й�ȣ üũ
	 * 
	 * @param UserVo @return String @author ������ @exception
	 */
	@RequestMapping(value = "/checkPw", method = RequestMethod.POST)
	@ResponseBody
	public String checkPw(@RequestParam String userPw, HttpSession session) throws SQLException {
		
		String userId= (String)session.getAttribute("loginUserId");
		
		String msg = mpUserService.checkPw(userId, userPw);
		
		return msg;
	}
	
	

	/**
	 * @throws SQLException ��й�ȣ ����
	 * 
	 * @param UserVo @return String @author ������ @exception
	 */
	
	  @RequestMapping(value = "/changePw", method = RequestMethod.POST)
	  @ResponseBody
	  public void changePw(@RequestParam String userPw, HttpSession session) throws SQLException {
		  log.debug("��й�ȣ ���� ��Ʈ�ѷ�..."); 
		  
		  //view���� �޾ƿ� ��й�ȣ 
		  System.out.println("�Է��� ��й�ȣ:"+userPw);
		  
		  //���ǿ� ����Ǿ��ִ� ���� ���̵� ������ ���� 
		  String userId= (String)session.getAttribute("loginUserId");
		  
		  int result = mpUserService.changePw(userId, userPw);
		  
	  }

	/**
	 * @throws SQLException �� ���� ����
	 * 
	 * @param UserVo @return String @author ������ @exception
	 */
	@RequestMapping(value = "/updInfo", method = RequestMethod.POST)
	public String modifyInfo2(UserVo userVo, HttpSession session) throws SQLException {
		log.debug("�� ���� ���� ��Ʈ�ѷ�...");

		// ���ǿ� ����Ǿ��ִ� ȸ����ȣ�� ������ ����
		String mbNo = (String) session.getAttribute("loginMbNo");
		System.out.println(mbNo);

		mpUserService.myinfo(mbNo, userVo);
		// �̸� ��Ͻ� ���ǿ� �̸� �����ϱ�
		session.setAttribute("loginUserNM", userVo.getUserNM());

		return "redirect:/mp/updInfo";
	}

	/**
	 * @throws SQLException ��ų���
	 * 
	 * @param @return ModelAndView @author ������ @exception
	 */
	@RequestMapping(value = "/auctList", method = RequestMethod.GET)
	public ModelAndView getAuctList(HttpSession session) throws SQLException {
		log.debug("��ų��� ���� ��Ʈ�ѷ�...");

		// ���ǿ��� mbno�� �ҷ��ͼ� �̸� ��������
		String mbNo = (String) session.getAttribute("loginMbNo");
		ModelAndView mav = new ModelAndView();
		mav.addObject("userVo", mpUserService.getName(mbNo));
		mav.addObject("sessionMbNo", mbNo);
		mav.addObject("alist", mpUserService.AuctList(mbNo));

		mav.setViewName("mp/user/userAuctList");
		return mav;
	}
	
	/**
	 * ��ų��� �����ϱ�
	 * 
	 * @param  
	 * @return String 
	 * @author Ȳ�¿�
	 * @exception 
	 */
	@RequestMapping(value = "/auctList/odr", method = RequestMethod.POST)
	public String addLgDetailOdr(@RequestParam("totOdrAmt")int totOdrAmt, @RequestParam("crudGbCd")String crudGbCd, @RequestParam("odrGbCd")String odrGbCd, @RequestParam("payGbCd")String payGbCd, 
			@RequestParam("seq")String seq, @RequestParam("mbNo")String mbNo, @RequestParam("gdsCd")String gdsCd, RentalAppliVo rentalAppliVo, Model model, HttpSession session ) {
		
//		System.out.println("��Ű��� �Դɰ�");
		
		rentalAppliVo.setCrudGbCd(crudGbCd);
		rentalAppliVo.setOdrGbCd(odrGbCd);
		rentalAppliVo.setPayGbCd(payGbCd);
		rentalAppliVo.setSeq(seq);
		rentalAppliVo.setMbNo((String) session.getAttribute("loginMbNo"));
		rentalAppliVo.setGdsCd(gdsCd);
		rentalAppliVo.setTotOdrAmt(totOdrAmt);
		rentalAppliVo.setGdsPrice(totOdrAmt);
		rentalAppliVo.setOdrQty(1);
		rentalAppliVo.setAgreeTerm("0");
		
		int result1 = rentalAppliService.rentalGdsOdr(rentalAppliVo);			// �ֹ��ڷ� ����
		int result2 = rentalAppliService.rentalGdsDetailOdr(rentalAppliVo);		// �ֹ����ڷ� ����
		model.addAttribute("rtnCd", Integer.toString(result1));
		return "redirect:/mp/auctList";
	}
	

	/**
	 * @throws SQLException �� ���� ����
	 * 
	 * @param @return ModelAndView @author ���μ� @exception
	 */
	@RequestMapping(value = "/mp/quest", method = RequestMethod.GET)
	public ModelAndView getQuestList(CsVo csVo, HttpSession session,Model model,
			@RequestParam(required = false, defaultValue = "1")int page, @RequestParam(required = false, defaultValue = "1")int range) throws SQLException {
		log.debug("�� ���� ���� ��Ʈ�ѷ�...");

		pagingPath="/mp";
		pagingPath+="/mp/quest";
		
        int listCnt=mpUserService.inquiryListCnt(session);
		
		Paging csPaging=new Paging();
		
		csPaging.pageInfo(page,range,listCnt);
		System.out.println("inq���۹�ȣ:"+csPaging.getstartListNum());
		System.out.println("inq ������:"+csPaging.getListSize());
		
		ModelAndView mav = new ModelAndView();
		
		mpUserService.myList(csVo, session,csPaging.getstartListNum(),csPaging.getListSize());

		mav.addObject("mylist", mpUserService.myList(csVo, session,csPaging.getstartListNum(),csPaging.getListSize()));
		model.addAttribute("pathPaging", pagingPath);
		model.addAttribute("paging", csPaging);
		mav.setViewName("mp/user/userQuestList");
		return mav;
	}

	/**
	 * @throws SQLException �� ���� ��
	 * 
	 * @param @return ModelAndView @author ���μ� @exception
	 */
	@RequestMapping(value = "/mp/questDetail")
	public ModelAndView myQuestDetail(HttpSession session, CsVo csVo) throws SQLException {
		String user = (String) session.getAttribute("loginUserId");
		ModelAndView mav = new ModelAndView();
		mav.addObject("bean", mpUserService.myInqDetail(csVo));
		mav.addObject("id", user);
		mav.setViewName("mp/user/userQuestDetail");
		return mav;
	}

	/**
	 * @throws SQLException �� ���� ����
	 * 
	 * @param @return ModelAndView @author ���μ� @exception
	 */
	@RequestMapping(value = "/mp/QuestDelete")
	public ModelAndView myQuestDe(@RequestParam("pquestNo") String pquestNo, @RequestParam("mbNo") String mbNo,
			HttpSession session) throws SQLException {

		CsVo csVo = new CsVo();
		csVo.setMbNo(mbNo);
		csVo.setPquestNo(pquestNo);
		ModelAndView mav = new ModelAndView();
		mpUserService.myQuestDel(csVo);
		mav.setViewName("redirect:/mp//mp/quest");
		return mav;
	}

	/**
	 * ���� �߰� ����
	 * 
	 * @param @return ModelAndView @author ������ @exception
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
	 * @param @return ModelAndView @author ������ @exception
	 */
	@RequestMapping(value = "/act", method = RequestMethod.GET)
	public ModelAndView getActList() {
		log.debug("�� Ȱ�� ���� ��Ʈ�ѷ�...");

		ModelAndView mav = new ModelAndView();
		mav.setViewName("mp/user/userActList");
		return mav;
	}

}