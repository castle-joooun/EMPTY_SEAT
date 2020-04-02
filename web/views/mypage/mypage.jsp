<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=57f292cf81a06c030ca86c61e79b1b56"></script>
	
	
<body>
	<h3 class="mypagemain1">MY PAGE</h3>
	<h3 class="mypagemain2">USE</h3>
	
	
	<div class="alldiv clearl">
		
		<div class="myinfobox">
			<table>
				<tr>
					<td>
						개인정보
					</td>
					<td>
						<button class="crystal">수정</button>
					</td>
				</tr>
			</table>
		</div>
		
		<div>
			<div class="upzooinfobox">
				<table class="upzoomyinfo1">
					<tr>
						<td>
							아이디
						</td>
						<td colspan='3'>
							<%=loginMember.getUserId() %>
						</td>
					</tr>
					<tr>
						<td>
							이름
						</td>
						<td colspan='3'>
							<%=loginMember.getUserName() %>
						</td>
					</tr>
					<tr>
						<td>
							이메일
						</td>
						<td colspan='3'>
							<%=loginMember.getEmail() %>
						</td>
					</tr>
					<tr>
						<td>
							핸드폰
						</td>
						<td colspan='3'> 
							<%=loginMember.getPhone() %>
						</td>
					</tr>
					<tr>
						<td>
							주소
						</td>
						<td colspan='3'>
							<%=loginMember.getAddress() %>
						</td>
					</tr>
					<tr>
						<td>
							성별
						</td>
						<td colspan='3'>
							<%=loginMember.getGender() %>
						</td>
					</tr>
					<tr>
						<td>
							캐시
						</td>
						<td>
							<%=loginMember.getCash() %>
						</td>
						<td>
							원
						</td>
						<td>
							<button class="outmoney">출금</button>
						</td>
					</tr>
				</table>
			</div>
			
			
			<div class="myinfobox">
				<table>
					<tr>
						<td>
							매장정보
						</td>
						<td>
							<button class="enrollstore">매장등록</button>
						</td>
					</tr>
				</table>
				
			</div>
			<div class="upzooinfobox">
				<table class="upzoomyinfo2">
					<tr>
						<td rowspan="7" colspan="1">
							<img alt="image/퓨리.jpg" src="">
						</td>
					</tr>
					<tr>
						<td>
							매장이름
						</td>
					</tr>
					<tr>
						<td>
							매장번호
						</td>
					</tr>
					<tr>
						<td>
							매장 영업시간
						</td>
					</tr>
					<tr>
						<td>
							컴퓨터 사양
						</td>
					</tr>
					<tr>
						<td>
							매장 주소
						</td>
					</tr>
					<tr>
						<td>
							부대시설
						</td>
					</tr>
					
				</table>
			</div>
		</div>
	
	
	
	
	</div>
	
	
	
	<script>
	$(function(){
		$(".mypagemain2").click(function(){ //사용내역으로
			$.ajax({
				url:"<%=request.getContextPath()%>/mypage/myUse.do", 
				type:"get",
				dataType:"html",
				success:function(data){
					$(".alldiv").html(data);	
					$(".mypagemain2").css({"font-size":"22px"});
					$(".mypagemain1").css({"font-size":"1.17em"});
				}
			})
		});			
	});
	
	$(function(){
		$(".mypagemain1").click(function(){  //내정보로
			$.ajax({
				url:"<%=request.getContextPath()%>/mypage/myPageList",
				type:"get",
				dataType:"html",
				success:function(data){
					$(".alldiv").html(data);		
					$(".mypagemain1").css({"font-size":"22px"});
					$(".mypagemain2").css({"font-size":"1.17em"});
				}
			})
		});			
	});
	
	
	$(function(){
		$(".crystal").click(function(){  //개인정보수정으로
			$.ajax({
				url:"<%=request.getContextPath()%>/mypage/crystal.do",
				type:"get",
				dataType:"html",
				success:function(data){
					$(".alldiv").html(data);
				}
			})
		})
	})
	
	$(function(){
		$(".outmoney").click(function(){  //출금으로
			$.ajax({
				url:"<%=request.getContextPath()%>/mypage/outmoney.do",
				type:"get",
				dataType:"html",
				success:function(data){
					$(".alldiv").html(data);
				}
			})
		})
	})
	
	$(function(){
		$(".enrollstore").click(function(){  //매장등록
			$.ajax({
				url:"<%=request.getContextPath()%>/mypage/enrollstore.do",
				type:"get",
				dataType:"html",
				success:function(data){
					$(".alldiv").html(data);
				}
			})
		})
	})
	
	</script>
</body>
</html>