<%-- 
    Document   : order
    Created on : Mar 3, 2025, 5:52:16 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="<%= request.getContextPath() %>/css/ordercss.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

        <!-- sử dụng bootstrap-->

    </head>
    <body>
        <div class="container">
            <h1>Product Management</h1>
            <div class="form-container">
                <div class="form-box-column">
                    <div class="form-box" >
                        <h2>Add Product by ID</h2>
                        <!--                        form 1 add sản phẩm -->
                        <form action="orders" method="get">
                            <label for="productID">Product ID:</label>
                            <input type="text" id="productID" name="productID" required>
                            <label for="productQuantity">Quantity:</label>
                            <input type="number" id="productQuantity" name="productQuantity"  required>
                            <button type="submit">Add Product</button>
                        </form>
                    </div>
                    <div class="form-box">
                        <h2>Delete Product by Index</h2>
                        <!--                        form 2 xóa sản phẩm theo index-->
                        <form action="orders" method="get">
                            <label for="deleteProductID">Product ID:</label>
                            <input type="text" id="deleteProductID" name="indexRemove" required >
                            <button type="submit">Delete Product</button>
                        </form>
                    </div>
                </div>
                <div class="form-box-large">
                    <h2>Product Information</h2>
                    <!--                    form 3 nhập thông tin khách hàng-->
                    <form action="orders" method="post">
                        <label for="customerName">Customer Name:</label>
                        <input type="text" id="customerName" name="customerName" class="short-input" required >               
                        <table>
                            <thead>
                                <tr>
                                    <th>Product ID</th>
                                    <th>Product Name</th>                    
                                    <th>Price</th>
                                    <th>Origin</th>
                                    <th>Country</th>
                                    <th>Quantity</th>
                                    <th>Tổng</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="s" items="${listOrder}">

                                    <tr>
                                        <td>${s.fruitsID}</td>                      
                                        <td>${s.nameFuirt}</td>
                                        <td>${s.price}</td>
                                        <td>${s.origin}</td>
                                        <td>${s.country}</td>
                                        <td>${s.soluong}</td>
                                        <td>${s.sum}</td>
                                    </tr>

                                </c:forEach>

                            </tbody>
                        </table>

                        <div class="checkout-container">               
                            <button  style="width: 200px" class="checkout-button">Xuất Hóa Đơn</button>              
                        </div>

                    </form>

                    <h4>Số Tiền Cần Thanh Toán : ${itemMoney}K VND</h4>  
                </div>
                        <h4>${statusStock}</h4>
                        <h4>${xuat}</h4>
            </div>

            <!--         form 4 xóa tất cả trong hóa đơn-->
            <form  action="orders" method="post">
                <input type="text" name="red" value="s"  style="display: none">
                <button style="width: 200px ;background-color: #f3ec78 ;color: #4cae4c ;margin-right: 20px" class="checkout-button">Clean</button>
            </form>


        </div>
    </body>

</html>