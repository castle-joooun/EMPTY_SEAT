<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file = "/views/common/header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/findIdPw.css" type="text/css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/withdrawal.css" type="text/css">
    <div id="findTitle">
        <h1><span style="color: rgb(94, 100, 177);">아이디</span> / <span style="color: rgb(72, 78, 155);">비밀번호 찾기</span>
        </h1>
        <hr class="line">
    </div>
    <div class="tabContainer">

        <ul class="tabs">
            <li class="tab-menu current" data-tab="tab-1"><b>아이디 찾기</b></li>
            <li class="tab-menu" data-tab="tab-2"><b>비밀번호 찾기</b></li>
        </ul>
        <div id="tab-1" class="tab-content current">
            <form id="findId" action="" method="POST">
                <div class="textInfor">
                    <h3 class="h3"> * 가입시 사용한 <span style="color: rgb(94, 100, 177);">이메일</span>을 입력하세요.</h3>
                </div>
                <div>
                    <b>이메일 입력</b><br>
                </div>
                <div>
                    <input class="findInp" type="email" name="email" id="email" placeholder="가입시 입력한 이메일">
            </form>
        </div>
        <div>
            <button class="findBtn" onclick="document.getElementById('inforId').style.display='block'">아이디
                찾기</button>
        </div>
    </div>
    <div id="tab-2" class="tab-content">
        <div class="textInfor">
            <h3 class="h3"> * <span class="pointSpan">아이디</span>를 입력하세요.</h3>
        </div>
        <div>
            <b>아이디 입력</b><br>
        </div>
        <div>
            <input class="findInp" type="text" name="findId" id="findId" placeholder="아이디">
        </div>
        <div>
            <h3 class="h3"> * 가입시 사용한 <span class="pointSpan">이메일</span>을 입력하세요.</h3>
        </div>
        <div>
            <b>이메일 입력</b><br>
        </div>
        <div>
            <input class="findInp" type="email" name="findIdEmail" id="findIdEmail" placeholder="가입시 입력한 이메일">
        </div>
        <div>
            <button class="findBtn" onclick="document.getElementById('inforPw').style.display='block'">비밀번호
                찾기</button>
        </div>
    </div>
    <hr class="line">
    <div id="inforId" class="inforModal">
        <div class="inforModal-content">
            <!-- 아이디 안내창  -->
            <div style="text-align: center; margin-top: 20px; background-color: seashell;">
                <h2>회원님의 <span class="pointSpan">아이디</span>는 ******입니다.</h2>
            </div>

            <div style="text-align: center;">
                <button type="button" class="findBtn" onclick="document.getElementById('inforId').style.display='none'">
                    확인
                </button>
            </div>
        </div>
    </div>
    <div id="inforPw" class="inforModal">
        <div class="inforModal-content">
            <form id="findPw" action="<%=request.getContextPath()%>/updatePassword" method="POST">
                <!-- 비밀번호 안내창  -->
                <div style="text-align: center; margin-top: 20px; background-color: seashell;">
                <input type="hidden" name="userId" value="pdh1234">
                    <div><b class="findPwinforText">새로운 비밀번호를 입력하세요.&nbsp;&nbsp;&nbsp;<span id="pwCondition"></span></b>
                    </div>
                    <input type="password" class="findInp" name="pw1" id="pw1"
                        placeholder="영어와 숫자, 특수문자(!@#$%^&*)만 사용 가능합니다." onchange="pwCondition()">
                    <div><b class="findPwinforText">비밀번호 확인&nbsp;&nbsp;&nbsp;<span id="pwOk"></span></b></div>
                    <input type="password" class="findInp" id="pw2" onchange="pswCheck()">
                </div>
                <div style="text-align: center;">
                    <button type="button" class="findBtn" onclick="resetPw()">
                        확인
                    </button>
                </div>
            </form>
        </div>
    </div>

<script type="text/javascript" src="<%=request.getContextPath()%>/js/base.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/findIdPw.js?1234"></script>
</body>

</html>