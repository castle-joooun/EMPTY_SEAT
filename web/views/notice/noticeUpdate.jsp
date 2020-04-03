<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.empty.notice.model.vo.Notice"%>
<%
   Notice n = (Notice) request.getAttribute("Notice");
%>


<%@ include file="/views/common/header.jsp"%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/notice/noticeUpdate.css" type="text/css">
	<center>
		<section>
			<div id="noticeUpdateDiv">
				<div>
					<p class="noticeUpdateHead">공지사항 수정</p>
				</div>
				<form id="noticeUpdateForm" action="<%=request.getContextPath()%>/notice/noticeUpdateEnd" method="post">
					<input type="hidden" name="time" value="<%=n.getNoticeDate() %>">
					<input type="hidden" name="no" value="<%=n.getNoticeNo() %>">
					<table id="noticeUpdateTbl">
						<tr>
						   <td><input type="text" name="title" id="noticeUpdateTitle" value="<%=n.getNoticeTitle() %>" size="50"></td>
						</tr>
						<tr>
						<td>
							<textarea name="content" id="noticeUpdateContent" cols="50" rows="10" style="resize: none;"><%=n.getNoticeContent() %></textarea>
						</td>
						</tr>
					</table>
					<div>
						<button type="button" id="noticeUpdateEndBtn" onclick="noticeUpdateFn();">수 정</button>
						<button type="button" id="noticeUpdateCencleBtn" onclick="noticeUpdateCencleFn();">취 소</button>
					</div>
				</form>
			</div>
		</section>
	</center>
	
	<script>
		function noticeUpdateFn(){
			var updateTitle = document.getElementById("noticeUpdateTitle").value;
			var updateContent = document.getElementById("noticeUpdateContent").value;
			if(updateTitle != "" && updateContent != ""){
				if(confirm("게시물을 수정하시겠습니까?")){
					document.getElementById("noticeUpdateForm").submit();
				}else{
					window.close();
				}
			}else if(updateTitle == ""){
				alert("제목을 입력하세요.");
			}else if(updateContent == ""){
				alert("내용을 입력하세요.");
			}
		}
		
		function noticeUpdateCencleFn(){
			if(confirm("게시물 수정을 중단하시겠습니까?")){
				location.href='<%=request.getContextPath()%>/notice';
			}else{
				window.close();
			}
		}
	</script>
</body>
</html>