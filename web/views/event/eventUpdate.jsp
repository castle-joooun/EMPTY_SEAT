<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.empty.event.model.vo.Event"%>
<%
	Event e = (Event) request.getAttribute("Event");
%>


<%@ include file="/views/common/header.jsp"%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/event/eventUpdate.css" type="text/css">
<center>
	<section>
		<div id="eventUpdateDiv">
			<div>	
				<p class="eventUpdateHead">이벤트 수정</p>
			</div>
			<form id="eventUpdateForm" action="<%=request.getContextPath()%>/event/eventUpdateEnd" method="post">
				<input type="hidden" name="time" value="<%=e.getEventDate() %>">
				<input type="hidden" name="no" value="<%=e.getEventNo() %>">
				<table id="eventUpdateTbl">
					<tr>
						<td>
							<input type="text" id="eventUpdateTitle" name="title" value="<%=e.getEventTitle() %>" size="50">
						</td>
					</tr>
					<tr>
						<td>
							<textarea id="eventUpdateContent" name="content" cols=51 rows=10 required><%=e.getEventContent() %></textarea>
						</td>
					</tr>
				</table>
				<div>
					<button type="button" id="eventUpdateEndBtn" onclick="eventUpdateFn();">수 정</button>
					<button type="button" id="eventUpdateCencleBtn" onclick="eventUpdateCencleFn();">취 소</button>
				</div>
			</form>
		</div>
	</section>
</center>
	<script>
		function eventUpdateFn(){
			var updateTitle = document.getElementById("eventUpdateTitle").value;
			var updateContent = document.getElementById("eventUpdateContent").value;
			if(updateTitle != "" && updateContent != ""){
				if(confirm("게시물을 수정하시겠습니까?")){
					document.getElementById("eventUpdateForm").submit();
				}else{
					window.close();
				}
			}else if(updateTitle == ""){
				alert("제목을 입력하세요.");
			}else if(updateContent == ""){
				alert("내용을 입력하세요.");
			}
		}
		
		function eventUpdateCencleFn(){
			if(confirm("게시물 수정을 중단하시겠습니까?")){
				location.href='<%=request.getContextPath()%>/event';
			}else{
				window.close();
			}
		}
	</script>
</body>
</html>