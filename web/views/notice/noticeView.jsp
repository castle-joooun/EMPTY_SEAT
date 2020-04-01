<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.empty.notice.model.vo.Notice"%>
<%
	Notice n = (Notice) request.getAttribute("Notice");
%>


<%@ include file="/views/common/header.jsp"%>

<section>
	<div>
		<table>
			<tr>
				<th>글번호</th>
				<td><%=n.getNoticeNo()%></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><%=n.getNoticeWriter()%></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><%=n.getNoticeTitle()%></td>
			</tr>
			<tr>
				<th>작성일</th>
				<td><%=n.getNoticeDate()%></td>
			</tr>
			<tr>
				<th>조회수</th>
				<td><%=n.getNoticeContent()%></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><%=n.getNoticeContent()%></td>
			</tr>
		</table>

	</div>
	<%if(loginMember != null && loginMember.getUserId().equals("admin")){ %>
	<div>
		<button onclick="noticeUpdate()">수정</button>
		<button onclick="noticeDelete()">삭제</button>
	</div>
	<%} %>

</section>

<script>
	function noticeUpdate(){
		location.replace("<%=request.getContextPath()%>/notice/noticeUpdate?no=<%=n.getNoticeNo()%>");
	}
	
	function noticeDelete(){
		location.replace("<%=request.getContextPath()%>/notice/noticeDelete?no=<%=n.getNoticeNo()%>");
	}
</script>