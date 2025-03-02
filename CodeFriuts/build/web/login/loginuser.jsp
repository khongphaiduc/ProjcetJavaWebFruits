
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <<link rel="stylesheet" href="../css/logincss.css"/>>
    </head>
    <body>
 <body>
    <h1 class="welcome-text">Welcome to Fruit Management</h1>
    <section>
        <form>
            <h1>Login</h1>
            <div class="inputbox">
                <ion-icon name="mail-outline"></ion-icon>
                Account <input type="email" required placeholder=" ">
            </div>
            <div class="inputbox">
                <ion-icon name="lock-closed-outline"></ion-icon>
                Password <input type="password" required>
            </div>
            <div class="forget">
                <label><input type="checkbox">Remember</label>
                <a href="#">Forgot Password</a>
            </div>
            <button>Login</button>
            <div class="register">
                <p>Anh đang nghiên cứu</p>
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
