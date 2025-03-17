
import com.sun.jdi.connect.spi.Connection;
import dal.DBContext;
import java.util.ArrayList;
import java.util.List;
import model.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.SQLException;
import org.apache.tomcat.util.net.SocketEvent;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Admin
 */
public class mainlogic extends DBContext {

    // lấy danh sách fruits
    public List<Fruits> getListFruits() {
        List<Fruits> list = new ArrayList<>();

        try {

            String sqp = "SELECT [FruitID]\n"
                    + "      ,[Name]\n"
                    + "      ,[Price]\n"
                    + "      ,[Stock]\n"
                    + "      ,[Origin]\n"
                    + "      ,[Country]\n"
                    + "  FROM [dbo].[Fruits]";

            PreparedStatement push = connection.prepareStatement(sqp);
            ResultSet rs = push.executeQuery();

            while (rs.next()) {
                list.add(new Fruits(rs.getInt("FruitID"), rs.getString("Name"), rs.getDouble("Price"), rs.getInt("Stock"), rs.getString("Origin"), rs.getString("Country")));
            }
            return list;
        } catch (Exception s) {
            return null;
        }
    }

    //tìm kiếm theo id
    public List<Fruits> searchbyID(int id) {
        List<Fruits> list = new ArrayList<>();
        mainlogic v = new mainlogic();
        try {

            String sqp = "SELECT [FruitID]\n"
                    + "      ,[Name]\n"
                    + "      ,[Price]\n"
                    + "      ,[Stock]\n"
                    + "      ,[Origin]\n"
                    + "      ,[Country]\n"
                    + "  FROM [dbo].[Fruits]\n"
                    + "\n"
                    + "  where [FruitID]=?";

            PreparedStatement push = connection.prepareStatement(sqp);
            push.setInt(1, id);
            ResultSet rs = push.executeQuery();

            while (rs.next()) {
                list.add(new Fruits(rs.getInt("FruitID"), rs.getString("Name"), rs.getDouble("Price"), rs.getInt("Stock"), rs.getString("Origin"), rs.getString("Country"), v.getFruitImageByID(rs.getInt("FruitID"))));
            }
            return list;
        } catch (Exception s) {
            return null;
        }
    }

    //tìm kiếm theo tên
    public List<Fruits> searchbyName(String name) {
        mainlogic s = new mainlogic();
        List<Fruits> list = new ArrayList<>();

        try {
            String sql = "SELECT [FruitID], [Name], [Price], [Stock], [Origin], [Country] "
                    + "FROM [dbo].[Fruits] "
                    + "WHERE [Name] LIKE ?";

            PreparedStatement push = connection.prepareStatement(sql);
            push.setString(1, "%" + name + "%"); // Thêm % vào tham số name trước khi truyền vào

            ResultSet rs = push.executeQuery();
            while (rs.next()) {
                list.add(new Fruits(
                        rs.getInt("FruitID"),
                        rs.getString("Name"),
                        rs.getDouble("Price"),
                        rs.getInt("Stock"),
                        rs.getString("Origin"),
                        rs.getString("Country"),
                        s.getFruitImageByID(rs.getInt("FruitID"))
                ));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //tìm theo giá
    public List<Fruits> searchbyPrice(String price) {
        List<Fruits> list = new ArrayList<>();
        mainlogic s = new mainlogic();
        try {
            String sql = "SELECT [FruitID]\n"
                    + "      ,[Name]\n"
                    + "      ,[Price]\n"
                    + "      ,[Stock]\n"
                    + "      ,[Origin]\n"
                    + "      ,[Country]\n"
                    + "  FROM [dbo].[Fruits]\n"
                    + "  where Price like ?";

            PreparedStatement push = connection.prepareStatement(sql);
            push.setString(1, "%" + price + "%"); // Thêm % vào tham số name trước khi truyền vào

            ResultSet rs = push.executeQuery();
            while (rs.next()) {
                list.add(new Fruits(
                        rs.getInt("FruitID"),
                        rs.getString("Name"),
                        rs.getDouble("Price"),
                        rs.getInt("Stock"),
                        rs.getString("Origin"),
                        rs.getString("Country"),
                        s.getFruitImageByID(rs.getInt("FruitID"))
                ));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //tìm theo tỉnh
    public List<Fruits> searchbyOrigin(String origin) {
        List<Fruits> list = new ArrayList<>();
        mainlogic s = new mainlogic();
        try {
            String sql = "SELECT [FruitID]\n"
                    + "      ,[Name]\n"
                    + "      ,[Price]\n"
                    + "      ,[Stock]\n"
                    + "      ,[Origin]\n"
                    + "      ,[Country]\n"
                    + "  FROM [dbo].[Fruits]\n"
                    + "WHERE [Origin] LIKE ?";

            PreparedStatement push = connection.prepareStatement(sql);
            push.setString(1, "%" + origin + "%"); // Thêm % vào tham số name trước khi truyền vào

            ResultSet rs = push.executeQuery();
            while (rs.next()) {
                list.add(new Fruits(
                        rs.getInt("FruitID"),
                        rs.getString("Name"),
                        rs.getDouble("Price"),
                        rs.getInt("Stock"),
                        rs.getString("Origin"),
                        rs.getString("Country"),
                        s.getFruitImageByID(rs.getInt("FruitID"))
                ));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //tìm theo đất nước 
    public List<Fruits> searchbyCountry(String country) {
        List<Fruits> list = new ArrayList<>();
        mainlogic s = new mainlogic();
        try {
            String sql = "SELECT [FruitID]\n"
                    + "      ,[Name]\n"
                    + "      ,[Price]\n"
                    + "      ,[Stock]\n"
                    + "      ,[Origin]\n"
                    + "      ,[Country]\n"
                    + "  FROM [dbo].[Fruits]\n"
                    + "WHERE [Country] LIKE ?";

            PreparedStatement push = connection.prepareStatement(sql);
            push.setString(1, "%" + country + "%"); // Thêm % vào tham số name trước khi truyền vào

            ResultSet rs = push.executeQuery();
            while (rs.next()) {
                list.add(new Fruits(
                        rs.getInt("FruitID"),
                        rs.getString("Name"),
                        rs.getDouble("Price"),
                        rs.getInt("Stock"),
                        rs.getString("Origin"),
                        rs.getString("Country"),
                        s.getFruitImageByID(rs.getInt("FruitID"))
                ));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // thêm sản quản mới 
    public void insert(String name, String price, String stock, String origin, String country) {
        logincode o = new logincode();
        int sizeRoot = o.getListAccount().size();
        int sizeNew = 0;
        String sql = "{CALL InsertFruit(?,?,?,?,?)}";     // gọi procedure
        try (CallableStatement push = connection.prepareCall(sql)) {
            push.setString(1, name);
            push.setString(2, price);
            push.setString(3, stock);
            push.setString(4, origin);
            push.setString(5, country);
            push.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // kiểm tra xem sản phẩm có tồn tại chưa 
    public boolean checkExsit(String name) {
        mainlogic s = new mainlogic();
        List<Fruits> list = s.getListFruits();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getNameFuirt().equalsIgnoreCase(name)) {
                return false;
            }
        }
        return true;
    }

    // lấy Fruit bằng id
    public Fruits getFruitbyID(String id) {

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
                return new Fruits(rs.getInt("FruitID"), rs.getString("Name"), rs.getDouble("Price"), rs.getInt("Stock"), rs.getString("Origin"), rs.getString("Country"));
            }

        } catch (Exception t) {

        }
        return null;
    }

// cập  nhật fuirt
    public boolean updateFruit(String fruitID, String name, String price, String stock, String origin, String country) {
        String sql = "UPDATE Fruits SET Name = ?, Price = ?, Stock = ?, Origin = ?, Country = ? WHERE FruitID = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, price);
            stmt.setString(3, stock);
            stmt.setString(4, origin);
            stmt.setString(5, country);
            stmt.setString(6, fruitID);

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //xóa Fuit
    public void removeFruit(String idFruits) {

        try {

            String sql1 = "delete from [dbo].[FruitImages] where [FruitID] = ?";
            PreparedStatement push1 = connection.prepareStatement(sql1);
            push1.setString(1, idFruits);
            push1.executeUpdate();
            String sql2 = "delete from [dbo].[Fruits] where [FruitID] =?";
            PreparedStatement push2 = connection.prepareStatement(sql2);
            push2.setString(1, idFruits);
            push2.executeUpdate();
            System.out.println("Xóa Thành Công");
        } catch (Exception s) {

        }

    }

    // chèn quả với url ảnh bằng sử dụng procedure
    public void insertFruitAndImage(String name, String price, String stock, String origin, String country, String imageUrl) {
        String sql = "{CALL InsertFruitAndImage(?, ?, ?, ?, ?, ?)}"; // Gọi Stored Procedure

        try {
            CallableStatement push = connection.prepareCall(sql);

            // Gán tham số cho Procedure
            push.setString(1, name);
            push.setString(2, price);
            push.setString(3, stock);
            push.setString(4, origin);
            push.setString(5, country);
            push.setString(6, imageUrl);

            // Thực thi Stored Procedure
            push.execute();
            System.out.println("✅ Dữ liệu đã được chèn thành công!");

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("❌ Lỗi khi chèn dữ liệu: " + e.getMessage());
        }
    }

    // lấy danh sách fruits với url ảnh
    public List<Fruits> getListFruitAndUrlImage() {
        List<Fruits> list = new ArrayList<>();
        mainlogic s = new mainlogic();
        try {

            String sqp = "SELECT [FruitID]\n"
                    + "      ,[Name]\n"
                    + "      ,[Price]\n"
                    + "      ,[Stock]\n"
                    + "      ,[Origin]\n"
                    + "      ,[Country]\n"
                    + "  FROM [dbo].[Fruits]";

            PreparedStatement push = connection.prepareStatement(sqp);
            ResultSet rs = push.executeQuery();

            while (rs.next()) {
                list.add(new Fruits(rs.getInt("FruitID"), rs.getString("Name"), rs.getDouble("Price"), rs.getInt("Stock"), rs.getString("Origin"), rs.getString("Country"), s.getFruitImageByID(rs.getInt("FruitID"))));
            }
            return list;
        } catch (SQLException g) {
            return null;
        }
    }

    public FruitImage getFruitImageByID(int id) {

        String sql = "SELECT [FruitID]\n"
                + "      ,[ImageURL]\n"
                + "  FROM [dbo].[FruitImages]\n"
                + "  where [FruitID]=?";

        try {

            PreparedStatement push = connection.prepareStatement(sql);
            push.setInt(1, id);
            ResultSet rs = push.executeQuery();
            while (rs.next()) {
                return new FruitImage(rs.getString("ImageURL"));
            }
            return null;
        } catch (Exception s) {
            s.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        mainlogic s = new mainlogic();

//        System.out.println(s.getFruitImageByID(119));
//          
//        s.insertFruitAndImage("Cherry", "1", "2", "vietnam", "vietnam", "imageFruits/cherry.jpg");
//        s.insertFruitAndImage("Cam", "1", "2", "Vietnam", "Vietnam", "imageFruits/cam.jpg");
//        s.insertFruitAndImage("Chanh Vàng", "2", "3", "Vietnam", "Vietnam", "imageFruits/chanhVang.jpg");
//        s.insertFruitAndImage("Cherry", "3", "5", "USA", "USA", "imageFruits/cherry.jpg");

       

        s.removeFruit("132");
    }

}
