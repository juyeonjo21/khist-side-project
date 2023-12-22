<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>공지사항 상세</h1>
<div>
${noticeDto.noticeTitle}
${noticeDto.noticeContent}
${noticeDto.noticeTime}
</div>

<a href="list">목록</a>
<a href="insert">글쓰기</a>
<a href="edit?noticeNo=${noticeDto.noticeNo}">수정</a>
<a href="delete?noticeNo=${noticeDto.noticeNo}">삭제</a>