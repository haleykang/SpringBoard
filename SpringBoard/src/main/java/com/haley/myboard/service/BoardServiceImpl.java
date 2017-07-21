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

	// 1. 글쓰기 처리 함수
	@Override
	public int writeBoard(HttpServletRequest request) {
		// 1) write.jsp 페이지에서 입력 받는 항목 값 받아오기
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String id = request.getParameter("id");

		// 2) getRemoteAddr() - 클라이언트 IP 가져오기
		String ip = request.getRemoteAddr();

		// 3) Dao에서 사용할 매개 변수 값 만들기
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setId(id);
		vo.setIp(ip);

		// 4) DAO 메소드 호출
		return boardDao.writeBoard(vo);
	}

	// 2. 글 목록 보기 처리 함수
	@Override
	public List<BoardVO> showList() {

		return boardDao.showList();
	}

}
