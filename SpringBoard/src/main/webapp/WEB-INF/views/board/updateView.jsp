<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 상단의 공통된 디자인 적용 - include 폴더의 header.jsp-->
<!-- include 폴더는 board폴더의 상위 views 폴더에 있기 때문에 ../ 코드를 추가 해줘야 함! -->
<%@include file="../include/header.jsp"%>
<!-- 사용되는 코드는 bootstrap 코드 -->
<section class="content">

	<!-- 제목 만들기 -->
	<div class="box-header">
		<h3 class="box-title">게시글 수정</h3>
	</div>

	<!-- action값 추가 -->
	<form role="form" method="post" action="modify">
		<div class="box-body">
			<div class="form-group">
				<!-- name의 값은 테이블 이름과 일치 시키기 -->
				<label>제목</label>
				<!-- placeholder 값을 value="${vo.title}" 형태로 변경 -->
				<input type="text" name="title" class="form-control"
					value="${vo.title}" />
			</div>
			<div class="form-group">
				<label>내용</label>
				<textarea class="form-control" name="content" rows="5">${vo.content}</textarea>
			</div>
			<div class="form-group">
				<label>작성자</label> <input type="text" name="id" class="form-control"
					value="${vo.id}" readonly="readonly" />
			</div>
			<!-- 화면에 보이지 않고 서버에게 값을 전달하는 데이터 추가 -->
			<input type="hidden" name="bno" value="${vo.bno}" />
			
			<div class="box-footer">
				<button type="submit" class="btn btn-primary">수정완료</button>
			</div>
		</div>
	</form>
</section>

<!-- 하단의 공통된 디자인 적용 - include 폴더의 footer.jsp -->
<%@include file="../include/footer.jsp"%>