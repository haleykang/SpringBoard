package com.haley.myboard.dao;

import com.haley.myboard.domain.UserVO;

// SpringUser 테이블에 대한 데이터베이스 작업 메소드 소유한 인터페이스

public interface UserDao {

	// 1. 로그인 처리 작업
	// -> 사용자가 입력한 id와 pw를 매개변수로 받아서 일치할 경우 데이터를 리턴
	public UserVO login(UserVO userVO);

	// 2. 아이디 중복 체크
	public String idCheck(String id);

}
