package com.haley.myboard.dao;

import java.util.List;

import com.haley.myboard.domain.BoardVO;

// �Խ��� ������ �ʿ��� �޼ҵ� ����
public interface BoardDao {

	// 1. �� ���� ó�� �Լ� - insert
	public int writeBoard(BoardVO vo);

	// 2. �� ��� ���� ó�� �Լ� - select
	public List<BoardVO> showList();

}
