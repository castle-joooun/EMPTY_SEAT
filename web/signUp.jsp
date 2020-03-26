<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
    <link rel="stylesheet" href="css/signUp.css">
    <script src="js/jquery-3.4.1.min.js"></script>

</head>

<body>

    <div id="modal" class="modal">
        <form id="myForm" class="modal-content" action="#">
            <div class="container">
                <h1 style="text-align: center;">회원가입</h1>

                <hr>
                <p style="text-align: right;">*은 필수입력 항목입니다.</p>
                <label for="id">
                    <b style="margin-right:3%">*아이디</b><span id="idCondition"></span>
                </label>
                <input type="text" placeholder="영어+숫자 5자 이상 15자 이내" id="userId" name="id" onchange="idCheck();">

                <label for="psw"><b style="margin-right:3%">*비밀번호</b><span id="pwCondition"></span></label>
                <input type="password" placeholder="영어와 숫자, 특수문자(!@#$%^&*)만 사용 가능합니다" id="pw1" name=" psw"
                    onchange="pwCondition()">

                <label for="pswcheck"><b style="margin-right:3%">*비밀번호 확인</b><span id="pwOk"></span></label>
                <input type="password" placeholder="위의 비밀번호와 같이 입력하세요" id="pw2" name="pswcheck" onchange="pswCheck()">

                <label for="name"><b style="margin-right:3%">*이름</b><span id="nameCondition"></span></label>
                <input type="text" placeholder="이름" id="userName" name="name" onchange="checkName();">

                <label for="email"><b style="margin-right:3%">*이메일</b><span id="emailCondition"></span></label>
                <input type="email" placeholder="이메일" id="userEmail" name="email" onchange="emailCondition();">

                <label for="phone"><b style="margin-right:3%">*전화번호</b><span id="phoneCondition"></span></label>
                <input type="text" placeholder="'-' 없이 입력해주세요" id="userPhone" name="phone" onchange="phoneCondition();">

                <label for="address"><b>*주소</b></label>
                <input type="text" placeholder="주소" id="userAddress" name="address">

                <label for="gender"><b>성별</b></label>
                <select name="gender" id="userGender">
                    <option value="성별">성별 선택</option>
                    <option value="남">남</option>
                    <option value="여">여</option>
                </select>

                <label for="birthday"><b>생년월일</b></label><br>
                <input type="text" placeholder="ex)1994" name="year" size="5" id="birthyear" required>년
                <select name="month" class="birthday">
                    <option value="0">월 선택</option>
                    <option value="1">01
                    <option value="2">02
                    <option value="3">03
                    <option value="4">04
                    <option value="5">05
                    <option value="6">06
                    <option value="7">07
                    <option value="8">08
                    <option value="9">09
                    <option value="10">10
                    <option value="11">11
                    <option value="12">12
                </select> 월
                <select name="day" class="birthday">
                    <option value="0">일 선택</option>
                    <option value="1">01
                    <option value="2">02
                    <option value="3">03
                    <option value="4">04
                    <option value="5">05
                    <option value="6">06
                    <option value="7">07
                    <option value="8">08
                    <option value="9">09
                    <option value="10">10
                    <option value="11">11
                    <option value="12">12
                    <option value="13">13
                    <option value="14">14
                    <option value="15">15
                    <option value="16">16
                    <option value="17">17
                    <option value="18">18
                    <option value="19">19
                    <option value="20">20
                    <option value="21">21
                    <option value="22">22
                    <option value="23">23
                    <option value="24">24
                    <option value="25">25
                    <option value="26">26
                    <option value="27">27
                    <option value="28">28
                    <option value="29">29
                    <option value="30">30
                    <option value="31">31
                </select> 일

                <p>계정 생성 시 이용약관에 동의하는 것으로 간주됩니다.<a href="#" style="color:blue">이용약관</a>.</p>

                <div class="clearfix">
                    <button type="button" onclick="signUpPass()" class="signupbtn">회원가입</button>
                    <a href="index.jsp">
                        <button type="button" class="cancelbtn">
                            취소
                        </button>
                    </a>
                </div>
            </div>
        </form>
    </div>


    <script src="js/signUp.js"></script>
</body>

</html>