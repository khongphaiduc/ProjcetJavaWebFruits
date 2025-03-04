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
import java.util.List;
import model.Fruits;

/**
 *
 * @author Admin
 */
@WebServlet(urlPatterns = {"/getDisplayListFruits"})
public class getDisplayListFruits extends HttpServlet {

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
            out.println("<title>Servlet getDisplayListFruits</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet getDisplayListFruits at " + request.getContextPath() + "</h1>");
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

        mainlogic s = new mainlogic();
        List<Fruits> listFruits = s.getListFruitAndUrlImage();
        request.setAttribute("listFruits", listFruits);
        request.getRequestDispatcher("/conten/displayFruits.jsp").forward(request, response);
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
        mainlogic s = new mainlogic();
        List<Fruits> listFruits = s.getListFruitAndUrlImage();
        String search = request.getParameter("search");
        String option = request.getParameter("option");
        try {
            if (option.equalsIgnoreCase("Name")) {
                listFruits = s.searchbyName(search); // theo name
                request.setAttribute("listFruits", listFruits);
            } else if (option.equalsIgnoreCase("ID")) {
                int id = Integer.parseInt(search);
                listFruits = s.searchbyID(id);   // theo id
                request.setAttribute("listFruits", listFruits);
            } else if (option.equalsIgnoreCase(" Price")) {
                listFruits = s.searchbyPrice(search); // thoe giá
                request.setAttribute("listFruits", listFruits);
            } else if (option.equalsIgnoreCase("Origin")) {
                listFruits = s.searchbyOrigin(search);  // theo tỉnh
                request.setAttribute("listFruits", listFruits);
            } else if (option.equalsIgnoreCase("Country")) {
                listFruits = s.searchbyCountry(search);
                request.setAttribute("listFruits", listFruits);
            } else {
                request.setAttribute("listFruits", listFruits);
            }
            request.getRequestDispatcher("/conten/displayFruits.jsp").forward(request, response);
        } catch (Exception c) {
            request.getRequestDispatcher("/conten/displayFruits.jsp").forward(request, response);
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
