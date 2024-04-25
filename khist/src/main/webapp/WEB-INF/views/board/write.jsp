<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
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
    <div class="container w-800">
    	<div class="row">
    		<h1>게시글 작성</h1>
    	</div>
    	<hr>
    		<div class="row left">
    			<div class="row">
    					<label>
    					제목
    					<span class="important fa-solid fa-asterisk red">
             			</span>
    					</label>
    				<div class=" row">
    					<input type="text" required class="form-input w-100"
    					style="width:600px;" name="boardTitle" oninput="checkBoardTitle();">
    				</div>
    			</div>
    				<div class="row left">
    				<div class="row">
    					<label>
    					내용
    					<span class="important fa-solid fa-asterisk red"> 
            			</span>
    					</label>
    				</div>
    					<textarea name="boardContent" class="form-input w-100" 
    					style="min-height:250px; width:600px; height:400px;"
    					 oninput="checkBoardContent();"></textarea>
    				</div>
    			<div class="row">
    				<button type="submit" class="btn btn-positive w-100">
    				<i class="fa-solid fa-pen"></i>등록</button>
    				<a class="btn w-100" href="${pageContext.request.contextPath}/board/list">목록으로</a>
    			</div>
    		</div>
    	</div>
</form>