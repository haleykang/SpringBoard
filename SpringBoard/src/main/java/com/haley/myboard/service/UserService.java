package com.haley.myboard.service;

import com.haley.myboard.domain.UserVO;

public interface UserService {

	// 1. 로그인 처리 메소드 선언
	public UserVO login(UserVO userVO);

}
