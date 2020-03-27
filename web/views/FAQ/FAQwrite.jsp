<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ include file="/views/common/header.jsp" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/FAQ/FAQwrite.css" type="text/css" >

<body>
	<div id="FAQwriteDiv">
		<h2>FAQ</h2>
		<form action="<%=request.getContextPath() %>/FAQwriteEnd" method="post">
			<table>
				<tr>
					<th>제목</th>
					<td><input type="text" name="title" id="FAQtitle_" placeholder="제목을 입력하세요" size="50"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea name="content" id="FAQcontent_" placeholder="내용을 입력하세요" cols="46" rows="10" style="resize:none"></textarea></td>
				</tr>
			</table>
			<input type="submit" value="작성완료" id="FAQwriteSubmit">
			<input type="reset" value="취소" id="FAQwriteReset">
		</form>
	</div>



</body>