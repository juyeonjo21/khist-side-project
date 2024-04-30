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
					<td>${boardDto.boardNo}</td>
					<td>${boardDto.boardCategory}</td>
					<td>${boardDto.boardWriter}</td>
					<td>${boardDto.boardDate}</td>
					<td>${boardDto.boadReadCount}</td>
					<td colspan="3">${boardDto.boardContent}</td>
				</tr>
			</tbody>
		</table>				
		</div>
	</div>