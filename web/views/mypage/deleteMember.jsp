<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/mypage/deleteMember.css"
	type="text/css">

<div id="deleteMemberMainDiv">
	<div id="deleteMemberHeader">
		<h1>회원탈퇴</h1>
	</div>
	<p>
		<span>빈시트 회원탈퇴 안내입니다.</span><br> <span>회원탈퇴시 모든 정보가 삭제되오니
			신중하게 탈퇴 신청을 해주시기 바랍니다.</span><br> <span>회원님의 정보보호를 위해 비밀번호를 다시한번
			입력해주시기 바랍니다.</span><br>
	</p>
	<div>
		<h3>회원정보확인</h3>
		<form action="<%=request.getContextPath()%>/deleteMemberEnd" id="deleteMemberForm" method="post">
			<table id="deleteMemberTable">
				<tr>
					<th>이름</th>
					<td><input type="text" name="userName" value="<%=loginMember.getUserName()%>" readonly></td>
				</tr>
				<tr>
					<th>아이디</th>
					<td><input type="text" name="userId" value="<%=loginMember.getUserId()%>" readonly></td>
				</tr>
				<tr>
					<th>비밀번호 확인</th>
					<td><input type="password" id="password" name="password"></td>
				</tr>
			</table>
		</form>
		<button type="button" id="deleteMemberBtn" onclick="deleteMemberBtn()" >회원탈퇴</button>
		<button type="button" onclick="deleteCancleBtn()" >취소</button>
	</div>
</div>

<script>
 	function deleteMemberBtn(){
 		if(document.getElementById("password").value!=""){
 			document.getElementById("deleteMemberForm").submit()
 		}else{
 			alert("비밀번호를 입력하세요");
 		}
		
		
		
	}
	
	function deleteCancleBtn(){
		location.replace("<%=request.getContextPath()%>/views/mypage/mypageMain.jsp");
	}
</script>