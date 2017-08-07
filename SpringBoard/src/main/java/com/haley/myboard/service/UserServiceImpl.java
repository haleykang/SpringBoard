package com.haley.myboard.service;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haley.myboard.dao.UserDao;
import com.haley.myboard.domain.UserDTO;
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

	// 3. 회원 가입 **** 중요
	@Override
	public void insertUser(UserDTO userDTO, HttpServletRequest request) {
		// 1) 사용자가 입력한 정보를 데이터베이스(springuser 테이블)에 저장하기 위해 UserVO 객체 생성
		UserVO userVO = new UserVO();

		// 2) request 객체를 이용해 파일을 업로드할 경로의 절대 경로 찾아와서 프로젝트 내 저장 폴더로 설정
		// -> 이 메소드를 통해 등록된 이미지가 저장될 폴더 -> webapp(또는 WebContent)/userimage
		String uploadPath = request.getServletContext().getRealPath("/userimage");

		// 3) 사용자가 등록한 파일의 이름 가져오기
		String inputfilename = userDTO.getImage().getOriginalFilename();

		// 4) 사용자가 등록한 파일이 있는 경우에만 실행 하도록 if 문 사용
		if (inputfilename.length() != 0) {
			// 5) 유일한 파일 이름 만들기
			try {

				// 5-1) 랜덤 문자열 생성 -> UUID
				UUID uid = UUID.randomUUID(); // 절대 중복되지 않는 문자열 생성
				// 5-2) uid와 사용자 등록 파일이름을 더해 실제 파일 이름 생성
				String filename = uid + inputfilename;
				// 5-3) 업로드할 파일 경로 만들기 -> 맥에서는 /로
				// -> 파일 경로를 설정 할 때는 디렉토리와 파일 이름 사이에 \(원 표시)가 하나 있어야하는데 하나만 적으면
				// 스프링에서 하나는 인식을 못함 \n 이런 개행 문자처럼 인식!
				String filepath = uploadPath + "\\" + filename;
				// 5-4) 파일 업로드
				File file = new File(filepath);
				userDTO.getImage().transferTo(file);
				// 5-5) 파일 이름을 UserVO에 저장
				userVO.setImage(filename);

			} catch (Exception e) {
				e.printStackTrace();
			}

			// 6) 입력 받은 데이터를 userVO에 저장
			userVO.setId(userDTO.getId());
			userVO.setPw(userDTO.getPw());
			userVO.setName(userDTO.getName());

			// 7) DAO 메소드 호출
			userDao.insertUser(userVO);

		}
	}

}
