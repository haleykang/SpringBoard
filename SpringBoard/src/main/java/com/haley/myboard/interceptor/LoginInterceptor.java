package com.haley.myboard.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

// �α��� ���ͼ���
public class LoginInterceptor implements HandlerInterceptor {

	// 1. Controller�� ��û�� ó���ϱ� �� ȣ��Ǵ� �޼ҵ�
	// true ���� - Controller�� ���� ���� ��û ó��
	// false ���� - Controller�� �̵� ����
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 1) �α��� ó�� ���� ���� �α��� ������ ���� ��� ����
		// -> ��, ������ �α��� �Ǿ������� �����ϰ� �ٽ� �α���

		// (1) ���� ��������
		// -> request ��ü�� ������ ��Ŀ����� ���� ����!
		// -> �츮�� redirect�� ������ �̵��ϱ� ������ ������Ʈ�� ������ ���� ���
		HttpSession session = request.getSession();
		// (2) �α��� ������ ���� ��� ����
		if (session != null) {
			session.removeAttribute("login");
		}

		// 2) Controller�� �̵�
		return true;
	}

	// 2. Controller�� ��û�� ó���� �� �� �������� �����ϱ� �� ȣ��Ǵ� �޼ҵ�
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// 1) �α��� ���� ���θ� �Ǵ��ϱ� ���� Controller���� model�� ������ ������ ��������
		// model.addAttribute("login", userVO);
		// -> �α��� ���� - userVO = null
		// -> �α��� ���� - userVO = �α��� ���� ����
		ModelMap modelMap = modelAndView.getModelMap();
		// 2) Object ��ü�� model���� ������ "login" ���� ����
		Object login = modelMap.get("login");
		// 3) �α��� ���� ���� �Ǵ�
		if (login == null) {
			// �α��� ����
			response.sendRedirect("/myboard/user/login"); // �α��� ���� �� �����̷�Ʈ�� ��û
		} else {
			// �α��� ����
			// (1) session�� �α��� ���� ����
			HttpSession session = request.getSession(); // ������Ʈ�� ���� ��������
			session.setAttribute("login", login); // ���ǿ� �α��� ���� ����

			// (2) ���ǿ��� dest Ű ���� �ִ� ������ ������
			String dest = (String) session.getAttribute("dest");
			if (dest == null) {
				// dest == null -> ������ ������ ������ �������� �̵�
				response.sendRedirect("/myboard");
			} else {
				// dest != null -> ������ ������ ������ �� �������� �̵�
				// ���� ���, �۾��� ��û�� ������ �� �α����� �ȵǾ��־ �α��� �������� �̵� �ߴٸ�
				// �α����� �� �� ���� �������� �ƴ� �۾��� �������� �ٷ� �̵��ϵ��� ����
				response.sendRedirect(dest);

			}

		}

	}

	// 3. Controller�� ��û ó�� & �� ������ ���� �� ȣ��Ǵ� �޼ҵ�
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
