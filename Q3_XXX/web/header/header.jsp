<%-- 
    Document   : header
    Created on : Mar 6, 2025, 1:08:03 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="<%= request.getContextPath() %>/header/headercss.css">
    </head>
    <body>
        <div class="header">           
            <h1>Fresh Fruits Store</h1>
            <div class="nav">
                <button type="button">Thống Kê</button>
                <button type="button" onclick="window.open('<%= request.getContextPath() %>/topproduct', '_blank')">Xu Hướng</button>
                <button type="button" onclick="window.open('<%= request.getContextPath() %>/svthongbao', '_blank')">Thông Báo</button>
                <button type="button" onclick="window.open('<%= request.getContextPath() %>/getDisplayListFruits', '_blank')">Kho Sản Phẩm</button>
                <button type="button" onclick="window.open('<%= request.getContextPath() %>/insertFruits', '_blank')">Nhập Hàng</button>
                <button type="button" onclick="window.open('<%= request.getContextPath() %>/updateFruits', '_blank')">Update</button>
                <button type="button" onclick="window.open('<%= request.getContextPath() %>/orders', '_blank')">Hóa Đơn</button>
            </div>
        </div>
    </body>
</html>
