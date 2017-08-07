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

@Controller // 컨트롤러 클래스 선언
@RequestMapping("/user/*") // --> /user/로 시작하는 요청은 이 컨트롤러에서 처리
public class UserController {

	@Autowired
	private UserService userService;

	// 1. 로그인 페이지로 이동 요청(/user/login) 처리
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public void goLogin() {

		// 단순 페이지 이동
		// 리턴 타입 - void ==> 받은 요청과 같은 이름의 뷰 페이지로 이동
		// user/login.jsp 페이지로 이동

	}

	// 2. 로그인 처리 요청(/user/loginPost) 처리 메소드
	// -> 로그인 처리 시 로그인 성공 결과는 HttpSession에 저장해야함 ****
	@RequestMapping(value = "loginPost", method = RequestMethod.POST)
	// public String loginPost(UserVO vo, HttpSession session) {
	public void loginPost(UserVO vo, Model model) {
		// 1) 파라미터를 받은 것을 매개변수로 로그인을 시도해 결과를 저장
		UserVO userVO = userService.login(vo);
		// -> 로그인 성공 : userVO에 테이블 데이터 저장
		// -> 로그인 실패 : userVO에 null 저장

		// 2) model 객체에 userVO 값 저장
		model.addAttribute("login", userVO);

		// 3) 리턴타입이 void -> user/loginPost가 결과 View 페이지가 됨

		// Interceptor 적용을 위해 하기 코드 삭제
		/*
		 * // 2) 로그인 성공 여부 확인 if (userVO == null) { // userVO 값이 null이면 로그인 실패
		 * // (1) 로그인 실패 시 session에 null 저장 session.setAttribute("login", null);
		 * // System.out.println(session.getAttribute("login")); // (2) 로그인 페이지로
		 * 다시 이동 return "redirect:login";
		 * 
		 * } else { // userVO 값이 null이 아닌 경우 로그인 성공 // (1) 로그인 성공 시 session에
		 * userVO 값을 저장 session.setAttribute("login", userVO); //
		 * System.out.println(session.getAttribute("login")); // (2) 일단 페인 페이지로
		 * 리다이렉트 return "redirect:/";
		 * 
		 * }
		 */

	}

	// 3. 로그아웃 요청(/user/logout)처리 메소드
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		// 1) session 초기화
		session.invalidate();
		// 2) 메인 페이지로 리다이렉트
		return "redirect:/";

	}

	// 4. 회원가입 페이지로 이동 (/user/join)처리 메소드
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public void toJoin() {

	}

	// 5. 실제 회원 가입 요청 처리 메소드
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(UserDTO dto, HttpServletRequest request, RedirectAttributes attr) {
		// 1) service 메소드 실행
		userService.insertUser(dto, request);
		// 2) 성공 메세지 저장
		attr.addFlashAttribute("msg", "회원 가입을 성공하였습니다.");
		// 3) home 페이지로 리다이렉트
		return "redirect:/";

	}

}
