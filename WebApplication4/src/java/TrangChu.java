
import business.Shoes;
import business.User;
import data.ShoesDB;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TrangChu extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("page", "home");
        int roleId = 0;
        String url = "/home.jsp";
        try {
            roleId = (int) session.getAttribute("roleId");
            ArrayList<Shoes> list = null;
            String message = "SẢN PHẨM HOT";
            try {
                list = new ShoesDB().getAllShoes();
            } catch (Exception ex) {
                Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
            }
            session.setAttribute("list", list);
            session.setAttribute("message", message);
            if (roleId == 1) {
                url = "/Admin/Manage.jsp";
            }
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);
        } catch (Exception e) {

            ArrayList<Shoes> list = null;
            String message = "SẢN PHẨM HOT";
            try {
                list = new ShoesDB().getAllShoes();
            } catch (Exception ex) {
                Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
            }
            session.setAttribute("list", list);
            //  session.setAttribute("user", new User());
            session.setAttribute("message", message);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);
        }
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
