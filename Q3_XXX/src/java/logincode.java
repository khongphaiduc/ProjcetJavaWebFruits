
import dal.DBContext;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.SQLException;
import org.apache.jasper.tagplugins.jstl.core.ForEach;

public class logincode extends DBContext {

    // lấy list account
    public List<Account> getListAccount() {
        List<Account> list = new ArrayList<>();
        try {
            String sql = "SELECT [AccountID]\n"
                    + "      ,[AccountMail]\n"
                    + "  FROM [dbo].[Accounts]";

            PreparedStatement push = connection.prepareStatement(sql);
            ResultSet rs = push.executeQuery();
            while (rs.next()) {
                list.add(new Account(rs.getInt("AccountID"), rs.getString("AccountMail")));
            }
        } catch (Exception s) {
            s.printStackTrace();
        }
        return list;
    }

    // lấy password  bằng acccount
    public String getPassword(String account) {
        String password = "";
        try {
            String sql = "select s2.KeyPassword\n"
                    + "from [dbo].[Accounts]s1\n"
                    + "join [dbo].[Passwords]s2 on s1.AccountID=s2.AccountID\n"
                    + "Where s1.AccountMail=?";
            PreparedStatement push = connection.prepareStatement(sql);
            push.setString(1, account);
            ResultSet rs = push.executeQuery();
            while (rs.next()) {
                password = rs.getString("KeyPassword");
            }
        } catch (Exception s) {

        }

        return password;
    }

    // check đầu vào
    public boolean login(String account, String pasword) {
        logincode o = new logincode();
        List<Account> list = o.getListAccount();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getAccountMail().equals(account)) {

                String realPassword = o.getPassword(account);
                if (realPassword.equals(pasword)) {
                    return true;
                }

            }
        }
        return false;
    }

    
    // phương thức đăng ký tài khoảng mới 
    public boolean signUp(String account, String password) {
        logincode o = new logincode();
        int sizeRoot = o.getListAccount().size();
        int sizeNew = 0;
        String sql = "{CALL InsertNewAccount(?, ?)}";              // gọi procedure
        try (CallableStatement stmt = connection.prepareCall(sql)) {
            stmt.setString(1, account);
            stmt.setString(2, password);
            stmt.executeUpdate();

            sizeNew = o.getListAccount().size();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (sizeNew == sizeRoot) ? false : true;
    }

    public static void main(String[] args) {
        logincode o = new logincode();
       List<Account> list = o.getListAccount();
       

       
       
    }
}
