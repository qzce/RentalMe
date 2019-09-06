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
import com.me.rentalme.model.entity.ActVo;


/**
* ����������(������) - �̺�Ʈ ��� ��Ʈ�ѷ�
* 
* @author Ȳ����
* @version ver1.0
* @see 
* ������� : 2019.08.14
*/
@Controller
@RequestMapping("/mp/mng")
public class MngActController {
	
	@Inject
	ActService actService;
	
	Logger log = LoggerFactory.getLogger(getClass());
	
	/**
	 * @throws SQLException 
	* �̺�Ʈ ��� 
	* 
	* @param  String code - c : �̺�Ʈ ��� ��� ��, R : �̺�Ʈ ��� ����Ʈ
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/actList", method = RequestMethod.GET)
	public ModelAndView getAct() throws SQLException{
		
		ModelAndView mav=new ModelAndView();
		/////
		///////
		ArrayList<ActVo> list=new ArrayList<ActVo>(actService.listAct());
		mav.addObject("actList", actService.listAct());
		System.out.println(actService.listAct());		
		System.out.println(actService.listAct());		
		
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
	* @author Ȳ����
	* @exception 
	*/
	
	@RequestMapping(value="")
	public ModelAndView modalInsert() {
		
		ModelAndView mav=new ModelAndView();
		return mav;
	}
	@RequestMapping(value = "/actInsert", method = RequestMethod.POST)
	public String addAct(@RequestParam("actStTime") @DateTimeFormat(pattern ="yyyy-MM-dd HH:mm" ) String actStTime,@RequestParam("actEdTime") @DateTimeFormat(pattern ="yyyy-MM-dd HH:mm" ) 
	String actEdTime,MultipartHttpServletRequest mtfRequest,@ModelAttribute ActVo actVo) throws SQLException, ParseException {
		log.debug("�̺�Ʈ ��� ��� ��Ʈ�ѷ�");
		
		int cnt=1;
		String currentTime=System.currentTimeMillis()+"";
		System.out.println("Ŀ��ƮŸ��"+currentTime);
		System.out.println("���۽ð�"+actStTime.charAt(4));
		System.out.println("����ð�"+actEdTime.charAt(5));
		int restTime=0;
		
		SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm");
		
		String format_time1 = format1.format (System.currentTimeMillis());
		
		   int ctime=0;
		   int actStartTime=0;
		   int actEndTime=0;
		for(int i=0;i<actStTime.length();i++) {
			actStartTime=actStTime.charAt(i);
			actEndTime=actEdTime.charAt(i);
			
			if(i==10) {
				actEndTime=0;
			}
			restTime=actStartTime-actEndTime;
			ctime=format_time1.charAt(i);
			System.out.print(actEndTime);
			System.out.println(ctime);
		}
		int restTime2=0;
		restTime2=actEndTime-ctime;
		System.out.println(restTime2);
		
		System.out.println("����ð�"+format_time1);
		/*
		 * SimpleDateFormat transFormat=new SimpleDateFormat("yyyy-MM-dd T HH:mm"); Date
		 * actStTime=(Date)transFormat.parse(startTime); Date
		 * actEdTime=(Date)transFormat.parse(endTime);
		 */
		
		String uploadDir="C:\\java\\workspace4\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\RentalMe\\imgs\\";
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
		}
		System.out.println("hi"+array.get(0).toString());
		return goodsList;
	}





}
