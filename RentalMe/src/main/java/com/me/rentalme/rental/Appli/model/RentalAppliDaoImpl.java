package com.me.rentalme.rental.Appli.model;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.me.rentalme.model.entity.RentalAppliVo;



@Repository
public class RentalAppliDaoImpl implements RentalAppliDao {

	@Inject
	SqlSession sqlSession;
	
	/* ��� */
	public List<RentalAppliVo> rentalPath(RentalAppliVo rentalAppliVo) {
		return sqlSession.selectList("rentalAppli.pathRetrive", rentalAppliVo);
	}
	
	/* �Ҹ޴� */
	public List<RentalAppliVo> rentalMenuList(RentalAppliVo rentalAppliVo) {
		return sqlSession.selectList("rentalAppli.menuListRetrive", rentalAppliVo);
	}

	/* �ɼ� */
	public List<RentalAppliVo> rentalOptionList(RentalAppliVo rentalAppliVo, String option) {
		if(option.equals("1")) {
			// ��Ż �ɼ� �귣�� : 1
			return sqlSession.selectList("rentalAppli.optionBrandListRetrive", rentalAppliVo);
		} else {
			// ��Ż �ɼ� ���� : 2
			return sqlSession.selectList("rentalAppli.optionPriceListRetrive", rentalAppliVo);
		}
	}

	/* BEST ĳ���� */
	public List<RentalAppliVo> rentalBestList(RentalAppliVo rentalAppliVo) {
		return sqlSession.selectList("rentalAppli.bestListRetrive", rentalAppliVo);
	}

	/* ��ǰ 2,3,4*/
	public List<RentalAppliVo> rentalGdsList(RentalAppliVo rentalAppliVo) {
		return sqlSession.selectList("rentalAppli.gdsListRetrive", rentalAppliVo);
	}

	/* ��ǰ 1,5,6 */
	public List<RentalAppliVo> rentalGdsList2(RentalAppliVo rentalAppliVo) {
		return sqlSession.selectList("rentalAppli.gdsListRetrive2", rentalAppliVo);
	}

	/* ���� */
	public List<RentalAppliVo> rentalGrade(RentalAppliVo rentalAppliVo) {
		return sqlSession.selectList("rentalAppli.gradeRetrive", rentalAppliVo);
	}
	
	/* ������ */
	public List<RentalAppliVo> rentalGdsListDetail(RentalAppliVo rentalAppliVo) {
		return sqlSession.selectList("rentalAppli.gdsListDetailRetrive", rentalAppliVo);
	}

	/* ����� */
	public int rentalGdsQuest(RentalAppliVo rentalAppliVo) {
		// �������� ����
		sqlSession.insert("rentalAppli.questSeqProduce", rentalAppliVo);
		return sqlSession.insert("rentalAppli.gdsQuestRegister", rentalAppliVo);
	}

	/* �ı� */
	public List<RentalAppliVo> rentalReview(RentalAppliVo rentalAppliVo) {
		return sqlSession.selectList("rentalAppli.reviewRetrive", rentalAppliVo);
	}

	/* �ıⰹ�� */
	@Override
	public List<RentalAppliVo> rentalReviewCnt(RentalAppliVo rentalAppliVo) {
		return sqlSession.selectList("rentalAppli.reviewRetriveCnt", rentalAppliVo);
	}

	/* ��ٱ��ϵ�� */
	public int rentalGdsCart(RentalAppliVo rentalAppliVo) {
		System.out.println("getMbNo = " + rentalAppliVo.getMbNo());
		System.out.println("getGdsCd = " + rentalAppliVo.getGdsCd());
		System.out.println("getOdrQty = " + rentalAppliVo.getOdrQty());
		System.out.println("getAgreeTerm = " + rentalAppliVo.getAgreeTerm());
		
		return sqlSession.insert("rentalAppli.gdsCartRegister", rentalAppliVo);
	}



}
