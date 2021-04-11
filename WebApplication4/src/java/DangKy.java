
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

public class DangKy extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        String userName = (String) request.getParameter("userName");
        String passWord = (String) request.getParameter("passWord");
        String passWordAgain = (String) request.getParameter("passWordAgain");
        String firstName = (String) request.getParameter("firstName");
        String lastName = (String) request.getParameter("lastName");
        String address = (String) request.getParameter("address");
        String phone = (String) request.getParameter("phone");
        String url = "/home.jsp";
        if (userName.length() == 0 || new AccountDB().isExistAccount(userName)) {
            userName = "";
        }
        if (passWord.length() == 0) {
            passWord = "";
        }
        if (passWord.length() == 0) {
            passWord = "";
        }
        if (passWordAgain.length() == 0) {
            passWordAgain = "";
        }
        if (firstName.length() == 0) {
            firstName = "";
        }
        if (lastName.length() == 0) {
            lastName = "";
        }
        if (address.length() == 0) {
            address = "";
        }
        if (phone.length() == 0) {
            phone = "";
        }
        if (!passWord.equals(passWordAgain)) {
            passWord = "";
            passWordAgain = "";
        }
        if (userName.equals("") || passWord.equals("") || passWordAgain.equals("")
                || firstName.equals("") || lastName.equals("") || address.equals("") || phone.equals("")
                || new AccountDB().isExistAccount(userName)) {
            url = "/register.jsp";
            request.setAttribute("userName", userName);
            request.setAttribute("passWord", passWord);
            request.setAttribute("passWordAgain", passWordAgain);
            request.setAttribute("firstName", firstName);
            request.setAttribute("lastName", lastName);
            request.setAttribute("address", address);
            request.setAttribute("phone", phone);

        } else {
            User user = new User(userName, firstName, lastName, address, phone);
            new AccountDB().addAccount(new Account(userName, passWord, 0));
            new UserDB().addUser(userName, user);
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            session.setAttribute("roleId", 0);
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(DangKy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(DangKy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
