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
import model.Fruits;

/**
 *
 * @author Admin
 */
@WebServlet(urlPatterns = {"/updateFruits"})
public class updateFruits extends HttpServlet {

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
            out.println("<title>Servlet updateFruits</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet updateFruits at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        mainlogic s = new mainlogic();
        String getID = request.getParameter("idFruits");
        String statuc = "";
        Fruits f = s.getFruitbyID(getID);
        request.setAttribute("f", f);
        request.setAttribute("status", statuc);
        request.getRequestDispatcher("/conten/update.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        mainlogic s = new mainlogic();
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String stock = request.getParameter("stock");
        String origin = request.getParameter("origin");
        String country = request.getParameter("country");

        if (s.updateFruit(id, name, price, stock, origin, country)) {
            String statuc = "Update thành công";
            request.setAttribute("status", statuc);
            request.getRequestDispatcher("/conten/displayFruits.jsp").forward(request, response);
        } else {
            String statuc = "Update Fail";
            request.setAttribute("status", statuc);
            request.getRequestDispatcher("/conten/update.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
