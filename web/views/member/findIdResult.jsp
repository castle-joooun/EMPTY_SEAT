<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/views/common/header.jsp"%>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/findId.css" type="text/css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/withdrawal.css" type="text/css">
<%
	userId = (String) request.getAttribute("userId");
%>

<div id="findTitle">
	<h1>
		<span style="color: rgb(94, 100, 177);">아이디 찾기</span>
	</h1>
	<hr class="line">
</div>

<div class="tabContainer">
	<div id="tab-1" class="tab-content current">
		<div class="textInfor">
			<h3 class="h3">
			<%if(userId != null){ %>
				<span>회원님의 아이디는 [<span style="color: rgb(94, 100, 177);"><%=userId%></span>]입니다.</span>
			<%}else{ %>
				 <span>일치하는 정보가 없습니다.</span>
			<%} %>
			</h3>
			<%if(userId != null){ %>
			<button class="findBtn" type="button" onclick="location.href='<%=request.getContextPath()%>/views/member/findPw.jsp'">비밀번호 찾기</button>
			<%}else{ %>
			<button class="findBtn" type="button" onclick="location.href='<%=request.getContextPath()%>/views/member/signUpChoice.jsp'">회원가입</button>
			<%} %>
			<button class="findBtn" type="button" onclick="location.href='<%=request.getContextPath()%>/views/member/main.jsp'">홈으로</button>
		</div>
	</div>
</div>
<hr class="line">

<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/findId.js"></script>
</body>

</html>