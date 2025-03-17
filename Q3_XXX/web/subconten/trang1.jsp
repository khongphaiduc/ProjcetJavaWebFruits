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
        <title>Xu Hướng</title>
        <link rel="stylesheet" href="<%= request.getContextPath() %>/subconten/trang1css.css">
    </head>
    <body>
        <div class="container">
            <h1 style="display: flex;justify-content: center">Top 8 Sản Phẩm Bán Chạy Nhất</h1>
            <div class="products">
                <div class="product">
                    <img src="${listTops[0].pathURL}" alt="Product 1">
                    <h2> Top1 : ${listTops[0].nameFuirt}</h2>
                    <p>Giá Bán : ${listTops[0].price} Nghìn VND</p>
                    <p>Tổng lượng bán ra : ${listTops[0].quantity} KG</p> 
                </div>
                <div class="product">
                    <img src="${listTops[1].pathURL}" alt="Product 1">
                    <h2> Top2 : ${listTops[1].nameFuirt}</h2>
                    <p>Giá Bán : ${listTops[1].price} Nghìn VND</p>
                    <p>Tổng lượng bán ra : ${listTops[1].quantity} KG</p>   
                </div>
                <div class="product">
                    <img src="${listTops[2].pathURL}" alt="Product 1">
                    <h2> Top3 : ${listTops[2].nameFuirt}</h2>
                    <p>Giá Bán : ${listTops[2].price} Nghìn VND</p>
                    <p>Tổng lượng bán ra : ${listTops[2].quantity} KG</p>   
                </div>
                <div class="product">
                    <img src="${listTops[3].pathURL}" alt="Product 1">
                    <h2> Top4 : ${listTops[3].nameFuirt}</h2>
                    <p>Giá Bán : ${listTops[3].price} Nghìn VND</p>
                    <p>Tổng lượng bán ra : ${listTops[3].quantity} KG</p> 
                </div>
                <div class="product">
                    <img src="${listTops[4].pathURL}" alt="Product 1">
                    <h2> Top5 : ${listTops[4].nameFuirt}</h2>
                    <p>Giá Bán : ${listTops[4].price} Nghìn VND</p>
                    <p>Tổng lượng bán ra : ${listTops[4].quantity} KG</p>   
                </div>
                <div class="product">
                   <img src="${listTops[5].pathURL}" alt="Product 1">
                        <h2> Top6 : ${listTops[5].nameFuirt}</h2>
                        <p>Giá Bán : ${listTops[5].price} Nghìn VND</p>
                        <p>Tổng lượng bán ra : ${listTops[5].quantity} KG</p>   
                </div>
                <div class="product">
                      <img src="${listTops[6].pathURL}" alt="Product 1">
                        <h2> Top7 : ${listTops[6].nameFuirt}</h2>
                        <p>Giá Bán : ${listTops[6].price} Nghìn VND</p>
                        <p>Tổng lượng bán ra : ${listTops[6].quantity} KG</p>   
                </div>
                <div class="product">
                   <img src="${listTops[7].pathURL}" alt="Product 1">
                        <h2> Top8: ${listTops[7].nameFuirt}</h2>
                        <p>Giá Bán : ${listTops[7].price} Nghìn VND</p>
                        <p>Tổng lượng bán ra : ${listTops[7].quantity} KG</p>   
                </div>
            </div>
        </div>
    </body>
</html>