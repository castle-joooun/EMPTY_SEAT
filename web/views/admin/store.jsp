<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/admincommon/header.jsp"%>

<link rel="stylesheet" href="<%=request.getContextPath() %>/css/adminPage/store.css" type="text/css">
<section>


	<div class="list_btn_area">

		<div id="storeSubMenu">
			<ul>
				<li><a href="#"><span class="text-item">스토어 이용현황</span></a></li>
				<li><a href="<%=request.getContextPath()%>/admin/store/requestStoreList"><span class="text-item">스토어 신청현황</span></a></li>
			</ul>
		</div>
		
		
	</div>

	</div>
	<div id="primaryContent">
		<div>
			<form>
				<input type="hidden" name="cPage" value="" id="cPage"> <select
					name="numPerPage" id="numPerPage">
					<option value="10">목록 10개</option>
					<option value="20">목록 20개</option>
					<option value="30">목록 30개</option>
					<option value="50">목록 50개</option>
				</select>
			</form>
		</div>
		<table class="contentTable" summary="">

			<thead>
				<tr>
					<th class="chk"><input id="allCheck" type="checkbox" value=""></th>
					<th class="userid_">아이디</th>
					<th class="username_">신청이름</th>
					<th class="phone_">전화번호</th>
					<th class="email_" nowrap="nowrap">이메일</th>
					<th class="addr_" nowrap="nowrap">주소</th>
					<th class="enrolldate_" nowrap="nowrap">신청 일자</th>

				</tr>
			</thead>
			<tbody id="tbody">

				<%--<%for(Member m : list){ %>
                            <tr class="myarticle">
                            	<th class="chk"><input id="allCheck" type="checkbox" value=""></th>
                                <th class="userid_"><%=m.getUserId()%></th>
                                <th class="userdiv_"><%=m.isUserDiv()%></th>
                                <th class="username_"><%=m.getusername()%></th>
                                <th class="gender_"><%=m.getGender()%></th>
                                <th class="phone_"><%=m.getPhone()%></th>
                                <th class="email_" ><%=m.getEmail()%></th>
                                <th class="addr_" ><%=m.getAddress()%></th>
                                <th class="enrolldate_" ><%=m.getEnrollDate()%></th>
                                
							</tr>
                            <%} %>     --%>
			</tbody>
		</table>
		<!-- end bbsList -->

	</div>
	<!-- paging -->
	<div class="list_btn_area">
		<div class="paging"></div>
		<button></button>

	</div>




	<!-- content end -->



</section>