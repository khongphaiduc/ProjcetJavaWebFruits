
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

    // thống kê tổng số lượng sản phẩm đã bán ra trong 1 ngày cụ thể 
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

    // lấy top 4 sản phẩm bán chạy nhất sử dụng cte của sql 
    public List<Fruits> getTop4BestSaleOfFruit() {
        List<Fruits> list = new ArrayList<>();
        try {

            String sql = "with findTotalNumber as (\n"
                    + "select  s1.FruitID,s2.Name ,sum(s1.Quantity) as result\n"
                    + "from [dbo].[OrderDetails]s1\n"
                    + "join[dbo].[Fruits] s2 on s1.FruitID=s2.FruitID\n"
                    + "group by s1.FruitID,s2.Name\n"
                    + "),\n"
                    + "  laypathImagegsanphamdaban as (\n"
                    + "select s1.FruitID,s1.Name,s1.Price,s2.ImageURL\n"
                    + "from [dbo].[Fruits]s1\n"
                    + "join [dbo].[FruitImages]s2 on s1.FruitID=s2.FruitID\n"
                    + ")\n"
                    + "\n"
                    + "select top(4) s1.FruitID,s1.Name,s2.Price,s1.result,s2.ImageURL\n"
                    + "from  findTotalNumber s1 \n"
                    + "join  laypathImagegsanphamdaban s2 on s1.FruitID=s2.FruitID\n"
                    + "order by s1.result desc";

            PreparedStatement push = connection.prepareStatement(sql);
            ResultSet rs = push.executeQuery();
            while (rs.next()) {

                list.add(new Fruits(rs.getInt("FruitID"), rs.getString("Name"), rs.getDouble("Price"), rs.getString("ImageURL"), rs.getInt("result")));

            }
        } catch (Exception v) {
            v.printStackTrace();
        }
        return list;
    }

    // lấy các sản phầm còn số lượng dưới 10
    public List<Fruits> getStatusStore() {

        List<Fruits> list = new ArrayList<>();
        String sql = "select s1.FruitID,s1. Name,s1.Stock\n"
                + "from [dbo].[Fruits]s1\n"
                + "where s1.Stock<=10 and s1.Stock>0"
                + "order by s1.Stock asc";

        try {
            PreparedStatement push = connection.prepareStatement(sql);
            ResultSet rs = push.executeQuery();

            while (rs.next()) {
                list.add(new Fruits(rs.getInt("FruitID"), rs.getString("Name"), rs.getInt("Stock")));
            }

        } catch (Exception k) {
            k.printStackTrace();
        }

        return list;
    }

    public List<Fruits> getProductStock() {

        List<Fruits> list = new ArrayList<>();
        String sql = "select s1.FruitID,s1. Name,s1.Stock\n"
                + "from [dbo].[Fruits]s1\n"
                + "where s1.Stock=0";

        try {
            PreparedStatement push = connection.prepareStatement(sql);
            ResultSet rs = push.executeQuery();

            while (rs.next()) {
                list.add(new Fruits(rs.getInt("FruitID"), rs.getString("Name"), rs.getInt("Stock")));
            }

        } catch (Exception k) {
            k.printStackTrace();
        }

        return list;
    }

    public static void main(String[] args) {
        getThongKe s = new getThongKe();

        System.out.println(s.getProductStock());
    }

}
