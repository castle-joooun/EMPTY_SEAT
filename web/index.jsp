<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page
	import="com.empty.member.model.vo.Member,com.empty.common.listener.SessionCheckListener"%>
<%
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
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>빈시트-pc방 자리찾기</title>
    <link rel="stylesheet" href="css/index.css" type="text/css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/login.css" type="text/css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/choiceSignUp.css" type="text/css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/signUp_terms.css">
    <link href="https://fonts.googleapis.com/css?family=Jim+Nightshade&display=swap" rel="stylesheet">
    <script src="<%=request.getContextPath()%>/js/base.js"></script>
	<script src="<%=request.getContextPath()%>/js/jquery-3.4.1.min.js"></script>
    <script>
        onchange
    </script>
</head>

<body>
    <header>
        <div>
            <a href="index.jsp">
                <!--로고 변하게 하기 -->
                <img id="mainLogo" src="image/로고-test.png" width="150px"> <!-- 원래 로고 -->
                <!-- <img id="transLogo" src="image/빈시트500-1-test.png" width="150px"> -->
            </a>
        </div>
        <nav>
            <center>
                <!-- 상단고정 메뉴바 -->
                <div id="menubar">
                    <!-- main페이지이면 main의 mainHover을 빼준다! ------------------------------------------------------------------->
                    <p id="main"><a href="main.html" style="color: white">MAIN</a></p>
                    <p id="introduce" class="mainHover"><a href="introduce.html">INTRODUCE</a></p>
                    <p id="notice" class="mainHover"><a href="notice.html">NOTICE</a></p>
                    <p id="myPage" class="mainHover"><a href="myPage.html">MY PAGE</a></p>
                    <p id="service" class="mainHover"><a href="service.html">SERVICE</a></p>
                </div>
            </center>

            <!-- 팝메뉴 -->
		<!-- ----------로그인---------- -->
		
			
			<%
				if(loginMember != null){ 
			%>
				<button type="button" class="logoutBtn" onclick="location.replace('<%=request.getContextPath()%>/logout')">로그아웃</button>
			<%
				}else{
			%>
				<img onclick="document.getElementById('openLogin').style.display='block'" id="popMenu" src="<%=request.getContextPath()%>/image/pop-test.png"
					width="30px">
			<%
				}
			%>

	</header>
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
						<b>비밀번호</b><input class="input" type="password" placeholder="비밀번호" name="psw" id="pw">
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

            <!-- 미들바 지움!! -->

        </nav>

    </header>

    <video id="video" preload="auto" autoplay="true" loop="loop" muted="muted" volume="0" 
    style="position: absolute; top: 0px; left: 0px; width: 1366px; height: 768px; z-index: -2; overflow: hidden;">
        <source src="image/main.mp4">
    </video>

    <img src="image/back.png" alt="" id="back" width="30px">
    <img src="image/next.png" alt="" id="next" width="30px">

    <div id="slide">
        <input type="radio" name="pos" id="pos1" class="pos">
        <input type="radio" name="pos" id="pos2" class="pos" checked>
        <input type="radio" name="pos" id="pos3" class="pos">

        <ul id="slideMove">
            <li class="slideAttr"> <!-- 즐겨찾기 -->
                <img src="image/즐겨찾기-1.png" alt="" id="favorite">
                <div id="clock"></div>
                <!-- <div id="addFavorite">
                    추가하기
                </div> -->
                <div id="favoriteLine">
                    <div class="favoritePc">
                        <br><br>
                        <a href="http://www.naver.com">1번 pc방</a>
                    </div>
                    <div class="favoritePc">
                        <br><br>2번 pc방
                    </div>
                    <div class="favoritePc">
                        <br><br>3번 pc방
                    </div>
                    <div class="favoritePc">
                        <br><br>4번 pc방
                    </div>
                    <div class="favoritePc">
                        <br><br>5번 pc방
                    </div>
                    <div class="favoritePc">
                        <br><br>6번 pc방
                    </div>
                </div>
            </li>
            <li class="slideAttr"> <!-- 메인검색 -->
                <form action="totalSearch" method="get" id="searchForm" onSubmit="false">
                    <center>
                        <div id="searchBoxGra">
                            <input id="searchBox" type="text" name="searchBox" placeholder="빈시트 검색" onchange="change()">
                            <input type="submit" value="검색">
                        </div>
                        <img id="moniter" src="image/main-test.png" alt="">
                    </center>
                </form>
                
            </li>
            <li class="slideAttr"> <!-- 지역검색 -->
                <img src="image/지역.png" alt="" id="searchRegion">
                <img src="image/지도.png" alt="" id="region">
            </li>
        </ul>
    </div>




    <script type="text/javascript" src="<%=request.getContextPath() %>/js/index.js"></script>
</body>

</html>