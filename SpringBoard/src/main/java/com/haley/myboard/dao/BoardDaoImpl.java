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

	// 3. 게시글 상세보기 처리

	// 3-1) 글 번호 기준 게시글 가져오기
	@Override
	public BoardVO getBoard(int bno) {

		return sqlSession.selectOne("board.getBoard", bno);
	}

	// 3-2) 조회수 1 증가
	@Override
	public int updateCount(int bno) {

		return sqlSession.update("board.updateCount", bno);
	}

	// 4. 게시글 삭제
	@Override
	public int deleteBoard(int bno) {

		return sqlSession.delete("board.deleteBoard", bno);
	}

}
