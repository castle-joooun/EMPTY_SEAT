<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.empty.FAQ.model.vo.FAQ"%>
<%
	FAQ f = (FAQ) request.getAttribute("FAQ");
%>


<%@ include file="/views/common/header.jsp"%>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/FAQ/FAQupdate.css?ver=0" type="text/css">
	
<section id="FAQupdateSection">
	<h2>FAQ 수정</h2>
	<form action="<%=request.getContextPath()%>/FAQ/FAQupdateEnd" method="post">
		
		<table id="FAQupdateTable">
			<tr>
				<th>번호</th>
				<td><input type="text" name="no" value="<%=f.getNo() %>" size="50" readonly></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" value="<%=f.getTitle() %>" size="50"></td>
			</tr>
			<tr>
				<th>작성일</th>
				<td><input type="text" name="time" value="<%=f.getTime() %>" size="50" readonly></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="content" cols=51 rows=10 required><%=f.getContent() %></textarea></td>
			</tr>
		</table>
		<input type="submit" value="수정완료" id="FAQupdateSubmitBtn">
		<input type="button" value="취소" onclick="javascript:history.back(-1)">
	</form>
</section>

<script>
	function updateResetBtn(){
		location.replace("<%=request.getContextPath()%>/")
	}
</script>