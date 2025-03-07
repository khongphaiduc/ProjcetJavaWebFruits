/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import model.*;
import java.time.LocalDate;

/**
 *
 * @author Admin
 */
@WebServlet(urlPatterns = {"/orders"})
public class orders extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet orders</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet orders at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        logicOrder s = new logicOrder();
        HttpSession seccion = request.getSession();
        String idproduct = request.getParameter("productID");
        String productQuantity = request.getParameter("productQuantity");
        String indexRemove = request.getParameter("indexRemove");

        List<Fruits> listOrder = (List<Fruits>) seccion.getAttribute("listOrder");
        if (listOrder == null) {
            listOrder = new ArrayList<>();
        }

        int totalMoney = 0;
      
        try {

            if (indexRemove != null) {
                int indexR = Integer.parseInt(indexRemove);
                listOrder.remove(indexR);               // xóa theo index 
                // tính tiền 
                for (int i = 0; i < listOrder.size(); i++) {
                    totalMoney += listOrder.get(i).getSum();
                }
                request.setAttribute("itemMoney", totalMoney);
                //  
                seccion.setAttribute("listOrder", listOrder);
                request.getRequestDispatcher("/conten/order.jsp").forward(request, response);

            } else {
                int number = Integer.parseInt(productQuantity);

                logicOrder v = new logicOrder();
                // kiểm tra số lượng trong kho trước khi thêm vào hóa đơn
                if (v.checkStockByID(idproduct, number)) {
                    
                    listOrder.add(s.getFruitbyID(idproduct, number)); // add vào hóa đơn

                    // tính tiền 
                    for (int i = 0; i < listOrder.size(); i++) {
                        totalMoney += listOrder.get(i).getSum();
                    }

                    request.setAttribute("itemMoney", totalMoney);
                    seccion.setAttribute("listOrder", listOrder);
                    request.getRequestDispatcher("/conten/order.jsp").forward(request, response);
                } else {
                    
                    String statusStock = "Thông báo :Số lượng sản phẩm trong kho không đủ vui lòng kiểm tra lại";
                    request.setAttribute("itemMoney", totalMoney);
                    seccion.setAttribute("listOrder", listOrder);
                    request.setAttribute("statusStock", statusStock);
                    request.getRequestDispatcher("/conten/order.jsp").forward(request, response);
                }
            }

        } catch (Exception t) {
            t.printStackTrace();
            request.getRequestDispatcher("/conten/order.jsp").forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                                                                             
        String red = request.getParameter("red");
        HttpSession session = request.getSession();

        String nameCustomer = request.getParameter("customerName");
        List<Fruits> list = (List<Fruits>) session.getAttribute("listOrder");
        String phone = request.getParameter("customerPhone");
        if (list == null) {
            String xuat = "Trạng Thái: Đơn hàng rỗng";
            request.setAttribute("xuat", xuat);
            request.getRequestDispatcher("/conten/order.jsp").forward(request, response);
            return;
        }    
        
        double totalMoney = 0;

        for (var l : list) {
            totalMoney += l.getSum();
        }

        LocalDate today = LocalDate.now();
        try {

            if (red != null) {
                session.invalidate();
                request.setAttribute("itemMoney", "0");
                request.getRequestDispatcher("/conten/order.jsp").forward(request, response);
                return;
            }

            // xử lý quá trình 
            // lấy danh sách id trong list (session)
            //lấy tổng tiền hóa đơn (totalMoney)
            // lấy số lượng từng sản phẩm
            // lấy giá của từng sản phẩm
            logicOrder a = new logicOrder();
            int idOrder = a.addOrderSInDataBase(nameCustomer, today.toString(), totalMoney); // thêm thông tin người dùng vào order

            // thêm các sản phẩm vào Table detailOrder trong  db
            for (var y : list) {
                a.addDetailOrder(idOrder, y.getFruitsID(), y.getSoluong(), y.getPrice());
            }

            createFileOrder t = new createFileOrder();
            logicOrder or = new logicOrder();

            String content = or.ghicontenhoadon(nameCustomer, phone, list);
            t.writeToFile(createFileOrder.getCurrentTime(), content); // ghi nội dung hóa đơn vào file 

            session.invalidate();     // xuất hóa đơn xong thì clean sesion 
            request.getRequestDispatcher("/conten/order.jsp").forward(request, response);

        } catch (Exception s) {
            request.getRequestDispatcher("/conten/order.jsp").forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
