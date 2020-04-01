<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ include file="/views/common/header.jsp" %>

	<div>
		<h2>이벤트</h2>
		<form action="<%=request.getContextPath()%>/eventWriteEnd" method="post">
			<table>
				<tr>
					<th>제목</th>
					<td>
						<input type="text" name="title" id="eventTitle" size="50">
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td>
						<textarea name="content" id="eventContent" cols="50" rows="10" style="resize:none"></textarea>
					</td>
				</tr>
			</table>
			<input type="submit" value="작성완료" id="eventWriteSubmit">
			<input type="reset" value="취소" id="eventReset">
		</form>
	</div>

</body>
</html>