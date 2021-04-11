
import business.Cart;
import business.Item;
import business.LineItem;
import data.ItemDB;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GioHang extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        int size = Integer.parseInt(request.getParameter("size"));
        System.out.println("Size la lan 2: " + size);
        //int size=38;

        String quantityString = request.getParameter("quantity");
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
        }
        //LAY SL ITEM
        int quantity = 1;
        try {
            quantity = Integer.parseInt(quantityString);
            if (quantity < 0) {
                quantity = 1;
            }
        } catch (NumberFormatException nfe) {
            quantity = 1;
        }
        //LAY TEN ITEM
        Item item = null;
        try {
            item = new ItemDB().getItemByCodeProductAndSize(id, size);
        } catch (Exception ex) {
            Logger.getLogger(GioHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        //CHUYEN SLL NEU SL ITEM >0 THI CAP NHAP SLL LINE ITEM
        //CHUYEN SLL NEU SL ITEM ==0 THI XOA LINE ITEM
        LineItem lineItem = new LineItem();
        lineItem.setItem(item);
        lineItem.setQuantity(quantity);
        if (quantity > 0) {
            cart.addItem(lineItem);
        } else if (quantity == 0) {
            cart.removeItem(lineItem);
        }
        session.setAttribute("cart", cart);
        String url = "/cart.jsp";
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
