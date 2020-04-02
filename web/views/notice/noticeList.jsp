<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,java.util.*,com.empty.notice.model.vo.Notice"%>
<%
   List<Notice> list = (List) request.getAttribute("list");
%>
<%@ include file="/views/common/header.jsp"%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/notice/noticeList.css" type="text/css">
<center>
<section>
   <div id="listDiv">
      <p id="noticeHead">공지사항</p>
      <%
         if(loginMember != null && loginMember.getUserId().equals("admin")){
      %>
      <div>
         <button type="button" id="noticeWriteBtn" onclick="location.replace('<%=request.getContextPath()%>/noticeWrite')">공지사항 작성</button>
      </div>
      <%} %>
      <hr class="hr">
      <table class="noticeListTbl">
         <thead>
            <tr>
               <th></th>
               <th>제 목</th>
               <th>작성자</th>
               <th>등록일</th>
               <th>조회수</th>
            </tr> 
         </thead>
         <tbody>
            <%
               if(list.isEmpty()){
            %>
            <tr>
               <td>등록된 내용이 없습니다.</td>
            </tr>
            <%
               }else{
                  for(Notice n : list){
            %>
            <tr>
               <td style="color:blue">[공 지]</td>
               <td>
                  <span class="innerContent" onclick="link(<%=n.getNoticeNo()%>)">
                     <%=n.getNoticeTitle() %>
                     <form action="<%=request.getContextPath()%>/noitce/noticeContent">
                        <input type="hidden" name="no" value="<%=n.getNoticeNo() %>">
                     </form>
                  </span>
               </td>
               <td>admin</td>
               <td><%=n.getNoticeDate() %></td>
               <td><%=n.getNoticeCount() %></td>
            </tr>
            <%
                  }
               }
            %>
         </tbody>
      </table>
         <form action="<%=request.getContextPath()%>/notice/noticeView" id="linkF">
            <input type="hidden" name="no">
         </form>
      <hr class="hr">
      <center>
         <div id="pageBar">
            <%=request.getAttribute("pageBar")%>
         </div>
      </center>
   </div>
</section>
</center>
      <script>
      function link(no){
         $("#linkF>input").val(no);
         $("#linkF").submit();
      }
   </script>
</body>
</html>