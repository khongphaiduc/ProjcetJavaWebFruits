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
        try {
            if ( indexRemove!=null) {
                int indexR = Integer.parseInt(indexRemove);
                listOrder.remove(indexR);               // xóa theo index 
              
                seccion.setAttribute("listOrder", listOrder);
                request.getRequestDispatcher("/conten/order.jsp").forward(request, response);
                return;
            }else{
                int number = Integer.parseInt(productQuantity);
                listOrder.add(s.getFruitbyID(idproduct, number)); // add vào hóa đơn

                seccion.setAttribute("listOrder", listOrder);
                request.getRequestDispatcher("/conten/order.jsp").forward(request, response);
                return ;
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
        processRequest(request, response);
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
