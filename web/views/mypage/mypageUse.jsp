<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.empty.payuse.model.vo.*,java.util.List" %>
<% PayUse p=(PayUse)request.getAttribute("PayUse"); %>
<%@ page
	import="com.empty.member.model.vo.Member,com.empty.common.listener.SessionCheckListener"%>
<%
	List<Member> list = (List) request.getAttribute("list");
	Member loginMember = (Member) session.getAttribute("loginMember");
%>





			<tr>
				<th>날짜</th>
				<th>매장명</th>
				<th>사용금액</th>
			</tr>
			<tr>
				<td><%=loginMember.getUserId()%></td>
				<td><%=p.getUser_id() %></td>
				<td></td>
			</tr>
