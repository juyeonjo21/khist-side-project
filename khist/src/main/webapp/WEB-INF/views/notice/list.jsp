<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
 <h1>공지사항 게시판임</h1> 
 
 <h4><a href="insert">글쓰기</a></h4>
 
 <table border="1" width="800">
 	<thead>
 		<tr>
				<th>번호</th>
				<th width="40%">제목</th>
				<th>작성자</th>
				<th>작성일</th>
 		</tr>
 	</thead>
 	<tbody>
 		<c:forEach var="noticeDto" items="${list}">
 			<tr>
 				<td>${noticeDto.noticeNo}</td>
 				<td><a href="detail?noticeNo=${noticeDto.noticeNo}">${noticeDto.noticeTitle}</a></td>
 				<td>${noticeDto.memberEmail}</td>
 				<td>${noticeDto.noticeTime}</td>
 			</tr>
 		</c:forEach>
 	</tbody>
 </table>