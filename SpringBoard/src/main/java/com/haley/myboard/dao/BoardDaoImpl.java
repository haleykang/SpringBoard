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

	// 1. �� ���� ó��
	@Override
	public int writeBoard(BoardVO vo) {

		return sqlSession.insert("board.writeBoard", vo);
	}

	// 2. �� ��� ���� ó��
	@Override
	public List<BoardVO> showList() {

		return sqlSession.selectList("board.showList");
	}

	// 3. �Խñ� �󼼺��� ó��

	// 3-1) �� ��ȣ ���� �Խñ� ��������
	@Override
	public BoardVO getBoard(int bno) {

		return sqlSession.selectOne("board.getBoard", bno);
	}

	// 3-2) ��ȸ�� 1 ����
	@Override
	public int updateCount(int bno) {

		return sqlSession.update("board.updateCount", bno);
	}

	// 4. �Խñ� ����
	@Override
	public int deleteBoard(int bno) {

		return sqlSession.delete("board.deleteBoard", bno);
	}

}
