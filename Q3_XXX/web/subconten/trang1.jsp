<%-- 
    Document   : trang1
    Created on : Mar 6, 2025, 1:00:37 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
          <link rel="stylesheet" href="<%= request.getContextPath() %>/subconten/trang1css.css">
    </head>
        <body>
        <h1 style="display: flex;justify-content:center ">Top những sản phẩm bán chạy nhất</h1>
        <div class="container">
           
            <div class="product">
             <img src="<%= request.getContextPath() %>/imageMau/mau1.jpg" alt="Product 1" style="width: 300px; height: 400px; object-fit: cover;">

                <h2>Sản Phẩm 1</h2>
                <p>Giá: 100,000 VND</p>
                <p>Mô tả: Đây là sản phẩm bán chạy nhất.</p>
            </div>
            <div class="product">
                <img src="<%= request.getContextPath() %>/imageMau/mau2.jpg" alt="Product 2" style="width: 300px; height: 400px; object-fit: cover;">
                <h2>Sản Phẩm 2</h2>
                <p>Giá: 200,000 VND</p>
                <p>Mô tả: Đây là sản phẩm bán chạy thứ hai.</p>
            </div>
            <div class="product">
                <img src="<%= request.getContextPath() %>/imageMau/gioTao1.jpg" alt="Product 2" style="width: 300px; height: 400px; object-fit: cover;">
                <h2>Sản Phẩm 3</h2>
                <p>Giá: 150,000 VND</p>
                <p>Mô tả: Đây là sản phẩm bán chạy thứ ba.</p>
            </div>
            <div class="product">
                <img src="<%= request.getContextPath() %>/imageMau/quaCam.jpg" alt="Product 2" style="width: 300px; height: 400px; object-fit: cover;">
                <h2>Sản Phẩm 4</h2>
                <p>Giá: 250,000 VND</p>
                <p>Mô tả: Đây là sản phẩm bán chạy thứ tư.</p>
            </div>
            <div class="product">
              <img src="<%= request.getContextPath() %>/imageMau/quaTao.jpg" alt="Product 2" style="width: 300px; height: 400px; object-fit: cover;">
                <h2>Sản Phẩm 5</h2>
                <p>Giá: 300,000 VND</p>
                <p>Mô tả: Đây là sản phẩm bán chạy thứ năm.</p>
            </div>
            <div class="product">
               <img src="<%= request.getContextPath() %>/imageMau/dau.jpg" alt="Product 2" style="width: 300px; height: 400px; object-fit: cover;">
                <h2>Sản Phẩm 6</h2>
                <p>Giá: 350,000 VND</p>
                <p>Mô tả: Đây là sản phẩm bán chạy thứ sáu.</p>
            </div>
            <div class="product">
                 <img src="imageFruits/hongDeo.jpg" alt="Product 2">
                <h2>Sản Phẩm 7</h2>
                <p>Giá: 400,000 VND</p>
                <p>Mô tả: Đây là sản phẩm bán chạy thứ bảy.</p>
            </div>
            <div class="product">
            <img src="<%= request.getContextPath() %>/imageFruits/hongDeo.jpg" alt="Product 2">

                <h2>Sản Phẩm 8</h2>
                <p>Giá: 450,000 VND</p>
                <p>Mô tả: Đây là sản phẩm bán chạy thứ tám.</p>
            </div>
            <div class="product">
                <img src="imageFruits/sauRieng.jpg" alt="Product 2">
                <h2>Sản Phẩm 9</h2>
                <p>Giá: 450,000 VND</p>
                <p>Mô tả: Đây là sản phẩm bán chạy thứ tám.</p>
            </div>
        </div>
    </body>
</html>
