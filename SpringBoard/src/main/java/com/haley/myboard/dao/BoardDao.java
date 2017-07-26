package com.haley.myboard.dao;

import java.util.List;

import com.haley.myboard.domain.BoardVO;

// �Խ��� ������ �ʿ��� �޼ҵ� ����
public interface BoardDao {

	// 1. �� ���� ó�� �Լ� - insert
	public int writeBoard(BoardVO vo);

	// 2. �� ��� ���� ó�� �Լ� - select
	public List<BoardVO> showList();

	// 3. �󼼺��� ����
	// 3-1) �� ��ȣ �������� ������ �������� �Լ�
	public BoardVO getBoard(int bno);

	// 3-2) ��ȸ�� 1 ���� ��Ű�� �Լ�
	public int updateCount(int bno);

	// 4. �Խñ� ���� ����
	public int deleteBoard(int bno);
}
