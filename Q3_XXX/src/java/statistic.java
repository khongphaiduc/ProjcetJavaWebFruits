/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import com.oracle.wls.shaded.org.apache.bcel.generic.AALOAD;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import model.Fruits;

@WebServlet(urlPatterns = {"/statistic"})
public class statistic extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet statistic</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet statistic at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getThongKe tk = new getThongKe();
        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")); // định dang ngày tháng 
        String doanhthu = tk.getStatisticOfMoney(today);             // lấy doanh thu hôm nay 
        String sanphambanra = tk.getStatisticNumberOfProduct(today); // lấy số lượng sản phấm bán ra hôm nay 
        request.setAttribute("danhthu", doanhthu);
        request.setAttribute("sosanpham", sanphambanra);
        request.setAttribute("today", today);
        mywearther weather = new mywearther();
        String thoitiet = weather.getweather();                    // gọi API  lấy thời tiết hiện tại        
        request.setAttribute("thoitiet", thoitiet);
        getThongKe st = new getThongKe();
        
        List<Fruits> listTops =st.getTop4BestSaleOfFruit(); // lấy 4 sản phẩm bán chạy nhất
        request.setAttribute("listTops", listTops);

        List<Double> listProfix = st.getStatisticProfix();  // lấy doanh thu của quán trong 7 ngày 
        request.setAttribute("listProfix", listProfix);

        request.getRequestDispatcher("/conten/thongke.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getThongKe tk = new getThongKe();
        String doanhthu = tk.getStatisticOfMoney("2025-3-6");
        String sanphambanra = tk.getStatisticNumberOfProduct("2025-3-6");
        request.setAttribute("danhthu", doanhthu);
        request.setAttribute("sosanpham", sanphambanra);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
