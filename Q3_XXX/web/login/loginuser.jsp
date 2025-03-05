<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="<%= request.getContextPath() %>/css/logincss.css">
    </head>
    <body>
        <h1 class="welcome-text">Welcome to Fruit Management</h1>
        <section>
            <form action="homes" method="post">
                <h1>Login</h1>
                <div class="inputbox">
                 
                    Account <input type="email" required placeholder=" " name="account">
                </div>
                <div class="inputbox">
                  
                    Password <input type="password" required name="password">
                </div>
                <button type="submit">Login</button>
                <br>
                <br>
                <button type="button" onclick="window.open('<%= request.getContextPath() %>/sigup', '_blank')">Đăng Ký</button>
                <div class="register">
                    <p style="color: red">${status}</p>
                </div>
            </form>
        </section>
        <script>
            document.addEventListener('DOMContentLoaded', () => {
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
    </body>
</html>