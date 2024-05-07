<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/template/header.jsp"%>

<div class="container-fluid">
	<div class="row"><div class="col-6 offset-3">
		<div class="row mt-5"><div class="col">
			<h1>로그인</h1>
		</div></div>
		<div class="row mt-3"><div class="col">
			<label for="memberEmailInput" class="form-label">이메일</label>
			<input id="memberEmailInput" name="memberEmail" type="text" class="form-control"
				value="${cookie.saveEmail.value}">
		</div></div>
		<div class="row mt-3"><div class="col">
			<label for="memberPwInput" class="form-label">비밀번호</label>
			<input id="memberPwInput" name="memberPw" type="text"class="form-control">
		</div></div>
		<div class="row mt-2"><div class="col">
			아이디 저장 
			<c:choose>
				<c:when test="${cookie.saveEmail != null}">
					<input name="remember" type="checkbox" checked>				
				</c:when>
				<c:otherwise>
					<input name="remember" type="checkbox">
				</c:otherwise>
			</c:choose>
		</div></div>
		<div class="row mt-3"><div class="col">
			<button type="button" class="form-control btn btn-primary"
							id="login-btn">로그인</button>
		</div></div>								
	</div></div>
</div>

<script>

	$("#login-btn").click(function(e){
		var memberEmail = $("#memberEmailInput").val();
		var memberPw = $("#memberPwInput").val();
		var remember = $("[name=remember]").is(":checked");
		console.log(remember);
		if(memberEmail.length < 1){
			alert("이메일을 입력해주세요.");
			return;
		}
		if(memberPw.length < 1){
			alert("비밀번호를 입력해주세요.");
			return;
		}
		$.ajax({
			type : "POST",
			url : window.contextPath + "/member/login",
			data : {
				"memberEmail" : memberEmail,
				"memberPw" : memberPw, 
				"remember" : remember
			},
			success : function(response){
				if(response === 1){
					alert("가입되지 않은 이메일입니다.");
					return;
				}
				else if(response === 2){
					alert("비밀번호가 일치하지 않습니다.");
					return;
				}
				else{
					window.location.href = window.contextPath + "/";
				}
			},
			error : function(error){
				alert("오류발생");
			}
		});
	});

</script>