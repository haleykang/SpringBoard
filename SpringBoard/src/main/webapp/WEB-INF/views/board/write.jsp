<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 상단의 공통된 디자인 적용 - include 폴더의 header.jsp-->
<!-- include 폴더는 board폴더의 상위 views 폴더에 있기 때문에 ../ 코드를 추가 해줘야 함! -->
<%@include file="../include/header.jsp"%>
<!-- 사용되는 코드는 bootstrap 코드 -->
<section class="content">

	<!-- 제목 만들기 -->
	<div class="box-header">
		<h3 class="box-title">게시판 글쓰기</h3>
	</div>

	<!-- 글쓰기 form 만들기 -->
	<!-- textarea가 포함되기 때문에 전송 방식은 POST -->
	<!-- action="요청주소", action이 없는 경우 이 페이지로 이동할 때 받은 주소가 요청 주소 -->
	<!-- => 이 경우 요청 주소는 board/write -->
	<form role="form" method="post">
		<div class="box-body">
			<div class="form-group">
				<!-- name의 값은 테이블 이름과 일치 시키기 -->
				<label>제목</label> <input type="text" name="title"
					class="form-control" placeholder="제목을 입력하세요" />
			</div>
			<div class="form-group">
				<label>내용</label>
				<textarea class="form-control" name="content" rows="5"
					placeholder="내용을 입력하세요"></textarea>
			</div>
			<div class="form-group">
				<label>작성자</label> <input type="text" name="id" class="form-control"
					placeholder="작성자를 입력하세요" />
			</div>
			<div class="box-footer">
				<button type="submit" class="btn btn-primary">작성완료</button>
			</div>
		</div>
	</form>
</section>

<!-- 하단의 공통된 디자인 적용 - include 폴더의 footer.jsp -->
<%@include file="../include/footer.jsp"%>