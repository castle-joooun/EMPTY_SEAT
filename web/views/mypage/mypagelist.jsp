<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page
	import="com.empty.member.model.vo.Member,com.empty.common.listener.SessionCheckListener"%>
<%
	Member loginMember = (Member) session.getAttribute("loginMember");
%>
	<script>
	$(document).ready(function(){
		var userId="<%=loginMember.getUserId()%>";
		var cash=0;
		$.ajax({
			url:"<%=request.getContextPath()%>/mypage.do", 
			type:"get",
			dataType:"json",
			data:{
				"userId":userId	
			},
			success:function(data){
				console.log(data['cash']);
				cash=data['cash'];
				$("#cashbox").text(cash);
			}
		})
	})
	</script>
			<div class="myinfobox">
			<table>
				<tr>
					<td>
						개인정보
					</td>
					<td>
						<button class="crystal">수정</button>
					</td>
				</tr>
			</table>
		</div>
		
		<div>
			<div class="upzooinfobox">
				<table class="upzoomyinfo1">
					<tr>
						<td>
							아이디
						</td>
						<td colspan='3'>
							<%=loginMember.getUserId() %>
						</td>
					</tr>
					<tr>
						<td>
							이름
						</td>
						<td colspan='3'>
							<%=loginMember.getUserName() %>
						</td>
					</tr>
					<tr>
						<td>
							이메일
						</td>
						<td colspan='3'>
							<%=loginMember.getEmail() %>
						</td>
					</tr>
					<tr>
						<td>
							핸드폰
						</td>
						<td colspan='3'> 
							<%=loginMember.getPhone() %>
						</td>
					</tr>
					<tr>
						<td>
							주소
						</td>
						<td colspan='3'>
							<%=loginMember.getAddress() %>
						</td>
					</tr>
					<tr>
						<td>
							성별
						</td>
						<td colspan='3'>
							<%=loginMember.getGender() %>
						</td>
					</tr>
					<tr>
						<td>
							캐시
						</td>
						<td id="cashbox">

						</td>
						<td>
							원
						</td>
						<td>
							<button class="outmoney">출금</button>
						</td>
					</tr>
				</table>
			</div>
			
			
			<div class="myinfobox">
				<table>
					<tr>
						<td>
							매장정보
						</td>
						<td>
							<button class="enrollstore">매장등록</button>
						</td>
					</tr>
				</table>
				
			</div>
			<div class="upzooinfobox">
				<table class="upzoomyinfo2">
					<tr>
						<td rowspan="7" colspan="1">
							<img alt="image/퓨리.jpg" src="">
						</td>
					</tr>
					<tr>
						<td>
							매장이름
						</td>
					</tr>
					<tr>
						<td>
							매장번호
						</td>
					</tr>
					<tr>
						<td>
							매장 영업시간
						</td>
					</tr>
					<tr>
						<td>
							컴퓨터 사양
						</td>
					</tr>
					<tr>
						<td>
							매장 주소
						</td>
					</tr>
					<tr>
						<td>
							부대시설
						</td>
					</tr>
					
				</table>
			</div>
		</div>
		
		<script>
		$(function(){
		$(".crystal").click(function(){
			$.ajax({
				url:"<%=request.getContextPath()%>/mypage/crystal.do",
				type:"get",
				dataType:"html",
				success:function(data){
					$(".alldiv").html(data);
				}
			})
		})
	})
	
	$(function(){
		$(".outmoney").click(function(){  //출금으로
			$.ajax({
				url:"<%=request.getContextPath()%>/mypage/outmoney.do",
				type:"get",
				dataType:"html",
				success:function(data){
					$(".alldiv").html(data);
				}
			})
		})
	})
	
	$(function(){
		$(".enrollstore").click(function(){  //매장등록
			$.ajax({
				url:"<%=request.getContextPath()%>/mypage/enrollstore.do",
				type:"get",
				dataType:"html",
				success:function(data){
					$(".alldiv").html(data);
				}
			})
		})
	})
	</script>