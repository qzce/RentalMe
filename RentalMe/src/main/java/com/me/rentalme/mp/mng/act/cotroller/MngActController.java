package com.me.rentalme.mp.mng.act.cotroller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.me.rentalme.act.service.ActService;
import com.me.rentalme.common.Paging;
import com.me.rentalme.model.entity.ActVo;
import com.me.rentalme.model.entity.CallVo;
import com.me.rentalme.mp.mng.service.MngService;


/**
* ����������(������) - �̺�Ʈ ��� ��Ʈ�ѷ�
* 
* @author ���μ�
* @version ver1.0
* @see 
* ������� : 2019.08.14
*/
@Controller
@RequestMapping("/mp/mng")
public class MngActController {
	
	String pagingPath="";
	
	@Inject
	ActService actService;
	
	@Inject
	MngService mngService;
	
	Logger log = LoggerFactory.getLogger(getClass());
	
	/**
	 * @throws SQLException 
	* �̺�Ʈ ��� 
	* 
	* @param  String code - c : �̺�Ʈ ��� ��� ��, R : �̺�Ʈ ��� ����Ʈ
	* @return ModelAndView 
	* @author ���μ�
	* @exception 
	*/
	@RequestMapping(value = "/actList", method = RequestMethod.GET)
	public ModelAndView getAct(Model model,@RequestParam(required = false, defaultValue = "1")int page, @RequestParam(required = false, defaultValue = "1")int range) throws SQLException{
		
		pagingPath="/mp/mng";
		pagingPath+="/actList";
		System.out.println("actlist ��Ʈ�ѷ�");
		int listCnt=actService.actListCnt();
		
		Paging actPaging=new Paging();
		actPaging.pageInfo(page, range, listCnt);
		//csVo.setStartListNum(csPaging.getstartListNum());
		System.out.println("���۳ѹ�:"+actPaging.getstartListNum());
		//csVo.setListSize(csPaging.getListSize());
		System.out.println("�Խù� ����:"+actPaging.getListSize());
		////////////////////////////////////
		
		/////
		///////
		//ArrayList<ActVo> list=new ArrayList<ActVo>(actService.mngListAct());
		ModelAndView mav=new ModelAndView();
		
		//mav.addObject("actList", actService.actList() );
		mav.addObject("actList", actService.mngListAct(actPaging));
		model.addAttribute("pathPaging", pagingPath);
		model.addAttribute("paging", actPaging);
		//System.out.println(actService.mngListAct());	
		
		mav.setViewName("/mp/manager/mngActList");
		
		return mav;
	}
	/**
	* �̺�Ʈ ��� ��� 
	* 
	* @param  ProductVo - ��ǰ
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/actInsertPage")
	public ModelAndView addActPage() {
		log.debug("�̺�Ʈ ��� ��� ������ ��Ʈ�ѷ�");
		
	
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/mp/manager/mngActAdd");
		
		//
		return mav;
	}
	/**
	 * @throws ParseException 
	 * @throws SQLException 
	* �̺�Ʈ ��� ��� 
	* 
	* @param  ProductVo - ��ǰ
	* @return ModelAndView 
	* @author ���μ�
	* @exception 
	*/
	
	@RequestMapping(value="")
	public ModelAndView modalInsert() {
		
		ModelAndView mav=new ModelAndView();
		return mav;
	}
	
	//��Ż�ǰ��� 
	@RequestMapping(value = "/actInsert", method = RequestMethod.POST)

	public String addAct(@RequestParam("actStTime") @DateTimeFormat(pattern ="yyyy-MM-dd HH:mm" ) String actStTime,
			MultipartHttpServletRequest mtfRequest,@ModelAttribute ActVo actVo) throws SQLException, ParseException {
		log.debug("�̺�Ʈ ��� ��� ��Ʈ�ѷ�");
		
		int cnt=1;
		
		System.out.println("��Ż�ǰ��ȣ ���:"+actVo.getGdsCd());
		String chaGdsCd=actVo.getGdsCd().substring(0,6);
		actVo.setGdsCd(chaGdsCd);
		System.out.println("�ٲۻ�ǰ��ȣ ���:"+actVo.getGdsCd());
		
		String currentTime=System.currentTimeMillis()+"";
		System.out.println("Ŀ��ƮŸ��"+currentTime);
		System.out.println("���۽ð�"+actStTime.charAt(4));
		
		SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm");
		
		String format_time1 = format1.format (System.currentTimeMillis());
		

		System.out.println("����ð�"+format_time1);
		
		
		String uploadDir="C:\\java\\workspace4\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\RentalMe\\imgs\\";
//		String uploadDir="/var/lib/tomcat8/webapps/rentalme/imgs/";
		String uploadRDS="/imgs/";
		
		List<MultipartFile> fileList = mtfRequest.getFiles("imgfile");
		
		
	        
		 for (MultipartFile mf : fileList) {
	            String originFileName = mf.getOriginalFilename(); // ���� ���� ��
	            long fileSize = mf.getSize(); // ���� ������

	            System.out.println("originFileName : " + originFileName);
	            System.out.println("fileSize : " + fileSize);

	            String fName=currentTime + originFileName;
	            
	            String safeFile = uploadDir+fName;
	            String img=uploadRDS+fName;
	            try {
	                mf.transferTo(new File(safeFile));
	            } catch (IllegalStateException e) {
	              
	                e.printStackTrace();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	            if(cnt==1) {
	            	actVo.setImg1(img);
	            	cnt++;
	            }else if(cnt==2) {
	            	actVo.setImg2(img);
	            	cnt++;
	            }else if(cnt==3) {
	            	actVo.setImg3(img);
	            	cnt++;
	            }else if(cnt==4) {
	            	actVo.setImg4(img);
	            }
	        }
		 
		mngService.rentalseq(); 
		actService.addAct300(actVo);
		actService.addAct100(actVo);
		return "redirect:/mp/mng/actList";
	}

	
	
	
	
	

	
	
	
	@RequestMapping(value = "searchCode", produces = "application/json; charset=utf-8")
	   public void searchList(HttpServletRequest req, HttpServletResponse res, String param) {
	      System.out.println("js�ڵ�");
	      res.setCharacterEncoding("utf-8");
	    
	      
	      try {
	         String classifi = param;
	         System.out.println("��з�"+classifi);
	         List<String> goodsList = new ArrayList<String>();
	         if(classifi.equals("10")) {
	        	 goodsList.add("������");
	        	 goodsList.add("�ó����");
	        	 goodsList.add("�����");
	        	 goodsList.add("TV");
	        	 goodsList.add("��Ź��");
	        	 goodsList.add("����������");
	        	 goodsList.add("����û����");
	        	 goodsList.add("���ձ�/������");
	         }
	         else if(classifi.equals("20")) {
	        	 goodsList.add("Ŀ�Ǹӽ�");
	        	 goodsList.add("������");
	        	 goodsList.add("û�ұ�");
	        	 goodsList.add("����̾�");
	        	 goodsList.add("����������");
	        	 goodsList.add("��ǻ��/��Ʈ��");
	        	 goodsList.add("��");
	        	 goodsList.add("�鵵��");
	         }
	         else if(classifi.equals("30")) {
	        	 
	        	 goodsList.add("���Ĺ�ó����");
	        	 goodsList.add("������");
	        	 goodsList.add("���ڷ�����");
	        	 goodsList.add("��ǻ��/���������̾�");
	        	 goodsList.add("����");
	         }
	         else if(classifi.equals("40")) {
	        	 
	        	 goodsList.add("ħ��");
	        	 goodsList.add("��Ʈ����");
	        	 goodsList.add("����");
	        	 goodsList.add("å��");
	         }
	         else if(classifi.equals("50")) {
	        	 goodsList.add("�Ǳ�");
	        	 goodsList.add("��ǰ");
	        	 goodsList.add("�ͱݼ�");
	         }
	         else if(classifi.equals("60")) {
	        	 goodsList.add("ħ����Ű��");
	        	 goodsList.add("�ֹ���Ű��");
	        	 goodsList.add("�����Ű��");
	        	 goodsList.add("��Ÿ��Ű��");
	         }
	         
	         
	       
	        
	     //    JSONArray jsonArray = new JSONArray();
	       //  JSONArray jsonarray=new JSONArray();
	         org.json.JSONArray jsonArray=new org.json.JSONArray();
	         
	         for(int i=0; i<goodsList.size(); i++) {
	            jsonArray.put(goodsList.get(i).toString());
//	            System.out.println(jsonArray.get(i));
	         }
	         
	         
	         PrintWriter pw = res.getWriter();
	         pw.print(jsonArray.toString());
	         pw.flush();
	         pw.close();
	         
//	         for(int i=0; i<jsonArray.length(); i++) {
//	            System.out.println(jsonArray.get(i));
//	         }
	         
	      } catch(Exception e) {
	         System.out.println("ajax error");
	      }
	   }
	//modalâ 
	@RequestMapping(value="searchList", method=RequestMethod.GET)
	@ResponseBody
	public List<ActVo> serchList(@RequestParam("param") String goodsNum,Model model) throws SQLException{
		List<ActVo> goodsList=actService.goodsList(goodsNum);
		System.out.println("�� �ȳ�����");
	
		
		ArrayList<String> array=new ArrayList();
		
		
		for(int i=0;i<goodsList.size();i++) {
			array.add(i, goodsList.get(i).toString());
		}
		for(int i=0;i<goodsList.size();i++) {
			System.out.println("��ü ����Ʈ"+goodsList.get(i).getGdsCd());
			StringBuilder act=new StringBuilder(goodsList.get(i).getGdsCd());
			act.setCharAt(0,'3');
			act.setCharAt(1,'0');
			System.out.println(act.toString());
		
			System.out.println();
			System.out.println("��ü ����Ʈ ����"+goodsList.get(i).getGdsCd());
			System.out.println("��ü ����Ʈ"+goodsList.get(i).getGdsNm());
		}
		System.out.println("hi"+array.get(0).toString());
		return goodsList;
	}
	
	//��Ż�ǰ ���û���
	@RequestMapping(value = "/deleteList", method = RequestMethod.POST)
	public ModelAndView deleteCart(@RequestParam(value = "chbox[]") List<String> chArr
			,ActVo actVo) throws SQLException {
	
		System.out.println("��Ż�ǰ ���� ��Ʈ�ѷ�");
		
		ModelAndView mav=new ModelAndView();

		for (String gdsCd : chArr) {
			actVo.setGdsCd(gdsCd);
			
			actService.deleteAct(gdsCd);
		}

		mav.setViewName("/mp/manager/mngActList");
		return mav;
	}



}