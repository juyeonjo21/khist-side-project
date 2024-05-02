<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<%@ include file="/WEB-INF/views/template/header.jsp"%>

<script>
   
</script>


	<div class="container w-800">
		<div class="row mt-5">
				<h1 class="text-center">자유 게시판</h1>
		</div>
			<%-- 글쓰기는 로그인 상태인 경우에만 출력 --%>
			<c:if test="${sessionScope.email != null}">
			<div class="row right">
				<a href="write" class="btn">
					글쓰기
					</a>
				</div>
			</c:if>
			<a class="btn w-100 mt-2" href="${pageContext.request.contextPath}/">홈으로</a>
		<hr>
		<div class="row">
		<table class="table table-slit">
			<thead>
				<tr>
					<th>번호</th>
					<th width="40%">제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회수</th>
					<th>좋아요</th>
				</tr>
			</thead>
				<tbody>
			<c:forEach var="boardDto" items="${list}">
				<tr>
					<%-- <c:if test="${sessionScope.level == '관리자'}">
					<td>
						<!-- 개별항목 체크박스 -->
						<input type="checkbox" class="check-item" name="boardNoList" value="${boardLikeDto.boardNo}">
					</td>
					</c:if> --%>
					<td>${boardDto.boardNo}</td>
						<td align="left">
						<!-- 제목을 누르면 상세페이지로 이동 -->
						<a class="link" href="detail?boardNo=${boardDto.boardNo}">
							${boardDto.boardTitle}
						</a>
					</td>
					<td>${writerName}</td>
					<td>${boardDto.boardDate}</td>
					<td>${boardDto.boardReadCount}</td>
					<td>${boardLikeDto.boardLikecount}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	  </div>
	</div>
