package com.haley.myboard.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haley.myboard.dao.BoardDao;
import com.haley.myboard.domain.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao boardDao;

	// 1. �۾��� ó�� �Լ�
	@Override
	public int writeBoard(HttpServletRequest request) {
		// 1) write.jsp ���������� �Է� �޴� �׸� �� �޾ƿ���
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String id = request.getParameter("id");

		// 2) getRemoteAddr() - Ŭ���̾�Ʈ IP ��������
		String ip = request.getRemoteAddr();

		// 3) Dao���� ����� �Ű� ���� �� �����
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setId(id);
		vo.setIp(ip);

		// 4) DAO �޼ҵ� ȣ��
		return boardDao.writeBoard(vo);
	}

	// 2. �� ��� ���� ó�� �Լ�
	@Override
	public List<BoardVO> showList() {

		return boardDao.showList();
	}

}
