<%-- 
    Document   : displayFruits
    Created on : Mar 3, 2025, 9:57:03 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="<%= request.getContextPath() %>/css/displayListcss.css">
    </head>
    <body>
        <h1>Fruit List</h1>

        <form action="getDisplayListFruits" method="post">
            <div class="search-container">
                <label for="search">Tìm Kiếm Fruits:</label>
                <input type="text" id="search" name="search">
                <select id="option" name="option">
                    <option value="Name">Name</option>
                    <option value="Origin">Origin</option>
                    <option value="Price">Price</option>                 
                    <option value="Country">Country</option>
                    <option value="ID">ID</option>
                </select>
                <input type="submit" value="Search">
            </div>
        </form>

        <table>
            <thead>
                <tr>
                    <th>Fruit ID</th>
                    <th>Name</th>
                    <th>Price/Kg</th>
                    <th>Stock</th>
                    <th>Origin</th>
                    <th>Country</th>
                         <th>Ảnh</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="s" items="${listFruits}">
                    <tr>
                        <td>${s.fruitsID}</td>
                        <td>${s.nameFuirt}</td>
                        <td>${s.price}</td>
                        <td>${s.stock}</td>
                        <td>${s.origin}</td>
                        <td>${s.country}</td>
                       <td><img src="${s.fruitsImageUrl.url}" alt="Fruit Image" width="130" height="100"/></td>

                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
