package com.haley.myboard.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

// �α��� ���θ� Ȯ�� �� ������ �ִ� ���ͼ���
public class AuthInterceptor implements HandlerInterceptor {

	// 1. Controller ó�� �ϱ� �� �����ϴ� �޼ҵ�
	// false - Controller�� �̵� ����
	// true - Controller�� �̵�

	// �۾��� ����� �۾����� �̵��ϱ� �� �α��� ���θ� Ȯ���ؾ� �ϱ� ������ preHandle�� �ڵ� �߰�
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 1) ���� �������� - request ��ü�� ������ �����´ٴ� ���� �� ����ϱ�
		HttpSession session = request.getSession();
		// 2) �α��� ���� Ȯ���ϱ�
		// 2-1) �α��� ����
		if (session.getAttribute("login") == null) {
			// (1) �α��� �������� �̵��ϱ� ���� ��û�ߴ� ��θ� ���ǿ� ����
			String uri = request.getRequestURI(); // Ŭ���̾�Ʈ�� ��û ��θ� ������
			// (2) �Ķ���� ���ڿ� ��������
			String query = request.getQueryString();
			// (3) query�� ������ "", ������ ? ���·� ������Ʈ�� ���̱�
			if (query == null || query.equals("null")) {
				query = "";
			} else {
				query = "?" + query;
			}
			// (4) ���ǿ� uri & query�� ����
			session.setAttribute("dest", uri + query);

			// (5) �α��� �������� �����̷�Ʈ
			response.sendRedirect("/myboard/user/login");

			// (6) Controller�� �̵� ����
			return false;

		}
		// 2-2) �α��� ���� - ������ Controller ��û�� ó���ϵ���
		return true;
	}

	// 2. Controller ��û ó�� �� �� ������ �̵��ϱ� �� �����ϴ� �޼ҵ�
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	// 3. Controller ��û ó�� �� �� �������� �̵� �� ����Ǵ� �޼ҵ�
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
