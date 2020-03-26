// 메인로고 바뀌게
var transLogo = document.getElementById("transLogo");
var mainLogo = document.getElementById("mainLogo");

transLogo.addEventListener("mouseover", trans);
function trans() { //바뀜
    mainLogo.setAttribute("src", "image/빈시트500-1.png");
}
transLogo.addEventListener("mouseleave", leave);
function leave() { //돌아옴
    mainLogo.setAttribute("src", "image/빈시트500-2.png");
}

// 메인메뉴 클릭 -> 서브메뉴 나타나게
// main
var menubarMain = document.getElementById("main");
var mainSub = document.getElementById("mainSub");
menubarMain.onclick = function () {
    mainSub.toggle
}


// 모달창 띄우기
var modal = document.getElementById('id01');

// 모달창 바깥 아무데나 누르면 꺼짐
window.onclick = function (event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}


