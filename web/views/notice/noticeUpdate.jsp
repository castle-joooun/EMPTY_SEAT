<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.empty.notice.model.vo.Notice"%>
<%
   Notice n = (Notice) request.getAttribute("Notice");
%>


<%@ include file="/views/common/header.jsp"%>
   
<section>
   <h2>공지사항 수정</h2>
   <form action="<%=request.getContextPath()%>/notice/noticeUpdateEnd" method="post">
      <table>
         <tr>
            <th>번 호</th>
            <td><input type="text" name="no" value="<%=n.getNoticeNo() %>" size="50" readonly></td>
         </tr>
         <tr>
            <th>제 목</th>
            <td><input type="text" name="title" value="<%=n.getNoticeTitle() %>" size="50"></td>
         </tr>
         <tr>
            <th>작성일</th>
            <td><input type="text" name="time" value="<%=n.getNoticeDate() %>" size="50" readonly></td>
         </tr>
         <tr>
            <th>내 용</th>
            <td><textarea name="content" cols=51 rows=10 required><%=n.getNoticeContent() %></textarea></td>
         </tr>
      </table>
      <input type="submit" value="수정">
      <button type="button" onclick="location.href='<%=request.getContextPath()%>/notice'">취소</button>
   </form>
</section>