package com.haley.myboard.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haley.myboard.domain.UserVO;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SqlSession sqlSession;

	// 1. �α��� SQL ����
	@Override
	public UserVO login(UserVO userVO) {
		// id�� pw�� �˻� ���� �� return �� �� �ִ� ���� 1�� -> selectOne
		return sqlSession.selectOne("user.login", userVO);
	}

}
