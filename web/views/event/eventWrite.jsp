<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ include file="/views/common/header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/event/eventWrite.css" type="text/css">
<center>
	<div>
		<div>
			<p id="eventWriteHead">이벤트 작성</p>
		</div>
		<div id="eventWriteDiv">
			<form id="eventWriteForm" action="<%=request.getContextPath()%>/eventWriteEnd" method="post">
				<input type="hidden" name="writer" value="<%=loginMember.getUserId() %>">
				<table id="eventWriteTbl">
					<tr>
						<td>
							<input placeholder="제 목" type="text" name="title" id="eventWriteTitle" size="50">
						</td>
					</tr>
					<tr>
						<td>
							<textarea placeholder="내 용" name="content" id="eventWriteContent" cols="50" rows="10" style="resize:none"></textarea>
						</td>
					</tr>
				</table>
				<div>
					<button type="button" id="eventWriteEndBtn" onclick="eventWriteFn();">작성완료</button>
					<button type="button" id="eventWriteCencleBtn" onclick="eventWriteCencleFn();">작성취소</button>
				</div>
			</form>
		</div>
	</div>
</center>
<script>
	function eventWriteFn(){
		var title = document.getElementById("eventWriteTitle").value;
		var content = document.getElementById("eventWriteContent").value;
		if(title != "" && content != ""){
			document.getElementById("eventWriteForm").submit();
		}else if(title == ""){
			alert("제목을 입력하세요.");
		}else if(content == ""){
			alert("내용을 입력하세요.");
		}
	}
	
	function eventWriteCencleFn(){
		if(confirm("게시물 작성을 중단하시겠습니까?\n작성 중이던 내용은 저장되지 않습니다.")){
			location.href='<%=request.getContextPath()%>/event';
		}else{
			window.close();
		}
	}
</script>
</body>
</html>