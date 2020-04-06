<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.empty.FAQ.model.vo.FAQ"%>
<%
	FAQ f = (FAQ) request.getAttribute("FAQ");
%>


<%@ include file="/views/common/header.jsp"%>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/FAQ/FAQview.css?ver=4"
	type="text/css">


<section id="FAQ-section">
	<div id="FAQ-container">
	<h2><%=f.getTitle() %></h2>
		<table id="FAQ-table">
			<tr>
				<th>글번호</th>
				<td><%=f.getNo()%></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><%=f.getTitle()%></td>
			</tr>
			<tr>
				<th>작성일</th>
				<td><%=f.getTime()%></td>
			</tr>
			<tr>
				<th>조회수</th>
				<td><%=f.getCount()%></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><%=f.getContent()%></td>
			</tr>
		</table>

	</div>
	<%if(loginMember!=null&&loginMember.getUserId().equals("admin")){ %>
	<div id="FAQviewBtn">
		<button id="FAQupdate" onclick="FAQupdate()">수정하기</button>
		<button id="FAQdelete" onclick="FAQdelete()">삭제하기</button>
	</div>
	<%} %>

</section>

<script>
	function FAQupdate(){
		location.replace("<%=request.getContextPath()%>/FAQ/FAQupdate?no=<%=f.getNo()%>");
	}
	
	function FAQdelete(){
		location.replace("<%=request.getContextPath()%>/FAQ/FAQdelete?no=<%=f.getNo()%>");
	}
</script>