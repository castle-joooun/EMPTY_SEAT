<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ include file="/views/common/header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/FAQ/FAQwrite.css" type="text/css" >
<center>
	<div>
		<div>
			<p id="FAQWriteHead">FAQ 작성</p>
		</div>
		<div id="FAQWriteDiv">
			<form id="FAQWriteForm" action="<%=request.getContextPath() %>/FAQwriteEnd" method="post">
				<table id="FAQWriteTbl">
					<tr>
						<td>
							<input type="text" name="title" id="FAQWriteTitle" placeholder="제목을 입력하세요" size="50">
						</td>
					</tr>
					<tr>
						<td>
							<textarea name="content" id="FAQWriteContent" placeholder="내용을 입력하세요" cols="46" rows="10" style="resize:none"></textarea>
						</td>
					</tr>
				</table>
				<div>
					<button type="button" id="FAQWriteEndBtn" onclick="FAQWriteFn();">작성완료</button>
					<button type="button" id="FAQWriteCencleBtn" onclick="FAQWriteCencleFn();">작성취소</button>
				</div>
			</form>
		</div>
	</div>
</center>
<script>
function FAQWriteFn(){
	var title = document.getElementById("FAQWriteTitle").value;
	var content = document.getElementById("FAQWriteContent").value;
	if(title != "" && content != ""){
		document.getElementById("FAQWriteForm").submit();
	}else if(title == ""){
		alert("제목을 입력하세요.");
	}else if(content == ""){
		alert("내용을 입력하세요.");
	}
}

function FAQWriteCencleFn(){
	if(confirm("게시물 작성을 중단하시겠습니까?\n작성 중이던 내용은 저장되지 않습니다.")){
		location.href='<%=request.getContextPath()%>/FAQMainServlet';
	}else{
		window.close();
	}
}
</script>


</body>
</html>