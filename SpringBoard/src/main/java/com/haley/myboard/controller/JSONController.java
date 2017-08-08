package com.haley.myboard.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.haley.myboard.domain.BoardVO;
import com.haley.myboard.domain.UserVO;
import com.haley.myboard.service.BoardService;
import com.haley.myboard.service.UserService;

//�޼ҵ忡�� return�ϴ� ���� JSON ������ ���ڿ��� �������ִ� ��Ʈ�ѷ�
//return�� �̸��� �� �������� �̵� X
@RestController
public class JSONController {

	@Autowired
	private UserService service;

	// 1. ��û ���������� ���̵� �����ͼ� ���̵� �ߺ� Ȯ�� �� ����� MAP���� ��ȯ�ϴ� �޼ҵ�
	@RequestMapping(value = "user/idCheck", method = RequestMethod.GET)
	public Map<String, Object> idCheck(@RequestParam("id") String id) {
		// 1) UserService�� idCheck �޼ҵ带 �����ؼ� ��� ����
		boolean result = service.idCheck(id);

		// 2) Map�� �����ؼ� result�� ����� "result" Ű�� map�� ����
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);

		// 3) map�� ������ ����� ������
		return map;

	}

	// 2. �ȵ���̵� �α��� - ����Ͽ��� �Է��� id�� pw�� �����ͼ� ����� json���� ����
	@RequestMapping("androidlogin")
	public Map<String, Object> login(@RequestParam("id") String id, @RequestParam("pw") String pw) {
		// 1) ����ڰ� �Է��� id�� pw ����
		UserVO userVO = new UserVO();
		userVO.setId(id);
		userVO.setPw(pw);
		// 2) Service�� login �޼ҵ� ���� -> ��� ����
		// -> �α��� ���� �� �α��� ���� ����, ���� �� null
		UserVO result = service.login(userVO);
		// 3) �α��� ����� map�� ����
		Map<String, Object> map = new HashMap<>();
		map.put("result", result);
		// 4) result ���� ������ map ����
		return map;
	}

	@Autowired
	private BoardService boardService;

	// 3. �ȵ���̵� ��� ���� - ����Ͽ��� �Խñ��� ����Ʈ�� �� ���ֵ��� JSON���� ����
	@RequestMapping("androidlist")
	public Map<String, Object> list() {
		// 1) ���̺� ������ List ��ü�� ����
		List<BoardVO> list = boardService.showList();

		// 2) ������ ������ map���� ����
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", list);

		// 3) ���� ����
		return map;

	}

	// 4. �ȵ���̵� �� ���� - ����Ͽ��� ������ �� ��ȣ��, �� ��ȣ�� �ش��ϴ� ������ JSON���� ����
	@RequestMapping("androiddetail")
	public Map<String, Object> detail(@RequestParam("bno") int bno) {
		// 1) bno�� �������� ������ �����ͼ� ����
		BoardVO boardVO = boardService.getBoard(bno);

		// 2) ���̺��� ������ �����͸� Map�� ����
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", boardVO);

		// 2) �����͸� ������ Map�� ����
		return map;
	}

	// ** JSON���� �����ϴ� ��� �ݵ�� Chrome���� �����Ͱ� ��� ��µǴ��� Ȯ�� �� ��

}
