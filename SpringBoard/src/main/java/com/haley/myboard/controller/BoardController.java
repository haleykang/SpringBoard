package com.haley.myboard.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.haley.myboard.domain.BoardVO;
import com.haley.myboard.service.BoardService;

@Controller // Controller ����
@RequestMapping("/board/*") // /board�� �����ϴ� ��û �ּҴ� �� ��Ʈ�ѷ��� ó��
public class BoardController {

	@Autowired
	BoardService boardService;

	// 1. �۾��� �������� �̵��ϴ� �޼ҵ�
	// Ŭ���� ��ܿ� @RequestMapping("/board/*") ������ �߱� ������ ��û �ּ� �տ� /board ����
	@RequestMapping(value = "write", method = RequestMethod.GET)
	// �ܼ��� ������ �̵��� ��� ���� Ÿ�� void : ��û �ּҰ� �̵��� view �̸��� ��
	// -> �� ��� ViewResolver ������ ���ļ� /WEB-INF/views/board/write.jsp �������� �̵�
	public void write() {

	}

	// 2. ����ڰ� �� �ۼ� �� "�ۼ��Ϸ�" ��ư Ŭ�� ��û �� ó���� �޼ҵ�
	// ó���� ��û �ּ� : /board/write -> form ���� action ���� �� ��� ����
	// 1���� 2���� �Լ� �̸��� ���Ƶ� ��(��, �Ű� ������ �޶����)
	@RequestMapping(value = "write", method = RequestMethod.POST)
	public String write(HttpServletRequest request) {
		// 1) writeBoard() �Լ� ����
		// => �Ű� ���� request�� ���ؼ� form���� �Է� ���� �׸� �����ͼ�
		// => VO Ŭ������ �����ϰ� BoardDao�� writeBoard() �Լ��� �������
		// => insert SQL�� ���� �ϰ� ��
		int result = boardService.writeBoard(request);
		// => insert/update/delete �Լ��� ���� ���� �� �ڽ��� ������ �� �������� ������ ��ȯ
		// ==> ���� result ���� 1 ���� ���� ��� insert �����ߴٴ� ��!
		if (result < 1) {
			// 2) �۾��� ���� �� �����ų ��ɾ� �ۼ�
			// -> �� ���� �������� �ٽ� �̵� !!! redirect ���!
			return "redirect:write";
		} else {
			// 3) �۾��� ���� �� �����ų ��ɾ� �ۼ�
			// -> ��� ���� �������� �̵� !!! redirect ���!!
			return "redirect:list";

		}

	}

	// 3. �� ��� ���� ��û ó�� board/list
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(Model model) {
		
		// 1) boardService.showList() �Լ� ���� �� ���� ���� List ������ ����
		List<BoardVO> list = boardService.showList();
		
		// 2) list�� ���� ��� �� �������� �����ϱ� ���� �Ű� ���� Model�� ����
		model.addAttribute("list",list);
		
		// 3) ����� ��� �������� �̵�
		return "board/list";
	}

}
