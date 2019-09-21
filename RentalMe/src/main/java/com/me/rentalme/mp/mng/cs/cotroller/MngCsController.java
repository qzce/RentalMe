package com.me.rentalme.mp.mng.cs.cotroller;

import java.sql.SQLException;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.me.rentalme.common.Paging;
import com.me.rentalme.cs.entity.CsVo;
import com.me.rentalme.cs.paging.Search;
import com.me.rentalme.cs.service.CsService;
import com.me.rentalme.model.entity.ProductVo;
import com.me.rentalme.model.entity.UserVo;


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

	String pagingPath="/mp/mng";
	
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
	public ModelAndView getCsNotice(HttpSession session,Model model,
			@RequestParam(required = false, defaultValue = "1")int page, @RequestParam(required = false, defaultValue = "1")int range) throws SQLException {
		log.debug("����/FAQ ��Ʈ�ѷ�");
		ModelAndView mav = new ModelAndView();
		pagingPath="/mp/mng";
		pagingPath+="/csNoticeList";
		String user = (String) session.getAttribute("loginUserId");
		String mbNo = (String) session.getAttribute("loginMbNo");
		UserVo userVo = csService.userLevel(mbNo);
		String userLevel = userVo.getLevelGbCd();
		System.out.println(userLevel);
		mav.addObject("levelGbCd",userLevel);
		int listCnt=csService.noticListCnt();
		
		Paging csPaging=new Paging();
		
		csPaging.pageInfo(page, range, listCnt);
		
	
		
		System.out.println("mapping..");
		
		// ���ǹ޾ƿ���
		String userId=(String)session.getAttribute("loginUserId");
		mav.addObject("id", userId);
		
		mav.addObject("alist", csService.csNoticeList(csPaging));
		model.addAttribute("pathPaging",pagingPath);
		model.addAttribute("paging", csPaging);
		
		mav.setViewName("/mp/manager/mngCsList");
		return mav;
	}
	
	@RequestMapping(value = "/csFaqList", method = RequestMethod.GET)
	public ModelAndView getCsFaq(HttpSession session,Model model,
			@RequestParam(required = false, defaultValue = "1")int page, @RequestParam(required = false, defaultValue = "1")int range) throws SQLException {
		log.debug("����/FAQ ��Ʈ�ѷ�");
		
		pagingPath="/mp/mng";
		pagingPath+="/csFaqList";
		
		ModelAndView mav = new ModelAndView();
		
		String user = (String) session.getAttribute("loginUserId");
		String mbNo = (String) session.getAttribute("loginMbNo");
		UserVo userVo = csService.userLevel(mbNo);
		String userLevel = userVo.getLevelGbCd();
		System.out.println(userLevel);
		mav.addObject("levelGbCd",userLevel);
		
		Search search=new Search();
		int listCnt=csService.faqListCnt1(search);
		
		Paging csPaging=new Paging();
		
		csPaging.pageInfo(page, range, listCnt);
		
		String userId=(String)session.getAttribute("loginUserId");
		mav.addObject("id", userId);
		
		
		System.out.println("mapping..");
		mav.addObject("blist", csService.csFaqList(search));
		model.addAttribute("pathPaging",pagingPath);
		model.addAttribute("paging", csPaging);
		
		mav.setViewName("/mp/manager/mngCsFaqList");
		return mav;
	}

	/**
	 * @throws SQLException 
	 * ȸ�� ���� ����
	 * 
	 * @param  
	 * @return ModelAndView 
	 * @author ���μ�
	 * @exception 
	 */
	@RequestMapping(value = "/InqList", method = RequestMethod.GET)
	public ModelAndView getQuestList(HttpSession session,CsVo csVo,Model model,
			@RequestParam(required = false, defaultValue = "1")int page, @RequestParam(required = false, defaultValue = "1")int range) throws SQLException {
		log.debug("���� ���� ��Ʈ�ѷ�...");
		
		pagingPath="/mp/mng";
		pagingPath+="/InqList";
		
		ModelAndView mav = new ModelAndView();
		
		String user = (String) session.getAttribute("loginUserId");
		String mbNo = (String) session.getAttribute("loginMbNo");
		UserVo userVo = csService.userLevel(mbNo);
		String userLevel = userVo.getLevelGbCd();
		System.out.println(userLevel);
		mav.addObject("levelGbCd",userLevel);
		
		
		
		int listCnt=csService.inquiryListCnt();
		System.out.println("inq����Ʈ ����:"+listCnt);
		
		Paging csPaging=new Paging();
		
		csPaging.pageInfo(page, range, listCnt);
		
		
		mav.addObject("inqlist", csService.csInqList(csPaging));
		
		System.out.println("list�̰� �ѱ��");
		String userId=(String)session.getAttribute("loginUserId");
		mav.addObject("id", userId);
		
		model.addAttribute("pathPaging",pagingPath);
		model.addAttribute("paging", csPaging);
		mav.setViewName("mp/manager/mngCsQuestList");
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
	
	/**
	 * @throws SQLException 
	*  ����/FAQ ����
	* 
	* @param  ProductVo - ��ǰ
	* @return ModelAndView 
	* @author ���μ�
	* @exception 
	*/
	@RequestMapping(value="/noticeDelete", method=RequestMethod.POST)
	public ModelAndView nolistdel(@RequestParam("num") String num) throws SQLException {
		System.out.println(num);
		csService.noticDel(num);
		ModelAndView  mav=new ModelAndView("redirect:/mp/mng/csNoticeList");
		return mav;
	}
	
	@RequestMapping(value="/faqDelete", method=RequestMethod.POST)
	public ModelAndView falistdel(@RequestParam("num") String num) throws SQLException {
		System.out.println(num);
		csService.faqDel(num);
		ModelAndView  mav=new ModelAndView("redirect:/mp/mng/csFaqList");
		return mav;
	}
	
	
	/**
	 * @throws SQLException 
	*  ����/FAQ ����
	* 
	* @param  ProductVo - ��ǰ
	* @return ModelAndView 
	* @author ���μ�
	* @exception 
	*/
	//notic������������ �̵�
	@RequestMapping(value="/csNoticeUpdatePage")
	public ModelAndView noticup(HttpSession session,CsVo csVo) throws SQLException{
		
		String userId=(String)session.getAttribute("loginUserId");
		ModelAndView mav=new ModelAndView();
		mav.addObject("id", userId);
		mav.addObject("detail",csService.csNoticeDetail(csVo));
		mav.setViewName("/mp/manager/mngCsNoticeUpdate");
		return mav;
	}
	
	//fac������������ �̵�
		@RequestMapping(value="/csFaqUpdatePage")
		public ModelAndView faqup(HttpSession session,CsVo csVo) throws SQLException{
			
			ModelAndView mav=new ModelAndView();
			System.out.println("�Ф�"+csVo.getFaqNo());
			mav.addObject("qdetail",csService.csFaqDetail(csVo));
			String userId=(String)session.getAttribute("loginUserId");
			mav.addObject("id", userId);
			mav.setViewName("/mp/manager/mngCsFaqUpdate");
			return mav;
		}
	
	//notic���������� �Ķ���� �ֱ�
	@RequestMapping(value="/csNoticeUpdate", method=RequestMethod.POST)
	public ModelAndView noticupdae(CsVo csVo) throws SQLException {
		System.out.println("/cs/csNoticeUpdate");
		ModelAndView mav=new ModelAndView();
		System.out.println(csVo.getNoticNo());
		
		
		csService.csUpdateOne(csVo);
		mav.addObject(csVo.getNoticNo());
		System.out.println(csVo.getNoticNo()+"+"+csVo.getSub());
		mav.setViewName("redirect:/mp/mng/csNoticeList");
		return mav;
	}
	
	//faq���������� �Ķ���� �ֱ�
		@RequestMapping(value="/csFaqUpdate",method=RequestMethod.POST)
		public ModelAndView faqupdae(CsVo csVo) throws SQLException {
			System.out.println("/cs/csFaqUpdate");
			ModelAndView mav=new ModelAndView();
			
			csService.csUpdateOne(csVo);
			System.out.println(csVo.getNoticNo()+"+"+csVo.getSub());
			mav.setViewName("redirect:/mp/mng/csFaqList");
			return mav;
		}
		
		
		/**
		 * @throws SQLException 
		* ȸ�� ���� �亯����
		* 
		* @param  
		* @return ModelAndView 
		* @author ���μ�
		* @exception 
		*/
		@RequestMapping(value="/answer")
		public ModelAndView questAnswer(@RequestParam("pquestNo") String num,HttpSession session) throws SQLException{
			System.out.println(num);
			ModelAndView mav=new ModelAndView();
			String userId=(String)session.getAttribute("loginUserId");
			mav.addObject("id", userId);
			mav.addObject("answer",csService.inqAnswer(num));
			mav.setViewName("redirect:/mp/mng/InqList");
			return mav;
		}
		
		@RequestMapping(value="/csList")
		@ResponseBody
		public String csList(@RequestParam("param") String selected) {
			if(selected.equals("20")) {
				System.out.println("����");
			}else {
				System.out.println("Ʋ��");
			}
			
			return selected;
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
