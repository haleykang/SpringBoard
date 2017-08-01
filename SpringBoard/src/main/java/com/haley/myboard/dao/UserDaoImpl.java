package com.haley.myboard.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haley.myboard.domain.UserVO;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SqlSession sqlSession;

	// 1. 로그인 SQL 연동
	@Override
	public UserVO login(UserVO userVO) {
		// id와 pw로 검색 했을 때 return 될 수 있는 값은 1개 -> selectOne
		return sqlSession.selectOne("user.login", userVO);
	}

}
