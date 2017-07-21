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

@Controller // Controller 선언
@RequestMapping("/board/*") // /board로 시작하는 요청 주소는 이 컨트롤러가 처리
public class BoardController {

	@Autowired
	BoardService boardService;

	// 1. 글쓰기 페이지로 이동하는 메소드
	// 클래스 상단에 @RequestMapping("/board/*") 선언을 했기 때문에 요청 주소 앞에 /board 생략
	@RequestMapping(value = "write", method = RequestMethod.GET)
	// 단순한 페이지 이동의 경우 리턴 타입 void : 요청 주소가 이동할 view 이름이 됨
	// -> 이 경우 ViewResolver 설정과 합쳐서 /WEB-INF/views/board/write.jsp 페이지로 이동
	public void write() {

	}

	// 2. 사용자가 글 작성 후 "작성완료" 버튼 클릭 요청 시 처리할 메소드
	// 처리할 요청 주소 : /board/write -> form 에서 action 값을 안 줬기 때문
	// 1번과 2번의 함수 이름은 같아도 됨(단, 매개 변수는 달라야함)
	@RequestMapping(value = "write", method = RequestMethod.POST)
	public String write(HttpServletRequest request) {
		// 1) writeBoard() 함수 실행
		// => 매개 변수 request를 통해서 form에서 입력 받은 항목 가져와서
		// => VO 클래스에 저장하고 BoardDao의 writeBoard() 함수를 실행시켜
		// => insert SQL을 실행 하게 됨
		int result = boardService.writeBoard(request);
		// => insert/update/delete 함수는 실행 성공 시 자신이 영향을 준 데이터의 갯수를 반환
		// ==> 따라서 result 값이 1 보다 작은 경우 insert 실패했다는 뜻!
		if (result < 1) {
			// 2) 글쓰기 실패 시 실행시킬 명령어 작성
			// -> 글 쓰기 페이지로 다시 이동 !!! redirect 사용!
			return "redirect:write";
		} else {
			// 3) 글쓰기 성공 시 실행시킬 명령어 작성
			// -> 목록 보기 페이지로 이동 !!! redirect 사용!!
			return "redirect:list";

		}

	}

	// 3. 글 목록 보기 요청 처리 board/list
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(Model model) {
		
		// 1) boardService.showList() 함수 실행 후 리턴 값을 List 변수에 저장
		List<BoardVO> list = boardService.showList();
		
		// 2) list의 값을 결과 뷰 페이지로 전달하기 위해 매개 변수 Model에 저장
		model.addAttribute("list",list);
		
		// 3) 출력할 결과 페이지로 이동
		return "board/list";
	}

}
