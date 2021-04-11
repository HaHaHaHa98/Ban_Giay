import business.Shoes;
import data.ShoesDB;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

 
public class QuanLySanPham extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         request.setCharacterEncoding("UTF-8");
        HttpSession session=request.getSession();
        session.setAttribute("roleId", 1);
        String url = "/Admin/Manage.jsp";
        String action = request.getParameter("action");
        String id = request.getParameter("id");
        Shoes shoes = null;
        try {
            shoes = new ShoesDB().getProductByID(id);
        } catch (Exception ex) {
            Logger.getLogger(HienThiSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("shoes", shoes);
        if (action.equals("edit")) {
            url = "/Admin/Update_Confirm.jsp";
        } else if (action.equals("delete")) {
            url = "/Admin/Delete_Confirm.jsp";
        } else if (action.equals("add")) {
            url = "/Admin/Update_Confirm.jsp";
        }
        request.setAttribute("id", id);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
