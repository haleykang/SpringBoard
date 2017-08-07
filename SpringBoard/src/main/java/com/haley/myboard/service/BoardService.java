package com.haley.myboard.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.haley.myboard.domain.BoardVO;

// Service �������̽� : SQL���� �޾ƿ� �� ���� ���� ���񽺿��� ó���ؼ� �����;� ��
public interface BoardService {

	// 1. �۾��� ó�� �޼ҵ�
	// -> ���� ���ε带 ���� �Ű����� MultipartHttpServletRequest �� ���� 
	public int writeBoard(MultipartHttpServletRequest request);
	// �Ű� ������ HttpServletRequest�� �δ� ����
	// �ۼ����� IP�� �޾ƿ��� ����
	// (��, ip�� ����ڰ� �۾��� form���� �Է��� ������ �� �� �������� ����)
	// IP�� ã�ƿ��� �� ó�� HttpServletRequest�� �� �ʿ��� ��Ȳ�� �ƴϸ� ���� DAO�� �Ű����� ����

	// 2. �� ��� ���� ó�� �޼ҵ�
	// �Ű� ������ ���� ��� DAO�� Service�� �ڵ�� ����
	public List<BoardVO> showList();

	// 3. �Խñ� �󼼺��� ó�� �޼ҵ�
	public BoardVO getBoard(int bno);

	// 4. �Խñ� ���� ����
	public int deleteBoard(int bno);

	// 5. �Խñ� ���� ����(���� �������� �̵�)
	public BoardVO updateBoard(int bno);

	// 6. �Խñ� ���� ����
	public int myUpdate(BoardVO vos);

}
