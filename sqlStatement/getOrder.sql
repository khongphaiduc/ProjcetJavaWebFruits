-- tìm hóa đơn theo ngày 
select *
from [dbo].[Fruits]s1
join [dbo].[OrderDetails]s2 on s1.FruitID=s2.FruitID
join [dbo].[Orders] s3 on s2.OrderID=s3.OrderID



-- tìm giá tiền của hóa đơn đó
SELECT o.OrderID, 
       o.CustomerName, 
       o.OrderDate, 
       o.TotalAmount
	   
FROM Orders o
JOIN OrderDetails od ON o.OrderID = od.OrderID
GROUP BY o.OrderID, o.CustomerName, o.OrderDate,o.TotalAmount;
