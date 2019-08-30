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
	@Override
	public List<RentalAppliVo> rentalPath(RentalAppliVo rentalAppliVo) {
		return sqlSession.selectList("rentalAppli.pathRetrive", rentalAppliVo);
	}
	
	/* �Ҹ޴� */
	@Override
	public List<RentalAppliVo> rentalMenuList(RentalAppliVo rentalAppliVo) {
		return sqlSession.selectList("rentalAppli.menuListRetrive", rentalAppliVo);
	}

	/* �ɼ� */
	@Override
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
	@Override
	public List<RentalAppliVo> rentalBestList(RentalAppliVo rentalAppliVo) {
		return sqlSession.selectList("rentalAppli.bestListRetrive", rentalAppliVo);
	}

	/* ��ǰ */
	@Override
	public List<RentalAppliVo> rentalGdsList(RentalAppliVo rentalAppliVo) {
		return sqlSession.selectList("rentalAppli.gdsListRetrive", rentalAppliVo);
	}

}
