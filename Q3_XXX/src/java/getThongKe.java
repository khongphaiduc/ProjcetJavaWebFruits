
import java.sql.*;
import dal.DBContext;
import java.util.ArrayList;
import java.util.List;
import model.Fruits;

public class getThongKe extends DBContext {

    // thông kê doanh thu của 1 ngày cụ thể
    public String getStatisticOfMoney(String date) {

        try {
            String sql = "  select sum(s1.TotalAmount) as money\n"
                    + "  from [dbo].[Orders]s1\n"
                    + "  where s1.OrderDate=?";
            PreparedStatement push = connection.prepareStatement(sql);
            push.setString(1, date);

            ResultSet rs = push.executeQuery();

            while (rs.next()) {
                return rs.getString("money");
            }
            return "0";

        } catch (Exception s) {
            s.printStackTrace();
        }
        return "0";
    }

    // thống kê số lượng sản phẩm đã bán ra trong 1 ngày cụ thể 
    public String getStatisticNumberOfProduct(String date) {

        try {
            String sql = "select sum(s2.Quantity) as sumproduct\n"
                    + "from [dbo].[Orders] s1 \n"
                    + "join [dbo].[OrderDetails]s2 on s1.OrderID=s2.OrderID\n"
                    + "where s1.OrderDate=?";
            PreparedStatement push = connection.prepareStatement(sql);
            push.setString(1, date);

            ResultSet rs = push.executeQuery();

            while (rs.next()) {
                return rs.getString("sumproduct");
            }
            return "0";

        } catch (Exception s) {
            s.printStackTrace();
        }
        return "0";
    }

    // lấy id của  top 9 sản phẩm bán chạy nhất
    public List<String> getIDTop9ProductBanChayNhat() {
        List<String> list = new ArrayList<>();
        try {
            String sql = "select Top(4)  s1.Name,s1.FruitID,s1.Price,s1.Country , sum(s2.Quantity) as Soluongdaban \n"
                    + "from [dbo].[Fruits]s1\n"
                    + "join [dbo].[OrderDetails]s2 on s1.FruitID=s2.FruitID\n"
                    + "group by  s1.Name,s1.FruitID,s1.Price,s1.Country\n"
                    + "order by Soluongdaban desc";

            PreparedStatement push = connection.prepareStatement(sql);

            ResultSet rs = push.executeQuery();

            while (rs.next()) {
                list.add(rs.getString("FruitID"));
            }
            return list;
        } catch (Exception s) {

        }
        return null;
    }

    // lấy path image theo id
    public Fruits getTopFruit(String id) {
        String sql = "select s1.FruitID,s1.Name,s1.Price,s2.ImageURL\n"
                + "from [dbo].[Fruits]s1 \n"
                + "join [dbo].[FruitImages]s2  on s1.FruitID=s2.FruitID\n"
                + "where s1.FruitID=?";
        try {
            PreparedStatement push = connection.prepareCall(sql);
            push.setString(1, id);
            ResultSet rs = push.executeQuery();

            while (rs.next()) {
                return new Fruits(rs.getInt("FruitID"), rs.getString("Name"), rs.getDouble("price"), rs.getString("ImageURL"));
            }

        } catch (Exception c) {
            c.printStackTrace();

        }
        return null;
    }

    // kết hợp 2 phương thức trên để trả về list đối tượng Fruit có số lượng bán nhiều nhất và có path image
    public List<Fruits> getIntoTOp9Product(List<String> listID) {
        getThongKe t = new getThongKe();
        List<Fruits> list = new ArrayList<>();
        for (int i = 0; i < listID.size(); i++) {
            list.add(t.getTopFruit(listID.get(i)));
        }
        return list;
    }

    // thống kê doanh thu 3 ngày gần nhất 
    public List<Double> getStatisticProfix() {
        List<Double> list = new ArrayList<>();
        try {
            String sql = "select top(3) s1.OrderDate ,sum(s1.TotalAmount) as totalDay\n"
                    + "from [dbo].[Orders] s1 \n"
                    + "group by s1.OrderDate\n"
                    + "order by s1.OrderDate asc";

            PreparedStatement push = connection.prepareStatement(sql);

            ResultSet rs = push.executeQuery();

            while (rs.next()) {
                list.add(rs.getDouble("totalDay"));
            }

            return list;
        } catch (Exception v) {

        }
        return null;
    }

    public static void main(String[] args) {
        getThongKe s = new getThongKe();

        System.out.println(s.getStatisticProfix());
    }

}
