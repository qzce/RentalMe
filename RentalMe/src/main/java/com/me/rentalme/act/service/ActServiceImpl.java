package com.me.rentalme.act.service;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.me.rentalme.act.dao.ActDao;
import com.me.rentalme.model.entity.ActVo;

@Service
public class ActServiceImpl implements ActService {

	@Inject
	ActDao actDao;
	
	@Override
	public List<ActVo> listAct() throws SQLException {
		System.out.println("actlistdao�� ����");
		return actDao.selectActList();
	}

	@Override
	public int addAct(ActVo actVo) throws SQLException {
		System.out.println("insertAct dao�� ����");
		System.out.println("���۽ð�"+actVo.getActStTime());
		System.out.println("����ð�"+actVo.getActEdTime());
		System.out.println("content"+actVo.getContent());
		return actDao.insertAct(actVo);
	}

}
