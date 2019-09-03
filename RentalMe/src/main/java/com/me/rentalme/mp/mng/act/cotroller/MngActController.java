package com.me.rentalme.mp.mng.act.cotroller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.me.rentalme.act.service.ActService;
import com.me.rentalme.model.entity.ActVo;
import com.me.rentalme.model.entity.ProductVo;


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
		mav.addObject("actList", actService.listAct() );
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
		return mav;
	}
	/**
	 * @throws SQLException 
	* �̺�Ʈ ��� ��� 
	* 
	* @param  ProductVo - ��ǰ
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	
	
	@RequestMapping(value = "/actInsert", method = RequestMethod.POST)
	public String addAct(@RequestParam("actStTime") @DateTimeFormat(pattern ="yyyy-MM-dd 'T' HH:mm" ) String actStTime,@RequestParam("actEdTime") @DateTimeFormat(pattern ="yyyy-MM-dd 'T' HH:mm" ) 
	String actEdTime,MultipartHttpServletRequest mtfRequest,@ModelAttribute ActVo actVo) throws SQLException {
		log.debug("�̺�Ʈ ��� ��� ��Ʈ�ѷ�");
		
		int cnt=1;
		String currentTime=System.currentTimeMillis()+"";
		
		System.out.println("Ŀ��ƮŸ��"+currentTime);
		
		
		String uploadDir="C:\\java\\workspace4\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\RentalMe\\imgs\\";
		String uploadRDS="/imgs/";
		
		List<MultipartFile> fileList = mtfRequest.getFiles("imgfile");
		
		 String src = mtfRequest.getParameter("src");
	        System.out.println("src value : " + src);
	        
	        
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
		actService.addAct(actVo);
		
		return "redirect:/mp/mng/actList";
	}
}
