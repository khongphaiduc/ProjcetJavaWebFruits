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
    </head>
    <body>
        <div class="container">
            <h1>Product Management</h1>
            <div class="form-container">
                <div class="form-box-column">
                    <div class="form-box" >
                        <h2>Add Product by ID</h2>
                        <form action="orders" method="get">
                            <label for="productID">Product ID:</label>
                            <input type="text" id="productID" name="productID" required>
                            <label for="productQuantity">Quantity:</label>
                            <input type="number" id="productQuantity" name="productQuantity"  required>
                            <button type="submit">Add Product</button>
                        </form>
                    </div>
                    <div class="form-box">
                        <h2>Delete Product by ID</h2>
                        <form action="orders" method="get">
                            <label for="deleteProductID">Product ID:</label>
                            <input type="text" id="deleteProductID" name="indexRemove" required >
                            <button type="submit">Delete Product</button>
                        </form>
                    </div>
                </div>
                <div class="form-box-large">
                    <h2>Product Information</h2>
                    <form>
                        <label for="customerName">Customer Name:</label>
                        <input type="text" id="customerName" name="customerName" class="short-input" required>
                        <label for="customerPhone">Customer Phone:</label>
                        <input type="text" id="customerPhone" name="customerPhone" class="short-input" required>
                    </form>

                    <table>
                        <thead>
                            <tr>
                                <th>Product ID</th>
                                <th>Product Name</th>                    
                                <th>Price</th>
                                <th>Origin</th>
                                <th>Country</th>
                                <th>Quantity</th>
                                <th>Sum</th>
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
                </div>
            </div>
            <div class="checkout-container">
                <button class="checkout-button">Proceed to Checkout</button>
            </div>
        </div>
    </body>
</html>