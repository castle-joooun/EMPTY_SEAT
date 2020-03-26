<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% int col = Integer.parseInt(request.getParameter("seatCol"));%>
<% int row = Integer.parseInt(request.getParameter("seatRow"));%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <style>
        #addSeat td {
            position: relative;
            width: 80px;
            height: 80px;
            text-align: center;
            border: solid 1px black;
        }

        #seatInfoText{
            position: relative;
            text-align: center;
            padding: 0;
            margin: 0 0 10px 0;
            display: block;
        }

        #viewSeat p {
            padding: 0;
            margin: 5px;
        }

        .seats{
            border: solid 1px blue;
        }

        .empty{
            border: 0;
        }
    </style>
    <script src="js/jquery-3.4.1.min.js"></script>
</head>

<body>

	<form action=""> <!-- DB에 보내버리기 -->
        <div id="viewSeat">
            <p id="seatInfoText">
                <input type="submit" value="저장하기">
            </p>
            <table id="addSeat">
                <%for(int i=1; i<=row; i++) { %>
                    <tr>
                    <%for(int j=1; j<=col; j++) {%>
                        <td>
                            <select name="seat" class="seat">
                                <option value="0">자리/복도 선택</option>
                                <option value="1">자리
                                <option value="2">복도
                        </td>
                    <%} %>
                    </tr>
                <%} %>
            </table>
        </div>
    </form>
    
    <script>
	    $(".seat").change(function() {
            var num = $(this).val();
            
            switch(num) {
                case "1": 
                	$(this).parent().css({"border":"solid 1px black", "backgroundColor":"blue"}); 
                	break;
                case "2": 
                	$(this).parent().css({"border":"solid 1px lightgray"}); 
                	$(this).css({
                		"display":"0"
                	})
                	break;
            }
        })
    </script>

</body>

</html>