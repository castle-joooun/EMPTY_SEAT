<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/admincommon/header.jsp"%>
<%@ page import="com.empty.member.model.vo.Member"%>
<%@ page import="java.util.List"%>
<%
	List<Member> list = (List) request.getAttribute("list");
	int cPage =request.getParameter("cPage")==null?1:Integer.parseInt(request.getParameter("cPage"));
	int numPerPage = request.getParameter("numPerPage")==null?10:Integer.parseInt(request.getParameter("numPerPage")); 
	
%>




<section>

	<!-- 관리자 서브메뉴 -->
	<!-- <div id="adminSubMenu">
               <ul>
                   <li><a href="#"><span class="text-item">Connect Us</span></a></li>
                   <li><a href="#"><span class="text-item">회사소개</span></a></li>
                   <li><a href="#"><span class="text-item">자주묻는 질문</span></a></li>
                   <li><a href="#"><span class="text-item">Q&A</span></a></li>
                   <li><a href="#"><span class="text-item">1:1 문의</span></a></li>
               </ul>
                          
            </div> -->
	<div class="list_btn_area">
		
		


		<div class="searchDiv">
			<div>
				<form>
					<select name="searchArray" class="searchPeriod" id="">
						<optgroup label="정렬">
							<option value="uName">이름 순</option>
							<option value="lastest">최근 가입순</option>
							<option value="bestUser">최다 이용 순</option>
						</optgroup>
					</select>
				</form>
			</div>
			<div>

				<div class="selectSearchType">
					<select id="searchType" onchange="choiceType()">

						<option value="username">이름 검색</option>
						<option value="gender">성별 검색</option>
						<option value="phone">전화번호 검색</option>

					</select>
					
					<div class="searchBoxGra" id="search-username">
						<form action ="<%=request.getContextPath()%>/admin/searchMemberType">
							<input type="hidden" name="searchType" value="userName"/>
							<input class="searchBox" type="text" name="searchKeyword" placeholder="이름 검색하기" > 
							<input type="submit" value="검색" class="search-btn">
						</form>
					</div>
					<div class="searchBoxGra" id="search-gender">
						<form action ="<%=request.getContextPath()%>/admin/searchMemberType">
							<select name="searchKeyword" class="searchBox">
								<option value="남">남자</option>
								<option value="여">여자</option>
							</select>
							<input type="hidden" name="searchType" value="gender"/>
							<input type="submit" value="검색" class="search-btn">
						</form>
					</div>
					<div class="searchBoxGra" id="search-phone">
						<form action ="<%=request.getContextPath()%>/admin/searchMemberType">
							<input class="searchBox" type="text" name="searchKeyword"placeholder="전화번호 검색하기" > 
							<input type="hidden" name="searchType" value="phone"/>
							<input type="submit" value="검색" class="search-btn">
						</form>
					</div>
				</div>

			</div>
			<!-- <div class="suggest"> -->
			<!-- <input type="text" value="" name="" size="22" autocomplete="off" class="inputText"/><button type="submit" class="searchBtn">검색하기</button> -->
			<div>
				<form>
					<input type="hidden" name="cPage" value="<%=cPage%>" id="cPage">
					<select name="numPerPage" id="numPerPage">
						<option value="10" <%=numPerPage==10?"selected":"" %>>목록 10개</option>
						<option value="20"<%=numPerPage==20?"selected":"" %>>목록 20개</option>
						<option value="30"<%=numPerPage==30?"selected":"" %>>목록 30개</option>
						<option value="50"<%=numPerPage==50?"selected":"" %>>목록 50개</option>
					</select>
				</form>
			</div>
		</div>

	</div>
	<div id="primaryContent">

		<table class="contentTable" summary="">

			<thead>
				<tr>
					<th class="chk"><input id="allCheck" type="checkbox" value=""></th>
					<th class="userid_">아이디</th>
					<th class="username_">회원이름</th>
					<th class="userdiv_">회원 구별</th>
					<th class="gender_">성별</th>
					<th class="phone_">전화번호</th>
					<th class="email_" nowrap="nowrap">이메일</th>
					<th class="addr_" nowrap="nowrap">주소</th>
					<th class="enrolldate_" nowrap="nowrap">가입일자</th>

				</tr>
			</thead>
			<tbody id="tbody">

				<%--<%for(Member m : list){ %>
                            <tr class="myarticle">
                            	<th class="chk"><input id="allCheck" type="checkbox" value=""></th>
                                <th class="userid_"><%=m.getUserId()%></th>
                                <th class="userdiv_"><%=m.isUserDiv()%></th>
                                <th class="username_"><%=m.getUserName()%></th>
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
		<div class="paging">
			
		</div>
		<button></button>
	
	</div>




	<!-- content end -->
	<script>
            $(function(){
            	requestData(1,10);
		})
		$(function(){
			$("#numPerPage").change(function(){
				var cPage = $("#cPage").val();
				var numPerPage = $(this).val();
				requestData(cPage,numPerPage);
			})
		})
		function requestData(cPage,numPerPage){
            	$.ajax({
            		url:"<%=request.getContextPath()%>/admin/ajaxPaging",
				dataType : "json",
				type : "get",
				data : {"cPage" :cPage,"numPerPage" :numPerPage},
				success : function(data) {

					const attach = $("#tbody");
				
					for (let i = 0; i < data.length-1; i++) {
						const tr = $("<tr>");
						tr.append($("<td>").append($("<input>").attr({name:"dataid",type : "checkbox",class :"chkone",value : data[i]['userid']})));
						tr.append($("<td>").html(data[i]['userid']).addClass('userid_'));
						tr.append($("<td>").html(data[i]['username']).addClass('username_'));
						tr.append($("<td>").html(data[i]['userdiv']).addClass('userdiv_'));
						tr.append($("<td>").html(data[i]['gender']).addClass('gender_'));
						tr.append($("<td>").html(data[i]['phone']).addClass('phone_'));
						tr.append($("<td>").html(data[i]['email']).addClass('email_'));
						tr.append($("<td>").html(data[i]['address']).addClass('addr_'));
						tr.append($("<td>").html(data[i]['enrolldate']).addClass('enrolldate_'));
						i==0?attach.html(tr):attach.append(tr);

					}
					
					$(".paging").html(data[data.length-1]['pageBar']);
					
					
				},
				error : function(request, status, error) {
					console.log(request, status, error);
					if (request.status == 404)
						//$("#content").append(request.status);
						$("#tbody").append("페이지를 찾을 수 없습니다.");
				}

			})

            }
		
	</script>



</section>


<script type="text/javascript" src="<%=request.getContextPath()%>/js/base.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/adminPage/manageUser.js"></script>
</body>

</html>