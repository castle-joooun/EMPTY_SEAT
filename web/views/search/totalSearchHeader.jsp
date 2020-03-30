<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="com.empty.member.model.vo.Member,com.empty.common.listener.SessionCheckListener"%>
<%-- <%
	Member loginMember = (Member) session.getAttribute("loginMember");
	String userId = (String) session.getAttribute("uname");
	Cookie[] cookies = request.getCookies();
	String saveId = null;
	if (cookies != null) {
		for (Cookie c : cookies) {
			String key = c.getName();
			String value = c.getValue();
			if (key.equals("saveId")) {
				saveId = value;
			}
		}
	}
%> --%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>빈시트 : pc방 자리찾기</title>
<link rel="stylesheet" href="css/totalSearchHeader.css" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Jim+Nightshade&display=swap"
	rel="stylesheet">
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
		<img
			onclick="document.getElementById('openLogin').style.display='block'"
			id="popMenu" src="image/popMenu500.png" width="30px">

		<div id="openLogin" class="modal">
			<center>
				<form class="modal-content" action="/action_page.php" method="post">
					<div id="login">
						<h1>로그인</h1>
					</div>
					<hr>
					<!-- 아이디 / 비번 입력창  -->
					<div id="inputData" class="container">
						<label for="uname"><b>아이디</b></label> <input type="text"
							placeholder="아이디" name="uname" required> <label for="psw"><b>비밀번호</b></label>
						<input type="password" placeholder="비밀번호" name="psw" required>
					</div>

					<!-- 로그인 / 취소 버튼 -->
					<button type="submit" class="buttonStyle">로그인</button>
					<button type="button" class="buttonStyle"
						onclick="document.getElementById('openLogin').style.display='none'">
						취소</button>
					<!-- 회원가입 / 계정찾기 링크 -->
					<div class="container">
						<ul>
							<li style="list-style: none;"><a class="link"
								href="signUp.html">회원가입</a></li>
							<br>
							<li style="list-style: none;"><a class="link" href="#">아이디/비밀번호
									찾기</a></li>
						</ul>
					</div>
				</form>
			</center>
		</div>


		<!-- 검색창 -->
		<form action="totalSearch" method="get">
			<div id="searchBoxGra">
				<input id="searchBox" type="text" name="searchBox" placeholder="빈시트 검색" onchange="change()" value="<%=request.getAttribute("searchText")!=null?request.getAttribute("searchText"):""%>"> 
					<input type="submit" value="검색">
			</div>
		</form>

	</header>