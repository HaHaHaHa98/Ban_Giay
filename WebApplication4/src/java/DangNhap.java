
import business.Account;
import business.User;
import data.AccountDB;
import data.UserDB;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DangNhap extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = "/TrangChu";
        String action = (String) request.getParameter("action");
        if (action.equals("login")) {
            String userName = (String) request.getParameter("userName");
            String passWord = (String) request.getParameter("passWord");
            User user = null;
            int roleId = 0;
            if (userName.length() != 0 && passWord.length() != 0) {
                try {
                    user = new UserDB().getUser(userName, passWord);
                } catch (Exception ex) {
                    Logger.getLogger(DangNhap.class.getName()).log(Level.SEVERE, null, ex);
                }
                url = "/TrangChu";
                try {
                    roleId = new AccountDB().getRole(userName, passWord);
                    if (roleId == 1) {
                        url = "/Admin/Manage.jsp";
                    }
                } catch (Exception ex) {
                    Logger.getLogger(DangNhap.class.getName()).log(Level.SEVERE, null, ex);
                }
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                String page = (String) session.getAttribute("page");
                if (page.equals("checkout")) {
                    url = "/Checkout";
                } else if (page.equals("history")) {
                    url = "/LichSu";
                }
            } else {
                request.setAttribute("userName", userName);
                request.setAttribute("passWord", passWord);
                url = "/login.jsp";
            }

        } else if (action.equals("register")) {
            request.setAttribute("userName", "");
            request.setAttribute("passWord", "");
            request.setAttribute("passWordAgain", "");
            request.setAttribute("firstName", "");
            request.setAttribute("lastName", "");
            request.setAttribute("address", "");
            request.setAttribute("phone", "");
            url = "/register.jsp";
        }
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
