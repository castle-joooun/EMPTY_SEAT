// 아이디 조건
function idCheck() {
    var uId = document.getElementById("userId").value;
    var idCondition = document.getElementById("idCondition");
    var condition = /^[A-za-z0-9]{5,15}/g;
    if (condition.test(uId)) {
        idCondition.innerHTML = "유효한 아이디입니다.";
        idCondition.style.color = "blue";
        return true;

    } else {
        idCondition.innerHTML = "아이디는 영어와 숫자조합 5~15자 사이만 가능합니다.";
        idCondition.style.color = "red";
        return false;
    }
}

// 비밀번호 확인 
function pswCheck() {
    var pw1 = document.getElementById("pw1").value;
    var pw2 = document.getElementById("pw2").value;
    var pwOk = document.getElementById("pwOk");
    if (pw1 != '' && pw2 != '') {
        if (pw1 == pw2) {
            pwOk.innerHTML = "비밀번호가 일치합니다.";
            pwOk.style.color = "blue";
            return true;
        } else {
            pwOk.innerHTML = "비밀번호가 일치하지 않습니다.";
            pwOk.style.color = "red";
            return false;
        }
    }
}
// 비밀번호 조건
function pwCondition() {
    var pw1 = document.getElementById("pw1").value;
    var pwCondition = document.getElementById("pwCondition");
    var condition = /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;
    if (condition.test(pw1)) {
        pwCondition.innerHTML = "조건이 일치합니다.";
        pwCondition.style.color = "blue";
        return true;
    } else {
        pwCondition.innerHTML = "조건이 일치하지 않습니다.";
        pwCondition.style.color = "red";
        return false;
    }
}

// 이름 확인
function checkName() {
    var name = document.getElementById("userName").value;
    var nameCondition = document.getElementById("nameCondition");
    var condition = /^[가-힣]{2,}$/;
    if (condition.test(name)) {
        nameCondition.innerHTML = "유효한 이름입니다."
        nameCondition.style.color = "blue";
        return true;
    } else {
        nameCondition.innerHTML = "한글이름 두글자 이상 입력하세요.";
        nameCondition.style.color = "red";
        return false;
    }
}

// 이메일 유효성
function emailCondition() {
    var userEmail = document.getElementById("userEmail").value;
    var emailCondition = document.getElementById("emailCondition");
    var condition = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
    if (condition.test(userEmail)) {
        emailCondition.innerHTML = "유효한 이메일입니다.";
        emailCondition.style.color = "blue";
        return true;
    } else {
        emailCondition.innerHTML = "이메일 형식이 아닙니다.";
        emailCondition.style.color = "red";
        return false;
    }
}

// 전화번호 유효성
function phoneCondition() {
    var userPhone = document.getElementById("userPhone").value;
    var phoneCondition = document.getElementById("phoneCondition");
    var condition = /^\d{3}\d{3,4}\d{4}$/;
    if (condition.test(userPhone)) {
        phoneCondition.innerHTML = "유효한 전화번호입니다.";
        phoneCondition.style.color = "blue";
        return true;
    } else {
        phoneCondition.innerHTML = "전화번호 형식이 아닙니다.";
        phoneCondition.style.color = "red";
        return false;
    }
}

// 회원가입조건 만족시 다음 / 아니면 얼럿
function signUpPass() {
    var pswCheck = this.pswCheck();
    var pwCondition = this.pwCondition();
    var idCheck = this.idCheck();
    var checkName = this.checkName();
    var emailCondition = this.emailCondition();
    var phoneCondition = this.phoneCondition();
    var uId = document.getElementById("userId").value;
    var uName = document.getElementById("userName").value;
    var uEmail = document.getElementById("userEmail").value;
    var uPhone = document.getElementById("userPhone").value;
    var uAddress = document.getElementById("userAddress").value;
    console.log(pwCondition, pswCheck);
    if (uId != "" && uName != "" && uEmail != "" && uPhone != "" && uAddress != ""
        && idCheck == true && checkName == true && pswCheck == true && pwCondition == true && emailCondition == true && phoneCondition == true) {
        document.getElementById("myForm").submit();
    } else if (pswCheck == false) {
        alert("비밀번호와 비밀번호 확인이 서로 다릅니다.");
    } else if (pwCondition == false) {
        alert("비밀번호 조건을 확인하세요.");
    } else if (idCheck == false) {
        alert("아이디 조건을 확인하세요.");
    } else if (checkName == false) {
        alert("이름을 확인하세요.")
    } else if (emailCondition == false) {
        alert("이메일 형식이 아닙니다.");
    } else if (phoneCondition == false) {
        alert("전화번호를 확인하세요.");
    } else if (uId == "") {
        alert("아이디를 입력하세요.");
    } else if (uName == "") {
        alert("이름을 입력하세요.");
    } else if (uEmail == "") {
        alert("이메일을 입력하세요.");
    } else if (uPhone == "") {
        alert("전화번호를 입력하세요.");
    } else if (uAddress == "") {
        alert("주소를 입력하세요.");
    }
}


