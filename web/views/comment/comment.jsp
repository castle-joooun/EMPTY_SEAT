<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

s
<%@ page import="com.empty.comment.model.vo.Comment,java.util.List"%>

<%

	List<Comment> commentList = (List)request.getAttribute("commentList");
%>



	<!-- 댓글 -->
	<div id="comment">
	

					<th>댓글</th>
				</tr>
				<tr>
					<form
						action="<%=request.getContextPath()%>/comment/storeCommentInsert"
						method="post">
						<td><input type="text" id="commentInput" name="userComment" /></td>
						<td><input type="hidden"  name="commentNo" /></td>
						<td><button  type="submit" id="commentBtn" name="commentBtn"
								onclick="fn_comment_btn">등록</button></td>
						<td><input type="hidden" name="commentWriter"
							value="<%=loginMember != null ? loginMember.getUserId() : ""%>" />
						<td>
						<input type="hidden" name="commentLevel" value="1" />
						<input type="hidden" name="commentRef" value="0" />
				</tr>
				</form>
</div>
	<script>
//댓글 스크립트 
 $(function(){                                
		$("#commentInput").focus(function(){
			if(<%=loginMember == null%>){
				alert("로그인 후 이용하세요");
				$("#userId").focus();
			}
		});
	})
</script>
		<table class="userTable">
				<%
					if (commentList != null && !commentList.isEmpty()) {
						for (Comment c : commentList) {
							if (c.getCommentLevel() == 1) {
				%>
			
				<tr>
						<sub><%=c.getCommentWriter()%><%=c.getCommentNo()%></sub>

								<div style="text-align: right;">
									<sub><%=c.getCommentDate()%></sub>
								</div> 
								
								<%=c.getUserComment()%>
					</tr>
				</table>

<%-- 
<div id="my-dialog">
<table>
<tr>	
	<form id="commUpdateForm" action="<%=request.getContextPath()%>/comment/storeCommentUpdate">
		<td><input type="hidden" id="commNo" name="commentNo" value="<%=c.getCommentNo() %>" /></td>
		<td><input type="text" id="userComment" name="userComment" value="<%c.getUserComment();%>"/></td>
		<td><input type="submit" value="수정" /><td>
	</form> 
</tr>
</table>
</div>
<div id="dialog-background"></div> --%>
							
							
							<div class="reBtn" style="text-align: right;">	
							
										<%if (loginMember!=null&&loginMember.getUserId().equals("ooze")) {%>	
									<button id="reBtn" onclick="reBtn(<%=c.getCommentNo()%>)">답글</button>
									</br>		
									<%} %>
									
									<%if (loginMember!=null&&loginMember.getUserId().equals("ooze")) {%>
									<button id="updateBtn" onclick="fnModify(<%=c.getCommentNo()%>)" >수정</button>
									</br>
									<button id="deleteBtn" onclick="deleteBtn(<%=c.getCommentNo()%>)">삭제</button>
									
									<%} %>
							</div>

				<%
					} else {
				%>

				<table class="storeTable">
					<tr>
						<td>
						<th><%=c.getCommentWriter()%></th>
						<td><%=c.getCommentDate()%></td>
						<br/>
								<td><%=c.getUserComment()%></td>
						
					</tr>
					<%
						}
							} //for
						} //if
					%>
				</table>
			</table>

<script>
function reBtn(no){
	var input = document.getElementById("commentInput").value;
	temp = input;
	}


 			function deleteBtn(no){
		location.replace("<%=request.getContextPath()%>/comment/storeCommentDelete?no="+no);	
	}
</script>
		
<script>
//댓글 
	$(function(){
		$("#commentBtn").keyup(function(e){
		  
		})
	})

//댓글수정모달 
function fnModify(no){
	$('#commNo').val(no);
	 $("#updateBtn,#dialog-background,#btn-close-dialog").click(function(){
		 	$("#my-dialog,#dialog-background").toggle();
	 });
}

</script>



	<!-- 댓글 -->

	<!--  뎃글 페이징  -->

<%-- 	<div id='pageBar'>
		<%=request.getAttribute("pageBar")%>
	</div> --%>

	<!--  뎃글 페이징  -->






	<!-- 댓글 -->