<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,java.util.*,com.empty.notice.model.vo.Notice"%>
<%
	List<Notice> list = (List) request.getAttribute("list");
%>
<%@ include file="/views/common/header.jsp"%>
	<div>
			<%
			if(loginMember != null && loginMember.getUserId().equals("admin")){
		%>
		<div>
			<input type="button" value="공지사항 작성" onclick="location.replace('<%=request.getContextPath()%>/noticeWrite')">
		</div>
		<%} %>
		<table>
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>등록일</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
				<%
					if(list.isEmpty()){
				%>
				<tr>
					<td>등록된 내용이 없습니다.</td>
				</tr>
				<%
					}else{
						for(Notice n : list){
				%>
				<tr>
					<td>[공지]</td>
					<td>
						<span onclick="link(<%=n.getNoticeNo()%>)">
							<%=n.getNoticeTitle() %>
							<form action="<%=request.getContextPath()%>/noitce/noticeContent">
								<input type="hidden" name="no" value="<%=n.getNoticeNo() %>">
							</form>
						</span>
					</td>
					<td>admin</td>
					<td><%=n.getNoticeDate() %></td>
					<td><%=n.getNoticeCount() %></td>
				</tr>
				<%
						}
					}
				%>
			</tbody>
		</table>
				<form action="<%=request.getContextPath()%>/notice/View" id="linkF">
			<input type="hidden" name="no">
		</form>
		<div id="pageBar">
			<%=request.getAttribute("pageBar")%>
		</div>

	</div>
		<script>
		function link(no){
			$("#linkF>input").val(no);
			$("#linkF").submit();
		}
	</script>
</body>
</html>