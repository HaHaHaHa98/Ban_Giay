
import business.Shoes;
import data.ShoesDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TimKiem extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String message = "SẢN PHẨM ";
        ArrayList<Shoes> list = null;
        String action = (String) request.getParameter("action");
        if (action.equals("phanloaidoituong")) {
            String obj = (String) request.getParameter("object");
            if (obj.equals("nam")) {
                message = message + "GIÀY NAM";
            } else if (obj.equals("nu")) {
                message = message + "GIÀY NỮ";
            }
            try {
                list = new ShoesDB().getAllShoesByObjcet(obj);
            } catch (Exception ex) {
                Logger.getLogger(TimKiem.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (action.equals("timkiemtheoten")) {
            String productName = request.getParameter("productName");
            System.out.println(productName);
            try {
                list = new ShoesDB().getProductByName(productName);
            } catch (Exception ex) {
                Logger.getLogger(TimKiem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        HttpSession session = request.getSession();
        session.setAttribute("list", list);
        session.setAttribute("message", message);
        String url = "/home.jsp";
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
