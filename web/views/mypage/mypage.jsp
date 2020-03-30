<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
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
					</tr>
					<tr>
						<td>
							닉네임
						</td>
					</tr>
					<tr>
						<td>
							핸드폰
						</td>
					</tr>
					<tr>
						<td>
							주소
						</td>
					</tr>
				</table>
			</div>
			
			
			<div class="myinfobox">
				매장정보
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
	
		<div class="comeonyo">
		
		
		
		
		
		
		
		</div>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	</div>
	
	
	
	<script>
	$(function(){
		$(".mypagemain2").click(function(){
			$.ajax({
				url:"<%=request.getContextPath()%>/mypage/myUse.do", 
				type:"get",
				dataType:"html",
				success:function(data){
					$(".alldiv").html(data);	
					$(".mypagemain2").css({"font-size":"30px"});
					$(".mypagemain1").css({"font-size":"1.17em"});
				}
			})
		});			
	});
	
	$(function(){
		$(".mypagemain1").click(function(){
			$.ajax({
				url:"<%=request.getContextPath()%>/mypage/myPageList",
				type:"get",
				dataType:"html",
				success:function(data){
					$(".alldiv").html(data);		
					$(".mypagemain1").css({"font-size":"30px"});
					$(".mypagemain2").css({"font-size":"1.17em"});
				}
			})
		});			
	});
	</script>
</body>
</html>