package com.haley.myboard.service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.haley.myboard.dao.BoardDao;
import com.haley.myboard.domain.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao boardDao;

	// 1. 글쓰기 처리 함수
	@Override
	public int writeBoard(MultipartHttpServletRequest request) {

		// 1) 글쓰기 폼에서 이미지 제외한 입력 값 가져오기
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String id = request.getParameter("id");
		String ip = request.getRemoteAddr();

		// 2) Dao 메소드에서 사용할 매개변수 생성
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setId(id);
		vo.setIp(ip);

		// 3) 이미지 파일 가져오기
		// (1) 사용자가 등록한 파일 이름 가져옴
		MultipartFile image = request.getFile("image");
		// (2) 파일 저장할 절대 경로 저장
		String uploadPath = request.getServletContext().getRealPath("/boardimage");
		// (3) 중복 되지 않는 문자열 파일 이름 만들기
		UUID uid = UUID.randomUUID();
		String filename = image.getOriginalFilename();
		if (filename.length() != 0) {
			filename = uid + filename;
			// 저장된 파일 경로 생성
			String filepath = uploadPath + "\\" + filename;
			// 파일 업로드
			File file = new File(filepath);
			try {
				image.transferTo(file);

			} catch (Exception e) {
				e.printStackTrace();
			}
			vo.setImage(filename);
		} else {
			vo.setImage("");
		}
		// 4) Dao 메소드 호출
		return boardDao.writeBoard(vo);
	}

	/*
	 * @Override public int writeBoard(HttpServletRequest request) { // 1)
	 * write.jsp 페이지에서 입력 받는 항목 값 받아오기 String title =
	 * request.getParameter("title"); String content =
	 * request.getParameter("content"); String id = request.getParameter("id");
	 * 
	 * // 2) getRemoteAddr() - 클라이언트 IP 가져오기 String ip =
	 * request.getRemoteAddr();
	 * 
	 * // 3) Dao에서 사용할 매개 변수 값 만들기 BoardVO vo = new BoardVO();
	 * vo.setTitle(title); vo.setContent(content); vo.setId(id); vo.setIp(ip);
	 * 
	 * // 4) DAO 메소드 호출 return boardDao.writeBoard(vo); }
	 */

	// 2. 글 목록 보기 처리 함수
	@Override
	public List<BoardVO> showList() {

		return boardDao.showList();
	}

	// 3. 게시글 상세보기 처리
	@Override
	public BoardVO getBoard(int bno) {
		// 1) 조회수 1 증가
		boardDao.updateCount(bno);
		// 2) 글 번호에 따른 테이블 데이터 반환
		return boardDao.getBoard(bno);
	}

	// 4. 게시글 삭제 처리 함수
	@Override
	public int deleteBoard(int bno) {

		return boardDao.deleteBoard(bno);
	}

	// 5. 게시글 수정 처리 함수
	@Override
	public BoardVO updateBoard(int bno) {
		// getBoard() 함수를 재사용해서 글 번호가 일치하는 테이블 값 가져오기
		return boardDao.getBoard(bno);
	}

	// 6. 게시글 실제 수정 처리 함수
	@Override
	public int myUpdate(BoardVO vo) {

		return boardDao.myUpdate(vo);
	}

}
