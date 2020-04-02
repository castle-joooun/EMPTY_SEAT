<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/admincommon/header.jsp"%>
<%
	String msg = (String)request.getAttribute("msg");
	String locstr = (String)request.getAttribute("locstr");
	String loc = (String)request.getAttribute("loc");

%>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/adminPage/msg.css" type="text/css">

<section>

	<div id="msgContainer">
		<div>
			<h4><%=msg %></h4>
		</div>
		<div>
			<a>
				<button type="button" id="wantloc"><%=locstr %></button>
			</a> 
			<a>
				<button type="button" id="mainloc">메인화면으로</button>
			</a>
		</div>
	</div>

</section>
<script>
	$("#wantloc").click(function(){
		location.replace("<%=request.getContextPath()%><%=loc%>");
	})
	$("#mainloc").click(function(){
		location.replace("<%=request.getContextPath()%>/");
	})
	

</script>