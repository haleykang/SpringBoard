package com.haley.myboard.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

// 로그인 여부를 확인 후 권한을 주는 인터셉터
public class AuthInterceptor implements HandlerInterceptor {

	// 1. Controller 처리 하기 전 실행하는 메소드
	// false - Controller로 이동 안함
	// true - Controller로 이동

	// 글쓰기 등등의 작업으로 이동하기 전 로그인 여부를 확인해야 하기 때문에 preHandle에 코드 추가
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 1) 세션 가져오기 - request 객체로 세션을 가져온다는 것을 꼭 기억하기
		HttpSession session = request.getSession();
		// 2) 로그인 여부 확인하기
		// 2-1) 로그인 실패
		if (session.getAttribute("login") == null) {
			// (1) 로그인 페이지로 이동하기 전에 요청했던 경로를 세션에 저장
			String uri = request.getRequestURI(); // 클라이언트의 요청 경로를 가져옴
			// (2) 파라미터 문자열 가져오기
			String query = request.getQueryString();
			// (3) query가 없으면 "", 있으면 ? 형태로 쿼리스트링 붙이기
			if (query == null || query.equals("null")) {
				query = "";
			} else {
				query = "?" + query;
			}
			// (4) 세션에 uri & query를 저장
			session.setAttribute("dest", uri + query);

			// (5) 로그인 페이지로 리다이렉트
			response.sendRedirect("/myboard/user/login");

			// (6) Controller로 이동 안한
			return false;

		}
		// 2-2) 로그인 성공 - 원래의 Controller 요청을 처리하도록
		return true;
	}

	// 2. Controller 요청 처리 후 뷰 페이지 이동하기 전 실행하는 메소드
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	// 3. Controller 요청 처리 후 뷰 페이지로 이동 후 실행되는 메소드
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
