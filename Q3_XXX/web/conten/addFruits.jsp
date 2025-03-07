<%-- 
    Document   : addFruits
    Created on : Mar 3, 2025, 12:23:41 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thêm Sản Phẩm</title>
        <link rel="stylesheet" href="<%= request.getContextPath() %>/css/addFruitcss.css">
    </head>
 <body>
    <div class="container">
        <h2>Thêm mới sản phẩm</h2>
        <form action="insertFruits" method="post">
            <div class="form-group">
                <label for="name">Tên sản phẩm:</label>
                <input type="text" id="name" name="name" required>
            </div>
            <div class="form-group">
                <label for="price">Giá:</label>
                <input type="text" id="price" name="price" required>
            </div>
            <div class="form-group">
                <label for="stock">Số lượng:</label>
                <input type="text" id="stock" name="stock" required>
            </div>
            <div class="form-group">
                <label for="origin">Nguồn gốc:</label>
                <input type="text" id="origin" name="origin" required>
            </div>
            <div class="form-group">
                <label for="country">Quốc gia:</label>
                <input type="text" id="country" name="country" required>
            </div>
            <button type="submit">Thêm sản phẩm</button>
        </form>
        
        <h3 style="color: yellowgreen">${status}</h3>
    </div>
</body>
</html>
