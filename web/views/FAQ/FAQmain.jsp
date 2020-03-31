<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,java.util.*,com.empty.FAQ.model.vo.FAQ"%>
<%
	List<FAQ> list = (List) request.getAttribute("list");
%>

<%@ include file="/views/common/header.jsp"%>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/FAQ/FAQmain.css?ver=0" type="text/css" />
	

<body>

	<div id="board">
	<h2>FAQ</h2>
		<table>
			<thead>
				<tr>
					<th class="tdnum">번호</th>
					<th class="tdsubject">제목</th>
					<th class="tddate">작성일</th>
					<th class="tdcount">조회수</th>
				</tr>
			</thead>
			<tbody>
				<%
					if (list.isEmpty()) {
				%>
				<tr>
					<td colspan='4'>등록된 FAQ가 없습니다.</td>
				</tr>
				<%
					} else {
					for (FAQ f : list) {
				%>
				<tr>
					<td class="FAQList"><%=f.getNo()%></td>
					<td class="FAQList">
						<span class="link" onclick="fn_link(<%=f.getNo()%>)">
							<%=f.getTitle() %>
							<form action="<%=request.getContextPath() %>/FAQ/FAQView" class="linkFrm">
								<input type="hidden" name="no" value="<%=f.getNo() %>">
							</form>
						</span>
					</td>
					<td class="FAQList"><%=f.getTime()%></td>
					<td class="FAQList"><%=f.getCount()%></td>
				</tr>
				<%
					}
				}
				%>
			</tbody>
		</table>
		<form action="<%=request.getContextPath()%>/FAQ/FAQView" id="linkF">
			<input type="hidden" name="no">
		</form>
		<div id="pageBar">
			<%=request.getAttribute("pageBar")%>
		</div>

		<%if (loginMember!=null&&loginMember.getUserId().equals("admin")) {%>
		<div id="btnDiv">
			<input type=button value="글쓰기"
				onclick="location.replace('<%=request.getContextPath()%>/FAQwrite')"
				id="writeBtn">
		</div>
		<%} %>
		
	</div>


	<script type="text/javascript" src="js/service.js"></script>
	<script>
		function fn_link(no){
			$("#linkF>input").val(no);
			$("#linkF").submit();
		}
	</script>

</body>