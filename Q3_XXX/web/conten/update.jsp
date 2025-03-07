<%-- 
    Document   : update
    Created on : Mar 3, 2025, 1:05:23 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cập Nhật Sản Phẩm</title>
        <link rel="stylesheet" href="<%= request.getContextPath() %>/css/updatecss.css">
    </head>
    <body>
        <div class="falling-stars"></div>
        <div class="container">
            <h1>Update Fruit Information</h1>

            <form method="get" action="updateFruits">
                <div class="form-group">
                    <label for="fruitID">Fruit ID:</label>
                    <input type="text" id="fruitID" name="idFruits" value="${f.fruitsID}" required>
                    <br>
                    <br>
                    <button type="submit" class="">Find</button>
                </div>
            </form>
            <form action="updateFruits" method="post">
                <input type="text" name="id" value="${f.fruitsID}" style="display: none">
                <div class="form-group">
                    <label for="name">Name:</label>
                    <input type="text" id="name" name="name" value="${f.nameFuirt}" required>
                </div>
                <div class="form-group">
                    <label for="price">Price:</label>
                    <input type="number" id="price" name="price" step="0.01"  value="${f.price}"required>
                </div>
                <div class="form-group">
                    <label for="stock">Stock:</label>
                    <input type="number" id="stock" name="stock"  value="${f.stock}" required>
                </div>
                <div class="form-group">
                    <label for="origin">Origin:</label>
                    <input type="text" id="origin" name="origin"  value="${f.origin}" required>
                </div>
                <div class="form-group">
                    <label for="country">Country:</label>
                    <input type="text" id="country" name="country"  value="${f.country}" required>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn">Update Fruit</button>
                </div>
               
            </form>
             <h2>${status}</h2>
        </div>
                
                
                
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
