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

	// 2. ���̵� �ߺ� üũ
	@Override
	public boolean idCheck(String id) {
		// 1) userDao.iDcheck �����ؼ� ���� �� ��������
		String result = userDao.idCheck(id);
		// 2) �ߺ� ���� Ȯ��
		if (result == null) {
			// �ߺ��Ǵ� ���̵� ���� ��� result == null
			return true;
		}
		// result �� null�� �ƴϸ� ���̵� �ߺ�
		return false;
	}

}
