<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<%@ include file="/WEB-INF/views/template/header.jsp"%>

<!-- javascript 작성 공간 -->
<script>

</script>

	<div class="flex-container">
		<div class="row">
			<table class="table table-slit">
			<tbody>
				<tr>
					<td>카테고리 : ${boardDto.boardCategory}</td>
				</tr>
				<tr>	
					<td>작성자 : ${writerName}</td>
				</tr>
				<tr>
					<td>작성일 : ${boardDto.boardDate}</td>
				</tr>
				<tr>
					<td> 첨부파일  <br> 
					<img id="boardImage${attachDto.attachNo}" src="${pageContext.request.contextPath}/attach/board/${attachDto.attachNo}"
     width="300" height="300">
					</td>
				</tr>
				<tr>
					<td colspan="3">내용 : ${boardDto.boardContent}</td>
				</tr>
			</tbody>
		</table>	
		<div class="row left">
				<div class="row">
    				<a class="btn w-100 mt-2" href="${pageContext.request.contextPath}/board/list">목록으로</a>
				</div>
			</div>			
		</div>
	</div>