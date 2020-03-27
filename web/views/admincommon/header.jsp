<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>빈시트 : pc방 자리찾기</title>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/adminPage/base.css" type="text/css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/adminPage/admin.css" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Jim+Nightshade&display=swap" rel="stylesheet">
    <script src="<%=request.getContextPath() %>/js/jquery-3.4.1.min.js"></script>
    <script>
        onchange
    </script>
</head>


<body>
    <header style="height: 123px;">
        <div>
            <!--로고 변하게 하기 -->
            <img id="mainLogo" class="hover" src="<%=request.getContextPath() %>/image/빈시트500-2.png" width="150px"> <!-- 원래 로고 -->
            <img id="transLogo" src="<%=request.getContextPath() %>/image/빈시트500-1.png" width="150px">
        </div>
        <center>
            <!-- 상단고정 메뉴바 -->
            <span id="menubar">
                <!-- main페이지이면 main의 mainHover을 빼준다! ------------------------------------------------------------------->
                <p id="main"><a href="main.html" style="color: #ff7531">MAIN</a></p>
                <p id="introduce" class="mainHover"><a href="<%=request.getContextPath()%>/admin/manageUser">USER</a></p>
                <p id="notice" class="mainHover"><a href="notice.html">STORE</a></p>
                <p id="service" class="mainHover"><a href="service.html">NOTICE</a></p>
                <p id="myPage" class="mainHover"><a href="myPage.html">COMMUNICATION</a></p>
             
            </span>
        </center>

        <!-- 팝메뉴 -->
        <img onclick="" id="log"
                src="<%=request.getContextPath() %>/image/pop-test.png" width="30px">
                
                
    </header>
    <div id="openLogin" class="modal">
        <center>
            <form class="modal-content" action="/action_page.php" method="post">
                <div id="login">
                    <h1>로그인</h1>
                </div>
                <hr>
                <!-- 아이디 / 비번 입력창  -->
                <div id="inputData" class="container">
                    <label for="uname"><b>아이디</b></label>
                    <input class="input" type="text" placeholder="아이디" name="uname" required>
                    <label for="psw"><b>비밀번호</b></label>
                    <input class="input" type="password" placeholder="비밀번호" name="psw" required>
                </div>

                <!-- 로그인 / 취소 버튼 -->
                <button type="submit" class="buttonStyle">로그인</button>
                <button type="button" class="buttonStyle"
                    onclick="document.getElementById('openLogin').style.display='none'">
                    취소
                </button>
                <!-- 회원가입 / 계정찾기 링크 -->
                <div class="container">
                    <ul>
                        <li style="list-style: none;"><a class="link" href="signUp.html">회원가입</a></li><br>
                        <li style="list-style: none;"><a class="link" href="#">아이디/비밀번호 찾기</a></li>
                    </ul>
                </div>
            </form>
        </center>
    </div>

    <!-- 미들 바 -->
    <nav id="middle">
        <p id="middleText">
            세상의 모든 자리 찾기
        </p>
    </nav>
</header>