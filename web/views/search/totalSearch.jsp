<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="totalSearchHeader.jsp"%>
<%@ page import="java.util.List"%>
<%@ page import="com.empty.search.model.vo.Store"%>
<%@ page import="java.util.ArrayList"%>

<%@ page
	import="java.io.IOException,
java.util.ArrayList,
java.util.Iterator,
org.jsoup.Jsoup,
org.jsoup.nodes.Document,
org.jsoup.nodes.Element,
org.jsoup.select.Elements"%>

<!--------------------------------------------------------------------------------------------------->

<body>

	<!-- 오른쪽 실시간 검색결과 -->
	<div id="rank">
		<p
			style="font-size: 17px; font-weight: 600; color: #5e64b1; margin: 0 0 5px 0; padding: 10px;">실시간
			게임 검색 순위</p>

		<%
			String url = "https://search.naver.com/search.naver?sm=top_hty&fbm=1&ie=utf8&query=게임검색";
			Document doc = null;

			try {
				doc = Jsoup.connect(url).get();

			} catch (IOException e) {
				e.printStackTrace();
			}

			// 가져올 태그를 가져온다
			Elements element = doc.select("ol.lst_realtime_srch");

			Iterator<Element> ie1 = element.select("em.num").iterator();
			Iterator<Element> ie2 = element.select("span.tit").iterator();

			for (int i = 0; i < 10; i++) {

				String str = ie1.next().text() + "\t" + ie2.next().text();
		%>

		<p class="rankP"><%=str%></p>

		<%
			}
		%>

	</div>

	<%
		List<Store> list = (List) request.getAttribute("list");
		int i = 1;
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
			<div class="result resultShadow" id="store"
				onclick="location.href='<%=request.getContextPath()%>/store'">
				<img src="image/퓨리.jpg" alt="" class="resultImg">
				<div class="resultText">
					<p class="resultTitle"><%=s.getStoreName()%></p>
					<p class="resultContent"><%=s.getStoreInfo()%></p>
					<p class="resultTag">
						<input type="hidden" name="storeId" value="<%=s.getStoreId()%>">
						<input type="hidden" name="storeName"
							value="<%=s.getStoreName()%>"> <input type="hidden"
							name="userId" value="ooze">
						<!-- 유저아이디 수정하기!!!!!!!!!!!!!!!!!11 -->
						<input type="hidden" name="searchText"
							value="<%=request.getAttribute("searchText")%>">
						<%
							for (String str : tags) {
						%>
						#<%=str%>
						<%
							}
						%>
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
</body>

</html>