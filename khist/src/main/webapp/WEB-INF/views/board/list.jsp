<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/template/header.jsp"%>

<script>
   
</script>


	<div class="container w-800">
		<div class="row mt-5">
				<h1 class="text-center">자유 게시판</h1>
		</div>
		<hr>
		<div class="row">
		<table class="table table-slit">
			<thead>
				<tr>
					<c:if test="${sessionScope.level == '관리자'}">
					<th>
						<!-- 전체선택 체크박스 -->
						<input type="checkbox" class="check-all">
					</th>
					</c:if>
					<th>번호</th>
					<th width="40%">제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회수</th>
					<th>좋아요</th>
				</tr>
			</thead>
		</table>
	  </div>
	</div>
