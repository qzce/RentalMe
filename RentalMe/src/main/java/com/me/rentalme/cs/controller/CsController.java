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
import com.me.rentalme.login.service.LoginService;
import com.me.rentalme.model.entity.UserVo;

/**
 * 고객센터 컨트롤러
 * 
 * @author 황인준
 * @version ver1.0
 * @see 등록일자 : 2019.08.18
 */
@Controller
@RequestMapping("/cs")
public class CsController {

	String pagingPath = "/cs";

	@Inject
	CsService csService;

	/**
	 * @throws SQLException 고객센터 리스트
	 * 
	 * @param None @return ModelAndView @author 황인준 @exception
	 */

	// 1:1문의여부 페이지
	@RequestMapping(value = "/csInquiry")
	public ModelAndView inquery(HttpSession session) throws SQLException {
		System.out.println("질문");
		ModelAndView mav = new ModelAndView();

		String user = (String) session.getAttribute("loginUserId");
		String mbNo = (String) session.getAttribute("loginMbNo");
		UserVo userVo = csService.userLevel(mbNo);
		
		String userLevel = userVo.getLevelGbCd();
		System.out.println(userLevel);
		// String userLevel=(String)session.getAttribute(userVo.getLevelGbCd());
		System.out.println("회원? 관리자?" + userLevel);
		
		mav.addObject("UserId", (String) session.getAttribute("loginUserId"));
		mav.addObject("userLevel", (String) session.getAttribute("userLevel"));
		mav.addObject("levelGbCd",userLevel);
		System.out.println(user);

		mav.setViewName("cs/csInquiry");
		return mav;

	}

	// 1:1문의 등록 페이지이동
	@RequestMapping(value = "/csInquiryAddPage")
	public ModelAndView inquiryAddPage(HttpSession session) throws SQLException {

		ModelAndView mav = new ModelAndView();
		CsVo csVo = new CsVo();
		String user = (String) session.getAttribute("loginUserId");

		System.out.println("회원id:" + user);
		System.out.println("곧 진입 회원번호:" + csVo.getMbNo());
		mav.addObject("id", user);
		mav.setViewName("cs/csQuestAdd");
		return mav;
	}

	// 1:1문의등록
	@RequestMapping(value = "/csInquiryAdd")
	public ModelAndView inquiryAdd(CsVo csVo, HttpSession session) throws SQLException {
		ModelAndView mav = new ModelAndView();

		if (csVo.getCsClassGbCd().equals("")) {
			System.out.println("만약" + csVo.getCsClassGbCd());
			mav.setViewName("redirect:/cs/csInquiryAddPage");
			return mav;
		}
		if (csVo.getSub().equals("")) {
			System.out.println("만약" + csVo.getCsClassGbCd());
			mav.setViewName("redirect:/cs/csInquiryAddPage");
			return mav;
		}
		if (csVo.getContent().equals("")) {
			System.out.println("만약" + csVo.getCsClassGbCd());
			mav.setViewName("redirect:/cs/csInquiryAddPage");
			return mav;
		}
		String loginMbNo = (String) session.getAttribute("loginMbNo");
		csVo.setMbNo(loginMbNo);
		System.out.println("회원번호 여기맞나" + csVo.getMbNo());
		System.out.println("이상..true??" + csVo.getCsGbCd().equals("30")); // true
		if (csVo.getCsGbCd().equals("30")) {
			csService.seqInqUp();
		}
		csService.addfaq(csVo);
		mav.setViewName("redirect:/mp/mp/quest");
		return mav;
	}

/////////////////////////////////////////////////////////////////////////////	
	// 공지게시판
	@RequestMapping(value = "/csNotice", method = RequestMethod.GET)
	public ModelAndView csNotic(Model model, @RequestParam(required = false, defaultValue = "1") int page,
			@RequestParam(required = false, defaultValue = "1") int range) throws SQLException {

		pagingPath = "/cs";
		pagingPath += "/csNotice";

		int listCnt = csService.noticListCnt();

		Paging csPaging = new Paging();

		csPaging.pageInfo(page, range, listCnt);
		// csVo.setStartListNum(csPaging.getstartListNum());
		System.out.println("시작넘버:" + csPaging.getstartListNum());
		// csVo.setListSize(csPaging.getListSize());
		System.out.println("게시물 갯수:" + csPaging.getListSize());
		////////////////////////////////////

		ModelAndView mav = new ModelAndView();
		mav.addObject("alist", csService.csNoticeList(csPaging));
		model.addAttribute("pathPaging", pagingPath);
		model.addAttribute("paging", csPaging);
		mav.setViewName("cs/csNotice");
		return mav;
	}

	// 실험

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@RequestMapping(value = "/ordlist")
	public @ResponseBody List<CsVo> headMenu(Model model, @RequestParam(required = false, defaultValue = "1") int page,
			@RequestParam(required = false, defaultValue = "1") int range, @RequestParam("param") String param)
			throws SQLException {
		System.out.println("컨트롤러" + param);

		ArrayList<String> array = new ArrayList();

		Paging paging = new Paging();

		pagingPath = "/cs";
		pagingPath += "/ordlist";
		CsVo csVo = new CsVo();
		csVo.setCsClassGbCd(param);

		// headTap 분류번호
		String tapName = csVo.getCsClassGbCd();
		System.out.println(csVo.getCsClassGbCd());

		// 게시물 갯수
		int listCnt = csService.faqListCnt22(csVo.getCsClassGbCd());

		// 페이징 정보
		paging.pageInfo(page, range, listCnt);

		// jsp에 넘길 페이징정보
		model.addAttribute("pathPaging", pagingPath);
		model.addAttribute("paging", paging);

		// 해당 분류번호 리스트
		List<CsVo> goodsList = csService.csFaqHeadList(paging, tapName);
//		Map<String,Object> map=new HashMap<String,Object>();
//		for(int i = 0; i < goodsList.size(); i++) {
//			System.out.println(goodsList.get(i).toString());
//			
//		}

//		for(int i=0;i<goodsList.size();i++) {
//			System.out.println("번호..!!"+goodsList.get(i).getFaqNo());
//			System.out.println("분류..!!"+goodsList.get(i).getCsClassGbCd());
//			System.out.println("제목..!!"+goodsList.get(i).getSub());
//			map.put("FaqNo"+i, goodsList.get(i).getFaqNo());	
//			map.put("tapName"+i, tapName);	
//			map.put("sub"+i,goodsList.get(i).getSub() );	
//			
//		}
//		for(int i=0;i<goodsList.size();i++ ) {
//			System.out.println("맵의 번호.."+map.get("FaqNo"+i));
//			System.out.println("맵의 분류.."+map.get("tapName"+i));
//			System.out.println("맵의 제목.."+map.get("sub"+i));
//		}

//		for(Map.Entry<String, Object> entry : map.entrySet()) {
//			System.out.println("key : "+ entry.getKey() + ", value :"+ entry.getValue());
//		}

		// csVo.setStartListNum(csPaging.getstartListNum());
		System.out.println("시작넘버:" + paging.getstartListNum());
		// csVo.setListSize(csPaging.getListSize());
		System.out.println("게시물 갯수:" + paging.getListSize());
		////////////////////////////////////

		System.out.println("여기 리스트 갯수" + listCnt);
		ModelAndView mav = new ModelAndView();
		mav.addObject("blist", csService.csFaqHeadList(paging, tapName));
		mav.setViewName("cs/csFAQ");
		for (int i = 0; i < goodsList.size(); i++) {

			if (goodsList.get(i).getCsClassGbCd().equals("1")) {

				goodsList.get(i).setCsClassGbCd("주문");
			}
			if (goodsList.get(i).getCsClassGbCd().equals("2")) {

				goodsList.get(i).setCsClassGbCd("배송");
			}
			if (goodsList.get(i).getCsClassGbCd().equals("3")) {

				goodsList.get(i).setCsClassGbCd("결제");
			}
			if (goodsList.get(i).getCsClassGbCd().equals("4")) {

				goodsList.get(i).setCsClassGbCd("교환취소");
			}
			if (goodsList.get(i).getCsClassGbCd().equals("5")) {

				goodsList.get(i).setCsClassGbCd("회원정보");
			}
			if (goodsList.get(i).getCsClassGbCd().equals("6")) {

				goodsList.get(i).setCsClassGbCd("기타");
			}
		}
		return goodsList;
	}

	// faq게시판
	@RequestMapping(value = "/csFAQ")
	public ModelAndView csFaq(Model model, 
			@RequestParam(required = false, defaultValue = "1") int page,
			@RequestParam(required = false, defaultValue = "1") int range,
			@RequestParam(required = false, defaultValue = "title") String searchType,
			@RequestParam(required = false) String keyword) throws SQLException {

		Search search = new Search();

		search.setSearchType(searchType);

		search.setKeyword(keyword);

		System.out.println("자주묻는질문");
		pagingPath = "/cs";
		pagingPath += "/csFAQ"; // 페이징경로 설정
		System.out.println("페이징경로" + pagingPath);
		// CsVo csVo=new CsVo();

		// 전체 게시물 갯수
		int listCnt = csService.faqListCnt1(search);
		System.out.println("전체 게시물 갯수" + listCnt);

		// 페이징 셋팅
		Paging csPaging = new Paging();

		search.pageInfo(page, range, listCnt); // 현재페이지,현재페이지범위, 게시물 총 갯수
		// csVo.setStartListNum(csPaging.getstartListNum());
		System.out.println("시작넘버:" + csPaging.getstartListNum());
		// csVo.setListSize(csPaging.getListSize());
		System.out.println("게시물 갯수:" + csPaging.getListSize());
		////////////////////////////////////

		ModelAndView mav = new ModelAndView();
		mav.addObject("blist", csService.csFaqList(search));
		model.addAttribute("pathPaging", pagingPath);
		model.addAttribute("paging", search);
		System.out.println("1" + search.getKeyword());
		System.out.println("2" + search.getSearchType());

		model.addAttribute("keyword", search.getKeyword());
		model.addAttribute("searchType", search.getSearchType());
		mav.setViewName("cs/csFAQ");
		return mav;
	}

/////////////////////////////////////////////////////////////////////////////		
	// notice상세게시판
	@RequestMapping(value = "/csNoticeDetail", method = RequestMethod.GET)
	public ModelAndView csNoticeDetail(HttpSession session, CsVo csVo) throws Exception {

		ModelAndView mav = new ModelAndView();
		String userId = (String) session.getAttribute("loginUserId");
		mav.addObject("id", userId);
		System.out.println("detail..start");
		csService.csNoticeDetail(csVo);
		mav.addObject("adetail", csService.csNoticeDetail(csVo));

		System.out.println("detail...end");
		return mav;

	}

	// faq상세게시판
	@RequestMapping(value = "/csFaqDetail", method = RequestMethod.GET)
	public ModelAndView csFaqDetail(HttpSession session, CsVo csVo) throws Exception {

		ModelAndView mav = new ModelAndView();
		String userId = (String) session.getAttribute("loginUserId");
		mav.addObject("id", userId);
		mav.addObject("bdetail", csService.csFaqDetail(csVo));

		return mav;
	}

/////////////////////////////////////////////////////////////////////////////	

	/**
	 * 고객센터 - 문의 등록 폼
	 * 
	 * @param None @return ModelAndView @author 황인준 @exception
	 */

	@RequestMapping(value = "/csQuestAdd", method = RequestMethod.GET)
	public String getCsQuestForm() {
		return "cs/csQuestAdd";
	}

	/**
	 * 고객센터 - 문의 등록
	 * 
	 * @param @return ModelAndView @author 황인준 @exception
	 */
	@RequestMapping(value = "/csQuest", method = RequestMethod.POST)
	public ModelAndView setCsQuestAdd() {

		ModelAndView mav = new ModelAndView("cs/csList");
		return mav;
	}
}
