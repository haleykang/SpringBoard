package com.haley.myboard.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.haley.myboard.domain.BoardVO;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Inject
	private SqlSession sqlSession;

	// 1. 글 쓰기 처리
	@Override
	public int writeBoard(BoardVO vo) {

		return sqlSession.insert("board.writeBoard", vo);
	}

	// 2. 글 목록 보기 처리
	@Override
	public List<BoardVO> showList() {

		return sqlSession.selectList("board.showList");
	}

}
