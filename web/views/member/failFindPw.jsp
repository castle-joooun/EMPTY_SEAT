<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/views/common/header.jsp"%>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/member/findId.css" type="text/css">
<div id="findTitle">
	<h1>
		<span style="color: rgb(94, 100, 177);">비밀번호 찾기</span>
	</h1>
	<hr class="line">
</div>
<div class="tabContainer">
<center>
<h2 class="h3">일치하는 정보가 없습니다.</h2>
	<div>
		<button class="findBtn" type="button"
			onclick="location.href='<%=request.getContextPath()%>/findIdView'">아이디
			찾기</button>
		<button class="findBtn" type="button"
			onclick="location.href='<%=request.getContextPath()%>/home'">홈으로</button>
	</div>
</center>
</div>
<hr class="line">

<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/findId.js"></script>
</body>

</html>