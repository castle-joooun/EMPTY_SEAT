<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="storeBaseTop.jsp"%>
<%@ page import="com.empty.search.model.vo.Store, java.util.List"%>
<%@ page import="com.empty.search.model.vo.StoreSeat, com.empty.member.model.vo.Member"%>

<%
	Member loginMember = (Member) session.getAttribute("loginMember");
%>
<link rel="stylesheet" href="css/store.css?ver=0" type="text/css">

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
				<span class="storeInfoBasicMajor">주소 : </span> 
				<span class="storeInfoBasicMinor"><%=s.getStoreAddress()%></span>
				<!-- 주소API 넣기 -->
				<div id="map" style="width:480px;height:300px;"></div>
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

	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1f47dde95b7968538cbb3ad2e6003356&libraries=services"></script>
	<script>
	  //즐겨찾기
	    $("#favorite").click(function () {
	    	
	    	var check;
	    	
	        if($("#favorite").attr("src") == "image/favorite-empty.png"){
	        	check = true;
	        } else {
	        	check = false;
	        }
	
	        
	        $.ajax({
	        	url:"<%=request.getContextPath()%>/favorite",
	        	type:"post",
	        	data:{"check":check, "userId":"ooze", "storeId":"<%=s.getStoreId()%>"},
	        	success:function(data) {
	        		console.log(data);
	        		if(data==6) {
	        			alert("!즐겨찾기 최대개수(6개) 도달! : 즐겨찾기를 삭제 후 추가해주세요.");
	        		} else if(data<6) {
	        			if($("#favorite").attr("src")==("image/favorite-use.png")) {
	        				$("#favorite").attr("src","image/favorite-empty.png");	     
	        			} else {
	        				$("#favorite").attr("src","image/favorite-use.png");	        				
	        			}
	        		}
	        	}
	        })
    })
    
    $(function() {
    	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
        mapOption = {
            center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
            level: 3 // 지도의 확대 레벨
        };  

	    // 지도를 생성합니다    
	    var map = new kakao.maps.Map(mapContainer, mapOption); 
	
	    // 주소-좌표 변환 객체를 생성합니다
	    var geocoder = new kakao.maps.services.Geocoder();
	
	    // 주소로 좌표를 검색합니다
	    geocoder.addressSearch('<%=s.getStoreAddress()%>', function(result, status) {
	
	        // 정상적으로 검색이 완료됐으면 
	         if (status === kakao.maps.services.Status.OK) {
	
	            var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
	
	            // 결과값으로 받은 위치를 마커로 표시합니다
	            var marker = new kakao.maps.Marker({
	                map: map,
	                position: coords
	            });
	
	            // 인포윈도우로 장소에 대한 설명을 표시합니다
	            var infowindow = new kakao.maps.InfoWindow({
	                content: '<div style="width:150px;text-align:center;padding:6px 0; top:-15px;"><%=s.getStoreName()%></div>'
	            });
	            infowindow.open(map, marker);
	
	            // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
	            map.setCenter(coords);
	        } 
	    });    
    })
    </script>




	<%@ include file="storeBaseBottom.jsp"%>