<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/template/header.jsp"%>

<div class="container-fluid">
	<div class="row"><div class="col-6 offset-3">
		<div class="row mt-5"><div class="col">
			<h1>마이페이지</h1>
		</div></div>
		<div class="row mt-5"><div class="col">
			<table class="table">
				<thead>
					<tr class="table-primary">
						<th colspan="2">내정보</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td class="table-secondary">이메일</td>
						<td>${memberDto.memberEmail}</td>
					</tr>
					<tr>
						<td class="table-secondary">이름</td>
						<td>${memberDto.memberName}</td>
					</tr>
					<tr>
						<td class="table-secondary">생년월일</td>
						<td>${memberDto.memberBirth}</td>
					</tr>
					<tr>
						<td class="table-secondary">등급</td>
						<td>${memberDto.memberLevel}</td>
					</tr>
					<tr>
						<td class="table-secondary">포인트</td>
						<td>${memberDto.memberPoint}</td>
					</tr>
					<tr>
						<td class="table-secondary">가입일</td>
						<td>${memberDto.memberJoin}</td>
					</tr>
					<tr>
						<td class="table-secondary">최근 로그인</td>
						<td>${memberDto.memberLogin}</td>
					</tr>
					<tr>
						<td class="table-secondary">비밀번호 변경일</td>
						<td>${memberDto.memberChange}</td>
					</tr>
				</tbody>
			</table>
		</div></div>
		<div class="row mt-5"><div class="col">
			<!-- Button trigger modal -->
			<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#changePwModal">
			  비밀번호 변경
			</button>
		</div></div>
	</div></div>
</div>

<!-- Modal -->
<div class="modal fade" id="changePwModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="changePwModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="changePwModalLabel">비밀번호변경</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
      	<div class="row"><div class="col">
	      	<label for="currentPw">현재 비밀번호</label>
	        <input class="form-control" id="currentPw">
      	</div></div>
       	<div class="row"><div class="col">
			<label for="newPw">새로운 비밀번호</label>
	        <input class="form-control" id="newPw">
       	</div></div>
       	<div class="row"><div class="col">
       		<label for="checkPw">새로운 비밀번호 확인</label>
	        <input class="form-control" id="checkPw">
       	</div></div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
        <button type="button" class="btn btn-primary" id="changePwBtn">비밀번호 변경</button>
      </div>
    </div>
  </div>
</div>

<script>
	$("#changePwBtn").click(function(){
		var currentPw = $("#currentPw").val();
		var newPw = $("#newPw").val();
		var checkPw = $("#checkPw").val();
		
		if(newPw != checkPw){
			alert("바꿀 비밀번호와 비밀번호 확인이 일치 하지 않습니다.")
			return;
		}
		
		$.ajax({
			type:"PUT",
			url:window.contextPath + "/member/changePw",
			data:{
				"currentPw" : currentPw,
				"newPw" : newPw
			},
			success:function(response){
				if(response == 2){
					alert("비밀번호가 일치하지 않습니다.");
					return;
				}
				else if(response == 4){
					alert("현재와 같은 비밀번호 변경 하실 수 없습니다.");
					return;
				}
				else if(response == 3){
					alert("변경되었습니다. 다시 로그인 해주세요.");
					window.location.href = window.contextPath + "/member/logout";
				}
				else{
					alert("오류가 발생하였습니다.");
					return;
				}
			},
			error:function(error){
				alert(error);
			},
		});
	});
</script>