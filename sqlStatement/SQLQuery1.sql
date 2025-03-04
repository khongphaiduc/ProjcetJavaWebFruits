CREATE PROCEDURE InsertFruitAndImage
    @Name NVARCHAR(255),
    @Price DECIMAL(10,2),
    @Stock INT,
    @Origin NVARCHAR(255),
    @Country NVARCHAR(255),
    @ImageURL NVARCHAR(500)
AS
BEGIN
    SET NOCOUNT ON;

    DECLARE @NewFruitID INT;

    -- Chèn dữ liệu vào bảng Fruits, FruitID tự động tăng
    INSERT INTO Fruits (Name, Price, Stock, Origin, Country)
    VALUES (@Name, @Price, @Stock, @Origin, @Country);

    -- Lấy FruitID vừa được tạo
    SET @NewFruitID = SCOPE_IDENTITY();

    -- Chèn dữ liệu vào bảng FruitImages với FruitID vừa lấy được
    INSERT INTO FruitImages (FruitID, ImageURL)
    VALUES (@NewFruitID, @ImageURL);
END;

drop procedure InsertFruitAndImage

EXEC InsertFruitAndImage 
    @Name = 'Apple', 
    @Price = 10.5, 
    @Stock = 100, 
    @Origin = 'USA', 
    @Country = 'United States', 
    @ImageURL = 'test';


select *
from [dbo].[FruitImages]s1 
join [dbo].[Fruits]s2 on s1.FruitID=s2.FruitID

delete from [dbo].[Fruits] where [FruitID] <=122

delete from [dbo].[FruitImages]  where [FruitID]  <=122