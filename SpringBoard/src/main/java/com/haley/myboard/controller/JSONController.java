package com.haley.myboard.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.haley.myboard.domain.UserVO;
import com.haley.myboard.service.UserService;

//메소드에서 return하는 값을 JSON 형식의 문자열로 리턴해주는 컨트롤러
//return한 이름의 뷰 페이지로 이동 X
@RestController
public class JSONController {

	@Autowired
	private UserService service;

	// 1. 요청 페이지에서 아이디를 가져와서 아이디 중복 확인 후 결과를 MAP으로 반환하는 메소드
	@RequestMapping(value = "user/idCheck", method = RequestMethod.GET)
	public Map<String, Object> idCheck(@RequestParam("id") String id) {
		// 1) UserService의 idCheck 메소드를 실행해서 결과 저장
		boolean result = service.idCheck(id);

		// 2) Map을 선언해서 result의 결과를 "result" 키로 map에 저장
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);

		// 3) map에 저장한 결과를 리턴함
		return map;

	}

	// 2. 안드로이드 로그인 - 모바일에서 입력한 id와 pw를 가져와서 결과를 json으로 리턴
	@RequestMapping("androidlogin")
	public Map<String, Object> login(@RequestParam("id") String id, @RequestParam("pw") String pw) {
		// 1) 사용자가 입력한 id와 pw 저장
		UserVO userVO = new UserVO();
		userVO.setId(id);
		userVO.setPw(pw);
		// 2) Service의 login 메소드 실행 -> 결과 저장
		// -> 로그인 성공 시 로그인 정보 저장, 실패 시 null
		UserVO result = service.login(userVO);
		// 3) 로그인 결과를 map에 저장
		Map<String, Object> map = new HashMap<>();
		map.put("result", result);
		// 4) result 값을 저장한 map 리턴
		return map;
	}

}
