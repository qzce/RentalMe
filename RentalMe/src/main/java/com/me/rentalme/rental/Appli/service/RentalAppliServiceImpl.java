package com.me.rentalme.rental.Appli.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.me.rentalme.model.entity.RentalAppliVo;
import com.me.rentalme.rental.Appli.model.RentalAppliDao;

@Service
public class RentalAppliServiceImpl implements RentalAppliService {

	@Inject
	RentalAppliDao rentalAppliDao;
	
	@Override
	public List<RentalAppliVo> rentalPath(RentalAppliVo rentalAppliVo) {
		return rentalAppliDao.rentalPath(rentalAppliVo);
	}
	
	@Override
	public List<RentalAppliVo> rentalMenu(RentalAppliVo rentalAppliVo) {
		return rentalAppliDao.rentalMenuList(rentalAppliVo);
	}

	@Override
	public List<RentalAppliVo> rentalOption(RentalAppliVo rentalAppliVo, String option) {
		return rentalAppliDao.rentalOptionList(rentalAppliVo, option);
	}

	@Override
	public List<RentalAppliVo> rentalBest(RentalAppliVo rentalAppliVo) {
		return rentalAppliDao.rentalBestList(rentalAppliVo);
	}

	@Override
	public List<RentalAppliVo> rentalGds(RentalAppliVo rentalAppliVo, String sortGbCd) {
		if(sortGbCd.equals("1")) {
			// ��Ż ���� �α�� : 1
			rentalAppliVo.setSortGbCd("1");
			return rentalAppliDao.rentalGdsList2(rentalAppliVo);
		} else if(sortGbCd.equals("2")) {
			// ��Ż ���� �ֽż� : 2
			rentalAppliVo.setSortGbCd("2");
			return rentalAppliDao.rentalGdsList(rentalAppliVo);
		} else if(sortGbCd.equals("3")) {
			// ��Ż ���� �������ݼ� : 3
			rentalAppliVo.setSortGbCd("3");
			return rentalAppliDao.rentalGdsList(rentalAppliVo);
		} else if(sortGbCd.equals("4")) {
			// ��Ż ���� �������ݼ� : 4
			rentalAppliVo.setSortGbCd("4");
			return rentalAppliDao.rentalGdsList(rentalAppliVo);
		} else if(sortGbCd.equals("5")) {
			// ��Ż ���� �Ǹŷ��� : 5
			rentalAppliVo.setSortGbCd("5");
			return rentalAppliDao.rentalGdsList2(rentalAppliVo);
		} else {
			// ��Ż ���� ���丹���� : 6
			rentalAppliVo.setSortGbCd("6");
			return rentalAppliDao.rentalGdsListDetail(rentalAppliVo);
		}
	}

	
	@Override
	public List<RentalAppliVo> rentalGrade(RentalAppliVo rentalAppliVo) {
		return rentalAppliDao.rentalGrade(rentalAppliVo);
	}
	
	@Override
	public List<RentalAppliVo> rentalGdsDetail(RentalAppliVo rentalAppliVo) {
		return rentalAppliDao.rentalGdsListDetail(rentalAppliVo);
	}


}
