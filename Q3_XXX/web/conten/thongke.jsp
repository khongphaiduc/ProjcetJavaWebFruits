<%-- 
    Document   : thongke
    Created on : Mar 7, 2025, 12:01:09 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Báo Cáo Thống Kê Doanh Thu và Sản Phẩm</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/thongkecss.css">
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<body>

    
 
    <div>
        <!--        phần header-->
        <%@include file="../header/header.jsp" %> 
    </div>       

    <div class="container">
        <section class="revenue-report">
            <h3>${thoitiet} </h3> 
            <h2>Doanh Thu 7 Ngày Gần Nhất</h2>
            <div class="chart-container">
                <canvas id="revenueChart"></canvas>
            </div>
        </section>
        <section class="today-report">
            <h2 style="color: #ffffff">Doanh Thu và Doanh Số Hôm Nay</h2>
            <h2 style="color: #ffffff">${today}</h2>
            <div class="today-details">
                <p class="highlight">Tổng Doanh Thu: <span>${danhthu}</span></p>
                <p class="highlight">Tổng Sản Phẩm Bán Được: <span>${sosanpham}</span></p>
            </div>

            <% if (request.getAttribute("danhthu") == null) { %>
            <p style="color:red;">Không có dữ liệu doanh thu</p>
            <% } %>
        </section>

        <section class="product-section">
            <h1 style="color: #28a745">Top 4 sản phẩm bán chạy nhất tại của hàng</h1>
            <div class="product-container">
                <c:forEach var="s" items="${listTop}">                  
                    <div class="product">
                    <img src="${s. pathURL}" alt="Product 1">
                    <h2> Tên Sản Phẩm ${s.nameFuirt}</h2>
                    <p>Giá Bán : ${s.price} Nghìn VND</p>                  
                </div>
              </c:forEach>             
            </div>
        </section>
    </div>
            <%@include file="../conten/footer.jsp" %>
    <script>
        const ctx = document.getElementById('revenueChart').getContext('2d');
        const revenueChart = new Chart(ctx, {
            type: 'bar',
            data: {
                labels: ['Ngày 1', 'Ngày 2', 'Now'],
                datasets: [{
                        label: 'Doanh Thu (VND)',
                        data: [${listProfix.get(0)},${listProfix.get(1)},${listProfix.get(2)}],
                        backgroundColor: 'rgba(75, 192, 192, 0.6)',
                        borderColor: 'rgba(75, 192, 192, 1)',
                        borderWidth: 1
                    }]
            },
            options: {
                responsive: true,
                maintainAspectRatio: false,
                scales: {
                    y: {
                        beginAtZero: true
                    }
                }
            }
        });
    </script>

</body>
</html>