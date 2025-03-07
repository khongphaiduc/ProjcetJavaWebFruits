SELECT TOP (1000) [OrderID]
      ,[CustomerName]
      ,[OrderDate]
      ,[TotalAmount]
  FROM [FruitManagers].[dbo].[Orders]


  select sum(s1.TotalAmount) as money
  from [dbo].[Orders]s1
  where s1.OrderDate='2025-06-03'
