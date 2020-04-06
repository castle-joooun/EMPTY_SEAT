<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ include file="/views/common/header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/notice/noticeWrite.css" type="text/css">
<center>
<div>
	<div>
		<p id="noticeWriteHead">공지사항 작성</p>
	</div>
	<div id="noticeWriteDiv">
		<form id="noticeWriteForm" action="<%=request.getContextPath()%>/noticeWriteEnd" method="post">
		<table id="noticeWriteTbl">
		   <tr>
		      <td>
		         <input placeholder="제 목" type="text" name="title" id="noticeTitleWrite" size="49">
		      </td>
		   </tr>
		   <tr>
		      <td>
		         <textarea placeholder="내 용" name="content" id="noticeContentWrite" cols="51" rows="10" style="resize:none;"></textarea>
		      </td>
		   </tr>
		</table>
		<div>
			<button type="button" id="noticeWriteEndBtn" onclick="noticeWriteFn();">작성완료</button>
			<button type="button" id="noticeWriteCencleBtn" onclick="noticeWriteCencleFn();">작성취소</button>
		</div>
		</form>
	</div>
</div>
</center>
<script>
	function noticeWriteFn(){
		var title = document.getElementById("noticeTitleWrite").value;
		var content = document.getElementById("noticeContentWrite").value;
		if(title != "" && content != ""){
			document.getElementById("noticeWriteForm").submit();
		}else if(title == ""){
			alert("제목을 입력하세요.");
		}else if(content == ""){
			alert("내용을 입력하세요.");
		}
	}
	
	function noticeWriteCencleFn(){
		if(confirm("게시물 작성을 중단하시겠습니까?\n작성 중이던 내용은 저장되지 않습니다.")){
			location.href='<%=request.getContextPath()%>/notice';
		}else{
			window.close();
		}
	}
</script>

</body>
</html>