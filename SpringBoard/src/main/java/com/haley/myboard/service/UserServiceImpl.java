package com.haley.myboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haley.myboard.dao.UserDao;
import com.haley.myboard.domain.UserVO;

@Service // 서비스 클래스 선언
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	// 1. 로그인 처리 메소드
	@Override
	public UserVO login(UserVO userVO) {

		return userDao.login(userVO);
	}

}
