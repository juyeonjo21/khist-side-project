<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
    봄..여름..가을 .. 겨울..
    
    h..i..s..t
    
    93..94..95..96
    
    <c:choose>
    	<c:when test="${sessionScope.email!=null}">
    		<br><br>
    		<a href="${pageContext.request.contextPath}/member/logout">로그아웃</a>	
    	</c:when>
    	<c:otherwise>
    		<br><br>
		    <a href="${pageContext.request.contextPath}/member/join">회원가입</a>
		    <br><br>
		    <a href="${pageContext.request.contextPath}/member/login">로그인</a>
    	</c:otherwise>
    </c:choose>
    
    
    
    
    
    
    <br><br>
    로그인 이메일 = ${email}
    
    