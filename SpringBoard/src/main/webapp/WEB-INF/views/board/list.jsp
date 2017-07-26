<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 가져올 데이터가 List -> 반복문 사용을 위한 태그 라이브러리 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>목록보기</title>
</head>
<body>
	<!-- 상단의 공통된 디자인 적용하기 -->
	<%@include file="../include/header.jsp"%>

	<!-- 게시글 삭제 후 리다이렉트를 통해 해당 페이지로 이동 할 경우 한 번만 출력되는 메세지 -->
	<div class="box-header with-border">
		<h3 class="box-title">${msg}</h3>
	</div>


	<!-- 데이터 출력을 위한 bootstrap 코드 작성  -->
	<div class="box-body">
		<table class="table table-bordered">
			<!-- 목록보기 타이틀 생성 -->
			<tr>
				<th>No.</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회</th>
			</tr>
			<!-- 글 목록 출력을 위한 반복문 작성 -->
			<!-- ${list}의 데이터를 순회하면서 순서대로 vo에 저장 -->
			<c:forEach var="vo" items="${list}">
				<tr>
					<td>${vo.bno}</td>
					<!-- 상세보기를 위해 제목에 링크 설정 & 파라미터로 bno값 넘겨주기 -->
					<td><a href="detail?bno=${vo.bno}">${vo.title}</a></td>
					<td>${vo.id}</td>
					<td>${vo.regdate}</td>
					<td align="right"><span class="badge bg-blue">${vo.readcnt}&nbsp;</span></td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<!-- 버튼 추가 -->
	<div class="box-footer">
		<div class="text-center">
			<button id="mainBt" class="btn btn-success">메인</button>
			<button id="writeBt" class="btn btn-danger">글 작성</button>
		</div>
	</div>

	<!-- Java Script로 버튼 클릭 처리 -->
	<script>
		// JQuery 사용
		$(function() {
			// main으로 이동
			$('#mainBt').on('click', function() {
				location.href = "../";
			});
		});

		$(function() {
			// 글 작성 페이지로 이동
			$('#writeBt').on('click', function() {
				location.href = "write";
			});
		});
	</script>

	<!-- 하단의 공통된 디자인 적용하기 -->
	<%@include file="../include/footer.jsp"%>
</body>
</html>
