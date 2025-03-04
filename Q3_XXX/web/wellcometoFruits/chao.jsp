<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="<%= request.getContextPath() %>/wellcometoFruits/chaocss.css">
    </head>
    <body>
        <div class="container">
            <div class="welcome-box">
                <h3 class="welcome-text">Welcome To Fruits</h3>
                <div class="intro-container">
                    <p class="intro-text left">Hãy Ăn Theo Cách Của Bạn</p>
                    <p class="intro-text right">Tính Tiền Theo Cách Của Tôi</p>
                </div>
                <button class="start-button" type="button" onclick="window.open('<%= request.getContextPath() %>/homes', '_self')">Get Started</button>
            </div>
        </div>
        <div id="stars"></div>
        <script>
            const starsContainer = document.getElementById('stars');
            for (let i = 0; i < 200; i++) {
                const star = document.createElement('div');
                star.className = 'star';
                star.style.left = `${Math.random() * 100}%`;
                star.style.animationDelay = `${Math.random() * 5}s`;
                starsContainer.appendChild(star);
            }
        </script>
    </body>
</html>