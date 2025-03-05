
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

    // ghi hóa đơn vào stringbuilder
    public String ghicontenhoadon(String name, String phone, List<Fruits> list) {
        StringBuilder order = new StringBuilder();

        order.append("--------------------------- HÓA ĐƠN THANH TOÁN Fruits ----------------------------\n");
        order.append("Mã Hóa Đơn: " + createFileOrder.getCurrentTime() + "\n");
        order.append("Tên khách hàng: " + name + "\n");
        order.append("Số điện thoại: " + phone + "\n");
        order.append("Thời gian mua hàng: " + createFileOrder.getCurrentTime() + "\n");
        order.append("__________________________________________________________________________________________________________________________________________________________\n");

        order.append(String.format("|%-20s |%-20s |%-20s |%-20s |%-20s |%-20s |%-20s |\n",
                "ID", "Product Name", "Price", "Origin", "Country", "Quantity", "Tổng"));
        order.append("__________________________________________________________________________________________________________________________________________________________\n");

        for (Fruits fruit : list) {
            order.append(String.format("|%-20s |%-20s |%-20s |%-20s |%-20s |%-20d |%-20.2f |\n",
                    fruit.getFruitsID(), fruit.getNameFuirt(), fruit.getPrice(),
                    fruit.getOrigin(), fruit.getCountry(), fruit.getSoluong(), fruit.getSum()));
        }

        order.append("__________________________________________________________________________________________________________________________________________________________\n");

        double sumMoney = 0;
        for (Fruits s : list) {
            sumMoney += s.getSum();
        }
        order.append("\n");
        order.append("\n");
        order.append("\n");
        order.append("\n");

        order.append("Tổng số tiền cần thanh toán là: " + sumMoney +"K VND"+ "\n");
        order.append("Xin cảm ơn quý khách đã ủng hộ dịch vụ của chúng tôi.\n");

        return order.toString();
    }

    public static void main(String[] args) {
        logicOrder s = new logicOrder();

        System.out.println(s.getFruitbyID("2", 21));

    }
}
