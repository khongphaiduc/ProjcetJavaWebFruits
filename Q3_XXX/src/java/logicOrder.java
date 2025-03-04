
import dal.DBContext;
import model.Fruits;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Admin
 */
public class logicOrder extends DBContext {

    // tính tiền
    public double sumMoney(int soluong, double price) {
        return soluong * price;
    }

    // thêm vào hóa đơn
    public Fruits getFruitbyID(String id, int number) {
        logicOrder o = new logicOrder();
        List<Fruits> list = new ArrayList<>();
        String sql = "SELECT [FruitID]\n"
                + "      ,[Name]\n"
                + "      ,[Price]\n"
                + "      ,[Stock]\n"
                + "      ,[Origin]\n"
                + "      ,[Country]\n"
                + "  FROM [dbo].[Fruits]\n"
                + "  where [FruitID]=?";

        try {
            PreparedStatement push = connection.prepareStatement(sql);
            push.setString(1, id);
            ResultSet rs = push.executeQuery();
            while (rs.next()) {
                return new Fruits(rs.getInt("FruitID"), rs.getString("Name"), rs.getDouble("Price"), number, rs.getString("Origin"), rs.getString("Country"), o.sumMoney(number, rs.getDouble("Price")));
            }

        } catch (Exception t) {
            t.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        logicOrder s = new logicOrder();

        System.out.println(s.getFruitbyID("2", 21));

    }
}
