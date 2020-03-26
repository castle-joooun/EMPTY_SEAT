<%@ include file="storeBaseTop.jsp"%>

<%@ page import="java.util.List"%>
<%@ page import="com.empty.search.model.vo.Store"%>

<%
	List<Store> list = (List) request.getAttribute("storeList");
	String[] tags = (String[]) request.getAttribute("storeTag");
	String str = "";
	for (String s : tags) {
		str += "#" + s + " ";
	}
%>

<div id="searchResult">
	<%
		if (list.isEmpty()) {
	%>
	<h2>검색된 결과가 없습니다.</h2>
	<%
		} else {
			for (Store s : list) {
	%>

				<div class="result resultShadow" id="store">
					<img src="<%=s.getStoreLogo()%>>" alt="" class="resultImg">
					<div class="resultText">
						<p class="resultTitle"><%=s.getStoreName()%></p>
						<p class="resultContent"><%=s.getStoreInfo()%></p>
						<p class="resultTag"><%=s.getStoreFacility()%></p>
					</div>
				</div>
	<%
			}
		}
	%>
</div>


<%@ include file="storeBaseBottom.jsp"%>