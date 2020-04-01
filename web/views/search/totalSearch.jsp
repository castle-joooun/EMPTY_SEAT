<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="totalSearchHeader.jsp"%>
<%@ page import="java.util.List"%>
<%@ page import="com.empty.search.model.vo.Store"%>
<%@ page import="java.util.ArrayList" %>

<!--------------------------------------------------------------------------------------------------->
<%
	String keyword = request.getParameter("searchBox");


%>
<body>

	<!-- 오른쪽 실시간 검색결과 -->
	<div id="rank">
		<p
			style="font-size: 17px; font-weight: 600; color: #5e64b1; margin: 0px; padding: 10px;">실시간
			게임 검색 순위</p>
		<p style="margin: 0px; padding: 0px 0 5px 10px;">1. 리그오브레전드</p>
		<p style="margin: 0px; padding: 0px 0 5px 10px;">2. 메이플스토리</p>
		<p style="margin: 0px; padding: 0px 0 5px 10px;">3. 피파온라인4</p>
		<p style="margin: 0px; padding: 0px 0 5px 10px;">4. 서든어택</p>
		<p style="margin: 0px; padding: 0px 0 5px 10px;">5. 오버워치</p>
		<p style="margin: 0px; padding: 0px 0 5px 10px;">6. 배틀그라운드</p>
		<p style="margin: 0px; padding: 0px 0 5px 10px;">7. 로스트아크</p>
		<p style="margin: 0px; padding: 0px 0 5px 10px;">8. 던전앤파이터</p>
		<p style="margin: 0px; padding: 0px 0 5px 10px;">9. 라트라이더</p>
		<p style="margin: 0px; padding: 0px 0 5px 10px;">10. 테트리스</p>
	</div>

	<%
		List<Store> list = (List) request.getAttribute("list");
		int i=1;
	%>
		<div id="searchResult">
			<%
				if (list.isEmpty()) {
			%>
			<h2>검색된 결과가 없습니다.</h2>
			<%
				} else {
					for (Store s : list) {
						String[] tags = s.getStoreFacility().split(", ");
			%>
	
			<form action="store" method="post" onclick="submit()">
				<div class="result resultShadow" id="store" onclick="location.href='<%=request.getContextPath()%>/store'">
					<img src="image/퓨리.jpg" alt="" class="resultImg">
					<div class="resultText">
						<p class="resultTitle"><%=s.getStoreName()%></p>
						<p class="resultContent"><%=s.getStoreInfo()%></p>
						<p class="resultTag">
							<input type="hidden" name="storeId" value="<%=s.getStoreId()%>">
							<input type="hidden" name="storeName" value="<%=s.getStoreName()%>">
							<input type="hidden" name="userId" value="ooze"> <!-- 유저아이디 수정하기!!!!!!!!!!!!!!!!!11 -->
							<input type="hidden" name="searchText" value="<%=request.getAttribute("searchText") %>">
							<%for(String str : tags) {%>
								#<%=str %> 
							<%} %>
						</p>
					</div>
				</div>
			</form>
			<%
					}
				}
			%>
		</div>

	<script type="text/javascript" src="js/totalSearch.js?ver=0"></script>
	<script>
		$(function(){
			requestData(1,10,<%=keyword%>);
		})
		function requestData(cPage,numPerPage,keyword){
			$.ajax({
				url:"<%=request.getContextPath()%>/totalSearch/ajaxPaging",
				dataType : "json",
				type:"get",
				data:{"cPage":cPage,"numPerPage":numPerPage,"keyword":keyword},
				success:function(data){
					
				},
				error:function(request,status,error){
					if (request.status == 404)
						console.log("페이지를 찾을 수 없습니다.");
						$(".paging").html("페이지를 찾을 수 없습니다.");
				}
				}
			})
		}
	
	
	</script>
	
	
	
</body>

</html>