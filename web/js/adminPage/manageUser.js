//검색타입 설정시 변하는 효과
function choiceType(){
	let type  = $("#searchType").val();
	let username = $("#search-username");
	let gender = $("#search-gender");
	let phone = $("#search-phone");
	username.hide();
	gender.hide();
	phone.hide();
	$("#search-"+type).css("display","inline-block");
	 
}
//$(function(){
//	$("#searchType").change(()=>{
//		
//		/* var cho = $(this).children("option:selected").text(); */
//		let type=$("#searchType").val();
//		let userId=$("#search-userId");
//		let userName=$("#search-userName");
//		let gender=$("#search-gender");
//		userId.hide();
//		userName.hide();
//		gender.hide();
//		$("#search-"+type).css("display","inline-block");
//		
//	
//	})
//	$("#searchType").trigger("change");
//})
//전체선택, 전체해제에 관한 설정
$(function(){
    $("#allCheck").click(function(){
        allCheckFunc($(this));
        
    })
    $(".chkone").each(function(){
        $(this).click(function(){
        	
            oneCheckFunc($(this));
        })
    })
})
function allCheckFunc(obj){
    $(".chkone").prop("checked",$(obj).prop("checked"));
}
function oneCheckFunc(obj){
    console.log("test");
    var allObj = $("#allCheck");
    var objName = $(obj).attr("name");
   if($(obj).prop("checked")){
       checkBoxLength = $("[name="+objName+"]").length;
       checkedLength = $("[name="+objName+"]:checked").length;
       console.log(checkBoxLength);
       console.log(checkedLength);
       if(checkBoxLength ==checkedLength){
           allObj.prop("checked",true);
       }else{
           allObj.prop("checked",false);
       }
   }else{
       allObj.prop("checked",false);
   }

}   
//관리자-유저페이지 들어오면실행되는것
$(function(){
	requestData(1,10);
})
$(function(){
$("#numPerPage").change(function(){
	var cPage = $("#cPage").val();
	var numPerPage = $(this).val();
	requestData(cPage,numPerPage);
})
})

//검색타입 설정후 검색했을 때

$(function(){
	$(".search-btn").click(function(){
		var key = $(event.target).siblings("[name='searchKeyword']").val();
		var type = $(event.target).siblings("[name='searchType']").val();
		var numPerPage = $("#numPerPage").val();
		searchKeyType(type,key,1,numPerPage);
		console.log("유형:"+type+" 검색어: "+key);
	})
})
