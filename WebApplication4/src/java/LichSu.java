
import business.Order;
import business.User;
import data.OrderDB;
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

public class LichSu extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        HttpSession session = request.getSession();
          String url = "/history.jsp";
        User user = (User) session.getAttribute("user");
        if (user == null || user.getUserName() == null) {
            session.setAttribute("page", "history");
            url = "/login.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);
        } else {
            ArrayList<Order> listOrder = new OrderDB().getOrderByUser(user.getUserName());
             url = "/history.jsp";
            request.setAttribute("listOrder", listOrder);
            // }
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);

        }
    }
        @Override
        protected void doGet
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            try {
                processRequest(request, response);
            } catch (Exception ex) {
                Logger.getLogger(LichSu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        protected void doPost
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            try {
                processRequest(request, response);
            } catch (Exception ex) {
                Logger.getLogger(LichSu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
