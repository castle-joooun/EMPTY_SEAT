<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.empty.member.model.vo.Member"%>
<%
	Member m=(Member) request.getAttribute("Member");
%>
	
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/mypage/mypageMain.css?ver=1" type="text/css">
<%@ include file="/views/common/header.jsp"%>

<section id="mypageMainSection">
	<div id="mypageMainDiv" class="col-8">
	<h1>MY PAGE</h1>
	<div class="mypageHeaderDiv">
		<span class="mypageHeader">개인정보</span>
		<input class="mypageHeaderBtn" type="button" value="수정하기">
	</div>
		<table id="mypageMainTable">
			<tr>
				<th>아이디</th>
				<td><%=loginMember.getUserId() %></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><%=loginMember.getUserName() %></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><%=loginMember.getEmail() %></td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td><%= loginMember.getPhone()%></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><%=loginMember.getAddress() %></td>
			</tr>
			<tr>
				<th>성별</th>
				<td><%=loginMember.getGender() %></td>
			</tr>
			<tr>
				<th>가입일</th>
				<td><%=loginMember.getEnrollDate() %></td>
			</tr>
		</table>
	</div>
	<div id="mypageUseDiv">
		<div class="mypageHeaderDiv">
			<span class="mypageHeader">사용내역</span>
		</div>
		<table id="mypageUseTable">

		</table>
	</div>
	
	<div id="mypagePayDiv">
		<div class="mypageHeaderDiv">
			<span class="mypageHeader">결제내역</span>
		</div>
		<table id="mypagePayTable">

		</table>
	</div>
</section>
<script>
$(function(){
      $("#mypageUseDiv").click(function(){
    	  if($("#mypageUseTable").html() == "") {
    		  $.ajax({
    	            url:"<%=request.getContextPath()%>/mypageUse",
    	            type:"get",
    	            dataType:"html",
    	            success:function(data){
    	               $("#mypageUseTable").html(data);
    	            }
    	         })
    	  } else {
    		  $("#mypageUseTable").html("");
    	  }
         
      });         
   });
   
   $(function(){
      $("#mypagePayDiv").click(function(){
    	  if($("#mypagePayTable").html() == ""){
         $.ajax({
            url:"<%=request.getContextPath()%>/mypagePay",
            type:"get",
            dataType:"html",
            success:function(data){
               $("#mypagePayTable").html(data); 
            }
         })
      }else{
    	  $("#mypagePayTable").html("");
      }
      });         
   });
</script>