package com.me.rentalme.act.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

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
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.me.rentalme.act.service.ActService;
import com.me.rentalme.model.entity.ActResultVo;
import com.me.rentalme.model.entity.ActVo;
import com.me.rentalme.model.entity.CallVo;



/**
* �̺�Ʈ ��� ��Ʈ�ѷ�
* 
* @author ������
* @version ver1.0
* @see 
* ������� : 2019.09.04
*/
@Controller
@RequestMapping("/act")
public class ActController {

	Logger log = LoggerFactory.getLogger(getClass());
	
	@Inject
	ActService actService;
	
	/**
	* �̺�Ʈ ��� ����Ʈ
	* 
	* @param  None
	* @return ModelAndView 
	* @author ������
	* @exception 
	*/
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView getActList(HttpSession session) throws SQLException{
		ModelAndView mav = new ModelAndView();
		mav.addObject("alist", actService.actList());
		mav.addObject("alist2",actService.actEndList());
		if(String.valueOf(session.getAttribute("loginMbNo")).equals("null")) {
			mav.setViewName("redirect:/login");
		}else {
			mav.addObject("myMb", actService.selectMyMb(String.valueOf(session.getAttribute("loginMbNo"))));
			mav.setViewName("act/actList");
		}
		return mav;
	}
	
	/**
	 * @throws SQLException 
	* �̺�Ʈ ��� �󼼺���
	* 
	* @param  None
	* @return ModelAndView 
	* @author ������
	* @exception 
	*/
	@RequestMapping(value="/{gdsCd}", method=RequestMethod.GET)
	public ModelAndView getActDetail(@PathVariable("gdsCd") String gdsCd, ActVo actVo, HttpSession session) throws SQLException {
		System.out.println(String.valueOf(session.getAttribute("loginMbNo")).equals(null));
		System.out.println(session.getAttribute("loginMbNo"));
		ModelAndView mav = new ModelAndView();
		mav.addObject("list1", actService.actDetail(gdsCd));
		mav.addObject("list2", actService.actDetailAuction(gdsCd));
		
		mav.setViewName("act/actDetail");
		return mav;
	}
	@RequestMapping(value="/admin/{gdsCd}", method=RequestMethod.GET)
	public ModelAndView getActDetailAdmin(@PathVariable("gdsCd") String gdsCd, ActVo actVo, HttpSession session) throws SQLException {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("list1", actService.actDetail(gdsCd));
		mav.addObject("list2", actService.actDetailAuction(gdsCd));
		actService.updateMngActStsCd(gdsCd);
		mav.setViewName("act/actAdmin");
		return mav;
	}
	
	/**
	* �̺�Ʈ ��� �󼼼���
	* 
	* @param  None
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value="/gds/{idx}", method=RequestMethod.GET)
	public ModelAndView getDiscript(@PathVariable int idx) {
		
		
		ModelAndView mav = new ModelAndView("act/actGdsDetail");
		return mav;
	}
	
	
	/**
	* �̺�Ʈ ��� ������� - ��Ʈ�ѷ� ���� ��� ����
	* 
	* @param  None
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	///////////////////////// �̺�Ʈ ��� ���� ��
	@RequestMapping(value="/ac", method=RequestMethod.GET)
	public String getActDei(HttpSession session) {
		log.info("index...");
		System.out.println(session.getId()+">>>"+session.getAttributeNames());
		return "act/actDetail";
	}
	
	@RequestMapping(value="/result", method=RequestMethod.POST)
	public String getActResult(@RequestParam("bidresult") String bidresult,
								@RequestParam("gdsCd") String gdsCd) throws SQLException {
		System.out.println("gdsCd:"+gdsCd);
		ObjectMapper mapper = new ObjectMapper();
		Map<String,Map<String,Integer>> map=new HashMap<String, Map<String,Integer>>();
		Map<String, Integer> map2 = new HashMap<String, Integer>();
		try {
			map=mapper.readValue(bidresult, new TypeReference<Map<String,Map<String,Integer>>>(){});
			System.out.println("dddadda"+map.toString());
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for(Map.Entry<String, Map<String,Integer>> entry : map.entrySet()) {
			ActResultVo bean=new ActResultVo();
			System.out.println("key : "+entry.getKey()+", value : "+entry.getValue());
			bean.setGdsCd(gdsCd);
			bean.setUserId(entry.getKey());
			for(Map.Entry<String, Integer> entry2 : entry.getValue().entrySet()) {
				System.out.println("key : "+entry2.getKey()+", value : "+entry2.getValue());
				bean.setBidTime(entry2.getKey());
				bean.setBidPrice(entry2.getValue());
			}
			actService.insertActResult(bean);
			
		}
		actService.updateBidWin(gdsCd);
		actService.updateActEnd(gdsCd);
		
//		ObjectMapper mapper = new ObjectMapper();
//		Map<String,Map<String,Integer>> map=new HashMap<String, Map<String,Integer>>();
//		Map<String, Integer> map2 = new HashMap<String, Integer>();
//		try {
//			map=mapper.readValue(bidresult, new TypeReference<Map<String,Map<String,Integer>>>(){});
//			System.out.println("dddadda"+map.toString());
//		} catch (JsonParseException e) {
//			e.printStackTrace();
//		} catch (JsonMappingException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		for(Map.Entry<String, Map<String,Integer>> entry : map.entrySet()) {
//			ActResultVo bean=new ActResultVo();
//			System.out.println("key : "+entry.getKey()+", value : "+entry.getValue());
//			bean.setGdsCd(gdsCd);
//			bean.setUserId(entry.getKey());
//			for(Map.Entry<String, Integer> entry2 : entry.getValue().entrySet()) {
//				System.out.println("key : "+entry2.getKey()+", value : "+entry2.getValue());
//				bean.setBidTime(entry2.getKey());
//				bean.setBidPrice(entry2.getValue());
//			}
//			actService.insertActResult(bean);
//			
//		}
//		actService.updateBidWin(gdsCd);
//		StringBuilder sb=new StringBuilder(gdsCd);
//		sb.setCharAt(0, '3');
//		sb.setCharAt(1, '0');
//		actService.updateActEnd(sb.toString());
		
		return "redirect:/act/";
	}
	
	/* ����� ��ų��� ���(����) */
	@RequestMapping(value = "/cancel", method = RequestMethod.POST)
	public String getActCancel(Model model,
			@RequestParam("gdsCd") String gdsCd,
			@RequestParam("mbNo") String mbNo,
			@RequestParam("gdsStPrice") String gdsStPrice) throws SQLException {
		CallVo bean = new CallVo();
		bean.setMbNo(mbNo);
		bean.setGdsStPrice(gdsStPrice);
		actService.updateMngBidCancel(gdsCd);
		actService.updateBidWin(gdsCd);
		actService.insertUserActMoney(bean);
		actService.updateUserActMoney(bean);
		
		return "redirect:/mp/auctList";
	}
	
	
	
	
	
}

