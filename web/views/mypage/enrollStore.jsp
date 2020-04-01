<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ page
	import="com.empty.member.model.vo.Member,com.empty.common.listener.SessionCheckListener"%>
<%
	Member loginMember = (Member) session.getAttribute("loginMember");
%>		
		<div class="myinfobox">
			<table>
				<tr>
					<td>
						매장등록
					</td>
				</tr>
			</table>
		</div>
		
			<div class="upzooinfobox">
				<table class="upzoomyinfo1">
					<tr>
						<td>
							매장이름
						</td>
						<td>
							<input type="text" id="storeName">
						</td>
					</tr>
					<tr>
						<td>
							매장 전화번호
						</td>
						<td>
							<input type="text" id="storePhone">
						</td>
					</tr>
					<tr>
						<td>
							영업시간
						</td>
						<td>
							<input type="time" id="storeTimestart">
							~
							<input type="time" id="storeTimeclose">
						</td>
					</tr>
					<tr>
						<td>
							매장정보
						</td>
						<td>
						 	<input type="text" id="storeInfo">
						</td>
					</tr>
					<tr>
						<td>
							부대시설
						</td>
						<td>
							<label for="storeFacirity1">
								매점<input type="checkbox" name="storeFacirity" id="storeFacirity1" value="매점">
							</label>
							<label for="storeFacirity2">
								카페<input type="checkbox" name="storeFacirity" id="storeFacirity2" value="카페">
							</label>
							<label for="storeFacirity3">
								난방시설<input type="checkbox" name="storeFacirity "id="storeFacirity3" value="난방시설">
							</label>
							<label for="storeFacirity4">
								공기청정기<input type="checkbox" name="storeFacirity" id="storeFacirity4" value="공기청정기">
							</label>
							<label for="storeFacirity5">
								흡연시설<input type="checkbox" name="storeFacirity" id="storeFacirity5" value="흡연시설">
							</label>
							<label for="storeFacirity6">
								제빙기<input type="checkbox" name="storeFacirity" id="storeFacirity6" value="제빙기">
							</label>
							<label for="storeFacirity7">
								주차시설<input type="checkbox" name="storeFacirity" id="storeFacirity7" value="주차시설">
							</label>
							
						</td>
					</tr>
					<tr>
						<td>
							위치
						</td>
						<td>
							<input type="text" id="storeAddress">
						</td>
					</tr>
					<tr>
						<td>
							시간당 금액
						</td>
						<td>
							<input type="text" id="storePrice">
						</td>
					</tr>
					<tr>
						<td>
							매장사진
						</td>
						<td>
							<input type="file" id="fileupload" multiple>
						</td>
					</tr>
				</table>
				<div id="filemiribogi">
					
			</div>
				<button id="storeEnrollbtn">등록</button>
			</div>
	<script>
			
			$(function(){
			
				
				$("#storeEnrollbtn").click(function(){
					var storeName=$("#storeName").val();
					var storePhone=$("#storePhone").val();
					var storeTimestart=$("#storeTimestart").val();
					var storeTimeclose=$("#storeTimeclose").val();
					var storeInfo=$("#storeInfo").val();
					var storeAddress=$("#storeAddress").val();
					var storePrice=$("#storePrice").val();
					var storeFacirity=[];
					var userId="<%=loginMember.getUserId()%>";
					var form=$("#frm").serialize();
					var fileupload=$("#fileupload").val();
					const fd=new FormData();
					$.each($("#fileupload")[0].files,function(i,item){
						fd.append("bs"+i,item);
					});
					
					$('input[name="storeFacirity"]:checked').each(function(i){//체크된 리스트 저장
						storeFacirity.push($(this).val());
	                });
					
					console.log(storeFacirity);
					$.ajax({
						url:"<%=request.getContextPath()%>/enroll/fileUp",
						data:fd,
						type:"post",
						processData:false,
						contentType:false,
						success:function(data){
							alert("등록 성공");
						 	$("#fileupload").val("");
						},
						error:function(r,e,m){
							alert("등록 실패");
						}
					})
					
					$.ajax({
						url:"<%=request.getContextPath()%>/enroll/store",
						data:{"storeName":storeName,
							  "storePhone":storePhone,
							  "storeTimestart":storeTimestart,
							  "storeTimeclose":storeTimeclose,
							  "storeInfo":storeInfo,
							  "storeAddress":storeAddress,
							  "storePrice":storePrice,
							  "storeFacirity":storeFacirity,
							  "userId":userId
						},
						dataType:"json",
						type:"post",
						success:function(data){
						},
					})
				});
				
				$("#fileupload").change(function(){   //미리버기
					const reader=new FileReader();
					$.each($(this)[0].files,function(i,item){
						const reader=new FileReader();
						reader.onload=function(e){
							var img=$("<img>").attr("src",e.target.result)
							.css({width:"100px",height:"100px"});
							$("#filemiribogi").append(img);
						}
						reader.readAsDataURL(item);
					});
					
				})
			})
			
			
			
			</script>
			
