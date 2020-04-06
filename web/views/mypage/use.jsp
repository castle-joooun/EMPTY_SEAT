<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.empty.member.model.vo.Member,com.empty.common.listener.SessionCheckListener"%>
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
				tr3.append($("<td>").html("출금날짜").css('font-size','17px').css('font-weight','bold'));
				tr3.append($("<td>").html("출금 계좌번호").css('font-size','17px').css('font-weight','bold'));
				tr3.append($("<td>").html("금액").css('font-size','17px').css('font-weight','bold'));
				tr3.append($("<td>").html("출금후 금액").css('font-size','17px').css('font-weight','bold'));
				tr.append(tr3);
				for(let i=0;i<data.length;i++){
					const tr2=$("<tr>");
						tr2.append($("<td>").html(data[i]['omDate']));
						tr2.append($("<td>").html(data[i]['omNumber']));
						tr2.append($("<td>").html(data[i]['om']));
						tr2.append($("<td>").html(data[i]['afterOm']));
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
			</table>
		</div>