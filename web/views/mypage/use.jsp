<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.empty.member.model.vo.Member,com.empty.common.listener.SessionCheckListener"%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/base2.css?ver=2.0" type="text/css">
<%
	Member loginMember = (Member) session.getAttribute("loginMember");
%>
	<script>
	$(document).ready(function(){
		var userId="<%=loginMember.getUserId()%>";
		$.ajax({
			url:"<%=request.getContextPath()%>/use/use.do", 
			type:"get",
			dataType:"json",
			data:{
				"userId":userId	
			},
			success:function(data){
				console.log(data);
				const tr=$("<tr>");
				const tr3=$("<tr>");
				tr3.append($("<td>").html("출금날짜"));
				tr3.append($("<td>").html("출금 계좌번호"));
				tr3.append($("<td>").html("금액"));
				tr.append(tr3);
				for(let i=0;i<data.length;i++){
					const tr2=$("<tr>");
						tr2.append($("<td>").html(data[i]['omDate']));
						tr2.append($("<td>").html(data[i]['omNumber']));
						tr2.append($("<td>").html(data[i]['om']));
						tr.append(tr2);
				}
				$(".myuseList:last-child").html(tr);
			}
		})
	})
	</script>
		<div class="useList">
			<table>
				<tr>
					<td>
						입금내역
					</td>
				</tr>
			</table>
		</div>
		
		<div class="inmoneyList">
			<table>
				<tr>
					<td>
						입금날짜
					</td>
					<td>
						입금자
					</td>
					<td>
						금액
					</td>
				</tr>
			</table>
		</div>
		
		<div class="useList">
			<table>
				<tr>
					<td>
						출금내역
					</td>
				</tr>
			</table>
		</div>
		
		<div class="myuseList">
			<table>
				<tr>
					<td>
						출금날짜
					</td>
					<td>
						출금 계좌번호
					</td>
					<td>
						금액
					</td>
				</tr>
				<tr>
				</tr>
			</table>
		</div>