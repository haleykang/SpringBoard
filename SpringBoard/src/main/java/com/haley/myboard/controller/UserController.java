package com.haley.myboard.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.haley.myboard.domain.UserDTO;
import com.haley.myboard.domain.UserVO;
import com.haley.myboard.service.UserService;

@Controller // ��Ʈ�ѷ� Ŭ���� ����
@RequestMapping("/user/*") // --> /user/�� �����ϴ� ��û�� �� ��Ʈ�ѷ����� ó��
public class UserController {

	@Autowired
	private UserService userService;

	// 1. �α��� �������� �̵� ��û(/user/login) ó��
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public void goLogin() {

		// �ܼ� ������ �̵�
		// ���� Ÿ�� - void ==> ���� ��û�� ���� �̸��� �� �������� �̵�
		// user/login.jsp �������� �̵�

	}

	// 2. �α��� ó�� ��û(/user/loginPost) ó�� �޼ҵ�
	// -> �α��� ó�� �� �α��� ���� ����� HttpSession�� �����ؾ��� ****
	@RequestMapping(value = "loginPost", method = RequestMethod.POST)
	// public String loginPost(UserVO vo, HttpSession session) {
	public void loginPost(UserVO vo, Model model) {
		// 1) �Ķ���͸� ���� ���� �Ű������� �α����� �õ��� ����� ����
		UserVO userVO = userService.login(vo);
		// -> �α��� ���� : userVO�� ���̺� ������ ����
		// -> �α��� ���� : userVO�� null ����

		// 2) model ��ü�� userVO �� ����
		model.addAttribute("login", userVO);

		// 3) ����Ÿ���� void -> user/loginPost�� ��� View �������� ��

		// Interceptor ������ ���� �ϱ� �ڵ� ����
		/*
		 * // 2) �α��� ���� ���� Ȯ�� if (userVO == null) { // userVO ���� null�̸� �α��� ����
		 * // (1) �α��� ���� �� session�� null ���� session.setAttribute("login", null);
		 * // System.out.println(session.getAttribute("login")); // (2) �α��� ��������
		 * �ٽ� �̵� return "redirect:login";
		 * 
		 * } else { // userVO ���� null�� �ƴ� ��� �α��� ���� // (1) �α��� ���� �� session��
		 * userVO ���� ���� session.setAttribute("login", userVO); //
		 * System.out.println(session.getAttribute("login")); // (2) �ϴ� ���� ��������
		 * �����̷�Ʈ return "redirect:/";
		 * 
		 * }
		 */

	}

	// 3. �α׾ƿ� ��û(/user/logout)ó�� �޼ҵ�
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		// 1) session �ʱ�ȭ
		session.invalidate();
		// 2) ���� �������� �����̷�Ʈ
		return "redirect:/";

	}

	// 4. ȸ������ �������� �̵� (/user/join)ó�� �޼ҵ�
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public void toJoin() {

	}

	// 5. ���� ȸ�� ���� ��û ó�� �޼ҵ�
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(UserDTO dto, HttpServletRequest request, RedirectAttributes attr) {
		// 1) service �޼ҵ� ����
		userService.insertUser(dto, request);
		// 2) ���� �޼��� ����
		attr.addFlashAttribute("msg", "ȸ�� ������ �����Ͽ����ϴ�.");
		// 3) home �������� �����̷�Ʈ
		return "redirect:/";

	}

}
