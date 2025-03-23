
import dal.DBContext;

import model.Fruits;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

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

    // thêm vào list dỏ hàng
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

    // kiểm tra số lượng trong kho trước khi thêm vào dỏ hàng 
    public boolean checkStockByID(String id, int number) {
        String sql = "SELECT Stock FROM [dbo].[Fruits] WHERE FruitID = ?";

        try {
            PreparedStatement push = connection.prepareStatement(sql);
            push.setString(1, id); // Sửa lỗi setInt thành setString

            ResultSet rs = push.executeQuery();

            if (rs.next()) { // Nếu có dữ liệu trả về
                int stock = rs.getInt("Stock");
                return stock >= number; // Kiểm tra số lượng tồn kho
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
    
    
       public int checkStockByID1(String id, int number) {
        String sql = "SELECT Stock FROM [dbo].[Fruits] WHERE FruitID = ?";

        try {
            PreparedStatement push = connection.prepareStatement(sql);
            push.setString(1, id); // Sửa lỗi setInt thành setString

            ResultSet rs = push.executeQuery();

            if (rs.next()) { // Nếu có dữ liệu trả về
                int stock = rs.getInt("Stock");
              
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
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

        order.append("Tổng số tiền cần thanh toán là: " + sumMoney + "K VND" + "\n");
        order.append("Xin cảm ơn quý khách đã ủng hộ dịch vụ của chúng tôi.\n");

        return order.toString();
    }

    // thêm thông tin khách hàng vào hóa đơn
    public int addOrderSInDataBase(String nameCustomer, String date, double totalMoney) {
        try {
            String sql = "INSERT INTO [dbo].[Orders] "
                    + "([CustomerName], [OrderDate], [TotalAmount]) "
                    + "VALUES (?,?,?)";

            // Chuẩn bị statement với tùy chọn trả về generated keys
            PreparedStatement push = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            push.setString(1, nameCustomer);
            push.setString(2, date);
            push.setDouble(3, totalMoney);

            // Thực thi câu lệnh INSERT
            push.executeUpdate();

            // Lấy kết quả generated keys
            ResultSet rs = push.getGeneratedKeys();
            int newOrderID = -1;

            if (rs.next()) {
                newOrderID = rs.getInt(1); // cột đầu tiên là ID mới
                System.out.println("Inserted Order ID: " + newOrderID);
            }

            return newOrderID;

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    //add fruits in  Detail Order 
    public void addDetailOrder(int orderID, int fruitID, int quality, double price) {

        String sql = "INSERT INTO [dbo].[OrderDetails]\n"
                + "           ([OrderID]\n"
                + "           ,[FruitID]\n"
                + "           ,[Quantity]\n"
                + "           ,[Price])\n"
                + "     VALUES\n"
                + "           (?,?,?,?)";

        try {
            PreparedStatement push = connection.prepareStatement(sql);
            push.setInt(1, orderID);
            push.setInt(2, fruitID);
            push.setInt(3, quality);
            push.setDouble(4, price);
            push.executeUpdate();
            System.out.println("thêm thành công");
        } catch (Exception t) {

        }
    }
    
    
    // update New  Stock of Product after add in order 
    public void trusoluonginTable(int id, int number) {

        try {
            int Stock = 0;
            String sql1 = "select s1.Stock\n"
                    + "from [dbo].[Fruits]s1\n"
                    + "where s1.FruitID=?";

            PreparedStatement push1 = connection.prepareStatement(sql1);
            push1.setInt(1, id);
            ResultSet rs1 = push1.executeQuery();
            
            while (rs1.next()) {
                Stock = rs1.getInt("Stock");
            }

            int NewStock = Stock - number;

            String sql2 = "update [dbo].[Fruits]\n"
                    + "set [Stock]=?\n"
                    + "where [FruitID]=?";

            PreparedStatement push2 = connection.prepareStatement(sql2);

            push2.setInt(1, NewStock);
            push2.setInt(2, id);

            push2.executeUpdate();
            System.out.println("Cạp nhật thành công");
        } catch (Exception s) {
            System.out.println("Fail");
            s.printStackTrace();
        }
    }

    public static void main(String[] args) {
        logicOrder s = new logicOrder();

//        System.out.println(s.addOrderSInDataBase("quynh anh", "2025/6/3", 9.9));
//  
              s.trusoluonginTable(123, 100);
    }
}
