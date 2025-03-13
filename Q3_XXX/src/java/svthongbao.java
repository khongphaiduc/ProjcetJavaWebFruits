


import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Fruits;


@WebServlet(urlPatterns={"/svthongbao"})
public class svthongbao extends HttpServlet {
   
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet svthongbao</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet svthongbao at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        getThongKe st = new getThongKe();
        
        List<Fruits>listStatus =st.getStatusStore();
         List<Fruits> productStock =st.getProductStock();
           request.setAttribute("listStatus", listStatus);
           request.setAttribute("productStock", productStock);
         request.getRequestDispatcher("/conten/thongbao.jsp").forward(request, response);
          
    } 

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
