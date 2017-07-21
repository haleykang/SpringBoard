package com.haley.myboard.dao;

import java.util.List;

import com.haley.myboard.domain.BoardVO;

// 게시판 구현에 필요한 메소드 선언
public interface BoardDao {

	// 1. 글 쓰기 처리 함수 - insert
	public int writeBoard(BoardVO vo);

	// 2. 글 목록 보기 처리 함수 - select
	public List<BoardVO> showList();

}
