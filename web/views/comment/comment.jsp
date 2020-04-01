<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.empty.member.model.vo.Member,com.empty.common.listener.SessionCheckListener"%>
<%@ page import="com.empty.comment.model.vo.Comment,java.util.List"%>

<%
	Member loginMember = (Member) session.getAttribute("loginMember");
	List<Comment> list = (List)request.getAttribute("commentList");
%>


 <!-- 댓글 -->
	<div id="comment">
	<form action="<%=request.getContextPath() %>/comment/storeCommentInsert" method="post">
		
		
		<table>
			<tr>
			
				<th>댓글</th>
		
			</tr>
			<tr>
			<form action="<%=request.getContextPath() %>/comment/storeCommentInsert" method="post">
				<td><textarea id="commentInput" name="userComment"></textarea></td>
				<td><input type="hidden" name="commentWriter" value="<%=loginMember !=null?loginMember.getUserId():""%>"/>
				<td><input type="hidden" name="commentLevel"	 value="1"/>
				<td><button id="commentBtn"  name="commentBtn" onclick="fn_comment_btn">등록</button></td>
			</form><
			</tr>
			
			<% if(list!=null && !list.isEmpty()){ 
				for(Comment c : list) {
					if(c.getCommentLevel()==1){
				%>
				
				<tr >
					<td>
						<sub class="comment-writer"><%=c.getCommentWriter() %></sub>
						<sub class="comment-date"><%=c.getCommentDate() %></sub>
						<br/>
						<%=c.getUserComment() %>
					</td>
					<td>
						<button class="storeBtn" value="<%=c.getCommentNo() %>">답글</button> 
						
					</td>
				</tr>
			<%	}else{%>
				<tr>
					<td>
						<sub><%=c.getCommentWriter() %></sub>
						<sub ><%=c.getCommentDate() %></sub>
						<br/>
						<%=c.getUserComment() %>
					</td>
					<td></td>
				</tr>
			<%	}
			   }//for
			 }//if %>
		</table>
	</form>  
	
	</div>     
			</div> 
 <!-- 댓글 -->
 
 <!--  뎃글 페이징  -->
 
 	<div id='pageBar'>
			<%=request.getAttribute("pageBar") %>
		</div>

 <!--  뎃글 페이징  -->

 <script>
 
 $(function(){
		$("#commentInput").focus(function(){
			if(<%=loginMember==null%>){
				alert("로그인 후 이용하세요");
				$("#userId").focus();
			}
		})
	});

 //댓글 ajax
	function fn_comment_btn(){
	 var xhr =new XMLHttpRequest();
	 xhr.onreadystatechange=function(){
		 if(xhr.readyState==4){
			 if(xhr.status==200){
				 document.querySelector("#result").innerHTML=xhr.responseText;
			 }
		 }
	 }
 } 
 function insertComment(){
	 	$.ajax({
	 		url:"StoreCommentInsert",
	 		type:"POST",
	 		cache: false,
	 		dataType : "JSON",
	 		data:$('#commentInput').serialiae(),
	 		success:
	 			function(data){
	 			
	 				alert("댓글등록성공");
	 		},
	 		error:
	 			function(request, staus, error){
	 				alert("댓글등록실패");
	 			
	 		}
	 	});
 }

 </script>