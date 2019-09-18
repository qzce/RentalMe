package com.me.rentalme.act.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
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
	@RequestMapping(value="/{gdsCdDetail}", method=RequestMethod.GET)
	public ModelAndView getActDetail(@PathVariable("gdsCdDetail") String gdsCdDetail, ActVo actVo, HttpSession session) throws SQLException {
		System.out.println(String.valueOf(session.getAttribute("loginMbNo")).equals(null));
		System.out.println(session.getAttribute("loginMbNo"));
		ModelAndView mav = new ModelAndView();
		mav.addObject("list1", actService.actDetail(gdsCdDetail));
		mav.addObject("list2", actService.actDetailAuction(gdsCdDetail));
		
		mav.setViewName("act/actDetail");
		return mav;
	}
	@RequestMapping(value="/admin/{gdsCdDetail}", method=RequestMethod.GET)
	public ModelAndView getActDetailAdmin(@PathVariable("gdsCdDetail") String gdsCdDetail, ActVo actVo, HttpSession session) throws SQLException {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("list1", actService.actDetail(gdsCdDetail));
		mav.addObject("list2", actService.actDetailAuction(gdsCdDetail));
		
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
		System.out.println(bidresult);
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
		StringBuilder sb=new StringBuilder(gdsCd);
		sb.setCharAt(0, '3');
		sb.setCharAt(1, '0');
		actService.updateActEnd(sb.toString());
		
		/*//

		Set<String> keys=map.keySet();
		Iterator<String> ite=keys.iterator();
		while(ite.hasNext()) {
			ActResultVo bean=new ActResultVo();
			bean.setGdsCd(gdsCd);
			bean.setUserId(ite.next());
			System.out.println("zzz"+map.get(ite.next()));
			Set<String> key=map.get(ite.next()).keySet();
			System.out.println(18);
			Iterator<String> iter=key.iterator();
			System.out.println(19);
			while(ite.hasNext()) {
				System.out.println(20);
				bean.setBidTime(iter.next());	
				System.out.println(21);
				bean.setBidPrice(map.get(ite.next()).get(iter.next()));
				System.out.println(22);
			}
			System.out.println(23);
			actService.insertActResult(bean);
			System.out.println(24);
		}
		*/
		return "redirect:/act/";
	}
	
	///////////////////////// �̺�Ʈ ��� ������
	@RequestMapping(value="/admin", method=RequestMethod.GET)
	public String getActNow(HttpSession session) {
		log.info("index...");
		System.out.println(session.getId()+">>>"+session.getAttributeNames());
		return "act/actAdmin";
	}
	
	
	
}

