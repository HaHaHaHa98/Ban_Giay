
import business.Item;
import business.Shoes;
import data.ItemDB;
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

public class HienThiSanPham extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        String id = request.getParameter("id");
        Shoes shoes = null;
        try {
            shoes = new ShoesDB().getProductByID(id);
        } catch (Exception ex) {
            Logger.getLogger(HienThiSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<Item>listItem=new ArrayList<Item>();
        listItem=new ItemDB().getItemByCodeProduct(id);
        request.setAttribute("listItem", listItem);
        request.setAttribute("shoes", shoes);
        String url = "/product.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(HienThiSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(HienThiSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
