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
                    <p class="highlight">Tổng doanh thu đến thời điểm hiện tại : <span>${danhthu}</span></p>
                    <p class="highlight">Tổng doanh số đạt được tính thới thời điểm hiện tại : <span>${sosanpham}</span></p>
                </div>

                <% if (request.getAttribute("danhthu") == null) { %>
                <p style="color:red;">Không có dữ liệu doanh thu</p>
                <% } %>
            </section>
        </div>                     

        <script>
            const ctx = document.getElementById('revenueChart').getContext('2d');
            const revenueChart = new Chart(ctx, {
                type: 'bar',
                data: {
                    labels: ['Ngày 1', 'Ngày 2', 'Ngày 3', 'Ngày 4', 'Ngày 5', 'Ngày 6', 'Hôm nay'],
                    datasets: [{
                            label: 'Doanh Thu (VND)',
                            data: [${listProfix.get(6)},${listProfix.get(5)},${listProfix.get(4)},${listProfix.get(3)},${listProfix.get(2)},${listProfix.get(1)},${listProfix.get(0)}],
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