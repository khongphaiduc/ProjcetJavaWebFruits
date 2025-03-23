<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Top 8 Sản Phẩm Phổ Biến</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .card {
            border-radius: 15px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            transition: transform 0.3s ease;
        }
        .card:hover {
            transform: translateY(-5px);
        }
        .card-img-top {
            width: 100%;
            height: 200px;
            object-fit: cover;
            border-top-left-radius: 15px;
            border-top-right-radius: 15px;
        }
        .card-body {
            background-color: white;
            border-bottom-left-radius: 15px;
            border-bottom-right-radius: 15px;
        }
        .title {
            color: #007bff;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <div class="container mt-4">
        <h1 class="text-center mb-4 text-primary">Top 8 Sản Phẩm Phổ Biến Nhất</h1>
        <div class="row">
            <div class="col-md-3 mb-4">
                <div class="card h-100 text-center">
                    <img src="${listTops[0].pathURL}" class="card-img-top" alt="${listTops[0].nameFuirt}">
                    <div class="card-body">
                        <h5 class="card-title title">Top 1: ${listTops[0].nameFuirt}</h5>
                        <p class="card-text">Giá Bán: ${listTops[0].price} Nghìn VND</p>
                        <p class="card-text">Tổng lượng bán ra: ${listTops[0].quantity} KG</p>
                    </div>
                </div>
            </div>
            <div class="col-md-3 mb-4">
                <div class="card h-100 text-center">
                    <img src="${listTops[1].pathURL}" class="card-img-top" alt="${listTops[1].nameFuirt}">
                    <div class="card-body">
                        <h5 class="card-title title">Top 2: ${listTops[1].nameFuirt}</h5>
                        <p class="card-text">Giá Bán: ${listTops[1].price} Nghìn VND</p>
                        <p class="card-text">Tổng lượng bán ra: ${listTops[1].quantity} KG</p>
                    </div>
                </div>
            </div>
            <div class="col-md-3 mb-4">
                <div class="card h-100 text-center">
                    <img src="${listTops[2].pathURL}" class="card-img-top" alt="${listTops[2].nameFuirt}">
                    <div class="card-body">
                        <h5 class="card-title title">Top 3: ${listTops[2].nameFuirt}</h5>
                        <p class="card-text">Giá Bán: ${listTops[2].price} Nghìn VND</p>
                        <p class="card-text">Tổng lượng bán ra: ${listTops[2].quantity} KG</p>
                    </div>
                </div>
            </div>
            <div class="col-md-3 mb-4">
                <div class="card h-100 text-center">
                    <img src="${listTops[3].pathURL}" class="card-img-top" alt="${listTops[3].nameFuirt}">
                    <div class="card-body">
                        <h5 class="card-title title">Top 4: ${listTops[3].nameFuirt}</h5>
                        <p class="card-text">Giá Bán: ${listTops[3].price} Nghìn VND</p>
                        <p class="card-text">Tổng lượng bán ra: ${listTops[3].quantity} KG</p>
                    </div>
                </div>
            </div>
            <div class="col-md-3 mb-4">
                <div class="card h-100 text-center">
                    <img src="${listTops[4].pathURL}" class="card-img-top" alt="${listTops[4].nameFuirt}">
                    <div class="card-body">
                        <h5 class="card-title title">Top 5: ${listTops[4].nameFuirt}</h5>
                        <p class="card-text">Giá Bán: ${listTops[4].price} Nghìn VND</p>
                        <p class="card-text">Tổng lượng bán ra: ${listTops[4].quantity} KG</p>
                    </div>
                </div>
            </div>
            <div class="col-md-3 mb-4">
                <div class="card h-100 text-center">
                    <img src="${listTops[5].pathURL}" class="card-img-top" alt="${listTops[5].nameFuirt}">
                    <div class="card-body">
                        <h5 class="card-title title">Top 6: ${listTops[5].nameFuirt}</h5>
                        <p class="card-text">Giá Bán: ${listTops[5].price} Nghìn VND</p>
                        <p class="card-text">Tổng lượng bán ra: ${listTops[5].quantity} KG</p>
                    </div>
                </div>
            </div>
            <div class="col-md-3 mb-4">
                <div class="card h-100 text-center">
                    <img src="${listTops[6].pathURL}" class="card-img-top" alt="${listTops[6].nameFuirt}">
                    <div class="card-body">
                        <h5 class="card-title title">Top 7: ${listTops[6].nameFuirt}</h5>
                        <p class="card-text">Giá Bán: ${listTops[6].price} Nghìn VND</p>
                        <p class="card-text">Tổng lượng bán ra: ${listTops[6].quantity} KG</p>
                    </div>
                </div>
            </div>
            <div class="col-md-3 mb-4">
                <div class="card h-100 text-center">
                    <img src="${listTops[7].pathURL}" class="card-img-top" alt="${listTops[7].nameFuirt}">
                    <div class="card-body">
                        <h5 class="card-title title">Top 8: ${listTops[7].nameFuirt}</h5>
                        <p class="card-text">Giá Bán: ${listTops[7].price} Nghìn VND</p>
                        <p class="card-text">Tổng lượng bán ra: ${listTops[7].quantity} KG</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
