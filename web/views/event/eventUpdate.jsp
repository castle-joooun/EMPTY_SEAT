<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.empty.event.model.vo.Event"%>
<%
	Event e = (Event) request.getAttribute("Event");
%>


<%@ include file="/views/common/header.jsp"%>
	
<section>
	<h2>Event 수정</h2>
	<form action="<%=request.getContextPath()%>/event/eventUpdateEnd" method="post">
		<table>
			<tr>
				<th>번호</th>
				<td><input type="text" name="no" value="<%=e.getEventNo() %>" size="50" readonly></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" value="<%=e.getEventTitle() %>" size="50"></td>
			</tr>
			<tr>
				<th>작성일</th>
				<td><input type="text" name="time" value="<%=e.getEventDate() %>" size="50" readonly></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="content" cols=51 rows=10 required><%=e.getEventContent() %></textarea></td>
			</tr>
		</table>
		<input type="submit" value="수정">
		<input type="reset" value="취소">
	</form>
</section>