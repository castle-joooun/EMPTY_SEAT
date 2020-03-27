<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="storeBaseTop.jsp"%>
<%@ page import="com.empty.search.model.vo.Store, java.util.List"%>
<%@ page import="com.empty.search.model.vo.StoreSeat, com.empty.member.model.vo.Member"%>

<%
	Member loginMember = (Member) session.getAttribute("loginMember");
%>

<!-- <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1f47dde95b7968538cbb3ad2e6003356"></script> -->

<link rel="stylesheet" href="css/store.css?ver=2" type="text/css">

<img src="image/back.png" alt="" id="back" width="20px">
<img src="image/next.png" alt="" id="next" width="20px">

<%
	Store s = (Store) request.getAttribute("store");
	System.out.println("store.jsp : " + s);
	String[] info = s.getStoreInfo().split(", ");
	List<String> imgs = (List) request.getAttribute("imgs");
	StoreSeat ss = (StoreSeat) request.getAttribute("storeSeat");
	String[] check = ss.getStoreCheck().split("");
	int seatNum = 0;
%>


<div id="imgBox">
	<center>
		<li id="imgSlide">
			<%
				for (String str : imgs) {
			%> <img src="<%=str%>" alt=""
			class="interior"> <%
 	}
 %>
		</li>
	</center>
</div>

<div id="store">
	<div id="storeInfo">

		<center>
			<div id="storeTitleBox">
				<p id="storeTitle"><%=s.getStoreName()%></p>
				<img src="<%=request.getAttribute("url") %>" alt="" id="favorite">
			</div>
		</center>
		<!-- <img > -->
		<div id="clickNone">
			<div id="storeInfoBasic">
				<div id="storePhone">
					<span class="storeInfoBasicMajor">전화번호 : </span>
					<sapn class="storeInfoBasicMinor"><%=s.getStorePhone()%> </sapn>
				</div>
				<div id="storeTime">
					<span class="storeInfoBasicMajor">운영시간 : </span>
					<sapn class="storeInfoBasicMinor"><%=s.getStoreTime()%> </sapn>
				</div>
				<div id="storeAdd">
					<span class="storeInfoBasicMajor">부대시설 : </span>
					<sapn class="storeInfoBasicMinor"><%=s.getStoreFacility()%>
					</sapn>
				</div>
				<div id="storePc">
					<span class="storeInfoBasicMajor">PC정보 : </span>
					<sapn class="storeInfoBasicMinor"> <%
 	for (String str : info) {
 %>
					<%=str%><br>
					<%
						}
					%> </sapn>
				</div>
			</div>
			<div id="storeInfoMap">
				<span class="storeInfoBasicMajor">주소 : </span> <span
					class="storeInfoBasicMinor"><%=s.getStoreAddress()%></span>
				<!-- 주소API 넣기 -->
				<div id="map" style="width: 480px; height: 300px"></div>
			</div>
		</div>


		<button id="viewSeatBtn">빈시트 CHECK!</button>
	</div>

	<div id="viewSeat">
		<p id="seatInfoText">
			<!-- 원래는 값 받아와서 넣기 -->
			빈시트 : 00 꽉시트 : 00
		</p>
		<center>
			<table>
				<%
					for (int i = 1; i <= ss.getRow(); i++) {
				%>
				<tr>
					<%
						for (int j = 1; j <= ss.getCol(); j++) {
					%>
					<%
						if (check[seatNum].equals("1")) {
					%>
					<td class="emptySeat"></td>
					<%
						} else {
					%>
					<td></td>
					<%
						}
					%>
					<%
						seatNum++;
					%>
					<%
						}
					%>
				</tr>
				<%
					}
				%>
			</table>
		</center>
	</div>

	<div id="comment">
		<table>
			<tr>
				<th>댓글</th>
				<td><button id="refresh">새로고침</button></td>
			</tr>
			<tr>
				<td><textarea id="commentInput"></textarea></td>
				<td><button id="commentBtn">등록</button></td>
			</tr>
		</table>
	</div>

	<script>
	  //즐겨찾기
	    $("#favorite").click(function () {
	    	
	    	var check;
	    	
	        if($("#favorite").attr("src") == "image/favorite-empty.png"){
	        	check = true;
	        } else {
	        	check = false;
	        }
	
	    	var request = new XMLHttpRequest();
	    	request.onreadystatechange = function() {
	    		if(request.readyState == 4) {
	    			if(request.status == 200) {
	    			    if($("#favorite").attr("src") == "image/favorite-empty.png"){
	    			    	$("#favorite").attr("src","image/favorite-use.png");
	    			    } else {
	    			    	$("#favorite").attr("src","image/favorite-empty.png");
	    			    }
	    			}
	    		}
	    	}
	    	
	    	
	    	request.open("post", "<%=request.getContextPath()%>/favorite");
	    	request.setRequestHeader("Content-type", "application/x-www-form-urlencoded;");
	    	// 여기 userId 고치기!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	    	<%-- request.send("check=" + check + "&userId=<%=loginMember.getUserId()%>&storeId=<%=s.getStoreId()%>"); --%>
	    	request.send("check=" + check + "&userId=ooze&storeId=<%=s.getStoreId()%>");

    })
    
    </script>




	<%@ include file="storeBaseBottom.jsp"%>