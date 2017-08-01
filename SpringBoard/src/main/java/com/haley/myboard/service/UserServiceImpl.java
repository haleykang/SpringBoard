package com.haley.myboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haley.myboard.dao.UserDao;
import com.haley.myboard.domain.UserVO;

@Service // ���� Ŭ���� ����
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	// 1. �α��� ó�� �޼ҵ�
	@Override
	public UserVO login(UserVO userVO) {

		return userDao.login(userVO);
	}

}
