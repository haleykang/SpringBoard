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
	<!-- 이미지 파일 업로드를 위해 enctype 추가 -->
	<form role="form" method="post" enctype="multipart/form-data">
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
				<!-- 작성자 이름에 로그인한 사람의 id가ㄴ 출력되도록 수정..? -->
				<label>작성자</label> <input type="text" name="id" class="form-control"
					value="${login.id}" readonly="readonly" />
			</div>

			<!-- 이미지 파일 등록 영역 -->
			<div class="form-group">
				<div>
					<img id="img" width="200" height="200" />

					<div>
						<input type="file" name="image" id="image" class="form-control" />
					</div>
				</div>
			</div>

			<div class="form-group">
				<div class="box-footer">
					<button type="submit" class="btn btn-primary">작성완료</button>
				</div>
			</div>
		</div>
	</form>
</section>


<!-- 파일 이미지 미리보기 구현을 위한 스크립트 -->
<script>
	$(function() {
		// change 이벤트가 발생하면 readURL 메소드 호출
		// change - 내용이 변경되면 호출되는 이벤트
		$('#image').on('change', function() {
			readURL(this);
		});
	});

	// id가 image인 태그에 change 이벤트 발생 시 실행 시킬 readURL 메소드
	// -> 이미지 파일 선택 시 미리보기 수행
	function readURL(input) {
		if (input.files && input.files[0]) {
			// 사용자가 선택한 파일 이름 가져오기
			var filename = input.files[0].name;
			// 파일 이름 뒤에서 3자 가져오기
			var ext = filename.substr(filename.length - 3, filename.length);
			// 파일 확장자가 그림 파일 인 경우 확인
			if (ext.toLowerCase() == 'jpg' || ext.toLowerCase() == 'gif'
					|| ext.toLowerCase() == 'png') {
				var reader = new FileReader();
				reader.onload = function(e) {
					$('#img').attr('src', e.target.result);
				}
				reader.readAsDataURL(input.files[0]);

			} else {
				alert("jpg나 gif, png 만 업로드 가능합니다. ;");
				return;
			}
		}
	}
</script>

<!-- 하단의 공통된 디자인 적용 - include 폴더의 footer.jsp -->
<%@include file="../include/footer.jsp"%>