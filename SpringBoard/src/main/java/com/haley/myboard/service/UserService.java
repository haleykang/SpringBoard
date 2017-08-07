package com.haley.myboard.service;

import javax.servlet.http.HttpServletRequest;

import com.haley.myboard.domain.UserDTO;
import com.haley.myboard.domain.UserVO;

public interface UserService {

	// 1. �α��� ó�� �޼ҵ� ����
	public UserVO login(UserVO userVO);

	// 2. ���̵� �ߺ�üũ ó��
	// ���̵� �ߺ� -> false, �ߺ��ƴ� true�� ���� ����
	public boolean idCheck(String id);

	// 3. ȸ�� ����
	public void insertUser(UserDTO userDTO, HttpServletRequest request);

}
