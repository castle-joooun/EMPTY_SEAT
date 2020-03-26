function find(){
    if(document.getElementById("findId").value != "" && document.getElementById("findIdEmail").value != ""){
    	document.getElementById("findPw").submit();
    }else if(document.getElementById("findId").value == ""){
        alert("아이디를 입력해주세요.");
    }else if(document.getElementById("findIdEmail").value == ""){
        alert("이메일을 입력해주세요.");
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
        pwCondition.innerHTML = "※조건이 일치하지 않습니다.";
        pwCondition.style.color = "red";
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
            pwOk.innerHTML = "※비밀번호가 일치하지 않습니다.";
            pwOk.style.color = "red";
            return false;
        }
    }
}

function resetPw() {
    var pwCondition = this.pwCondition();
    var pswCheck = this.pswCheck();
    var pw1 = document.getElementById("pw1").value;
    var pwOk = document.getElementById("pwOk").value;

    if (pwCondition == true && pswCheck == true && pw1 != "" && pwOk != "") {
        document.getElementById("findPw").submit();
    } else if (pswCheck == false) {
        alert("비밀번호와 비밀번호 확인이 서로 다릅니다.");
    } else if (pwCondition == false) {
        alert("비밀번호 조건을 확인하세요.");
    }
}