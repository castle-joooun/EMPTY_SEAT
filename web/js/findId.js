function find(){
    if(document.getElementById("email").value != ""){
    	document.getElementById("findId").submit();
    }else{
        alert("이메일을 입력해주세요.");
    }
}