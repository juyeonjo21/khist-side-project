<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="/WEB-INF/views/template/header.jsp"%>
    
    <!-- summernote cdn -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">

	<style>
        .note-editable{
            line-height:2 !important;
        }
     </style>

<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
    
    <!-- javascript 작성 공간 -->
    <script>
    	$(function(){
    		$('[name=boardContent]').summernote({
    			 placeholder: '내용을 작성하세요',
    	           tabsize: 2,//탭을 누르면 이동할 간격
    	           height: 200,//에디터 높이
    	           minHeight:200,//에디터 최소높이
    	           toolbar: [
    	               ['style', ['style']],
    	               ['font', ['bold', 'italic', 'underline']],
    	               ['color', ['color']],
    	               ['para', ['paragraph']],
    	               ['table', ['table']],
    	               ['insert', ['link']],
    	           ]
    		});
    	});
    </script>
    
  <form action="write" method="post" autocomplete="off">
    <div class="container w-600">
    	<div class="row">
    		<h1 class="text-center mt-5">게시글 작성</h1>
    	</div>
    	<hr>
    	<div class="row left">
    		<div class="row">
    			<select class="form-select form-select me-2" aria-label="select example">
  				<option selected>게시판 선택</option>
  				<option value="1">자유게시판</option>
 				<option value="2">우리반 게시판</option>
  				<option value="3">스터디 게시판</option>
  				<option value="4">강사 후기 게시판</option>
				</select>
    		</div>
    	</div>
    		<div class="row left">
    				<div class=" row">
    					<input type="text" placeholder="글 제목을 작성해주세요." required class="form-input w-100 mt-2"
    					 name="boardTitle" oninput="checkBoardTitle();">
    				</div>
    			</div>
    			<div class="row left">
    				<div class=" row">
    					<input type="text" placeholder="사진 첨부" required class="form-input w-100 mt-2"
    					 name="boardTitle" oninput="checkBoardTitle();">
    				</div>
    			</div>
    				<div class="row left">
    				<div class="row">
    					<textarea name="boardContent" class="form-input w-100 mt-3" 
    					style="min-height:250px;"
    					 oninput="checkBoardContent();"></textarea>
    				</div>
    				</div>
    				
    		<div class="row left">
    			<div class="row">
    				<button type="submit" class="btn btn-primary w-100 mt-5">
    				<i class="fa-solid fa-pen"></i>등록</button>
    			</div>
    		</div>
    			
    		<div class="row left">
    			<div class="row">
    				<a class="btn w-100 mt-2" href="${pageContext.request.contextPath}/board/list">목록으로</a>
    			</div>
    		</div>
    	</div>
</form>