<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.empty.event.model.vo.Event"%>
<%
	Event e = (Event) request.getAttribute("Event");
%>


<%@ include file="/views/common/header.jsp"%>

<section>
	<div>
		<table>
			<tr>
				<th>글번호</th>
				<td><%=e.getEventNo()%></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><%=e.getEventWriter()%></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><%=e.getEventTitle()%></td>
			</tr>
			<tr>
				<th>작성일</th>
				<td><%=e.getEventDate()%></td>
			</tr>
			<tr>
				<th>조회수</th>
				<td><%=e.getEventContent()%></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><%=e.getEventContent()%></td>
			</tr>
		</table>

	</div>
	<%if(loginMember != null && loginMember.getUserId().equals(e.getEventWriter())){ %>
	<div>
		<button onclick="eventUpdate()">수정</button>
		<button onclick="eventDelete()">삭제</button>
	</div>
	<%} %>

</section>

<script>
	function eventUpdate(){
		location.replace("<%=request.getContextPath()%>/event/eventUpdate?no=<%=e.getEventNo()%>");
	}
	
	function eventDelete(){
		location.replace("<%=request.getContextPath()%>/event/eventDelete?no=<%=e.getEventNo()%>");
	}
</script>