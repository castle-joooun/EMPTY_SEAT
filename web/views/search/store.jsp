<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="storeBaseTop.jsp"%>
<%@ page import="com.empty.search.model.vo.Store, java.util.List"%>
<%@ page import="com.empty.search.model.vo.StoreSeat, com.empty.member.model.vo.Member"%>
<%@ page import="com.empty.comment.model.vo.Comment,java.util.List"%>

<link rel="stylesheet" href="css/store.css?ver=1" type="text/css">

<img src="image/back.png" alt="" id="back" width="20px">
<img src="image/next.png" alt="" id="next" width="20px">

<%
	Store s = (Store) request.getAttribute("store");
	System.out.println("store.jsp : " + s);
	String[] info = s.getStoreInfo().split(", ");
	List<String> imgs = (List) request.getAttribute("imgs");
	StoreSeat ss = (StoreSeat) request.getAttribute("storeSeat");
	String[] seatCheck = ss.getSeatNum().split(",");
	String[] useCheck = ss.getSeatCheck().split(",");
	int seatNum = 1;
	
	List<Comment> list = (List)request.getAttribute("list");
%>
<!-- 댓글 css -->
	<link rel="stylesheet"`
	href="<%=request.getContextPath()%>/css/storeComment/storeComment.css?ver=2" type="text/css" />
<!-- 댓글 css -->



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
					<sapn class="storeInfoBasicMinor"> 
					<%
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
				<%for(int i=1; i<=ss.getRow(); i++) {%>
					<tr>
						<%
						for(int n=1; n<=ss.getCol(); n++) {
							if(seatCheck[(seatNum-1)].equals("0")) {
						%>
								<td></td>
						<%	} else { %>
								<td class="emptySeat seat"></td>
						<% 	}
							seatNum++;
						} 
						%>
					</tr>
				<%} %>
			</table>

		</center>
	</div>


	<!-- 댓글 -->
	<div id="comment">
	

					<th>댓글</th>

				</tr>
				<tr>
					<form
						action="<%=request.getContextPath()%>/comment/storeCommentInsert"
						method="post">
						<td><input type="text" id="commentInput" name="userComment" /></td>
						<td><button id="commentBtn" name="commentBtn"
								onclick="fn_comment_btn">등록</button></td>
						<td><input type="hidden" name="commentWriter"
							value="<%=loginMember != null ? loginMember.getUserId() : ""%>" />
						<td><input type="hidden" name="commentLevel" value="1" />
				</tr>
				</form>
</div>
	<script>
//댓글 스크립트 
 $(function(){
		$("#commentInput").focus(function(){
			if(<%=loginMember == null%>){
				alert("로그인 후 이용하세요");
				$("#userId").focus();
			}
		});
	});
</script>
		<table class="userTable">
				<%
					if (list != null && !list.isEmpty()) {
						for (Comment c : list) {
							if (c.getCommentLevel() == 1) {
				%>
			
					<tr>
						<sub><%=c.getCommentWriter()%></sub>

								<div style="text-align: right;">
									<sub><%=c.getCommentDate()%></sub>
								</div> 
								<%=c.getUserComment()%>

								<div style="text-align: right;">

									<button class="recommentBtn" value="<%=c.getCommentNo()%>">답글</button>

									<form
										action="<%=request.getContextPath()%>/comment/storeCommentUpdate"
										method="post">
										<button class="recommentBtn">수정</button>
									</form>

									<form
										action="<%=request.getContextPath()%>/comment/storeCommentDelete"
										method="post">
										<button class="recommentBtn">삭제</button>
									</form>
								</div>
					</tr>

				</table>


				<%
					} else {
				%>

				<table class="storeTable">
					<tr>
						<td>
						<th><%=c.getCommentWriter()%></th>
						<td><%=c.getCommentDate()%></td>
						<br />
						<%=c.getUserComment()%>
						</td>
						<td></td>
					</tr>
					<%
						}
							} //for
						} //if
					%>
				</table>
			</table>
	


	<!-- 댓글 -->

	<!--  뎃글 페이징  -->

	<div id='pageBar'>
		<%=request.getAttribute("pageBar")%>
	</div>

	<!--  뎃글 페이징  -->




<script>

	 	$(".recommentBtn").click(function(){
				if(<%=loginMember != null%>){
					const tr=$("<tr>");
					const td=$("<td>").css({
						"display":"none","text-align":"left"
					}).attr("colspan",2);
					const form=$("<form>").attr({
						"action":"<%=request.getContextPath()%>/comment/storeCommentInsert",
						"method":"post"
					});
 </script>

	<!-- 댓글 -->

	<div id="reservation">
		<p id="storeReInfo">매장 : <strong><%=s.getStoreName() 
		%></strong></p>
		<p id="userInfo">
			ID : <strong><%=loginMember.getUserId() %></strong>&nbsp;&nbsp;&nbsp;&nbsp;
			빈캐시 : <strong><%=loginMember.getCash() %></strong>
		</p>
		<div id="underLine"></div>
		
		<center>
			<div id="reView">
				<span>이용시간 선택</span>
				<span>예약내역 확인</span>
				<span>예약</span>
			</div>
			
			<div class="reStep">
				<div class="reStepTitle">
					<span>이용시간 선택</span>
					<span id="reStepMini">(1시간당 1,000원)</span>
				</div>
				<div class="reStepContent">
					<label>
						<input type="radio" name="time" value="1시간">1시간
					</label>
					<label>
						<input type="radio" name="time" value="2시간">2시간
					</label>
					<label>
						<input type="radio" name="time" value="3시간">3시간
					</label>
					<label>
						<input type="radio" name="time" id="ectTime"><input id="ectNum" type="text" style="padding:0; margin:0; display:inline-block; width:30px; text-align:center;">시간
					</label>
				</div>
			</div>
			<%-- <div class="reStep">
				<div class="reStepTitle">
					예약내역확인
				</div>
				<div id="reStepCon">
					<span>매장 : <%=s.getStoreName() %></span>
					<span>매장주소 : <%=s.getStoreAddress() %></span>
					<span>이용시간 : 0 시간</span>
					<span>이용금액 : <%=1*1000 %>원</span>
					<span>결재 후 빈캐시 : 0 빈캐시</span>
				</div>
			</div>
		</center> --%>
		
		<div id="reBtns">
			<button id="reCan">취소</button>
			<button id="reOk">다음</button>
		</div>
	</div>

	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1f47dde95b7968538cbb3ad2e6003356&libraries=services"></script>
	<script>
	  //즐겨찾기
	    $("#favorite").click(function () {
	    	
	    	
	    	if(<%=loginMember!=null%>) {
	    		
		    	var check;
		    	
		        if($("#favorite").attr("src") == "image/favorite-empty.png"){
		        	check = true;
		        } else {
		        	check = false;
		        }
		
		        
		        $.ajax({
		        	url:"<%=request.getContextPath()%>/favorite",
		        	type:"post",
		        	data:{"check":check, "userId":"<%=loginMember!=null?loginMember.getUserId():""%>", "storeId":"<%=s.getStoreId()%>"},
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
	    	} else {
	    		alert("로그인을 해주세요!");
	    	}
    })
    
    
    // 지도 API
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

</div>

<script src="js/store.js?ver=1"></script>
<script type="text/javascript" src="js/totalSearch.js"></script>
</body>
</html>