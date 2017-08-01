package com.haley.myboard.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

// 로그인 인터셉터
public class LoginInterceptor implements HandlerInterceptor {

	// 1. Controller가 요청을 처리하기 전 호출되는 메소드
	// true 리턴 - Controller로 가서 다음 요청 처리
	// false 리턴 - Controller로 이동 안함
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 1) 로그인 처리 전에 기존 로그인 정보가 있을 경우 삭제
		// -> 즉, 기존에 로그인 되어있으면 삭제하고 다시 로그인

		// (1) 세션 가져오기
		// -> request 객체는 포워딩 방식에서만 값을 전달!
		// -> 우리는 redirect로 페이지 이동하기 때문에 리퀘스트로 세션을 만들어서 사용
		HttpSession session = request.getSession();
		// (2) 로그인 정보가 있을 경우 삭제
		if (session != null) {
			session.removeAttribute("login");
		}

		// 2) Controller로 이동
		return true;
	}

	// 2. Controller가 요청을 처리한 후 뷰 페이지를 리턴하기 전 호출되는 메소드
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// 1) 로그인 성공 여부를 판단하기 위해 Controller에서 model에 저장한 데이터 가져오기
		// model.addAttribute("login", userVO);
		// -> 로그인 실패 - userVO = null
		// -> 로그인 성공 - userVO = 로그인 정보 저장
		ModelMap modelMap = modelAndView.getModelMap();
		// 2) Object 객체에 model에서 가져온 "login" 정보 저장
		Object login = modelMap.get("login");
		// 3) 로그인 성공 여부 판단
		if (login == null) {
			// 로그인 실패
			response.sendRedirect("/myboard/user/login"); // 로그인 실패 시 리다이렉트할 요청
		} else {
			// 로그인 성공
			// (1) session에 로그인 정보 저장
			HttpSession session = request.getSession(); // 리퀘스트로 세션 가져오기
			session.setAttribute("login", login); // 세션에 로그인 정보 저장

			// (2) 세션에서 dest 키 값에 있는 정보를 가져옴
			String dest = (String) session.getAttribute("dest");
			if (dest == null) {
				// dest == null -> 목적지 정보가 없으면 메인으로 이동
				response.sendRedirect("/myboard");
			} else {
				// dest != null -> 목적지 정보가 있으면 그 페이지로 이동
				// 예를 들어, 글쓰기 요청을 눌렀을 때 로그인이 안되어있어서 로그인 페이지로 이동 했다면
				// 로그인을 한 후 메인 페이지가 아닌 글쓰기 페이지로 바로 이동하도록 구현
				response.sendRedirect(dest);

			}

		}

	}

	// 3. Controller가 요청 처리 & 뷰 페이지 리턴 후 호출되는 메소드
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
