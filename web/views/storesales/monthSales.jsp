<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<% 
	String year =(String)request.getAttribute("year");
	String month =(String)request.getAttribute("month");
%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/storesales/salesmain.css?ver=2" type="text/css">
<div class="subMenuContainer">

	<div id="storeSubMenu">
		<ul>
			<li><a href="<%=request.getContextPath()%>/store/salesView"><span>일매출 보기</span></a></li>
			<li><a href="<%=request.getContextPath()%>/store/monthSalesView"><span class="text-item">월매출보기</span></a></li>
			<li><a href="#"><span>스토어 매출보기</span></a></li>
		</ul>
	</div>
	<div>

</div>
<div id="contentContainer">
	<div id="dayContainer">
		<div><img src="<%=request.getContextPath()%>/image/leftward.png"></div>
		<div id="dateStyle">
			<%=year+"년 "+month+"월" %>
			
			<input type="hidden" name="today" value="<%=year+"-"+month %>">
		</div>		
		<div><img src="<%=request.getContextPath()%>/image/rightward.png"></div>
	</div>
	<form action="<%=request.getContextPath() %>/store/monthSalesView" method="post">
		<input type="month" name="month" id="month">
		<button>검색</button>
	</form>
	<div class="down-btn-container">
		
	</div>
	<div id="monthTableContainer">
		<!-- <table>
			<tr >
				<td colspan='6'>상호 명</td>
			</tr>
			<tr>
				<td>일자</td>
				<td>요일</td>
				<td>객수</td>
				<td>매출액</td>
				<td>공급가액</td>
				<td>부가세</td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td colspan='2'>합계</td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</table> -->
	</div>
</div>
<script>
	$(function(){
		/* var today = new Date();
		if(today.getMonth()<10){
			var month = "0"+today.getMonth();
			console.log(month);
		}
        var date = today.getFullYear()+"-"+month; */
       	var date = '<%=year+"-"+month %>';
       	console.log(date);
        requestSales(date);
	})
	function requestSales(date){
		$.ajax({
			url:"<%=request.getContextPath()%>/store/monthSales/ajax",
			dateType:"json",
			type:"post",
			data:{"date":date,"storeId":'<%=loginMember.getUserId()%>'},
			success:function(data){
				if(data.length>0){
					
					const table = $("<table>");
					const tr = $("<tr>");
					tr.append($("<td colspan='6'>").html(data[0]['storeName']));
					table.append(tr);
					const tr2 = $("<tr>");
					tr2.append($("<td>").html("일자"));
					tr2.append($("<td>").html("요일"));
					tr2.append($("<td>").html("객수"));
					tr2.append($("<td>").html("공급가액"));
					tr2.append($("<td>").html("부가세"));
					tr2.append($("<td>").html("합계액"));
					table.append(tr2);
					var totalC=0;
					var totalNet = 0;
					var totalTax =0;
					var totalProfit=0;
					
					for(let i = 0;i<data.length;i++){
						const tr3 =$("<tr>");
						tr3.append($("<td>").html(data[i]['enDate']));
						
						tr3.append($("<td>").html(data[i]['dayOfWeek']));
						tr3.append($("<td>").html(data[i]['customer']));
						totalC+=data[i]['customer'];
						tr3.append($("<td>").html(data[i]['netProfit']));
						totalNet+=data[i]['netProfit'];
						tr3.append($("<td>").html(data[i]['tax']));
						totalTax+=data[i]['tax'];
						tr3.append($("<td>").html(data[i]['totalProfit']));
						totalProfit+=data[i]['totalProfit'];
						table.append(tr3);
						
					}
					var tf = $("<tfoot>");
					tf.append($("<td colspan='2'>").html("합계"));
					tf.append($("<td>").html(totalC));
					tf.append($("<td>").html(totalNet));
					tf.append($("<td>").html(totalTax));
					tf.append($("<td>").html(totalProfit));
					table.append(tf);
					$("#monthTableContainer").append(table);
					
					$(".down-btn-container").html("<button onclick='exelDown()'>엑셀파일</button>");
					
					
					
				}else{
					$("#monthTableContainer").append("검색된 정보가 없습니다.");
				}
			
				
			}
		})
	}
	function exelDown(){
		<%-- $.ajax({
			url:"<%=request.getContextPath()%>/exelDown.do",
			dateType:"json",
			type:"post",
			data:{"date":'<%=year+"-"+month %>',"storeId":'<%=loginMember.getUserId()%>'},
			success:function(data){
				console.log("성공");	
				
			}
		}) --%>
		location.href="<%=request.getContextPath()%>/exelDown.do?date=<%=year+"-"+month %>&storeId=<%=loginMember.getUserId()%>";
		
	}


</script>
</body>

</html>