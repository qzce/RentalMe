package com.me.rentalme.cs.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.me.rentalme.common.Paging;
import com.me.rentalme.cs.entity.CsVo;
import com.me.rentalme.cs.paging.Search;
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
	
	
	String pagingPath="/cs";
	
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
		mav.addObject("UserId",(String)session.getAttribute("loginUserId"));
		System.out.println(user);
		
	
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
	public ModelAndView csNotic(Model model,
			@RequestParam(required = false, defaultValue = "1")int page, @RequestParam(required = false, defaultValue = "1")int range) throws SQLException {
		
		pagingPath="/cs";
		pagingPath+="/csNotice";
		
		int listCnt=csService.noticListCnt();
		
		Paging csPaging=new Paging();
		
		csPaging.pageInfo(page,range,listCnt);
		//csVo.setStartListNum(csPaging.getstartListNum());
		System.out.println("���۳ѹ�:"+csPaging.getstartListNum());
		//csVo.setListSize(csPaging.getListSize());
		System.out.println("�Խù� ����:"+csPaging.getListSize());
		////////////////////////////////////
		
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("alist", csService.csNoticeList(csPaging));
		model.addAttribute("pathPaging", pagingPath);
		model.addAttribute("paging", csPaging);
		mav.setViewName("cs/csNotice");
		return mav;
	}
	
	//����
	
	 
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@RequestMapping(value="/ordlist")
	public @ResponseBody List<CsVo> headMenu(Model model,@RequestParam(required = false, defaultValue = "1")int page, @RequestParam(required = false, defaultValue = "1")int range
			, @RequestParam("param") String param) throws SQLException {
		System.out.println("��Ʈ�ѷ�"+param);
		
		ArrayList<String> array=new ArrayList();
		
		
		Paging paging=new Paging();
		
		pagingPath="/cs";
		pagingPath+="/ordlist";
		CsVo csVo=new CsVo();
		csVo.setCsClassGbCd(param);
		
		//headTap �з���ȣ
		String tapName=csVo.getCsClassGbCd();
		System.out.println(csVo.getCsClassGbCd());
		
		//�Խù� ����
		int listCnt=csService.faqListCnt22(csVo.getCsClassGbCd());
		
		//����¡ ����
		paging.pageInfo(page, range,listCnt); 
		
		//jsp�� �ѱ� ����¡����
		model.addAttribute("pathPaging", pagingPath);
		model.addAttribute("paging", paging);
		
		//�ش� �з���ȣ ����Ʈ
		List<CsVo> goodsList=csService.csFaqHeadList(paging,tapName);
//		Map<String,Object> map=new HashMap<String,Object>();
//		for(int i = 0; i < goodsList.size(); i++) {
//			System.out.println(goodsList.get(i).toString());
//			
//		}
		
		
		
//		for(int i=0;i<goodsList.size();i++) {
//			System.out.println("��ȣ..!!"+goodsList.get(i).getFaqNo());
//			System.out.println("�з�..!!"+goodsList.get(i).getCsClassGbCd());
//			System.out.println("����..!!"+goodsList.get(i).getSub());
//			map.put("FaqNo"+i, goodsList.get(i).getFaqNo());	
//			map.put("tapName"+i, tapName);	
//			map.put("sub"+i,goodsList.get(i).getSub() );	
//			
//		}
//		for(int i=0;i<goodsList.size();i++ ) {
//			System.out.println("���� ��ȣ.."+map.get("FaqNo"+i));
//			System.out.println("���� �з�.."+map.get("tapName"+i));
//			System.out.println("���� ����.."+map.get("sub"+i));
//		}
		
//		for(Map.Entry<String, Object> entry : map.entrySet()) {
//			System.out.println("key : "+ entry.getKey() + ", value :"+ entry.getValue());
//		}
		
		
		//csVo.setStartListNum(csPaging.getstartListNum());
				System.out.println("���۳ѹ�:"+paging.getstartListNum());
				//csVo.setListSize(csPaging.getListSize());
				System.out.println("�Խù� ����:"+paging.getListSize());
				////////////////////////////////////
		
		
		System.out.println("���� ����Ʈ ����"+listCnt);
		ModelAndView mav=new ModelAndView();
		mav.addObject("blist", csService.csFaqHeadList(paging,tapName));
		mav.setViewName("cs/csFAQ");
		for(int i=0;i<goodsList.size();i++) {
			
			if(goodsList.get(i).getCsClassGbCd().equals("1")) {
				
				goodsList.get(i).setCsClassGbCd("�ֹ�");
			}
			if(goodsList.get(i).getCsClassGbCd().equals("2")) {
				
				goodsList.get(i).setCsClassGbCd("���");
			}
			if(goodsList.get(i).getCsClassGbCd().equals("3")) {
				
				goodsList.get(i).setCsClassGbCd("����");
			}
			if(goodsList.get(i).getCsClassGbCd().equals("4")) {
				
				goodsList.get(i).setCsClassGbCd("��ȯ���");
			}
			if(goodsList.get(i).getCsClassGbCd().equals("5")) {
				
				goodsList.get(i).setCsClassGbCd("ȸ������");
			}
			if(goodsList.get(i).getCsClassGbCd().equals("6")) {
				
				goodsList.get(i).setCsClassGbCd("��Ÿ");
			}
		}
		return goodsList;
	}
	//faq�Խ���
	@RequestMapping(value="/csFAQ")
	public ModelAndView csFaq(Model model,
			@RequestParam(required = false, defaultValue = "1")int page, @RequestParam(required = false, defaultValue = "1")int range
			, @RequestParam(required = false, defaultValue = "title") String searchType
			, @RequestParam(required = false) String keyword) throws SQLException {
		
		Search search = new Search();

		search.setSearchType(searchType);

		search.setKeyword(keyword);


		System.out.println("���ֹ�������");
		pagingPath="/cs";
		pagingPath+="/csFAQ";  //����¡��� ����
		System.out.println("����¡���"+pagingPath);
		//CsVo csVo=new CsVo();
		
		//��ü �Խù� ����
		int listCnt=csService.faqListCnt1(search);
		System.out.println("��ü �Խù� ����"+listCnt);
		
		//����¡ ����
		Paging csPaging = new Paging();
		
		search.pageInfo(page, range,listCnt); //����������,��������������, �Խù� �� ����
		//csVo.setStartListNum(csPaging.getstartListNum());
		System.out.println("���۳ѹ�:"+csPaging.getstartListNum());
		//csVo.setListSize(csPaging.getListSize());
		System.out.println("�Խù� ����:"+csPaging.getListSize());
		////////////////////////////////////
		
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("blist", csService.csFaqList(search));
		model.addAttribute("pathPaging", pagingPath);
		model.addAttribute("paging", search);
		System.out.println("1"+search.getKeyword());
		System.out.println("2"+search.getSearchType());
		
		model.addAttribute("keyword",search.getKeyword());
		model.addAttribute("searchType",search.getSearchType());
		mav.setViewName("cs/csFAQ");
		return mav;
	}
/////////////////////////////////////////////////////////////////////////////		
	//notice�󼼰Խ���
	@RequestMapping(value="/csNoticeDetail",method=RequestMethod.GET)
	public ModelAndView csNoticeDetail(HttpSession session,CsVo csVo) throws Exception{
		
		ModelAndView mav=new ModelAndView();
		String userId=(String)session.getAttribute("loginUserId");
		mav.addObject("id", userId);
		System.out.println("detail..start");
		csService.csNoticeDetail(csVo);
		mav.addObject("adetail", csService.csNoticeDetail(csVo));
		
		System.out.println("detail...end");
		return mav;
		
	}
	
	//faq�󼼰Խ���
	@RequestMapping(value="/csFaqDetail",method=RequestMethod.GET)
	public ModelAndView csFaqDetail(HttpSession session,CsVo csVo) throws Exception{
		
		
		ModelAndView mav=new ModelAndView();
		String userId=(String)session.getAttribute("loginUserId");
		mav.addObject("id", userId);
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
