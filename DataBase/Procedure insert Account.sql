CREATE PROCEDURE InsertNewAccount
    @AccountMail NVARCHAR(50),
    @KeyPassword NVARCHAR(30)
AS
BEGIN
    SET NOCOUNT ON;

    DECLARE @NewAccountID INT;

    -- Kiểm tra xem email đã tồn tại chưa
    IF EXISTS (SELECT 1 FROM Accounts WHERE AccountMail = @AccountMail)
    BEGIN
        PRINT N'Email đã tồn tại!';
        RETURN;
    END

    -- Thêm tài khoản mới vào bảng Accounts
    INSERT INTO Accounts (AccountMail)
    VALUES (@AccountMail);

    -- Lấy AccountID vừa được tạo
    SET @NewAccountID = SCOPE_IDENTITY();

    -- Thêm mật khẩu vào bảng Passwords
    INSERT INTO Passwords (AccountID, KeyPassword)
    VALUES (@NewAccountID, @KeyPassword);

    PRINT N'Tài khoản đã được tạo thành công!';
END;

EXEC InsertNewAccount @AccountMail = 'ptrungduc1011@gmail.com', @KeyPassword = '123';
