<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,java.util.*,com.empty.FAQ.model.vo.FAQ"%>
<%
	List<FAQ> list = (List) request.getAttribute("list");
%>

<%@ include file="/views/common/header.jsp"%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/FAQ/FAQmain.css?ver=0" type="text/css" />
<center>
<section>
	<div id="FAQDiv">
		<div style="text-align: left; margin-left: 140px; margin-bottom: 40px;">
			<p class="FAQHead">FAQ</p>
		</div>
      <%
         if(loginMember != null && loginMember.getUserId().equals("admin")){
      %>
      <div>
         <button type="button" id="FAQWriteBtn" onclick="location.replace('<%=request.getContextPath()%>/FAQwrite')">FAQ 작성</button>
      </div>
      <%}else{ %>
	  <div style="height: 40px;"></div>
	  <%} %>
		<table class="FAQListTbl">
			<thead>
				<tr>
					<th class="tdnum">번 호</th>
					<th id="FAQTitleTh" class="tdsubject">제 목</th>
					<th class="tddate">작성일</th>
					<th class="tdcount">조회 수</th>
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
					<td style="color: blue" class="FAQList"><%=f.getNo()%></td>
					<td class="FAQList">
						<span class="innerContent" onclick="fn_link(<%=f.getNo()%>)">
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
		<div id="pageBar" style="margin-top: 25px;">
			<%=request.getAttribute("pageBar")%>
		</div>
	</div>
</section>
</center>
	<script>
		function fn_link(no){
			$("#linkF>input").val(no);
			$("#linkF").submit();
		}
	</script>

</body>
</html>