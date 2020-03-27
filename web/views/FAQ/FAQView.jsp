<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.empty.FAQ.model.vo.FAQ"%>
<%
	FAQ f = (FAQ) request.getAttribute("FAQ");
%>


<%@ include file="/views/common/header.jsp"%>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/FAQ/FAQview.css?ver=2"
	type="text/css">


<section id="FAQ-section">
	<div id="FAQ-container">
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



</section>