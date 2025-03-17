<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cập Nhật Sản Phẩm</title>
        <link rel="stylesheet" href="<%= request.getContextPath() %>/css/updatecss.css">
        <style>
            body {
                font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
                background: linear-gradient(135deg, #f3ec78, #af4261);
                margin: 0;
                padding: 0;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
            }

            .container {
                width: 50%;
                background-color: rgba(255, 255, 255, 0.9);
                padding: 40px;
                box-shadow: 0 0 30px rgba(0, 0, 0, 0.2);
                border-radius: 15px;
                transition: transform 0.3s;
            }

            h1 {
                text-align: center;
                color: #333;
                font-size: 2.5em;
                margin-bottom: 20px;
            }

            .form-group {
                margin-bottom: 20px;
            }

            label {
                display: block;
                margin-bottom: 8px;
                color: #333;
                font-weight: bold;
            }

            input[type="text"],
            input[type="number"] {
                width: 100%;
                padding: 12px;
                border: 2px solid #ccc;
                border-radius: 5px;
                box-sizing: border-box;
            }

            .btn-group {
                display: flex;
                justify-content: space-between;
            }

            .btn {
                width: 48%;
                padding: 15px;
                background-color: #5cb85c;
                border: none;
                border-radius: 5px;
                color: #fff;
                font-size: 1.2em;
                cursor: pointer;
                transition: background-color 0.3s;
            }

            .btn-delete {
                background-color: red;
            }

            .btn:hover {
                background-color: #4cae4c;
            }

            .btn-delete:hover {
                background-color: darkred;
            }

            /* Modal */
            .modal {
                display: none;
                position: fixed;
                z-index: 1;
                left: 0;
                top: 0;
                width: 100%;
                height: 100%;
                background-color: rgba(0,0,0,0.5);
            }

            .modal-content {
                background-color: white;
                margin: 15% auto;
                padding: 20px;
                border: 1px solid #888;
                width: 30%;
                text-align: center;
                border-radius: 8px;
            }

            .modal button {
                margin: 10px;
                padding: 8px 15px;
                cursor: pointer;
            }

            .btn-cancel {
                background-color: gray;
                color: white;
            }
        </style>
    </head>

    <body>
        <div class="container">
            <h1>Update Fruit Information</h1>

            <form method="get" action="updateFruits">
                <div class="form-group">
                    <label for="fruitID">Fruit ID:</label>
                    <input type="text" id="fruitID" name="idFruits" value="${f.fruitsID}" required>
                    <br><br>
                    <button type="submit" class="btn">Find</button>
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
                    <input type="number" id="price" name="price" step="0.01" value="${f.price}" required>
                </div>
                <div class="form-group">
                    <label for="stock">Stock:</label>
                    <input type="number" id="stock" name="stock" value="${f.stock}" required>
                </div>
                <div class="form-group">
                    <label for="origin">Origin:</label>
                    <input type="text" id="origin" name="origin" value="${f.origin}" required>
                </div>
                <div class="form-group">
                    <label for="country">Country:</label>
                    <input type="text" id="country" name="country" value="${f.country}" required>
                </div>
                <div class="form-group btn-group">
                    <button type="submit" class="btn">Update Fruit</button>                  
                </div>
            </form>

            <!-- Nút Xóa -->
            <button onclick="openModal()" class="btn btn-delete">Delete</button>

            <!-- Modal xác nhận -->
            <div id="deleteModal" class="modal">
                <div class="modal-content">
                    <p>Bạn có chắc chắn muốn xóa không?</p>
                    <form action="updateFruits" method="post">
                        <input type="hidden" name="id" value="${f.fruitsID}">
                        <input type="text" name="xoa" value="xoa" style="display: none">
                        <button type="submit" class="btn-delete">Xác nhận</button>
                        <button type="button" class="btn-cancel" onclick="closeModal()">Hủy</button>
                    </form>
                </div>
            </div>
          
        </div>

        <script>
            function openModal() {
                document.getElementById("deleteModal").style.display = "block";
            }

            function closeModal() {
                document.getElementById("deleteModal").style.display = "none";
            }

            // Function to show a message
            function showMessage(message) {
                alert(message);
            }

            // Check if there is any status message from the server
            window.onload = function() {
                var statusMessage = "${status}";
                if (statusMessage) {
                    showMessage(statusMessage);
                }
            };
        </script>
    </body>
</html>