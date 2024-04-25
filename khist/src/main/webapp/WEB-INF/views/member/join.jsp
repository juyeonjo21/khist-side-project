<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/template/header.jsp"%>    

<form class="join-form" method="post" autocomplete="off">
<div class="container-fluid">
	<div class="row"><div class="col-6 offset-3">
		<div class="row"><div class="col mt-5">
			<h1>회원가입</h1>
		</div></div>
		<div class="row mt-3"><div class="col">
			<label for="memberEmailInput" class="form-label">이메일</label>
			<input id="memberEmailInput" name="memberEmail" type="text" class="form-control">
		</div></div>
		<div class="row mt-3"><div class="col">
			<label for="memberPwInput" class="form-label">비밀번호</label>
			<input id="memberPwInput" name="memberPw" type="text" class="form-control"
			placeholder="영문 소문자, 숫자, 특수문자 반드시 포함">  
		</div></div>
		<div class="row mt-3"><div class="col">
			<label for="memberPwCheck" class="form-label">비밀번호 확인</label>
			<input id="memberPwCheck" type="text" class="form-control">  
		</div></div>
		<div class="row mt-3"><div class="col">
			<label for="memberNameInput" class="form-label">이름</label>
			<input id="memberNameInput" name="memberName" type="text" class="form-control"> 
		</div></div>
		<div class="row mt-3"><div class="col">
			<label for="memberBirthInput" class="form-label">생년월일</label>
			<input id="memberBirthInput" name="memberBirth" type="date" class="form-control"> 
		</div></div>
		<div class="row mt-3"><div class="col">
			<button type="submit" class="form-control btn-primary" id="join-btn">회원가입</button>
		</div></div>
	</div></div>
</div>
</form>

<script>
$(function(){
	let status = {
		memberEmail : false,
		memberPw : false,
		memberPwCheck : false,
		memberName : false,
		memberBirth : false,
	};
	
	$("[name=memberEmail]").blur(function(){
		let regex = /^[a-zA-Z0-9+-\_.]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/;
		let email = $(this).val();
		let isValid = email.length > 0 && regex.test(email);
		$(this).removeClass("is-valid is-invalid");
		$(this).addClass(isValid?"is-valid":"is-invalid");
		status.memberEmail = isValid;
	});
	
	$("[name=memberPw]").blur(function(){
		let regex = /^(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$])[A-Za-z0-9!@#$]{8,16}$/;
		let pw = $(this).val();
		let isValid = pw.length > 0 && regex.test(pw);
		$(this).removeClass("is-valid is-invalid");
		$(this).addClass(isValid?"is-valid":"is-invalid");
		$("#memberPwCheck").blur();
		status.memberPw = isValid;
	});
	
	$("#memberPwCheck").blur(function(){
		let originPw = $("[name=memberPw]").val();
		let checkPw = $(this).val();
		let isValid = originPw===checkPw && checkPw.length > 0
		$(this).removeClass("is-valid is-invalid");
		if(isValid) $(this).addClass("is-valid");
		else $(this).addClass("is-invalid");
		status.memberPwCheck = isValid;
	});
	
	$("[name=memberName]").blur(function(){
		let regex = /^[가-힣]{2,7}$/;
		let name = $(this).val();
		let isValid = name.length > 0 && regex.test(name);
		$(this).removeClass("is-valid is-invalid");
		$(this).addClass(isValid?"is-valid":"is-invalid");
		status.memberName = isValid;
	});
	
	$("[name=memberBirth]").blur(function(){
		let regex = /^(19[0-9]{2}|20[0-9]{2})-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/;
        let birth = $(this).val();
        let birthDate = new Date(birth);
        let currentDate = new Date();
        let isValid = birth.length > 0 && regex.test(birth) && birthDate < currentDate;
		$(this).removeClass("is-valid is-invalid");
		$(this).addClass(isValid?"is-valid":"is-invalid");
		status.memberBirth = isValid;
	});
	
	$(window).on("beforeunload", function(){
        return false;
    });
	
	$(".join-form").submit(function(e){
		$(".form-control").blur();
		let isValid = Object.values(status).every(value => value === true);
		if(!isValid){
			e.preventDefault();
		}
		else{
			$(window).off("beforeunload");
		}
	});
});
</script>