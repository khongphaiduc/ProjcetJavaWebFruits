<%-- 
    Document   : thongbao
    Created on : Mar 8, 2025, 2:53:50 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thông Báo</title>
        <link rel="stylesheet" href="<%= request.getContextPath() %>/css/thongbaocss.css">
    </head>
    <body>
        <header class="main-header">
            <h1>Thông Báo Tình Trạng Sản Phẩm Trong Kho</h1>
        </header>
        <div class="container">
            <section class="notification-section">
                <h2>Trạng Thái Kho Hàng Hiện Tại</h2>
                <table class="product-table">
                    <thead>
                        <tr> <th>ID Sản Phẩm</th>
                            <th>Tên Sản Phẩm</th>
                            <th>Số Lượng Còn Lại</th>
                            <th>Trạng Thái</th>
                        </tr>
                    </thead>
                    <tbody>
                        <!--                                    list sản phẩm sắp hết hàng-->
                        <c:forEach var="s" items="${listStatus}">

                            <tr>
                                <td>${s.fruitsID}</td>
                                <td>${s.nameFuirt}</td>
                                <td>${s.stock}</td>
                                <td class="low-stock">Sắp Hết</td>
                            </tr>
                        </c:forEach>

                        <!--                                  list sản phầm hết hàng-->
                        <c:forEach var="s" items="${productStock}">

                            <tr>
                                 <td>${s.fruitsID}</td>
                                <td>${s.nameFuirt}</td>
                                <td style="color: #f44336">${s.stock}</td>
                                <td class="low-stock" style="color: red">Hết Hàng</td>
                            </tr>
                        </c:forEach>


                    </tbody>
                </table>
            </section>
        </div>
    </body>
</html>
