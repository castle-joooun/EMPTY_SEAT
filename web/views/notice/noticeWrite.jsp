<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ include file="/views/common/header.jsp" %>

   <div>
      <h2>공지사항</h2>
      <form action="<%=request.getContextPath()%>/noticeWriteEnd" method="post">
         <table>
            <tr>
               <th>제목</th>
               <td>
                  <input type="text" name="title" id="noticeTitle" size="50">
               </td>
            </tr>
            <tr>
               <th>내용</th>
               <td>
                  <textarea name="content" id="noticeContent" cols="50" rows="10" style="resize:none"></textarea>
               </td>
            </tr>
         </table>
         <input type="submit" value="작성완료" id="noticeWriteSubmit">
         <button type="button" onclick="location.href='<%=request.getContextPath()%>/notice'">취소</button>
      </form>
   </div>

</body>
</html>