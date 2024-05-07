<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/template/header.jsp"%>

<form class="join-form" method="post" autocomplete="off">
	<div class="container-fluid">
		<div class="row">
			<div class="col-6 offset-3">
				<div class="row">
					<div class="col mt-5">
						<h1>회원가입</h1>
					</div>
				</div>
				<div class="row mt-3">
					<div class="col">
						<label for="memberEmailInput" class="form-label">이메일</label>
						<div class="input-group">
							<input id="memberEmailInput" name="memberEmail" type="text"
								class="form-control">
							<button id="sendEmailBtn" class="btn btn-outline-primary col-3"
								type="button" disabled="disabled">
								<i class="fa-solid fa-spinner fa-spin-pulse"></i>
								<span>이메일인증</span>
								</button>
								
						</div>
					</div>
				</div>
				<div class="row mt-3 checkRow" hidden="true">
					<div class="col">
						<div class="input-group">
							<input id="certCheckInput" class="form-control" type="text"
								placeholder="인증번호">
							<button id="certCheckBtn" class="btn btn-outline-primary"
								type="button">인증</button>
						</div>
					</div>
				</div>
				<div class="row mt-3">
					<div class="col">
						<label for="memberPwInput" class="form-label">비밀번호</label> <input
							id="memberPwInput" name="memberPw" type="text"
							class="form-control" placeholder="영문 소문자, 숫자, 특수문자 반드시 포함">
					</div>
				</div>
				<div class="row mt-3">
					<div class="col">
						<label for="memberPwCheck" class="form-label">비밀번호 확인</label> <input
							id="memberPwCheck" type="text" class="form-control">
					</div>
				</div>
				<div class="row mt-3">
					<div class="col">
						<label for="memberNameInput" class="form-label">이름</label> <input
							id="memberNameInput" name="memberName" type="text"
							class="form-control">
					</div>
				</div>
				<div class="row mt-3">
					<div class="col">
						<label for="memberBirthInput" class="form-label">생년월일</label> <input
							id="memberBirthInput" name="memberBirth" type="date"
							class="form-control">
					</div>
				</div>
				<div class="row mt-3">
					<div class="col">
						<button type="submit" class="form-control btn btn-primary"
							id="join-btn" disabled>회원가입</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</form>
<script>
$(function(){
	let status = {
		memberEmail : false,
		emailCheck : false,
		certCheck : false,
		memberPw : false,
		memberPwCheck : false,
		memberName : false,
		memberBirth : false,
	};
	
	$("[name=memberEmail]").keyup(function(){
		let regex = /^[a-zA-Z0-9+-\_.]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/;
		let email = $(this).val();
		let isValid = email.length > 0 && regex.test(email);
		$(this).removeClass("is-valid is-invalid");
		$("#sendEmailBtn").removeClass("btn-outline-primary btn-primary");
		if(isValid){
			$(this).addClass("is-valid");
			$("#sendEmailBtn").addClass("btn-primary");
			$("#sendEmailBtn").prop("disabled", false);
		}
		else{
			$(this).addClass("is-invalid");
			$("#sendEmailBtn").addClass("btn-outline-primary");
			$("#sendEmailBtn").prop("disabled", true);
		}
		status.memberEmail = isValid;
		checkStatus();
	});
	
	$("[name=memberPw]").keyup(function(){
		let regex = /^(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$])[A-Za-z0-9!@#$]{8,16}$/;
		let pw = $(this).val();
		let isValid = pw.length > 0 && regex.test(pw);
		$(this).removeClass("is-valid is-invalid");
		$(this).addClass(isValid?"is-valid":"is-invalid");
		$("#memberPwCheck").keyup();
		status.memberPw = isValid;
		checkStatus();
	});
	
	$("#memberPwCheck").keyup(function(){
		let originPw = $("[name=memberPw]").val();
		let checkPw = $(this).val();
		let isValid = originPw===checkPw && checkPw.length > 0
		$(this).removeClass("is-valid is-invalid");
		if(isValid) $(this).addClass("is-valid");
		else $(this).addClass("is-invalid");
		status.memberPwCheck = isValid;
		checkStatus();
	});
	
	$("[name=memberName]").keyup(function(){
		let regex = /^[가-힣]{2,7}$/;
		let name = $(this).val();
		let isValid = name.length > 0 && regex.test(name);
		$(this).removeClass("is-valid is-invalid");
		$(this).addClass(isValid?"is-valid":"is-invalid");
		status.memberName = isValid;
		checkStatus();
	});
	
	$("[name=memberBirth]").keyup(function(){
		let regex = /^(19[0-9]{2}|20[0-9]{2})-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/;
        let birth = $(this).val();
        let birthDate = new Date(birth);
        let currentDate = new Date();
        let isValid = birth.length > 0 && regex.test(birth) && birthDate < currentDate;
		$(this).removeClass("is-valid is-invalid");
		$(this).addClass(isValid?"is-valid":"is-invalid");
		status.memberBirth = isValid;
		checkStatus();
	});
	
	function checkStatus() {
        let isValid = Object.values(status).every(value => value === true);
        $("#join-btn").prop("disabled", !isValid);
    }
	
	$(window).on("beforeunload", function(){
        return false;
    });
	
	$(".join-form").submit(function(e){
		$(".form-control").keyup();
		let isValid = Object.values(status).every(value => value === true);
		if(!isValid){
			e.preventDefault();
		}
		else{
			$(window).off("beforeunload");
		}
	});
	
	$("#sendEmailBtn").find(".fa-spinner").hide();
	
	function sendCert(email){
		$.ajax({
			type:"POST",
			url:window.contextPath + "/cert/" + email,
			success:function(response){
				alert("이메일을 확인해주세요.");
				$(".checkRow").prop("hidden", false);
				$("#sendEmailBtn").find(".fa-spinner").hide();
				$("#sendEmailBtn").find("span").text("이메일인증");
			},
			error: function(error){
				alert("오류발생");
			}
		});
	}
	
	$("#sendEmailBtn").click(function(){
		var email = $("#memberEmailInput").val();
		$.ajax({
			type:"GET",
			url:window.contextPath + "/member/" + email,
			success: function(response){
				if(!response) {
					status.emailCheck = true;
					$("#sendEmailBtn").find(".fa-spinner").show();
					$("#sendEmailBtn").find("span").text("");
					sendCert(email);
				}
				else{
					status.emailCheck = false;
					alert("이미 가입된 이메일 입니다.");
				}
			},
			error: function(error){
				alert("오류 발생");
			},
		});
		checkStatus();
	});
	
	$('#certCheckInput').on('input', function(event) {
        $(this).val($(this).val().replace(/\D/, '')); // 숫자가 아닌 문자 제거
    });
	
	
	$("#certCheckBtn").click(function(){
		var inputNum = $("#certCheckInput").val();
		var email = $("#memberEmailInput").val();
		$.ajax({
			type:"POST",
			url:window.contextPath + "/cert/check",
			data:{
				"certEmail" : email,
				"certNumber" : inputNum
			},
			success : function(response){
				if(response){
					status.certCheck = true;
					alert("인증되었습니다.");
					emailDisabled();
				}
				else{
					status.certCheck = false;
					alert("인증번호를 확인해주세요");
				}
					
			},
			error: function(error){
				alert("오류발생");
			},
		});
		checkStatus();
	});
	
	function emailDisabled(){
		$(".input-group input").prop("readonly", true);
		$(".input-group button").prop("disabled", true);
	};
	
});
</script>
<%@ include file="/WEB-INF/views/template/footer.jsp"%>