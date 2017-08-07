package com.haley.myboard.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.haley.myboard.domain.BoardVO;

// Service 인터페이스 : SQL에서 받아올 수 없는 값을 서비스에서 처리해서 가져와야 함
public interface BoardService {

	// 1. 글쓰기 처리 메소드
	// -> 파일 업로드를 위해 매개변수 MultipartHttpServletRequest 로 변경 
	public int writeBoard(MultipartHttpServletRequest request);
	// 매개 변수를 HttpServletRequest로 두는 이유
	// 작성자의 IP를 받아오기 위해
	// (즉, ip와 사용자가 글쓰기 form에서 입력한 내용을 둘 다 가져오기 위함)
	// IP를 찾아오는 것 처럼 HttpServletRequest가 꼭 필요한 상황이 아니면 보통 DAO와 매개변수 같음

	// 2. 글 목록 보기 처리 메소드
	// 매개 변수가 없는 경우 DAO와 Service의 코드는 동일
	public List<BoardVO> showList();

	// 3. 게시글 상세보기 처리 메소드
	public BoardVO getBoard(int bno);

	// 4. 게시글 삭제 구현
	public int deleteBoard(int bno);

	// 5. 게시글 수정 구현(수정 페이지로 이동)
	public BoardVO updateBoard(int bno);

	// 6. 게시글 수정 구현
	public int myUpdate(BoardVO vos);

}
