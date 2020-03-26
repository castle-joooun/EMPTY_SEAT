<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/views/common/header.jsp"%>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/findPw.css" type="text/css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/withdrawal.css" type="text/css">
<%
	userId = (String) request.getAttribute("userId");
%>

<div id="findTitle">
	<h1>
		<span style="color: rgb(94, 100, 177);">비밀번호 찾기</span>
	</h1>
	<hr class="line">
</div>

<div class="tabContainer">
	<form id="findPw" action="<%=request.getContextPath()%>/updatePassword"
		method="POST">
		<div id="tab-2" class="tab-content">
			<%
				if (userId != null) {
			%>
			<input style="display: none" name="id" value="<%=userId%>" />
			<div class="textInfor">
				<h3 class="h3">
					* 새 <span class="pointSpan">비밀번호</span>를 입력하세요.<span
						class="spanText" id="pwCondition"></span>
				</h3>
			</div>
			<div>
				<label for="psw"></label> <input class="findInp" type="password"
					placeholder="영어와 숫자, 특수문자(!@#$%^&*)만 사용 가능합니다" id="pw1" name="psw"
					onchange="pwCondition()">
			</div>
			<div class="textInfor">
				<h3 class="h3">
					* <span class="pointSpan">비밀번호 </span>확인.<span class="spanText"
						id="pwOk"></span>
				</h3>
			</div>
			<div>
				<label for="pswcheck"></label> <input type="password"
					class="findInp" placeholder="위의 비밀번호와 같이 입력하세요" id="pw2"
					name="pswcheck" onchange="pswCheck()">
			</div>
	</form>
	<div>
		<button class="findBtn" onclick="resetPw();">비밀번호 변경</button>
	</div>
	<%
		} else {
	%>
	<h2 class="h3">일치하는 정보가 없습니다.</h2>
	<div>
		<button class="findBtn" type="button"
			onclick="location.href='<%=request.getContextPath()%>/views/member/findId.jsp'">아이디
			찾기</button>
		<button class="findBtn" type="button"
			onclick="location.href='<%=request.getContextPath()%>/views/member/main.jsp'">홈으로</button>
		<%
			}
		%>
	</div>
</div>

<hr class="line">

<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/findPw.js"></script>
</body>

</html>