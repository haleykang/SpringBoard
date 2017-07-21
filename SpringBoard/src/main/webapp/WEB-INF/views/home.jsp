<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<!-- header.jsp 파일의 내용을 가져와서 삽입 -->
<%@include file="include/header.jsp"%>
<section class="content">
	<div class="box">
		<div class="box-header with-border">
			<a href="board/write"><h3 class="box-title">게시판 글쓰기</h3></a>
		</div>
	</div>
	
	<!-- 게시글 목록 보기 추가 -->
	<div class="box">
		<div class="box-header with-border">
			<a href="board/list"><h3 class="box-title">게시판 목록보기</h3></a>
		</div>
	</div>
</section>
<!-- footer.jsp 파일의 내용을 가져와서 삽입 -->
<%@include file="include/footer.jsp"%>