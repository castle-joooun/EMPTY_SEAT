<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <script>
        // 메인로고 바뀌게
        var transLogo=document.getElementById("transLogo");
        var mainLogo=document.getElementById("mainLogo");

        transLogo.addEventListener("mouseover",trans);
        function trans(){ //바뀜
            mainLogo.setAttribute("src","<%=request.getContextPath()%>/image/빈시트500-1.png");
        }
        transLogo.addEventListener("mouseleave",leave);
        function leave(){ //돌아옴
            mainLogo.setAttribute("src","<%=request.getContextPath()%>/image/빈시트500-2.png");
        }
        function nawarayo(){
       		var nwajo = window.open("nawhatdayo.jsp", "" , "width=300px, height=490px");
        	nwajo.resizeTo(515,490);
        }
        
       

    </script>



















    </body>

</html>