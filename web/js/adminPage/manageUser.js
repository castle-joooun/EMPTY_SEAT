
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
$(function(){
    $("#allCheck").click(function(){
        allCheckFunc($(this));
        console.log("gd1");
    })
    $(".chkone").each(function(){
        $(this).click(function(){
        	console.log("gd2");
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