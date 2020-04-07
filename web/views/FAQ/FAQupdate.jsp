<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.empty.FAQ.model.vo.FAQ"%>
<%
	FAQ f = (FAQ) request.getAttribute("FAQ");
%>


<%@ include file="/views/common/header.jsp"%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/FAQ/FAQupdate.css?ver=0" type="text/css">
<center>
	<section>
		<div id="FAQUpdateDiv">
			<div>
				<p class="FAQUpdateHead">FAQ 수정</p>
			</div>
			<form  id="FAQUpdateForm" action="<%=request.getContextPath()%>/FAQ/FAQupdateEnd" method="post">
				<input type="hidden" name="time" value="<%=f.getTime() %>">
				<input type="hidden" name="no" value="<%=f.getNo() %>">
				<table id="FAQUpdateTbl">
					<tr>
						<td>
							<input type="text" id="FAQUpdateTitle" name="FAQUpdateTitle" value="<%=f.getTitle() %>" size="50">
						</td>
					</tr>
					<tr>
						<td>
							<textarea id="FAQUpdateContent" name="content" cols=51 rows=10 required><%=f.getContent() %></textarea>
						</td>
					</tr>
				</table>
				<div>
					<button type="button" id="FAQUpdateEndBtn" onclick="FAQUpdateFn();">수 정</button>
					<button type="button" id="FAQUpdateCencleBtn" onclick="FAQUpdateCencleFn();">취 소</button>
				</div>
			</form>
		</div>
	</section>
</center>
	<script>
		function FAQUpdateFn(){
			var updateTitle = document.getElementById("FAQUpdateTitle").value;
			var updateContent = document.getElementById("FAQUpdateContent").value;
			if(updateTitle != "" && updateContent != ""){
				if(confirm("게시물을 수정하시겠습니까?")){
					document.getElementById("FAQUpdateForm").submit();
				}else{
					window.close();
				}
			}else if(updateTitle == ""){
				alert("제목을 입력하세요.");
			}else if(updateContent == ""){
				alert("내용을 입력하세요.");
			}
		}
		
		function FAQUpdateCencleFn(){
			if(confirm("게시물 수정을 중단하시겠습니까?")){
				location.href='<%=request.getContextPath()%>/FAQMainServlet';
			}else{
				window.close();
			}
		}
	</script>
</body>
</html>