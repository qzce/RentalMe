package com.me.rentalme.login.find.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.me.rentalme.model.entity.UserVo;

/**
* ���̵�/��й�ȣ ã�� Dao
* 
* @author Ȳ����
* @version ver1.0
* @see 
* ������� : 2019.08.28
*/
@Repository
public class LoginFindDaoImpl implements LoginFindDao {
	
	Logger log = LoggerFactory.getLogger(getClass());

	@Inject
	SqlSession sqlSession;
	/**
	* �Է��� �̸����� ��ϵ� �̸������� üũ (1���̻� : ��ϵ� ���̵�, 0�� : ��ϵ� ���̵� x)
	* 
	* @param  String email : �̸����ּ�
	* @return String 
	* @author Ȳ����
	* @exception
	*/
	@Override
	public int checkEmail(String email) {
		log.debug("�̸��Ϸ� ���̵� ��/�� üũ Dao");
		
		return sqlSession.selectOne("loginFind.checkId", email);
	}
	
	/**
	* ��ϵ� �̸��Ϸ� ���̵� ã�� - ���̵�, ��������
	* 
	* @param  String email : �̸����ּ�
	* @return String 
	* @author Ȳ����
	* @exception
	*/	
	@Override
	public List<UserVo> getEmailFindId (String email) {
		log.debug("�̸��Ϸ� ���̵� ã�� Dao");

		return sqlSession.selectList("loginFind.getId", email);
	}
	
	/**
	* ��ϵ� �̸��Ϸ� ��й�ȣ ã�� 
	* 
	* @param  String userId : �Է��� ����� ���̵� 
	* @param  String email  : �Է��� ����� �̸���
	* @return int 
	* @author Ȳ����
	* @exception
	*/	
	@Override
	public int checkPwEmail(String userId, String email) {
		log.debug("��ϵ� �̸��Ϸ� ��й�ȣ ã�� Dao");
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		map.put("email", email);
		int result = sqlSession.selectOne("loginFind.checkPwEmail", map);
		return result;
	}
	
	/**
	* ��ϵ� �ڵ������� ��й�ȣ ã�� 
	* 
	* @param  String userId : �Է��� ����� ���̵� 
	* @param  String hp  : �Է��� ����� �ڵ�����ȣ
	* @return int 
	* @author Ȳ����
	* ������� : 2019-09-21
	*/
	@Override
	public int checkPwHp(String userId, String hp) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		map.put("hp", hp);
		int result =  sqlSession.selectOne("loginFind.checkPwHp", map);
		System.out.println("result : "+result);
		return result;
	}

	/**
	* ��й�ȣ ���� 
	* 
	* @param  String userPw
	* @return void
	* @author Ȳ����
	* @exception
	*/
	@Override
	public int updPw(String userPw, String userId, String email) {
		log.debug("��й�ȣ ���� Dao");
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("userPw", userPw);
		map.put("userId", userId);
		map.put("email", email);
		
		return sqlSession.update("loginFind.changePw", map);
		
	}

	/**
	* ��ϵ� �ڵ����� ���ſ��� üũ 
	* 
	* @param  String hp
	* @return int - ���ŵ��ǵ� ���̵� ����
	* @author Ȳ����
	* ������� : 2019-09-09
	*/
	@Override
	public int selectHpYn(String hp) {
	return sqlSession.selectOne("loginFind.hpYnCheck", hp);
	}
	
	/**
	 * ��ϵ� �ڵ������� ���̵� ã�� 
	 * 
	 * @param  String hp : �Է��� �ڵ�����ȣ
	 * @return List
	 * @author Ȳ����
	 * ������� : 2019-09-09
	 */
	@Override
	public List<UserVo> getHpFindId(String hp) {
		//js�� ������ �ΰ��� �и��ؼ� ���� �� ���� �ϳ��� �޼��忡 �б��ļ� ������ ���� 
		//�ΰ��� �и��� ��� - (�ڵ尡 ������ �ߺ����� ����Ǵ� ���װ� ����)
		return sqlSession.selectList("loginFind.hpFindId", hp);
	}
	


}
