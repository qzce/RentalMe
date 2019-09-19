package com.me.rentalme.mp.mng.rental.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.me.rentalme.model.entity.ActVo;
import com.me.rentalme.model.entity.ProductVo;
import com.me.rentalme.model.entity.RentalAppliVo;
import com.me.rentalme.mp.mng.service.MngService;

/**
* ����������(������) ��� ��Ʈ�ѷ�
* 
* @author Ȳ����
* @version ver1.0 
* ������� : 2019.08.14
*/
@Controller
@RequestMapping("/mp")
public class MngRentalController {

	@Inject
	MngService mngService;
	Logger log = LoggerFactory.getLogger(getClass());
	
	/**
	* ����������(������) - ��ǰ��� ��
	* 
	* @param  
	* @return String 
	* @author ���μ�
	* @exception 
	*/
	@RequestMapping(value = "/mng/rentalAddPage", method = RequestMethod.GET)
	public ModelAndView getPrdRegisterForm() {
		log.debug("����������(������) ��ǰ ��� �� ��Ʈ�ѷ�");
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("mp/manager/mngRentalAdd");
		
		
		return mav;
	}
	
	/**
	* ����������(������) - ��ǰ��� 
	* 
	* @param  String prdDiv - �ߺз�
	* @return ModelAndView
	* @author ���μ�
	* @exception 
	*/
	@RequestMapping(value = "/mng/rentalInsert", method = RequestMethod.POST)
	public ModelAndView getRentalList(
			MultipartHttpServletRequest mtfRequest,RentalAppliVo rentalAppliVo,ProductVo productVo) {
		log.debug("����������(������) ��ǰ ��� ��Ʈ�ѷ�");
		
		System.out.println("��ǰ�ڵ�"+rentalAppliVo.getGdsCd());
		System.out.println("��ǰ��з�"+rentalAppliVo.getGdsLclassCd());
		System.out.println("��ǰ�ߺз�"+rentalAppliVo.getGdsMclassCd());
		System.out.println("��ǰ�̸�"+rentalAppliVo.getGdsNm());
		System.out.println("�귣��"+rentalAppliVo.getBrandNm());
		System.out.println("���̸�"+rentalAppliVo.getModelNm());
		System.out.println("��ǰ����"+rentalAppliVo.getGdsGbCd());
		
		productVo.setPrdCode(rentalAppliVo.getGdsCd());	//gds200 ��ǰ��ȣ
		
		System.out.println("��ǰ�ڵ�"+productVo.getPrdCode());
		System.out.println("���Ⱓ"+productVo.getPrdContDate());
		System.out.println("��ۺ�"+productVo.getPrdDeliveryCost());
		System.out.println("��ġ��"+productVo.getPrdInstCost());
		System.out.println("AS����"+productVo.getPrdAsContent());
		
		int cnt=1;
		String currentTime=System.currentTimeMillis()+"";
		
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
	            	productVo.setImg1(img);
	            	cnt++;
	            }else if(cnt==2) {
	            	productVo.setImg2(img);
	            	cnt++;
	            }else if(cnt==3) {
	            	productVo.setImg3(img);
	            	cnt++;
	            }else if(cnt==4) {
	            	productVo.setImg4(img);
	            	cnt++;
	            }else if(cnt==5) {
	            	productVo.setImg5(img);
					cnt++;
				}else if(cnt==6) {
					productVo.setImg6(img);
					cnt++;
				}else if(cnt==7) {
					productVo.setImg7(img);
					cnt++;
				}else if(cnt==8) {
					productVo.setImg8(img);
					cnt++;
				}else if(cnt==9) {
					productVo.setImg9(img);
					cnt++;
				}else if(cnt==10) {
					productVo.setImg10(img);
					cnt++;
				}else if(cnt==11) {
					productVo.setImg11(img);
					cnt++;
				}else if(cnt==12) {
					productVo.setImg12(img);
				}
	           
	            
	        }
		 
		mngService.rentalGoodsAdd100(rentalAppliVo);
		mngService.rentalGoodsAdd200(productVo);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/mp/mng/goodsList");
		return mav;
	}
}
