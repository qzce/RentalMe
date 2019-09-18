package com.me.rentalme.used.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.me.rentalme.model.entity.DeclVo;
import com.me.rentalme.model.entity.UsedCmtVo;
import com.me.rentalme.model.entity.UsedStoreVo;
import com.me.rentalme.model.entity.UsedVo;
import com.me.rentalme.used.service.UsedService;


/**
* �߰�ŷ� ��Ʈ�ѷ�
* 
* @author Ȳ����
* @version ver1.0
* @see 
* ������� : 2019.08.18
*/
@Controller
@RequestMapping("/used")
public class UsedController {

	Logger log = LoggerFactory.getLogger(getClass());
	
	@Inject
	UsedService usedService;

	/**
	 * @throws SQLException 
	* �߰�ŷ� ����Ʈ
	* 
	* @param  None
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/big", method = RequestMethod.GET)
	public String getUsedListB(Model model,
			@RequestParam(required = false, defaultValue = "0")int startPage,
			@RequestParam(required = false, defaultValue = "")String modelNm,
			@RequestParam(required = false, defaultValue = "1")String align,
			HttpSession session) throws SQLException {
		UsedVo bean=new UsedVo();
		log.debug("�߰�ŷ� ��������");
		bean.setStartPage(startPage);
		bean.setModelNm(modelNm);
		bean.setAlign(align);
		bean.setGdsMclassCd("10");
		sessionFunc(session,bean);
		model.addAttribute("remain", 10);
		model.addAttribute("alist1", usedService.oneList(bean));
		return "used/usedList";
	}
	@RequestMapping(value = "/sml", method = RequestMethod.GET)
	public String getUsedListS(Model model,HttpSession session,@ModelAttribute UsedVo bean) throws SQLException {
		log.debug("�߰�ŷ� ��������");
		bean.setGdsMclassCd("20");
		sessionFunc(session,bean);
		model.addAttribute("remain", 20);
		model.addAttribute("alist1", usedService.oneList(bean));
		return "used/usedList";
	}
	@RequestMapping(value = "/kit", method = RequestMethod.GET)
	public String getUsedListK(Model model,HttpSession session,@ModelAttribute UsedVo bean) throws SQLException {
		log.debug("�߰�ŷ� �ֹ氡��");
		bean.setGdsMclassCd("30");
		sessionFunc(session,bean);
		model.addAttribute("remain", 30);
		model.addAttribute("alist1", usedService.oneList(bean));
		return "used/usedList";
	}
	@RequestMapping(value = "/app", method = RequestMethod.GET)
	public String getUsedListA(Model model,HttpSession session,@ModelAttribute UsedVo bean) throws SQLException {
		log.debug("�߰�ŷ� ����");
		bean.setGdsMclassCd("40");
		sessionFunc(session,bean);
		model.addAttribute("remain", 40);
		model.addAttribute("alist1", usedService.oneList(bean));
		return "used/usedList";
	}
	@RequestMapping(value = "/etc", method = RequestMethod.GET)
	public String getUsedListE(Model model,HttpSession session,@ModelAttribute UsedVo bean) throws SQLException {
		log.debug("�߰�ŷ� ��Ÿ");
		bean.setGdsMclassCd("50");
		sessionFunc(session,bean);
		model.addAttribute("remain", 50);
		model.addAttribute("alist1", usedService.oneList(bean));
		return "used/usedList";
	}
	
	public void sessionFunc(HttpSession session,UsedVo bean) throws SQLException {
		session.removeAttribute("gdsMclassCd");
		session.removeAttribute("align");
		session.removeAttribute("modelNm");
		session.removeAttribute("page");
		session.removeAttribute("listsize");
		session.setAttribute("gdsMclassCd", bean.getGdsMclassCd());
		session.setAttribute("align", bean.getAlign());
		session.setAttribute("modelNm", bean.getModelNm());
		session.setAttribute("page",bean.getStartPage());
		int page=(usedService.usedcount(bean)-1)/10+1;
		session.setAttribute("listsize", page);
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String getUsedListS(HttpSession session,Model model,@ModelAttribute UsedVo bean) throws SQLException {
		
		log.debug("�߰�ŷ� �˻� ��Ʈ�ѷ�");
		sessionFunc(session,bean);
		model.addAttribute("alist1", usedService.oneList(bean));
		return "used/usedList";
	}

	/**
	 * @throws SQLException 
	* �߰�ŷ� �󼼺���
	* 
	* @param  int idx
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/detail/{idx}", method = RequestMethod.GET)
	public String getUsedDetail(Model model, @PathVariable("idx") String usedGdsNo) throws SQLException {
		
		model.addAttribute("UsedVo", usedService.detail(usedGdsNo));
		model.addAttribute("cmt", usedService.cmtList(usedGdsNo));
		return "used/usedDetail";
	}
	@RequestMapping(value = "/cmtAdd", method = RequestMethod.POST)
	public String getUsedCmtAdd(@ModelAttribute UsedCmtVo bean) throws SQLException {
		
		usedService.addCmt(bean);
		return "redirect:/used/detail/"+bean.getUsedGdsNo();
	}
	@RequestMapping(value = "/cmtDecl", method = RequestMethod.POST)
	public String getUsedCmtDecl(@ModelAttribute DeclVo bean) throws  SQLException {
		usedService.usedComtDecl(bean);
		return "redirect:/used/detail/"+bean.getUsedGdsNo();
	}
	
	
	/**
	 * @throws SQLException 
	* ���� �߰���� ����Ʈ
	* 
	* @param  None
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/store/{idx}", method = RequestMethod.GET)
	public String getUsedMyStore(HttpSession session,Model model,@PathVariable("idx") String mbNo) throws SQLException {
		model.addAttribute("mbNo", mbNo);
		model.addAttribute("alist", usedService.myUsedAll(mbNo));
		model.addAttribute("cmtlist", usedService.listMyStoreCmt(mbNo));
		return "used/usedMyStore";
	}
	@RequestMapping(value = "/store/now", method = RequestMethod.GET)
	public String getUsedMyStoreNow(HttpSession session,Model model,@ModelAttribute UsedVo bean) throws SQLException {
		model.addAttribute("usedGdsResStsCd", bean.getUsedGdsResStsCd());
		model.addAttribute("mbNo", bean.getMbNo());
		model.addAttribute("alist", usedService.mySelectAllAlign(bean));
		model.addAttribute("cmtlist", usedService.listMyStoreCmt(bean.getMbNo()));
		return "used/usedMyStore";
	}

	@RequestMapping(value = "/store/reviewinsert", method = RequestMethod.POST)
	public String getUsedMyStroeReviewInsert(HttpSession session,@ModelAttribute UsedStoreVo bean) throws SQLException {
		
		usedService.addMyStoreCmt(bean);
		
		return "redirect:/used/store/"+session.getAttribute("loginMbNo");
	}
	@RequestMapping(value = "/store/cmtDecl", method = RequestMethod.POST)
	public String getUsedMyStroecmtDecl(@ModelAttribute DeclVo bean) throws SQLException {
		System.out.println(bean.getStoreNo()+","+bean.getStoreReviewDt()+","+bean.getStoreReviewNo());
		usedService.usedStoreDecl(bean);
		
		return "redirect:/used/store/"+bean.getMbNo();
	}
	
	@RequestMapping(value = "/store/del/{idx}", method = RequestMethod.POST)
	public String getUsedMyStroeReviewDelete(HttpSession session,@PathVariable("idx") String usedGdsNo) throws SQLException {
		
		usedService.delMyStoreListOne(usedGdsNo);
		
		return "redirect:/used/store/"+session.getAttribute("loginMbNo");
	}
	
	
	/**
	* �߰�ŷ� ��ǰ��� ��
	* 
	* @param  None
	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/mng", method = RequestMethod.GET)
	public ModelAndView getUsedPrd() {
		
		
		ModelAndView mav = new ModelAndView("used/usedMng");
		return mav;
	}
	
	/**
	 * @throws SQLException 
	* �߰�ŷ� ��ǰ��� 
//	* 
//	* @param  None
//	* @return ModelAndView 
	* @author Ȳ����
	* @exception 
	*/
	@RequestMapping(value = "/mng", method = RequestMethod.POST)
	public String addUsedPrd(HttpSession session,MultipartHttpServletRequest mtfRequest,@ModelAttribute UsedVo bean) throws SQLException {
		
		int cnt=1; //�̹��� ī��Ʈ
		
		String currentTime=System.currentTimeMillis()+"";
		//String uploadDir="C:\\Users\\USER\\git\\RentalMe\\RentalMe\\src\\main\\webapp\\imgs\\";
		String uploadDir="C:\\java\\3rdProject\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\RentalMe\\imgs\\";
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
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if(cnt==1) {
            	bean.setImg1(img);
            	cnt++;
            }else if(cnt==2) {
            	bean.setImg2(img);
            	cnt++;
            }else if(cnt==3) {
            	bean.setImg3(img);
            	cnt++;
            }else if(cnt==4) {
            	bean.setImg4(img);
            }
        }
        
		// ������ 1����
		usedService.seqUp();
		usedService.addUsed(bean);
		
		return "redirect:/used/store/"+session.getAttribute("loginMbNo");
	}

	
	/**
	 * �߰�ŷ� ��ǰ����
	 * 
	 * @param  None
	 * @return ModelAndView 
	 * @author Ȳ����
	 * @exception 
	 */
	@RequestMapping(value = "/mng", method = RequestMethod.PUT)
	public ModelAndView modifyUsedPrd() {
		
		
		ModelAndView mav = new ModelAndView("used/usedMyStore");
		return mav;
	}

}
