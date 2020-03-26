

//아이디 조건
function idCheck() {
    var uId = document.getElementById("userId").value;
    var idCondition = document.getElementById("idCondition");
    var condition = /^[A-za-z0-9]{5,15}/g;
    if (condition.test(uId)) {
        idCondition.innerHTML = "유효한 아이디입니다.";
        idCondition.style.color = "blue";
        return true;
    } else {
        idCondition.innerHTML = "※아이디는 영어와 숫자조합 5~15자 사이만 가능합니다.";
        idCondition.style.color = "red";
        return false;
    }
}