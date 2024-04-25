<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/template/header.jsp"%>    

<h1>회원가입 완료</h1>
<a href="${pageContext.request.contextPath}/">홈으로</a>
<script>
	history.pushState(null, null, location.href);
	window.onpopstate = function(event) {
	    alert("이전 페이지로 이동 할 수 없습니다.");
	    history.go(1);
	};
</script>