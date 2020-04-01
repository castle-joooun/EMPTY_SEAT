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
						출금
					</td>
				</tr>
			</table>
		</div>
		<div class="upzooinfobox">
				<table class="upzoomyinfo1">
					<tr>
						<td>
							출금가능잔액 : <%=loginMember.getCash() %>원
						</td>
					</tr>
					<tr>
						<td>
							출금하실 금액 <input type="text" id="choiceOutMoney">
						</td>
					</tr>
					<tr>
						<td>
							은행
						</td>
					</tr>
					<tr>
						<td>
							계좌번호
						</td>
					</tr>
					<tr>
						<td>
							예금주
						</td>
					</tr>
				</table>
				<button id="goOutMoneySV">출금</button>
		</div>
		
		
		<script>
		$(function(){
			$("#goOutMoneySV").click(function(){
				var choiceOutMoney = $("#choiceOutMoney").val();
				var userId="<%=loginMember.getUserId()%>";
				$.ajax({
					url:"<%=request.getContextPath()%>/cash/goOutMoneySV.do",
					type:"post",
					data:{"money":choiceOutMoney,
						  "userId":userId},
					dataType:"json",
					success:function(data){
					}
				})
			})
		})
		</script>