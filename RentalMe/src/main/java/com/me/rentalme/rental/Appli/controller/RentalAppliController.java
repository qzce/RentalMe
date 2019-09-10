package com.me.rentalme.rental.Appli.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.me.rentalme.common.Paging;
import com.me.rentalme.model.entity.RentalAppliVo;
import com.me.rentalme.rental.Appli.service.RentalAppliService;
import com.mysql.fabric.Response;


/**
* ��Ż������ - ����Ʈ, �󼼺���
* 
* @author Ȳ����
* @version ver1.0
* @see 
* ������� : 2019.08.17
*/
@Controller
@RequestMapping("/rental/Appli/lg")
public class RentalAppliController {

	Logger log = LoggerFactory.getLogger(getClass());
	//String pathPaging= "/rental/Appli/lg";
	
	@Inject
	RentalAppliService rentalAppliService; 
	
	/**
	* ����������Ż ����Ʈ
	* 
	* @param  
	* @return String 
	* @author Ȳ�¿�
	* @exception 
	*/
	@RequestMapping(value = "/{menu}", method = RequestMethod.GET)
	public String getLgList(@PathVariable("menu") String gdsSclassCd, @RequestParam(value="brandNm", required = false, defaultValue="") List<String> brandNm
			, @RequestParam(value="sts", required = false, defaultValue = "") String sts, @RequestParam(value="search", required = false, defaultValue = "") String search 
			, @RequestParam(value="searchPriceSt", required = false, defaultValue = ""  ) String searchPriceSt, @RequestParam(value="searchPriceEd", required = false, defaultValue = "") String searchPriceEd
			, @RequestParam(value="sort", required = false, defaultValue = "1") String sort, RentalAppliVo rentalAppliVo, Model model, HttpSession session
			, @RequestParam(required = false, defaultValue = "1")int page, @RequestParam(required = false, defaultValue = "1")int range) {
		
		String pathPaging = "/rental/Appli/lg/";
		pathPaging += gdsSclassCd;
		
		// RequestParm ���� ����
		session.removeAttribute("menu");
		session.setAttribute("menu", gdsSclassCd);
		session.removeAttribute("brandNm");
		session.setAttribute("brandNm", brandNm);
		session.removeAttribute("sts");
		session.setAttribute("sts", sts);
		session.removeAttribute("search");
		session.setAttribute("search", search);
		session.removeAttribute("searchPriceSt");
		session.setAttribute("searchPriceSt", searchPriceSt);
		session.removeAttribute("searchPriceEd");
		session.setAttribute("searchPriceEd", searchPriceEd);
		session.removeAttribute("sort");
		session.setAttribute("sort", sort);
		
//		System.out.println("=========����1 ����=========");
//		System.out.println(brandNm.size());
//		System.out.println(rentalAppliVo.getBrandNm2());
//		System.out.println("=========����1 ��=========");
		
		// Vo ����
		rentalAppliVo.setGdsSclassCd(gdsSclassCd);
		if(brandNm.size() > 0 ) {
			rentalAppliVo.setBrandNm2(brandNm);
		}
		rentalAppliVo.setSts(sts);
		rentalAppliVo.setSearch(search);
		rentalAppliVo.setSearchPriceSt(searchPriceSt);
		rentalAppliVo.setSearchPriceEd(searchPriceEd);
		rentalAppliVo.setSort(sort);
		

//		System.out.println("=========����2 ����=========");
//		System.out.println(brandNm.size());
//		System.out.println(rentalAppliVo.getBrandNm2());
//		System.out.println("=========����2 ��=========");
		
		List<RentalAppliVo> path = rentalAppliService.rentalPath(rentalAppliVo);				//	PATH ���
		List<RentalAppliVo> list1 = rentalAppliService.rentalMenu(rentalAppliVo);				//	�Ҹ޴��� ����Ʈ
		List<RentalAppliVo> list2 = rentalAppliService.rentalOption(rentalAppliVo, "1");		//	�ɼ� �귣��� ����Ʈ
		List<RentalAppliVo> list3 = rentalAppliService.rentalOption(rentalAppliVo, "2");		//	�ɼ� ���ݴ� ����Ʈ
		List<RentalAppliVo> list4 = rentalAppliService.rentalBest(rentalAppliVo);				//	Best ĳ���� ��ǰ����Ʈ
		List<RentalAppliVo> list6 = rentalAppliService.rentalGdsTotCnt(rentalAppliVo, sort);	// ��ǰ����Ʈ �Ѱ���
		
		// Paging ����
		Paging usedPage = new Paging();
		usedPage.pageInfo(page, range, list6.get(0).getCnt());
		rentalAppliVo.setStartListNum(usedPage.getstartListNum());
		rentalAppliVo.setListSize(usedPage.getListSize());
		
		List<RentalAppliVo> list5 = rentalAppliService.rentalGds(rentalAppliVo, sort);			// ��ǰ����Ʈ
		
//		path test 
//		System.out.println("getGubunCd 			== " + path.get(0).getGubunCd());
//		System.out.println("getGdsMclassNm 		== " + path.get(0).getGdsMclassNm());
//		System.out.println("getGdsSclassNm		== " + path.get(0).getGdsSclassNm());
		
//		session test
//		System.out.println("-----------------session start ----------------------");
//		System.out.println("sessionMenu			== " + session.getAttribute("menu"));
//		System.out.println("sessionBrandnm  	== " + session.getAttribute("brandNm"));
//		System.out.println("sessionSts  		== " + session.getAttribute("sts"));
//		System.out.println("search  			== " + session.getAttribute("search"));
//		System.out.println("searchPriceSt  		== " + session.getAttribute("searchPriceSt"));
//		System.out.println("searchPriceEd  		== " + session.getAttribute("searchPriceEd"));
//		System.out.println("sort		  		== " + session.getAttribute("sort"));
//		System.out.println("-----------------session end ----------------------");
		
//		gds test
//		System.out.println("-----------------list5 start ----------------------");
//		System.out.println("gdsCd				== " + list5.get(0).getGdsCd());
//		System.out.println("gdsLclassCd			== " + list5.get(0).getGdsLclassCd());
//		System.out.println("gdsMclassCd			== " + list5.get(0).getGdsMclassCd());
//		System.out.println("gdsSclassCd			== " + list5.get(0).getGdsSclassCd());
//		System.out.println("gdsNm				== " + list5.get(0).getGdsNm());
//		System.out.println("brandNm				== " + list5.get(0).getBrandNm());
//		System.out.println("modelNm				== " + list5.get(0).getModelNm());
//		System.out.println("mig1				== " + list5.get(0).getImg1());
//		System.out.println("regDt				== " + list5.get(0).getRegDt());
//		System.out.println("gdsPrice			== " + list5.get(0).getGdsPrice());
		

		model.addAttribute("path", path);
		model.addAttribute("list1", list1);
		model.addAttribute("list2", list2);
		model.addAttribute("list3", list3);
		model.addAttribute("list4", list4);
		model.addAttribute("list5", list5);
		model.addAttribute("menu", session.getAttribute("menu"));
		model.addAttribute("brandNm", session.getAttribute("brandNm"));
		model.addAttribute("sts", session.getAttribute("sts"));
		model.addAttribute("search", session.getAttribute("search"));
		model.addAttribute("searchPriceSt", session.getAttribute("searchPriceSt"));
		model.addAttribute("searchPriceEd", session.getAttribute("searchPriceEd"));
		model.addAttribute("sort", session.getAttribute("sort"));
		
		model.addAttribute("pathPaging", pathPaging);
		model.addAttribute("paging", usedPage);
		
		return "rental/rentalAppliLgList";
	}
	
	/**
	 * ����������Ż �󼼺���
	 * 
	 * @param  
	 * @return String 
	 * @author Ȳ�¿�
	 * @exception 
	 */
	@RequestMapping(value = "/{menu}/detail/{gdsCd}", method = RequestMethod.GET)
	public String getLgDeatail(@PathVariable("menu") String gdsSclassCd, @PathVariable("gdsCd") String gdsCd, RentalAppliVo rentalAppliVo, Model model, HttpSession session ) {
//		System.out.println("detail~~~");
		rentalAppliVo.setGdsSclassCd(gdsSclassCd);
		rentalAppliVo.setGdsCd(gdsCd);
		
		List<RentalAppliVo> path = rentalAppliService.rentalPath(rentalAppliVo);		//	PATH ���
		List<RentalAppliVo> grade = rentalAppliService.rentalGrade(rentalAppliVo);		//  ��ǰ����
		List<RentalAppliVo> list1 = rentalAppliService.rentalGdsDetail(rentalAppliVo);	//	��ǰ������
		List<RentalAppliVo> review = rentalAppliService.rentalReview(rentalAppliVo);	//	��ǰ�ı�
		List<RentalAppliVo> reviewCnt = rentalAppliService.rentalReviewCnt(rentalAppliVo);	//	��ǰ�ıⰹ��
		
//		gds test
//		System.out.println("gdsCd				== " + list1.get(0).getGdsCd());
//		System.out.println("gdsLclassCd			== " + list1.get(0).getGdsLclassCd());
//		System.out.println("gdsMclassCd			== " + list1.get(0).getGdsMclassCd());
//		System.out.println("gdsSclassCd			== " + list1.get(0).getGdsSclassCd());
//		System.out.println("gdsNm				== " + list1.get(0).getGdsNm());
//		System.out.println("brandNm				== " + list1.get(0).getBrandNm());
//		System.out.println("modelNm				== " + list1.get(0).getModelNm());
//		System.out.println("mig1				== " + list1.get(0).getImg1());
//		System.out.println("regDt				== " + list1.get(0).getRegDt());
//		System.out.println("gdsPrice			== " + list1.get(0).getGdsPrice());
//		System.out.println("rnk					== " + review.get(0).getRnk());
		
		String user=(String)session.getAttribute("loginUserId");
		System.out.println("sessionId = " + user);
		String sessionMbNo = (String)session.getAttribute("loginMbNo");
		System.out.println("sessionMbno = " + sessionMbNo);
		
		model.addAttribute("path", path);
		model.addAttribute("grade", grade);
		model.addAttribute("list1", list1);
		model.addAttribute("review", review);
		model.addAttribute("reviewCnt", reviewCnt);
		model.addAttribute("loginUserId", user);
		model.addAttribute("sessionMbNo", sessionMbNo);
		
		return "rental/rentalDetail";
	}
	
	/**
	 * ����������Ż ��㿹����
	 * 
	 * @param  
	 * @return String 
	 * @author Ȳ�¿�
	 * @exception 
	 */
	@RequestMapping(value = "/detail/quest", method = RequestMethod.POST)
	public String addLgDetailQuest(RentalAppliVo rentalAppliVo, Model model) {
		int result = rentalAppliService.rentalGdsQuest(rentalAppliVo);		//	�����
		//System.out.println("result = " + result);
		model.addAttribute("rtnCd", Integer.toString(result));
		return "redirect:/rental/Appli/lg/"+rentalAppliVo.getGdsSclassCd()+"/detail/"+rentalAppliVo.getGdsCd();
	}
	
	/**
	 * ����������Ż ��ٱ��ϵ��
	 * 
	 * @param  
	 * @return String 
	 * @author Ȳ�¿�
	 * @exception 
	 */
	@RequestMapping(value = "/detail/cart", method = RequestMethod.POST)
	public String addLgDetailCart(RentalAppliVo rentalAppliVo, Model model ) {
		int result = rentalAppliService.rentalGdsCart(rentalAppliVo);	// ��ٱ��ϵ��
		model.addAttribute("renCd", Integer.toString(result));
		return "redirect:/rental/Appli/lg/"+rentalAppliVo.getGdsSclassCd()+"/detail/"+rentalAppliVo.getGdsCd();
	}
	
	/**
	 * ����������Ż �����ϱ�
	 * 
	 * @param  
	 * @return String 
	 * @author Ȳ�¿�
	 * @exception 
	 */
	@RequestMapping(value = "/detail/odr", method = RequestMethod.POST)
	public String addLgDetailOdr(@RequestParam("totOdrAmt")int totOdrAmt, @RequestParam("crudGbCd")String crudGbCd, @RequestParam("odrGbCd")String odrGbCd, @RequestParam("payGbCd")String payGbCd, 
			@RequestParam("seq")String seq, @RequestParam("mbNo")String mbNo, @RequestParam("gdsCd")String gdsCd,
			@RequestParam("gdsPrice")int gdsPrice, @RequestParam("agreeTerm")String agreeTerm, @RequestParam("deliverCost")String deliverCost, @RequestParam("instalCost")String instalCost, 
			@RequestParam("asCondition")String asCondition, @RequestParam("odrQty")int odrQty, RentalAppliVo rentalAppliVo, Model model, HttpSession session ) {
		
		System.out.println("��Ż���� �Դɰ�");
		
		/* RequestParam text */
//		System.out.println(userId);
//		System.out.println(mbNo);
//		System.out.println(gdsCd);
//		System.out.println(gdsPrice);
//		System.out.println(agreeTerm);
//		System.out.println(deliverCost);
//		System.out.println(instalCost);
//		System.out.println(asCondition);
//		System.out.println(odrQty);
//		System.out.println(realTotPrice);
		
		rentalAppliVo.setCrudGbCd(crudGbCd);
		rentalAppliVo.setOdrGbCd(odrGbCd);
		rentalAppliVo.setPayGbCd(payGbCd);
		rentalAppliVo.setSeq(seq);
		rentalAppliVo.setMbNo((String) session.getAttribute("loginMbNo"));
		rentalAppliVo.setGdsCd(gdsCd);
		rentalAppliVo.setGdsPrice(gdsPrice);
		rentalAppliVo.setAgreeTerm(agreeTerm);
		rentalAppliVo.setOdrQty(odrQty);
		rentalAppliVo.setTotOdrAmt(totOdrAmt);
		
		System.out.println("crudGbCd 		= " +rentalAppliVo.getCrudGbCd());
		System.out.println("odrGbCd	 		= " +rentalAppliVo.getOdrGbCd());
		System.out.println("payGbCd			= " +rentalAppliVo.getPayGbCd());
		System.out.println("seq		= " +rentalAppliVo.getSeq());
		System.out.println("mbNo			= " +rentalAppliVo.getMbNo());
		System.out.println("gdsCd 			= " +rentalAppliVo.getGdsCd());
		System.out.println("gdsPrice 		= " +rentalAppliVo.getGdsPrice());
		System.out.println("agreeTerm 		= " +rentalAppliVo.getAgreeTerm());
		System.out.println("odrQty 			= " +rentalAppliVo.getOdrQty());
		System.out.println("totOdrAmt 		= " +rentalAppliVo.getTotOdrAmt());
		
		int result1 = rentalAppliService.rentalGdsOdr(rentalAppliVo);			// �ֹ��ڷ� ����
		int result2 = rentalAppliService.rentalGdsDetailOdr(rentalAppliVo);		// �ֹ����ڷ� ����
		model.addAttribute("renCd", Integer.toString(result1));

		return null;
	}
}
