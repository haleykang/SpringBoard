package com.haley.myboard.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.haley.myboard.domain.BoardVO;

// Service �������̽� : SQL���� �޾ƿ� �� ���� ���� ���񽺿��� ó���ؼ� �����;� ��
public interface BoardService {

	// 1. �۾��� ó�� �޼ҵ�
	public int writeBoard(HttpServletRequest request);
	// �Ű� ������ HttpServletRequest�� �δ� ����
	// �ۼ����� IP�� �޾ƿ��� ����
	// (��, ip�� ����ڰ� �۾��� form���� �Է��� ������ �� �� �������� ����)
	// IP�� ã�ƿ��� �� ó�� HttpServletRequest�� �� �ʿ��� ��Ȳ�� �ƴϸ� ���� DAO�� �Ű����� ����

	// 2. �� ��� ���� ó�� �޼ҵ�
	// �Ű� ������ ���� ��� DAO�� Service�� �ڵ�� ����
	public List<BoardVO> showList();
}
