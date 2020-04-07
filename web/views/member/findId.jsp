<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/views/common/header.jsp"%>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/member/findId.css" type="text/css">
<%
	userId = (String)request.getAttribute("userId");
%>

<div id="findTitle">
	<h1>
		<span style="color: rgb(94, 100, 177);">아이디 찾기</span>
	</h1>
	<hr class="line">
</div>

<div class="tabContainer">
	<div id="tab-1" class="tab-content current">
		<form id="findId" action="<%=request.getContextPath()%>/findId"
			method="POST">
			<div class="textInfor">
				<h3 class="h3">
					* 가입시 사용한 <span style="color: rgb(94, 100, 177);">이메일</span>을
					입력하세요.
				</h3>
			</div>
			<div>
				<b style="font-size: 20px;">이메일 입력</b><br>
			</div>
			<div>
				<input class="findInp" type="email" name="email" id="email"
					placeholder="가입시 입력한 이메일">
			</div>
		</form>
		<button class="findBtn" onclick="find();">아이디 찾기</button>
	</div>
</div>
<hr class="line">

<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/findId.js"></script>
</body>

</html>