package com.haley.myboard.dao;

import java.util.List;

import com.haley.myboard.domain.BoardVO;

// 게시판 구현에 필요한 메소드 선언
public interface BoardDao {

	// 1. 글 쓰기 처리 함수 - insert
	public int writeBoard(BoardVO vo);

	// 2. 글 목록 보기 처리 함수 - select
	public List<BoardVO> showList();

	// 3. 상세보기 구현
	// 3-1) 글 번호 기준으로 데이터 가져오는 함수
	public BoardVO getBoard(int bno);

	// 3-2) 조회수 1 증가 시키는 함수
	public int updateCount(int bno);

	// 4. 게시글 삭제 구현
	public int deleteBoard(int bno);
}
