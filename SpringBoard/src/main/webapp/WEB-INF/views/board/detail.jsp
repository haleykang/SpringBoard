<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--for나 if를 사용하기위한 JSTL 태그 라이브러리 추가  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상세보기</title>
</head>
<body>
	<!-- 상단 공통 디자인 적용 -->
	<%@include file="../include/header.jsp"%>
	<section class="content">
	<div class="box">
		<div class="box-header">
			<h3 class="box-title">상세보기</h3>
		</div>

		<div class="box-body">
			<div class="form-group">
				<label>제목</label> <input type="text" name="title"
					class="form-control" value="${vo.title}" readonly="readonly" />
			</div>
			<div class="form-group">
				<label>내용</label>
				<textarea rows="5" readonly="readonly" name="content"
					class="form-control">${vo.content}</textarea>
			</div>
			<div class="form-group">
				<label>작성자</label> <input type="text" name="id" class="form-control"
					value="${vo.id}" readonly="readonly" />
			</div>
		</div>

		<!-- 필요한 버튼 추가 -->
		<div class="box-footer">
			<button id="mainBt" class="btn btn-success">메인</button>
			<button id="listBt" class="btn btn-warning">목록</button>
			<c:if test="${login.id==vo.id}">
				<button id="updateBt" class="btn btn-danger">수정</button>
				<button id="deleteBt" class="btn btn-primary">삭제</button>
			</c:if>
		</div>

	</div>

	<!-- 버튼 처리를 위한 스크립트 --> <script>
		$(function() {
			$('#mainBt').on('click', function() {
				location.href = "../";
			});
		});

		$(function() {
			$('#listBt').on('click', function() {
				location.href = "list";
			});
		});

		// 수정 처리 버튼 -> 글 번호 파라미터 값 꼭 보내기 
		$(function() {
			$('#updateBt').on('click', function() {
				location.href = "update?bno=${vo.bno}";
			});
		});

		// 삭제 처리 버튼
		$(function() {
			$('#deleteBt').on('click', function() {
				location.href = "delete?bno=${vo.bno}";
			});
		});
	</script> </section>
	<!-- 하단 공통 디자인 적용 -->
	<%@include file="../include/footer.jsp"%>

</body>
</html>