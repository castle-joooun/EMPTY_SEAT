<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/views/common/header.jsp"%>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/findPw.css" type="text/css">

<div id="findTitle">
	<h1>
		<span style="color: rgb(94, 100, 177);">비밀번호 찾기</span>
	</h1>
	<hr class="line">
</div>

<div class="tabContainer">
	<div id="tab-2" class="tab-content">
		<form id="findPw" action="<%=request.getContextPath()%>/findPw" method="POST">
			<div class="textInfor">
				<h3 class="h3">
					* <span class="pointSpan">아이디</span>를 입력하세요.
				</h3>
			</div>
			<div>
				<b>아이디 입력</b><br>
			</div>
			<div>
				<input class="findInp" type="text" name="userId" id="findId"
					placeholder="아이디">
			</div>
			<div>
				<h3 class="h3">
					* 가입시 사용한 <span class="pointSpan">이메일</span>을 입력하세요.
				</h3>
			</div>
			<div>
				<b>이메일 입력</b><br>
			</div>
			<div>
				<input class="findInp" type="email" name="email"
					id="findIdEmail" placeholder="가입시 입력한 이메일">
			</div>
		</form>
		<div>
			<button class="findBtn"
				onclick="find();">비밀번호
				찾기</button>
		</div>
	</div>
	<hr class="line">
</div>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/findPw.js"></script>
</body>

</html>