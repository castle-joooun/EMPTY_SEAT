<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page
	import="com.empty.member.model.vo.Member,com.empty.common.listener.SessionCheckListener"%>
<%
	Member loginMember = (Member) session.getAttribute("loginMember");
%>
	
	<div class="myinfobox">
			<table>
				<tr>
					<td>
						개인정보 수정
					</td>
					<td>
						<button class="crystalcom">수정</button>
					</td>
				</tr>
			</table>
		</div>
	
	<talbe>
		<tr>
			<td>
			
			</td>
		</tr>
	</talbe>
	
	<button class="byevin">탈퇴</button>
	
	<script>
	$(function(){
		$(".crystalcom").click(function(){
			$.ajax({
				url:"<%=request.getContextPath()%>/mypage/crystalcom.do",
				type:"post",
				/* data:{""}, */
				dataType:"json",
				success:function(data){
					$(".alldiv").html(data);
				}
			})
		})
	})
	
	
	$(function(){
		$(".byevin").click(function(){
			$.ajax({
				url:"<%=request.getContextPath()%>/mypage/byevin.do",
				type:"post",
				data:{"userId":<%=loginMember.getUserId()%>},
				dataType:"json",
				success:function(data){
					$(".alldiv").html(data);
				}
			})
		})
	})
	</script>
