<%-- 
    Document   : content1
    Created on : Mar 2, 2025, 11:09:33 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="<%= request.getContextPath() %>/css/csscontent1.css">
    </head>
    <body>
        <%@include file="../conten/header.jsp" %>
        <audio autoplay loop>
            <source src="<%= request.getContextPath() %>/audio/bai1.mp3" type="audio/mp3">
        </audio>
       
        <%@include file="../conten/footer.jsp" %>>

    </body>
</body>

</html>
