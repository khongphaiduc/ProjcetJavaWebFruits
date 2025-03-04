<%-- 
    Document   : sigin
    Created on : Mar 2, 2025, 7:02:18 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
     <link rel="stylesheet" href="<%= request.getContextPath() %>/css/sigincss.css">

    </head>
  <div class="container">
        <h2>Đăng Ký Tài Khoản</h2>
        <form action="sigup" method="post">
            <label for="email">Email:</label>
            <input type="email" id="email" name="account" required>

            <label for="password">Mật khẩu:</label>
            <input type="password" id="password" name="password" required>

            <label for="confirmPassword">Nhập lại mật khẩu:</label>
            <input type="password" id="confirmPassword" name="confirmPassword" required>
              <br>
              <br>
              <button type="submit" style="background-color: #28a745">Đăng Ký</button>
            
           
<!--     chuyển hướng đến form đăng nhập nếu người dùng Ấn hủy đăng ký tài khoảng mới -->
        </form>
         <br>
         <br>
        <h2 style="color: #f06">${status}</h2>
    </div>
    <script>
        document.addEventListener('DOMContentLoaded', () => {
            const container = document.querySelector('.container');
            const body = document.body;

            function createLeaf() {
                const leaf = document.createElement('div');
                leaf.classList.add('leaf');
                leaf.style.left = Math.random() * 100 + 'vw';
                leaf.style.animationDuration = Math.random() * 3 + 2 + 's';
                body.appendChild(leaf);

                setTimeout(() => {
                    leaf.remove();
                }, 5000);
            }

            setInterval(createLeaf, 300);
        });
    </script>




</html>
