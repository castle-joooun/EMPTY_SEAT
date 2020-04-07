<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/views/common/header.jsp"%>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/member/findId.css" type="text/css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/member/withdrawal.css" type="text/css">
<%
	userId = (String) request.getAttribute("userId");
%>

<div id="findTitle">
	<h1>
		<span style="color: rgb(94, 100, 177);">아이디 찾기</span>
	</h1>
	<hr class="line">
</div>

<center>
<div class="tabContainer">
	<div>
		<div>
			<h3>
			<%if(userId != null){ %>
				<span>회원님의 아이디는 [<span style="color: rgb(94, 100, 177);"><%=userId%></span>]입니다.</span>
			<%}else{ %>
				 <span>일치하는 정보가 없습니다.</span>
			<%} %>
			</h3>
			<%if(userId != null){ %>
			<button class="findBtn" type="button" onclick="location.href='<%=request.getContextPath()%>/findPwView'">비밀번호 찾기</button>
			<%}else{ %>
			<button class="findBtn" type="button" onclick="location.href='<%=request.getContextPath()%>/signUpChoice'">회원가입</button>
			<%} %>
			<button class="findBtn" type="button" onclick="location.href='<%=request.getContextPath()%>/home'">홈으로</button>
		</div>
	</div>
</div>
</center>
<hr class="line">

<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/findId.js"></script>
</body>

</html>