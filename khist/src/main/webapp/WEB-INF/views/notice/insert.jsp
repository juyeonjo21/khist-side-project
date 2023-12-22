<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>공지사항 작성</h1>
<form method="post" action="insert" autocomplete="off">

<div>
<input type="text" name="noticeTitle" placeholder="제목">
</div>
<div>
<textarea name="noticeContent" placeholder="내용" rows="10" cols="50"></textarea>
</div>
<button type="submit">작성하기</button>

</form>