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

	// 2. 아이디 중복 체크
	@Override
	public boolean idCheck(String id) {
		// 1) userDao.iDcheck 실행해서 리턴 값 가져오기
		String result = userDao.idCheck(id);
		// 2) 중복 여부 확인
		if (result == null) {
			// 중복되는 아이디가 없는 경우 result == null
			return true;
		}
		// result 가 null이 아니면 아이디 중복
		return false;
	}

}
