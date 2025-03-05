<%-- 
    Document   : header
    Created on : Mar 3, 2025, 1:26:32 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Fresh Fruits Store</title>
        <link rel="stylesheet" href="<%= request.getContextPath() %>/css/headercss.css">
    </head>
<body>
    <div class="marquee" style="height: 30px">
        <p>Chào mừng đến với project quảng lý bán trái cây với đội ngũ dev một mình tao!</p>
    </div>
    <br>

    <header class="main-header">
        <div class="container">
            <h1 style="color: white;font-family: cursive" class="store-name">Fresh Fruits Store</h1>      
            <nav class="main-nav">
                <ul>
                    <li> <button type="button" onclick="window.open('<%= request.getContextPath() %>/sigup', '_blank')">Trang Chủ</button></li>
                    <li> <button type="button" onclick="window.open('<%= request.getContextPath() %>/getDisplayListFruits', '_blank')">List Sản Phẩm</button></li>
                    <li> <button type="button" onclick="window.open('<%= request.getContextPath() %>/insertFruits', '_blank')">Nhập Hàng</button></li>
                    <li> <button type="button" onclick="window.open('<%= request.getContextPath() %>/updateFruits', '_blank')">Update</button></li>
                    <li> <button type="button" onclick="window.open('<%= request.getContextPath() %>/orders', '_blank')">Hóa Đơn</button></li>
                </ul>
            </nav>
        </div>
    </header>
</body>
</html>
