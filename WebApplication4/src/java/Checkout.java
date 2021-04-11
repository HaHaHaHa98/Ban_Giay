
import business.Cart;
import business.LineItem;
import business.Order;
import business.User;
import data.OrderDB;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Checkout extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        String action = (String) request.getParameter("action");
        System.out.println(action);
        System.out.println(action.equals("confirm"));
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Cart cart = (Cart) session.getAttribute("cart");
        String url = "/cart.jsp";
        if (!action.equals("confirm")) {
            if (cart.getItems().size() == 0) {
                url = "/cart.jsp";
            } else if (user == null && cart.getItems().size() != 0) {
                session.setAttribute("page", "checkout");
                url = "/login.jsp";
            } else {
                url = "/checkout.jsp";
            }
        } else {
            ArrayList<LineItem> listLineItem = cart.getItems();
            ArrayList<Order> listOrder = new ArrayList<Order>();
            int quantity = 1;
            double unitPrice = 0;
            String userName = "", idItem = "";
            for (LineItem lineItem : listLineItem) {
                quantity = lineItem.getQuantity();
                unitPrice = lineItem.getShoes().getPrice();
                userName = user.getUserName();
                idItem = lineItem.getItem().getId();
                long time = System.currentTimeMillis();
                Date buyDate = new java.sql.Date(new java.util.Date().getTime());

                listOrder.add(new Order(quantity, unitPrice, userName, idItem, buyDate));
            }
            OrderDB orderDB = new OrderDB();
            for (Order order : listOrder) {
                orderDB.addOrder(order);
            }
            session.setAttribute("cart", new Cart());
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception e) {

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception e) {

        }
    }

}
