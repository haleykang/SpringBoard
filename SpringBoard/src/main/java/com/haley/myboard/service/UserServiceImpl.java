package com.haley.myboard.service;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haley.myboard.dao.UserDao;
import com.haley.myboard.domain.UserDTO;
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

	// 3. ȸ�� ���� **** �߿�
	@Override
	public void insertUser(UserDTO userDTO, HttpServletRequest request) {
		// 1) ����ڰ� �Է��� ������ �����ͺ��̽�(springuser ���̺�)�� �����ϱ� ���� UserVO ��ü ����
		UserVO userVO = new UserVO();

		// 2) request ��ü�� �̿��� ������ ���ε��� ����� ���� ��� ã�ƿͼ� ������Ʈ �� ���� ������ ����
		// -> �� �޼ҵ带 ���� ��ϵ� �̹����� ����� ���� -> webapp(�Ǵ� WebContent)/userimage
		String uploadPath = request.getServletContext().getRealPath("/userimage");

		// 3) ����ڰ� ����� ������ �̸� ��������
		String inputfilename = userDTO.getImage().getOriginalFilename();

		// 4) ����ڰ� ����� ������ �ִ� ��쿡�� ���� �ϵ��� if �� ���
		if (inputfilename.length() != 0) {
			// 5) ������ ���� �̸� �����
			try {

				// 5-1) ���� ���ڿ� ���� -> UUID
				UUID uid = UUID.randomUUID(); // ���� �ߺ����� �ʴ� ���ڿ� ����
				// 5-2) uid�� ����� ��� �����̸��� ���� ���� ���� �̸� ����
				String filename = uid + inputfilename;
				// 5-3) ���ε��� ���� ��� ����� -> �ƿ����� /��
				// -> ���� ��θ� ���� �� ���� ���丮�� ���� �̸� ���̿� \(�� ǥ��)�� �ϳ� �־���ϴµ� �ϳ��� ������
				// ���������� �ϳ��� �ν��� ���� \n �̷� ���� ����ó�� �ν�!
				String filepath = uploadPath + "\\" + filename;
				// 5-4) ���� ���ε�
				File file = new File(filepath);
				userDTO.getImage().transferTo(file);
				// 5-5) ���� �̸��� UserVO�� ����
				userVO.setImage(filename);

			} catch (Exception e) {
				e.printStackTrace();
			}

			// 6) �Է� ���� �����͸� userVO�� ����
			userVO.setId(userDTO.getId());
			userVO.setPw(userDTO.getPw());
			userVO.setName(userDTO.getName());

			// 7) DAO �޼ҵ� ȣ��
			userDao.insertUser(userVO);

		}
	}

}
