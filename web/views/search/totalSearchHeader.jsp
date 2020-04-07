<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page
	import="com.empty.member.model.vo.Member,com.empty.common.listener.SessionCheckListener"%>
<%
	Member loginMember = (Member) session.getAttribute("loginMember");
	String userId = (String) session.getAttribute("uname");
	Cookie[] cookies = request.getCookies();
	String msg = null;
	String saveId = null;
	if (cookies != null) {
		for (Cookie c : cookies) {
			String key = c.getName();
			String value = c.getValue();
			if (key.equals("saveId")) {
				saveId = value;
			}else if(key.equals("loginFail")){
				msg = URLDecoder.decode(c.getValue(), "UTF-8");
				System.out.println(msg);
			}
		}
	}
	
	int slideNum = 0;
%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>빈시트 : pc방 자리찾기</title>
<link rel="stylesheet" href="css/totalSearchHeader.css?ver=1" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Jim+Nightshade&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/member/login.css" type="text/css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/member/choiceSignUp.css" type="text/css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/member/signUp_terms.css">
<script src="<%=request.getContextPath()%>/js/base.js"></script>
<link rel="stylesheet" href="css/totalSearch.css?ver=1" type="text/css">

<script src="js/jquery-3.4.1.min.js"></script>
<script>
	onchange
</script>

<%
	request.setCharacterEncoding("UTF-8");
%>
</head>

<body>
	<header>
		<div id="transLogo">
			<!--로고 변하게 하기 -->
			<a href="index.jsp"> <img id="mainLogo" class="hover"
				src="image/빈시트500-2.png" width="105px"> <!-- 원래 로고 --> <img
				id="transLogo" src="image/빈시트500-1.png" width="105px">
			</a>
		</div>

		<!-- 팝메뉴 -->
		
		<%
				if(loginMember != null){ 
			%>	
				<img onclick="location.replace('<%=request.getContextPath()%>/logout')" class="logoutBtn" src="<%=request.getContextPath()%>/image/logout.png"
					width="30px" style="position: absolute; float: right; left: 1130px; cursor: pointer; top: 33px; z-index:3;">
				<%-- <button type="button" class="logoutBtn" onclick="location.replace('<%=request.getContextPath()%>/logout')">로그아웃</button> --%>
			<%
				}else{
			%>
				<img onclick="document.getElementById('openLogin').style.display='block'" id="popMenu" src="<%=request.getContextPath()%>/image/login.png"
					width="30px">
			<%
				}
			%>
		
		
		<%if(loginMember == null && msg == null) {%>
	<div id="openLogin" class="modal">
		<center>
			<div class="modal-content" id="login">
			    <span onclick="document.getElementById('openLogin').style.display='none'" class="close" title="Close Modal">&times;</span>
				<h1>로그인</h1>
				<hr>
				<!-- 아이디 / 비번 입력창  -->
				<form id="loginData" action="<%=request.getContextPath()%>/login" method="post">
					<div id="inputData" class="container">
						<b>아이디</b><input class="input" type="text" placeholder="아이디" name="uname" id="uId" value="<%=saveId != null ? saveId : ""%>">
						<b>비밀번호</b><input class="input" type="password" onkeyup="enterkey();" placeholder="비밀번호" name="psw" id="pw">
					</div>
					<div class="checkBox">
						<input type="checkbox" name="saveId" id="saveId" <%=saveId != null ? "Checked" : ""%>>
						<label for="saveId">아이디저장&nbsp;&nbsp;</label><br>
					</div>
				</form>
			<!-- 로그인 / 취소 버튼 -->
			<button type="button" class="buttonStyle" id="loginBtn" onclick="checkMember()">로그인</button>
			<button type="button" class="buttonStyle" onclick="document.getElementById('openLogin').style.display='none'">취소</button>
			<!-- 회원가입 / 계정찾기 링크 -->
			<div class="container">
				<ul>
					<li style="list-style: none;">
						<a class="link" href="<%=request.getContextPath()%>/signUpChoice">회원가입</a>
					</li>
					<br>
					<li style="list-style: none;">
						<a class="link" href="<%=request.getContextPath()%>/findIdView">아이디 찾기&nbsp;</a>
						<a class="link" href="<%=request.getContextPath()%>/findPwView">&nbsp;비밀번호 찾기</a></li>
					</div>
				</ul>
			</div>
		</center>
	</div>
	<%}else if(loginMember == null && msg != null) {%>
		<div id="openLogin" class="modal">
		<center>
			<div class="modal-content" id="login">
			    <span onclick="document.getElementById('openLogin').style.display='none'" class="close" title="Close Modal">&times;</span>
				<h1>로그인</h1>
				<hr>
				<!-- 아이디 / 비번 입력창  -->
				<form id="loginData" action="<%=request.getContextPath()%>/login" method="post">
					<div id="inputData" class="container">
						<b>아이디</b><input class="input" type="text" placeholder="아이디" name="uname" id="uId" value="<%=saveId != null ? saveId : ""%>">
						<b>비밀번호</b><input class="input" type="password" onkeyup="enterkey();" placeholder="비밀번호" name="psw" id="pw">
					</div>
					<div class="checkBox">
						<input type="checkbox" name="saveId" id="saveId" <%=saveId != null ? "Checked" : ""%>>
						<label for="saveId">아이디저장&nbsp;&nbsp;</label><span style="color:red"><%=msg %></span><br>
					</div>
				</form>
			<!-- 로그인 / 취소 버튼 -->
			<button type="button" class="buttonStyle" id="loginBtn" onclick="checkMember()">로그인</button>
			<button type="button" class="buttonStyle" onclick="document.getElementById('openLogin').style.display='none'">취소</button>
			<!-- 회원가입 / 계정찾기 링크 -->
			<div class="container">
				<ul>
					<li style="list-style: none;">
						<a class="link" href="<%=request.getContextPath()%>/views/member/signUpChoice.jsp">회원가입</a>
					</li>
					<br>
					<li style="list-style: none;">
						<a class="link" href="<%=request.getContextPath()%>/views/member/findId.jsp">아이디 찾기&nbsp;</a>
						<a class="link" href="<%=request.getContextPath()%>/views/member/findPw.jsp">&nbsp;비밀번호 찾기</a></li>
					</div>
				</ul>
			</div>
		</center>
	</div>
	<script>
		$(function(){
			var v = document.getElementById('openLogin');
			v.style.display = "block";
		})
	</script>
	<%
		Cookie ck = new Cookie("loginFail", null);
		ck.setMaxAge(0);
		response.addCookie(ck);
	%>
	<%} %>


		<!-- 검색창 -->
		<form action="totalSearch" method="get">
			<div id="searchBoxGra">
				<input id="searchBox" type="text" name="searchBox" placeholder="빈시트 검색" onchange="change()" value="<%=request.getAttribute("searchText")!=null?request.getAttribute("searchText"):""%>"> 
					<input type="submit" value="검색">
			</div>
		</form>

	</header>