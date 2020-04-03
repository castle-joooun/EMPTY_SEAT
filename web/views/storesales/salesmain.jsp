<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/storesales/salesmain.css?ver=2" type="text/css">
<% 
	String date =(String)request.getAttribute("date");

%>

<div class="subMenuContainer">

	<div id="storeSubMenu">
		<ul>
			<li><a href="<%=request.getContextPath()%>/store/salesView"><span class="text-item">일매출 보기</span></a></li>
			<li><a href="<%=request.getContextPath()%>/store/monthSalesView"><span>월매출보기</span></a></li>
			<li><a href="#"><span>스토어 매출보기</span></a></li>
		</ul>
	</div>
	

</div>
<div id="contentContainer">
	<div id="dayContainer">
		<div><img src="<%=request.getContextPath()%>/image/leftward.png"></div>
		<div id="dateStyle"><%=date %></div>
		<div><img src="<%=request.getContextPath()%>/image/rightward.png"></div>
	</div>
	<div id="tableContainer">
		<table>
			<tr >
				<td colspan='2'>상호 명</td>
			</tr>
			<tr>
				<td>고객수</td>
				<td>10명</td>
			</tr>
			<tr>
				<td>공급가액</td>
				<td>00000</td>
			</tr>
			<tr>
				<td>부가세</td>
				<td>0000</td>
			</tr>
			<tr>
				<td>총 매출</td>
				<td>000000</td>
			</tr>
			<tr>
				<td>객단가</td>
				<td>매출/고객수</td>
			</tr>
			
		</table>
	</div>
</div>
</body>

</html>